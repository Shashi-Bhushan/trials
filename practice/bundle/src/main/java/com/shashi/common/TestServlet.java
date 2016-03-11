package com.shashi.common;

import com.shashi.common.factoryconfig.FactoryConfig;
import com.shashi.common.factoryconfig.FactoryConfigCleanerWay;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Shashi Bhushan
 *         Created on 10/3/16.
 *         For practice
 */
@SlingServlet(resourceTypes = TestServlet.resourceType, selectors = "map", extensions = "json")
public class TestServlet extends SlingSafeMethodsServlet{

    @Reference
    private FactoryConfigCleanerWay factoryConfig;

    @Reference
    private ConfigurationAdmin configAdmin;

    /**
     * Static Final Variables of {@link TestServlet}
     */
    public static final String resourceType = "/apps/geometrixx-gov/components/applicationformheader";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);

    private Configuration serviceConfigurations;
    private Configuration serviceConfiguration;

    protected void activate(ComponentContext context) {
        LOG.info("activating {}", this.getClass().getName());
    }

    protected void deactivate(ComponentContext context){
        LOG.info("Deactivating {}", this.getClass().getName());
    }

    protected void unbindFactoryConfig(FactoryConfigCleanerWay config) {
        LOG.info("Unbind Method of : {} | {}" , TestServlet.class.getName(), "unbindFactoryConfig" );
        this.factoryConfig = null;
    }

    protected void bindFactoryConfig(FactoryConfigCleanerWay config) {
        LOG.info("Bind Method of : {} | {}" , TestServlet.class.getName(), "bindFactoryConfig" );
        this.factoryConfig = config;
    }

    private void listConfigurations(){
        try {
            serviceConfiguration = configAdmin.getConfiguration(FactoryConfig.class.getName());
            serviceConfigurations = configAdmin.getConfiguration(FactoryConfigCleanerWay.class.getName());
        } catch (IOException e) {
            LOG.error(e.getMessage());
            e.getMessage();
        }
//        catch (InvalidSyntaxException e) {
//            e.getMessage();
//        }

        LOG.info("Configuration Admin is : {}", configAdmin);
        LOG.info("Service Configuration is : {}", serviceConfiguration);
        LOG.info("Service Configurations are : {}", serviceConfigurations);

        Dictionary dic = serviceConfiguration.getProperties();

        Enumeration keys = dic.keys();
        Map<String, String> values = new HashMap<String, String>();
        while(keys.hasMoreElements()){
            Object key = keys.nextElement();
            values.put(String.valueOf(key), String.valueOf(dic.get(keys.nextElement())));

        }
        LOG.info(LINE_SEPARATOR + "Elements of {} are : {}", serviceConfiguration.getPid(), values );

//        Dictionary dic2 = serviceConfigurations.getProperties();
//
//        Enumeration keys2 = dic2.keys();
//        Map<String, String> values2 = new HashMap<String, String>();
//        while(keys2.hasMoreElements()){
//            Object key = keys.nextElement();
//            values.put(String.valueOf(key), String.valueOf(dic2.get(keys.nextElement())));
//
//        }
//        LOG.info(LINE_SEPARATOR + "Elements of {} are : {}", serviceConfigurations.getPid(), keys2.nextElement() );
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        listConfigurations();
        writer.write("This Servlet is Registered at Resource Type " + resourceType + LINE_SEPARATOR);

        writer.format("Map is : %s %s", factoryConfig, LINE_SEPARATOR);
        writer.format("Service Configurations Length is : %s %s", serviceConfigurations , LINE_SEPARATOR);
    }
}
