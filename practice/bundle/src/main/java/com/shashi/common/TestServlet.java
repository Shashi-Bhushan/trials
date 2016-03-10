package com.shashi.common;

import com.shashi.common.factoryconfig.FactoryConfigCleanerWay;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Shashi Bhushan
 *         Created on 10/3/16.
 *         For practice
 */
@SlingServlet(resourceTypes = TestServlet.resourceType, selectors = "map", extensions = "json")
public class TestServlet extends SlingSafeMethodsServlet{

    @Reference
    private FactoryConfigCleanerWay factoryConfig;

    /**
     * Static Final Variables of {@link TestServlet}
     */
    public static final String resourceType = "/apps/geometrixx-gov/components/applicationformheader";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final Logger LOG = LoggerFactory.getLogger(TestServlet.class);

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

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("This Servlet is Registered at Resource Type " + resourceType + LINE_SEPARATOR);

        writer.format("Map is : %s | {} |", factoryConfig);
    }
}
