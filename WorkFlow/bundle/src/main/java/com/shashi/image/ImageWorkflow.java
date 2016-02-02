package com.shashi.image;


import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
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
public class ImageWorkflow implements WorkflowProcess {
    final Logger log = LoggerFactory.getLogger(ImageWorkflow.class);

    @Reference
    ResourceResolverFactory resolverFactory;

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
            asset.addRendition("shashi-jpeg", io, "image/jpeg");
            asset.addRendition("shashi-png", io, "image/png");
        } catch (LoginException e) {
            log.error("Error in Try Catch");
        }
    }
}
