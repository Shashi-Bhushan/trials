package org.slf4j.impl;

/**
 * @author Shashi Bhushan
 *         Created on 1/3/16.
 *         For Logging-Framework
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shashi.logging.Loggable;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class LoggingLoggerFactory implements ILoggerFactory {

    public LoggingLoggerFactory() {
    }

    void reset() {
        this.loggerMap.clear();
    }

    /**
     * Map to hold Logger objects as a Key value pair.
     * the key is the class for which the {@link Loggable} object has been spawned and value is the actual {@link Loggable}
     * object.
     * Using a ConcurrentHashMap here bacause of two reasons,
     * - Reads can happen very fast while write is done with a lock.
     * - ConcurrentHashMap doesn't throw a {@link java.util.ConcurrentModificationException} if one thread tries to modify
     *   the Map, while another thread is iterating over it.
     */
    private static final Map<String, Logger> loggerMap = new ConcurrentHashMap<String, Logger>();

    /**
     * This method returns the {@link Loggable} instance for a particular class.
     * but first, it should check if the {@link Loggable} object alredy exists for that class
     * @param clazz
     *      {@link Class} for which to initialize the Logger
     * @return
     *      {@link Loggable} object with Specified {@link Class}
     */
    public Logger getLogger(String clazz){
        Logger logger = this.loggerMap.get(clazz);

        if(logger != null){
            // set explicit LOG_LEVEL if it is not equal to Existing LOG level of the Loggable Class Object
//            if(logger.getCurrentLogLevel() != log_level){
//                logger.setCurrentLogLevel(log_level);
//            }
//            if(out != logger.getOutput()){
//                logger.setOutput(out);
//            }
            return logger;
        }else{
            logger = new LoggerImpl(clazz);
            loggerMap.put(clazz, logger);

            return logger;
        }
    }
}