package com.general.sightly.bean;

/**
 * Bean used to Store values of Hello Text's heading and description
 * It defines two class members, and contains getter and setter methods for them.
 *
 * @author Shashi Bhushan
 *         Created on 2/5/16.
 *         For Project : sightly
 */
public class HelloTextBean {

    private String headingText;

    private String description;

    /**
     * Setter for {@code headingText}
     *
     * @param headingText
     *          sets this to be {@code headingText} of the class
     */
    public void setHeadingText(String headingText){
        this.headingText = headingText;
    }

    /**
     * Getter for {@code headingText}
     *
     * @return
     *          {@code headingText} value
     */
    public String getHeadingText(){
        return headingText;
    }

    /**
     * Setter for {@code description}
     *
     * @param description
     *          sets this to be {@code description} of the class
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Getter of {@code description}
     *
     * @return
     *          {@code description} value
     */
    public String getDescription(){
        return description;
    }
}
