package com.shashi.logging.exception;

/**
 * @author Shashi Bhushan
 *         Created on 29/2/16.
 *         For Logging-Framework
 */
public class LogLevelNotSupportedException extends RuntimeException {

    public LogLevelNotSupportedException(String message){
        super(message);
    }

    public LogLevelNotSupportedException(){
        super("Debug is not Enabled");
    }
}
