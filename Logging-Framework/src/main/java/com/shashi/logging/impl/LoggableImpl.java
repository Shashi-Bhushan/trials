package com.shashi.logging.impl;

import com.shashi.logging.Loggable;
import com.shashi.logging.exception.LogLevelNotSupportedException;

import java.io.PrintStream;

/**
 * @author Shashi Bhushan
 *         Created on 26/2/16.
 *         For Logging-Framework
 */
public class LoggableImpl implements Loggable {
    private Loggable.LOG_LEVEL logLevel;

    private final Class clazz;

    private PrintStream out;

    /**
     * Public Constructor of the Class. Provides options to set {@code clazz}, {@code log_level} and {@code out} for the
     * class. If the {@code log_level} or {@code out} has not been set, then they will be set to their default values.
     *
     * @param clazz
     *      The class for which this {@link Loggable} object has been created
     * @param log_level
     *      The {@link com.shashi.logging.Loggable.LOG_LEVEL} to set for this {@link Loggable} object
     * @param out
     *      The {@link PrintStream} output to print to the file
     */
    LoggableImpl(Class clazz,LOG_LEVEL log_level, PrintStream out){
        this.clazz = clazz;
        if(log_level != null){
            this.logLevel = log_level;
        } else {
            this.logLevel = LOG_LEVEL.DEBUG;
        }

        if(out != null){
            this.out = out;
        } else {
            this.out = System.out;
        }
    }

    /**
     * Checks if the {@code logLevel} is greater than or equals to Debug's {@code logLevel}.
     * @return
     *      true if the {@code logLevel} is greater than or equal to {@link com.shashi.logging.Loggable.LOG_LEVEL}'s Debug
     *      log level otherwise false
     */
    public boolean isDebugEnabled(){
        return (this.logLevel.getLogLevel() >= LOG_LEVEL.DEBUG.getLogLevel()) ? true : false;
    }

    /**
     * Get the current {@code logLevel}
     * @return
     *      the current {@code logLevel}
     */
    public LOG_LEVEL getLogLevel(){
        return this.logLevel;
    }

    /**
     * Sets the current {@link com.shashi.logging.Loggable.LOG_LEVEL} to the Specified {@code logLevel}
     * @see {@link Loggable#setLogLevel(LOG_LEVEL)}
     */
    public void setLogLevel(LOG_LEVEL logLevel){
        this.logLevel = logLevel;
    }

    public void setOutput(PrintStream out){
        if(out != null)
            this.out = out;
    }

    public PrintStream getOutput(){
        return this.out;
    }

    public void info(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.INFO);
    }

    public void debug(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.DEBUG);
    }

    public void warn(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.WARN);
    }

    public void error(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.ERROR);
    }

    private void printMessageInternal(String message, LOG_LEVEL logLevel) throws LogLevelNotSupportedException {
        if(this.logLevel.getLogLevel() >= logLevel.getLogLevel()){
            out.println(message);
        }else{
            throw new LogLevelNotSupportedException(logLevel + " is not Supported at this level of Logging.");
        }
    }
}
