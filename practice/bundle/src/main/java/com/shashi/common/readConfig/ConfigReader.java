package com.shashi.common.readConfig;

import com.shashi.common.factoryconfig.FactoryConfigCleanerWay;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author Shashi Bhushan
 *         Created on 4/3/16.
 *         For practice
 */
@Component(
        label = "Factory Config Reader",
        metatype = false,
        enabled = true,
        description = "Factory Configuration Reader - Using to read configurations for FactoryConfig Class"
)
public class ConfigReader {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigReader.class);

    @Reference
    private ConfigurationAdmin configadmin;

    private Configuration configuration;

    @Activate
    @Modified
    public void activate(final Map<String, Object> properties){

        try {
            configuration = configadmin.getConfiguration(FactoryConfigCleanerWay.class.getName());
        } catch (IOException cause) {
            LOG.error("Error is : {}", cause.getMessage());
            cause.getMessage();
        }

        LOG.info("Configuration is : {}", "Activate MThod called again");
    }
}
