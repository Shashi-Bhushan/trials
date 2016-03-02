package org.slf4j.impl;

/**
 * This class is a custom implementation of {@link org.slf4j.spi.LoggerFactoryBinder} of slf4j API.
 * It holds a Singleton object of itself, which can be accessed via a static method {@link #getSingleton()}.
 * Also, holds a custom implementation of {@link org.slf4j.ILoggerFactory}, which spawns {@link org.slf4j.impl.LoggerImpl}
 * object when {@link #getLoggerFactory()} is called.
 *
 * @author Shashi Bhushan
 *         Created on 1/3/16.
 *         For Logging-Framework
 */
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    public static String REQUESTED_API_VERSION = "1.6.99";
    private static final String loggerFactoryClassStr = LoggingLoggerFactory.class.getName();
    private final ILoggerFactory loggerFactory = new LoggingLoggerFactory();

    /**
     * Returns the Singleton {@link StaticLoggerBinder} object
     * @return
     *      Singleton implementation object of {@link StaticLoggerBinder}
     */
    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    /**
     * Private constructor prevents object spawning for {@link StaticLoggerBinder} class from outside the class.
     */
    private StaticLoggerBinder() {
    }

    /**
     * Provides a custom implementation of {@link ILoggerFactory}'s object, which is being held by {@code loggerFactory} of
     * the class
     *
     * @return
     *      Custom implementation of {@link ILoggerFactory}'s object
     */
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    /**
     * Name of the {@link ILoggerFactory} implementation class
     *
     * @return
     *      name of the {@link ILoggerFactory} implementation class
     */
    public String getLoggerFactoryClassStr() {
        return loggerFactoryClassStr;
    }
}