package com.shashi.image;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.process.AbstractAssetWorkflowProcess;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.Route;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import com.shashi.constants.WorkFlowConstants;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Shashi Bhushan
 *         Created on 31/1/16.
 *         For WorkFlow
 */
@Component(label = "process.label",description = "Image Extension Change")
@Service
@Properties({
        @Property(
                name = Constants.SERVICE_DESCRIPTION,
                value = "Sample Workflow Process implementation.",
                propertyPrivate = true
        ),
        @Property(
                label = "Workflow Label",
                name = "process.label",
                value = "Sample Workflow Process",
                description = "Label which will appear in the AEM Workflow interface; This should be unique across "
                        + "Workflow Processes",
                propertyPrivate = true
        )
})
public class ImageWorkflow extends AbstractAssetWorkflowProcess implements WorkflowProcess {


    public ImageWorkflow() {
        super();
    }

    private static final int ALLOWED_ASSET_ROUTE = 0;
    private static final int DISALLOWED_ASSET_ROUTE = 1;

    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {

        Session session = workflowSession.getSession();
        List<Route> routes = workflowSession.getRoutes(workItem);


        //TODO : get asset path using service user mapper
        Asset asset = null;
        String assetPath = asset.getPath();


//        workItem.getWorkflowData().getPayload()
        String assetType = StringUtils.EMPTY;
        Node assetMetaNode = null;
        try {
            assetMetaNode = session.getNode(assetPath + WorkFlowConstants.JCR_CONTENT + WorkFlowConstants.SLASH + WorkFlowConstants.DC_METADATA);
            assetType = assetMetaNode.getProperty(WorkFlowConstants.DC_FORMAT).getString();
        } catch (RepositoryException e) {
            e.getMessage();
        }

        if(StringUtils.isNotEmpty(assetType) && assetType.equals("png")){
            workflowSession.complete(workItem, routes.get(DISALLOWED_ASSET_ROUTE));
        }else{
            workflowSession.complete(workItem, routes.get(ALLOWED_ASSET_ROUTE));
        }
    }

    /**
     * Converts an image to another format
     *
     * @param inputImagePath Path of the source image
     * @param outputImagePath Path of the destination image
     * @param formatName the format to be converted to, one of: jpeg, png,
     * bmp, wbmp, and gif
     * @return true if successful, false otherwise
     * @throws IOException if errors occur during writing
     */
    public static boolean convertFormat(String inputImagePath,
                                        String outputImagePath, String formatName) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputImagePath);
        FileOutputStream outputStream = new FileOutputStream(outputImagePath);

        // reads input image from file
        BufferedImage inputImage = ImageIO.read(inputStream);

        // writes to the output image in specified format
        boolean result = ImageIO.write(inputImage, formatName, outputStream);

        // needs to close the streams
        outputStream.close();
        inputStream.close();

        return result;
    }
}
