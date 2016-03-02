package com.shashi.logging;

import com.shashi.logging.exception.LogLevelNotSupportedException;

import java.io.PrintStream;

/**
 * This interface Specifies what the Loggable class should be able to do.
 * Requirements:
 *      - [x] Define Log Levels at the most basic levels
 *      - [x] Must have a configuration mechanism to set the log level(how many?)
 *      - [x] provide methods to log at different levels
 *      - [x] Framework should be able to print to different outputs such as Files, Consoles, Sockets, Streams etc
 *      - [ ] Framework must be instantiated once and should be then shared by other classes using Logger. Also, avoid
 *        premature optimization.
 *      - [ ] Should have multithreaded capabilities, you don't want multiple threads writing to LOG at the same time,else
 *        you'll end up with garbage.
 *      - [ ] Make it expandable and usable with other Third party libraries viz SLF4J
 *      It should be fairly easy. you'll need to implement your own Logger and LoggerFactory. you will not have to change
 *      existing code at all. After doing that you'll need to implement StaticLoggerBinder to return your logger factory
 *      and class name. if you download the slf4j zip file then you get the source for all the implementations too, just
 *      have a look at the StaticLoggerBinder in slf4j-log4j for an example.
 *      have a look at this link for details : http://www.slf4j.org/faq.html#slf4j_compatible
 *
 * @author Shashi Bhushan
 *         Created on 26/2/16.
 *         For Logging-Framework
 */
public interface Loggable {
    /**
     * Enumeration for different log levels
     * Notice the snake casing in naming
     */
    enum LOG_LEVEL{
        INFO(1),
        DEBUG(2),
        WARN(3),
        ERROR(4);

        private final int logLevel;

        LOG_LEVEL(int logLevel){
            this.logLevel = logLevel;
        }

        public int getLogLevel(){
            return this.logLevel;
        }
    }

    boolean isDebugEnabled();

    void setOutput(PrintStream out);

    PrintStream getOutput();

    LOG_LEVEL getLogLevel();

    /**
     * Sets the current {@link com.shashi.logging.Loggable.LOG_LEVEL} to the Specified {@code logLevel}
     * @param logLevel
     *      The {@link com.shashi.logging.Loggable.LOG_LEVEL} to set the current {@code logLevel} to
     */
    void setLogLevel(LOG_LEVEL logLevel);

    void debug(String message) throws LogLevelNotSupportedException;

    void info(String message) throws LogLevelNotSupportedException;

    void warn(String message) throws LogLevelNotSupportedException;

    void error(String message) throws LogLevelNotSupportedException;
}
