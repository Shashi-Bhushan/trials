package com.general.sightly.components;

import com.adobe.cq.sightly.WCMUse;
import com.general.sightly.Constants.HelloTextConstants;
import com.general.sightly.bean.HelloTextBean;
import org.apache.sling.api.resource.Resource;

import javax.jcr.Node;

/**
 * @author Shashi Bhushan
 *         Created on 2/5/16.
 *         For Project : sightly
 */
public class HelloTextComponent extends WCMUse {

    private HelloTextBean helloTextBean;

    @Override
    public void activate() throws Exception {
        Node currentNode = getResource().adaptTo(Node.class);

        helloTextBean = new HelloTextBean();

        if(currentNode.hasProperty(HelloTextConstants.HEADING)){
            helloTextBean.setHeadingText(currentNode.getProperty(HelloTextConstants.PROP_HEADING).getString());
        }
        if(currentNode.hasProperty(HelloTextConstants.DESCRIPTION)){
            helloTextBean.setDescription(currentNode.getProperty(HelloTextConstants.PROP_DESCRIPTION).getString());
        }
    }

    public HelloTextBean getHelloTextBean(){
        return this.helloTextBean;
    }
}
