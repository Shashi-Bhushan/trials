package com.shashi.common.factoryconfig;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * This is another way Or say a Cleaner way of doing the same thing.
 *
 * @author Shashi Bhushan
 *         Created on 3/3/16.
 *         For practice
 */
@Component(
        label = "Factory Configuration - Cleaner Way",
        immediate = true,
        metatype = true,
        enabled = true,
        description = "Sample Factory Configuration having Some Properties - is a cleaner way of doing things"
)
@Properties({
        @Property(name = FactoryConfigCleanerWay.NAME_PROPERTY, label = "Name Property", description = "Name of the User"),
        @Property(name = FactoryConfigCleanerWay.GENDER_PROPERTY, label = "Gender Property", description = "Gender DropDown Property for testing",
                options = {
                        @PropertyOption(name = "Male", value = "MALE"),
                        @PropertyOption(name = "Female", value = "FEMALE")
                }),
        @Property(name = FactoryConfigCleanerWay.PHONE_NUMBERS_PROPERTY ,label="Phone Number", description = "Phone Numbers of the user", cardinality = Integer.MAX_VALUE),
        @Property(name = FactoryConfigCleanerWay.IS_ALIVE_PROPERTY, boolValue = {false}, label = "Are you alive", description = "Are you seriously Alive Man"),
        @Property(name = FactoryConfigCleanerWay.HOW_MANY_CHILDREN, intValue = 0, label = "How Many Children", description = "Describes How many Children You Have")
})

public class FactoryConfigCleanerWay {

    /**
     * Static Final String variables serves as name for the {@link Property}
     */
    static final String NAME_PROPERTY = "name.property";

    static final String GENDER_PROPERTY = "gender.property";

    static final String PHONE_NUMBERS_PROPERTY = "phoneNumber.property";

    static final String IS_ALIVE_PROPERTY = "is.alive.property";

    static final String HOW_MANY_CHILDREN = "child.property";

    /**
     * Private variables to hold the values for individual instances
     */
    private String name;

    private String gender;

    private List<String> phoneNumbers;

    private boolean isAlive;

    private int children;

    private static final Logger LOG = LoggerFactory.getLogger(FactoryConfigCleanerWay.class);

    @Activate
    public void activate(final Map<String, Object> properties) {
        this.modified(properties);
    }

    @Modified
    public void modified(final Map<String, Object> properties) {
        this.name = String.valueOf(properties.get(NAME_PROPERTY));
        this.gender = String.valueOf(properties.get(GENDER_PROPERTY));
        this.phoneNumbers = Arrays.asList(PropertiesUtil.toStringArray(properties.get(PHONE_NUMBERS_PROPERTY)));
        this.isAlive = PropertiesUtil.toBoolean(properties.get(IS_ALIVE_PROPERTY), false);
        this.children = PropertiesUtil.toInteger(properties.get(HOW_MANY_CHILDREN), 0);

        LOG.info("Map is : {}", properties);
        LOG.info("Phone Number is : {} and are you alive : {}", this.phoneNumbers, this.isAlive);
    }
}
