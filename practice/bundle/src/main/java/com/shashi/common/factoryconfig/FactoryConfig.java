package com.shashi.common.factoryconfig;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Factory Configuration is a SINGLE OSGi SERVICE, having MULTIPLE CONFIGURATIONS bind to it.
 * Logging Logger and Logging Writer are examples of Factory Configurations.
 *
 * Note that the maven-bundle-plugin and maven-scr-plugin will generate the manifest(Manifest.mf)
 * and serviceComponents(serviceComponents.xml) files automatically
 *
 * Declarative Services (DS) is a component model that simplifies the creation of components that publish and/or
 * reference OSGi Services.
 * - Declarative means no need to write explicit code to publish or consume services.
 * - components that publish services are delayed, meaning that the service implementation class is not loaded or
 * instantiated until the service is actually requested by a client.
 * - components have their own lifecycle (i.e. activation and deactivation), bounded by the lifecycle of the bundle
 * in which they are defined.
 * - components can automatically receive configuration data from Configuration Admin.
 *
 * Order of precedence of configurations
 * felix > apps > libs is precedence order while looking for configurations at run time(Reason Below)
 * and apps > libs > felix is the order while startup
 * Reason: In CQ5. Any changes done in felix console modifies the config files with the highest priority(in apps).
 *
 * Tools have taken different approach to generate Service-Component's xml.
 * BND and SCR takes Annotations approach.
 *
 * @author Shashi Bhushan
 *         Created on 2/2/16.
 *         For practice
 *
 * import aQute.bnd.annotation.component.Component is a BND Annotation
 *
 * Maven SCR Annotations
 * For Annotation - Component
 *      label:      Name which is shown in Configuration Manager
 *      metatype:   true makes the configuration configurable in Configuration manager
 */
@Component(
        label = "Factory Configuration",
        immediate = true,
        metatype = true,
        enabled = true,
        description = "Sample Factory Configuration having Some Properties"
)
public class FactoryConfig {

    private static final Logger log = LoggerFactory.getLogger(FactoryConfig.class);

    static{
//        BasicConfigurator.configure();
    }

    /**
     * SINGLE TEXTFIELD PROPERTY
     * This property specifies with which name to save this property in ComponentContext Map.
     * You can directly do, componentContextMap.get('PropertyName') each time you require the value of the property
     * and you would get the latest property of that name.
     * name
     */
    @Property(name = "name.property", label = "Name Property", description = "Name of the User")
    private static final String PATH_PROPERTY = "Name Property";

    /**
     * DROPDOWN PROPERTY
     * This Property specifies another entry in componentContext Map
     */
    @Property(label="Gender Property" , description = "Gender DropDown Property for testing",
    options = {
            @PropertyOption(name = "Male", value = "MALE"),
            @PropertyOption(name = "Female", value = "FEMALE")
    })
    private static final String GENDER_PROPERTY = "gender.property";
    /**
     * MULTI-VALUED PROPERTY
     * This is the property that specifies multiple values for a single {@link Property}
     */
    @Property(label="Phone Number", description = "Phone Numbers of the user", cardinality = Integer.MAX_VALUE)
    private static final String PHONE_NUMBER_PROPERTY = "phoneNumber.property";
    /**
     * BOOLEAN VALUE (Checkbox)
     */
    @Property(boolValue = {false}, label = "Are you alive", description = "Are you seriously Alive Man")
    private static final String IS_ALIVE_PROPERTY = "is.alive.property";

    /**
     * This is a normal instance variable in this Class and is used to getProperty once from the map and set in this
     * instance variable so that you won't have to do map.get('PropertyName') each time you require a value.
     */
    private String name;
    private String gender;
    private List<String> phoneNumbers;
    private boolean isAlive;

    @Activate
    public void activate(final Map<String, Object> properties){
        this.modified(properties);
        log.info("Map is: {}", properties);
    }

    @Modified
    public void modified(final Map<String, Object> properties){
        name = String.valueOf(properties.get("name.property"));
        gender = String.valueOf(properties.get(GENDER_PROPERTY));
        this.phoneNumbers = Arrays.asList(PropertiesUtil.toStringArray(properties.get(PHONE_NUMBER_PROPERTY)));
        this.isAlive = PropertiesUtil.toBoolean(properties.get(IS_ALIVE_PROPERTY), false);

        log.info("Map is : {}", properties);
        log.info("Phone Number is : {}" ,  this.phoneNumbers);
    }
}
