package com.shashi.common.factoryconfig;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;

/**
 * Factory Configuration is a Single Service, having multiple configurations bind to it.
 * Logging Logger and Logging Writer are examples of Factory Configurations.
 *
 * Note that the maven-bundle-plugin and maven-scr-plugin will generate the manifest and serviceComponents files automatically
 *
 * @author Shashi Bhushan
 *         Created on 2/2/16.
 *         For practice
 *
 * label: Name which is shown in Configuration Manager
 * metatype: true makes the configuration configurable in Configuration manager
 */
@Component(
        label = "Factory Configuration",
        immediate = true,
        metatype = true,
        enabled = true,
        description = "Sample Factory Configuration having Some Properties"
)
@Properties({
        @Property(name = "propertyPath")
})
public class FactoryConfig {

    private static final Logger log = LoggerFactory.getLogger(FactoryConfig.class);

    private static final String NAME_PROPERTY = "prop.name";

    private String[] propertyPath;

    @Activate
    public void activate(ComponentContext componentContext){
        Dictionary properties = componentContext.getProperties();

        String property = String.valueOf(properties.get("propertyPath"));

        log.info("Name Property is: {}", property);
    }
}
