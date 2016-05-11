package com.general.sightly.Constants;

import com.day.cq.commons.jcr.JcrConstants;

/**
 * @author Shashi Bhushan
 *         Created on 2/5/16.
 *         For Project : sightly
 */
public interface HelloTextConstants {
    String DELIMETER = "./";

    String HEADING = "jcr:Heading";
    String PROP_HEADING = DELIMETER  + HEADING;

    String DESCRIPTION = JcrConstants.JCR_DESCRIPTION ;
    String PROP_DESCRIPTION = DELIMETER + DESCRIPTION ;
}
