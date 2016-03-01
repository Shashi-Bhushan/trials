package com.shashi.logging.impl;

import com.shashi.logging.Loggable;
import com.shashi.logging.impl.LoggableImpl;

import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Shashi Bhushan
 *         Created on 26/2/16.
 *         For Logging-Framework
 */
public class LoggerFactory {

    /**
     * Map to hold Logger objects as a Key value pair.
     * the key is the class for which the {@link Loggable} object has been spawned and value is the actual {@link Loggable}
     * object.
     * Using a ConcurrentHashMap here bacause of two reasons,
     * - Reads can happen very fast while write is done with a lock.
     * - ConcurrentHashMap doesn't throw a {@link java.util.ConcurrentModificationException} if one thread tries to modify
     *   the Map, while another thread is iterating over it.
     */
    private static final Map<Class, Loggable> loggerMap = new ConcurrentHashMap<Class, Loggable>();

    /**
     * This method returns the {@link Loggable} instance for a particular class.
     * but first, it should check if the {@link Loggable} object alredy exists for that class
     * @param clazz
     *      {@link Class} for which to initialize the Logger
     * @return
     *      {@link Loggable} object with Specified {@link Class}
     */
    public static Loggable getInstance(Class clazz){
        return getInstanceInternal(clazz, null, null);
    }

    public static Loggable getInstance(Class clazz, Loggable.LOG_LEVEL log_level){
        return getInstanceInternal(clazz, log_level, null);
    }

    public static Loggable getInstance(Class clazz, Loggable.LOG_LEVEL log_level, PrintStream out){
        return getInstanceInternal(clazz, log_level, out);
    }

    private static Loggable getInstanceInternal(Class clazz, Loggable.LOG_LEVEL log_level, PrintStream out){
        Loggable logger = loggerMap.get(clazz);

        if(logger != null){
            // set explicit LOG_LEVEL if it is not equal to Existing LOG level of the Loggable Class Object
            if(logger.getLogLevel() != log_level){
                logger.setLogLevel(log_level);
            }
            if(out != logger.getOutput()){
                logger.setOutput(out);
            }
            return logger;
        }else{
            logger = new LoggableImpl(clazz, log_level, out);
            loggerMap.put(clazz, logger);

            return logger;
        }
    }
}
