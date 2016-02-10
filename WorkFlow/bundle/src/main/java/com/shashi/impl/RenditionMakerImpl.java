package com.shashi.impl;

/**
 * @author Shashi Bhushan
 *         Created on 9/2/16.
 *         For WorkFlow
 */
import com.adobe.cq.gfx.Gfx;
import com.adobe.cq.gfx.Instructions;
import com.adobe.cq.gfx.Layer;
import com.adobe.cq.gfx.Plan;
import com.adobe.xmp.XMPMeta;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.handler.xmp.XMPHandler;
import com.day.cq.dam.api.handler.xmp.XMPWriteBackOptions;
import com.day.cq.dam.api.renditions.RenditionMaker;
import com.day.cq.dam.api.renditions.RenditionTemplate;
import com.day.cq.dam.commons.metadata.SimpleXmpToJcrMetadataBuilder;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.dam.commons.util.OrientationUtil;
//import com.day.cq.dam.core.impl.handler.xmp.XMPWriteBackOptionsImpl;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.jackrabbit.oak.commons.IOUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.mime.MimeTypeService;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        metatype = true,
        label = "Adobe CQ DAM Rendition Maker",
        description = "Adobe CQ DAM Rendition Maker"
)
@Service
public class RenditionMakerImpl {
    private static final Logger log = LoggerFactory.getLogger(RenditionMakerImpl.class);
    public static final String PREFIX_WEB_RENDITION = "cq5dam.web.";
    private static final boolean DEFAULT_PROPAGATE_XMP = false;
    @Property(
            boolValue = {false},
            label = "Propagate XMP",
            description = "Propagate XMP from asset metadata to renditions"
    )
    private static final String PROPAGATE_XMP = "xmp.propagate";
    private static final String XMP_PROP_DELIM = " ";
    private static final String PS_AUX_ISO = "http://ns.adobe.com/exif/1.0/aux/ ISO";
    private static final String[] DEFAULT_XMP_EXCLUDES = new String[]{"http://ns.adobe.com/exif/1.0/aux/ ISO"};
    @Property(
            value = {"http://ns.adobe.com/exif/1.0/aux/ ISO"},
            cardinality = 1,
            label = "XMP Excludes",
            description = "XMP properties to skip on propagation. Format: <namespace> <property>"
    )
    private static final String XMP_EXCLUDES = "xmp.excludes";
    @Reference
    private Gfx gfx;
    @Reference
    private MimeTypeService mimeTypeService;
    @Reference
    protected XMPHandler xmpHandler;
    private boolean propagateXMP;
    private String[] xmpExcludes;

    public RenditionMakerImpl() {
    }

    @Activate
    private void activate(ComponentContext ctx) {
        Dictionary cfg = ctx.getProperties();
        this.propagateXMP = PropertiesUtil.toBoolean(cfg.get("xmp.propagate"), false);
        this.xmpExcludes = PropertiesUtil.toStringArray(cfg.get("xmp.excludes"), DEFAULT_XMP_EXCLUDES);
    }

    public RenditionTemplate createThumbnailTemplate(Asset asset, int width, int height, boolean center) {
        return this.createThumbnailTemplate(asset.getOriginal(), width, height, center);
    }

    public RenditionTemplate createThumbnailTemplate(Rendition rendition, int width, int height, boolean doCenter) {
        RenditionMakerImpl.PlanBasedTemplate template = new RenditionMakerImpl.PlanBasedTemplate();
        Asset asset = rendition.getAsset();
        boolean useRenditionPath = rendition.equals(asset.getOriginal());
        template.renditionName = DamUtil.getThumbnailName(width, height, doCenter?new String[]{"margin"}:null);
        template.mimeType = "image/png";
        template.plan = this.gfx.createPlan();
        template.plan.layer(0).set("src", useRenditionPath?rendition.getPath():asset.getPath());
        applyOrientation(OrientationUtil.getOrientation(asset), template.plan.layer(0));
        applyThumbnail(width, height, doCenter, template.mimeType, template.plan);
        return template;
    }

    public RenditionTemplate createWebRenditionTemplate(Asset asset, int width, int height, int quality, String mimeType, String[] mimeTypesToKeep) {
        RenditionMakerImpl.PlanBasedTemplate template = new RenditionMakerImpl.PlanBasedTemplate();
        String assetMimeType = asset.getMimeType();
        template.mimeType = ArrayUtils.contains(mimeTypesToKeep, assetMimeType)?assetMimeType:mimeType;
        template.renditionName = "cq5dam.web." + width + "." + height + "." + this.mimeTypeService.getExtension(template.mimeType);
        template.plan = this.gfx.createPlan();
        template.plan.layer(0).set("src", asset.getPath());
        applyOrientation(OrientationUtil.getOrientation(asset), template.plan.layer(0));
        this.applyWebRendition(width, height, quality, template.mimeType, template.plan);
        return template;
    }

    public List<Rendition> generateRenditions(Asset asset, RenditionTemplate... templates) {
        boolean oldBatchMode = asset.isBatchMode();
        asset.setBatchMode(true);
        ArrayList renditions = new ArrayList();
        RenditionTemplate[] e = templates;
        int len$ = templates.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            RenditionTemplate cfg = e[i$];
            Rendition rendition = cfg.apply(asset);
            if(rendition != null) {
                log.info("generated rendition: {}", rendition.getPath());
                renditions.add(rendition);
            }
        }

        if(this.propagateXMP) {
            this.propagateXMP(asset, renditions);
        }

        asset.setBatchMode(oldBatchMode);

        try {
            ((Node)asset.adaptTo(Node.class)).getSession().save();
        } catch (RepositoryException var10) {
            log.error("Error while generating renditions for asset " + asset.getPath(), var10);
        }

        return renditions;
    }

    private static void applyThumbnail(int width, int height, boolean doCenter, String mimeType, Plan plan) {
        Instructions global = plan.view();
        global.set("bgc", "0,0,0,0r");
        global.set("wid", Integer.valueOf(width));
        global.set("hei", Integer.valueOf(height));
        global.set("fit", doCenter?"fit,1":"constrain,1");
        String fmt = StringUtils.substringAfter(mimeType, "/");
        if("png".equals(fmt) || "gif".equals(fmt) || "tif".equals(fmt)) {
            fmt = fmt + "-alpha";
        }

        global.set("fmt", fmt);
    }

    private void applyWebRendition(int width, int height, int quality, String mimeType, Plan plan) {
        Instructions global = plan.view();
        global.set("wid", Integer.valueOf(width));
        global.set("hei", Integer.valueOf(height));
        global.set("fit", "constrain,0");
        if(!"image/jpg".equals(mimeType) && !"image/jpeg".equals(mimeType)) {
            if("image/gif".equals(mimeType)) {
                global.set("bgc", "0,0,0,0r");
                global.set("quantize", "adaptive,diffuse," + quality);
            }
        } else {
            global.set("qlt", Integer.valueOf(quality));
        }

        String fmt = StringUtils.substringAfter(mimeType, "/");
        if("png".equals(fmt) || "gif".equals(fmt) || "tif".equals(fmt)) {
            fmt = fmt + "-alpha";
        }

        global.set("fmt", fmt);
    }

    private static void applyOrientation(short exifOrientation, Layer layer) {
        switch(exifOrientation) {
            case 2:
                layer.set("flip", "lr");
                break;
            case 3:
                layer.set("rotate", Integer.valueOf(180));
                break;
            case 4:
                layer.set("flip", "ud");
                break;
            case 5:
                layer.set("flip", "lr");
                layer.set("rotate", Integer.valueOf(270));
                break;
            case 6:
                layer.set("rotate", Integer.valueOf(90));
                break;
            case 7:
                layer.set("flip", "lr");
                layer.set("rotate", Integer.valueOf(90));
                break;
            case 8:
                layer.set("rotate", Integer.valueOf(270));
        }

    }

    private void propagateXMP(Asset asset, List<Rendition> renditions) {
        if(this.xmpHandler != null && this.xmpHandler.isSupported(asset.getMimeType())) {
//            XMPWriteBackOptionsImpl writeBackOptions = new XMPWriteBackOptionsImpl();
//            writeBackOptions.createVersion(false);
//            writeBackOptions.setRenditions(new HashSet(renditions));
//            this.writeXmp(asset, writeBackOptions, this.xmpHandler);
        }

    }

    private synchronized void writeXmp(Asset asset, XMPWriteBackOptions writeBackOptions, XMPHandler xmpHandler) {
        try {
            Node e = (Node)asset.adaptTo(Node.class);
            Node metadataNode = e.getNode("jcr:content/metadata");
            SimpleXmpToJcrMetadataBuilder metadataAdapter = new SimpleXmpToJcrMetadataBuilder();
            XMPMeta xmpMeta = metadataAdapter.getXmpFromJcr(metadataNode);
            String[] arr$ = this.xmpExcludes;
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                String exclude = arr$[i$];
                String[] split = exclude.split(" ", 2);
                if(split.length == 2) {
                    String ns = split[0];
                    String prop = split[1];
                    if(xmpMeta.doesPropertyExist(ns, prop)) {
                        log.debug("Excluding XMP property: {} {}", ns, prop);
                        xmpMeta.deleteProperty(ns, prop);
                    }
                } else {
                    log.warn("Configuration xmp.excludes has entry that does not have the format \'<namespace> <property>\': {}", exclude);
                }
            }

            xmpHandler.writeXmp(asset, xmpMeta, writeBackOptions);
        } catch (Throwable var15) {
            if(log.isDebugEnabled()) {
                log.debug("Could not propagate xmp to renditions of asset: \'" + asset.getPath() + "\'", var15);
            } else {
                log.warn("Could not propagate xmp to renditions of asset \'{}\': {}", asset.getPath(), var15.getMessage());
            }
        }

    }

    protected void bindGfx(Gfx var1) {
        this.gfx = var1;
    }

    protected void unbindGfx(Gfx var1) {
        if(this.gfx == var1) {
            this.gfx = null;
        }

    }

    protected void bindMimeTypeService(MimeTypeService var1) {
        this.mimeTypeService = var1;
    }

    protected void unbindMimeTypeService(MimeTypeService var1) {
        if(this.mimeTypeService == var1) {
            this.mimeTypeService = null;
        }

    }

    protected void bindXmpHandler(XMPHandler var1) {
        this.xmpHandler = var1;
    }

    protected void unbindXmpHandler(XMPHandler var1) {
        if(this.xmpHandler == var1) {
            this.xmpHandler = null;
        }

    }

    private class PlanBasedTemplate implements RenditionTemplate {
        public Plan plan;
        public String renditionName;
        public String mimeType;

        private PlanBasedTemplate() {
        }

        public Rendition apply(Asset asset) {
            InputStream stream = null;

            Rendition var3;
            try {
                stream = RenditionMakerImpl.this.gfx.render(this.plan, ((Resource)asset.adaptTo(Resource.class)).getResourceResolver());
                if(stream == null) {
                    return null;
                }

                var3 = asset.addRendition(this.renditionName, stream, this.mimeType);
            } finally {
                IOUtils.closeQuietly(stream);
            }

            return var3;
        }
    }
}
