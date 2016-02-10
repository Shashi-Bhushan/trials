package com.shashi.image;


import com.adobe.cq.gfx.Gfx;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.renditions.RenditionTemplate;
import com.day.cq.dam.core.process.CreateThumbnailProcess;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import com.shashi.impl.RenditionMakerImpl;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shashi Bhushan
 *         Created on 2/2/16.
 *         For WorkFlow
 */

@Component
@Service
@Properties({ @Property(name = "process.label", value = "Image Asset Type Check") })
public class ImageWorkflow implements WorkflowProcess{

    final Logger log = LoggerFactory.getLogger(ImageWorkflow.class);

    @Reference
    ResourceResolverFactory resolverFactory;
    @Reference
    private RenditionMakerImpl renditionMakerImpl;

    /*
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        log.info("ImageWorkflow.execute()");
        log.info("ImageWorkflow.execute()" + resolverFactory);

        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("user.jcr.session", workflowSession.getSession());

            ResourceResolver rr = resolverFactory.getResourceResolver(map);
            log.info("No Error in RR");

            String path = workItem.getWorkflowData().getPayload().toString();
            log.info("Here2 path: " + path);
            Resource resource = rr.getResource(path);
            log.info("Here2 resource: " + resource);
            InputStream is = resource.adaptTo(InputStream.class);
            log.info("Here2 assets IS: " + is);

            Rendition rendition = resource.adaptTo(Rendition.class);
            log.info("Rendition: " + rendition);
            InputStream io = rendition.getStream();
            log.info("IO: " + io);


            Asset asset = rendition.getAsset();
            log.info("Mime Type: " + rendition.getMimeType());
            asset.addRendition("shashi", io, rendition.getMimeType());
            log.info("Adding Rendition Done");
//            asset.addRendition("shashi-jpeg", io, "image/jpeg");
//            asset.addRendition("shashi-png", io, "image/png");

            BufferedImage inputImage = ImageIO.read(rendition.getStream());

            log.info("Image is : " + inputImage);
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

            log.info("Before Writing, Byte Array : " + byteArrayOut);
            ImageIO.write(inputImage, "image/png", byteArrayOut);

            log.info("After Writing, Byte Array : " + byteArrayOut);
            asset.addRendition("Rendition - shashi-Png", io, rendition.getMimeType());
//            Boolean b = convertFormat(io, new NullOutputStream(), "image/jpeg");
//            log.info("Rendered IMage: " + b);
            log.info("Workflow Done");
        } catch (LoginException e) {
            log.info("Error in Try Catch");
        } catch (IOException e) {
            log.info("IOException");
            e.printStackTrace();
        } catch(Exception cause){
            log.info("Cause : " , cause.getMessage());
        }
// catch (IOException e) {
//            log.error("Exception IO: " ,e.getMessage());
//        }
    }
    */

    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaData) throws WorkflowException {
        Asset asset = null;
        try {
            final Map<String, Object> map = new HashMap<String, Object>();
            map.put("user.jcr.session", workflowSession.getSession());

            ResourceResolver rr = resolverFactory.getResourceResolver(map);
            log.info("No Error in RR");

            String path = workItem.getWorkflowData().getPayload().toString();
            log.info("Here2 path: " + path);
            Resource resource = rr.getResource(path);
            log.info("Here2 resource: " + resource);
            InputStream is = resource.adaptTo(InputStream.class);
            log.info("Here2 assets IS: " + is);

            Rendition rendition = resource.adaptTo(Rendition.class);
            log.info("Rendition: " + rendition);
            InputStream io = rendition.getStream();
            log.info("IO: " + io);


            asset = rendition.getAsset();
        } catch (LoginException e) {
            log.info("Error in Try Catch");
        } catch(Exception cause){
            log.info("Cause : " , cause.getMessage());
        }

        if(asset == null) {
            String config1 = workItem.getWorkflowData().getPayload().toString();
            String templates1 = "execute: cannot create thumbnails, asset [{" + config1 + "}] in payload doesn\'t exist for workflow [{" + workItem.getId() + "}].";
            throw new WorkflowException(templates1);
        } else {
            CreateThumbnailProcess.Config config = this.parseConfig(metaData);
            if(this.handleAsset(asset, config)) {
                asset.setBatchMode(true);
                RenditionTemplate[] templates = createRenditionTemplates(asset, config.thumbnails, this.renditionMaker);
                this.renditionMaker.generateRenditions(asset, templates);
            }

        }
    }

    /**Writes to nowhere*/
    private static class NullOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {
        }
    }

    /**
     * Converts an image to another format
     *
     * @param formatName the format to be converted to, one of: jpeg, png,
     * bmp, wbmp, and gif
     * @return true if successful, false otherwise
     * @throws IOException if errors occur during writing
     */

    public static boolean convertFormat(InputStream inputStream,
                                        OutputStream outputStream, String formatName) throws IOException {
        // reads input image from file
        BufferedImage inputImage = ImageIO.read(inputStream);

        // writes to the output image in specified format
        boolean result = ImageIO.write(inputImage, formatName, outputStream);

        // needs to close the streams
//        outputStream.close();
//        inputStream.close();

        return result;
    }

}
