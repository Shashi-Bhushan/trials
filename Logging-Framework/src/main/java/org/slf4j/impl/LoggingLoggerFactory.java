package org.slf4j.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.shashi.logging.Loggable;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * This class is a custom {@link org.slf4j.ILoggerFactory} implementation for slf4j.
 * Provides a {@code loggerMap}, which holds name of the {@link Class} to initialize the {@link Logger} for and actual
 * {@link Logger} object in a key value pair. Also, provides a {@link #getLogger(String)} method to return the {@code Logger}
 * object if it already exists or create one and add this to {@code loggerMap} along with returning it back to the caller.
 *
 * @author Shashi Bhushan
 *         Created on 1/3/16.
 *         For Logging-Framework
 */
public class LoggingLoggerFactory implements ILoggerFactory {

    public LoggingLoggerFactory() {
    }

    /**
     * Resets the {@code loggerMap}
     */
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
     * This method returns the {@link Logger} instance for a particular class.
     * but first, it should check if the {@link Logger} object already exists for that class
     * @param clazz
     *      {@link Class} name for which to initialize the Logger
     * @return
     *      {@link Logger} object with Specified {@link Class}
     */
    public Logger getLogger(String clazz){
        Logger logger = this.loggerMap.get(clazz);

        if(logger != null){
            return logger;
        }else{
            logger = new LoggerImpl(clazz);
            loggerMap.put(clazz, logger);

            return logger;
        }
    }
}