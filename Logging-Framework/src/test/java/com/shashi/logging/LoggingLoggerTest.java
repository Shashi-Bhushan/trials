package com.shashi.logging;

import com.shashi.logging.exception.LogLevelNotSupportedException;
import com.shashi.logging.impl.LoggerFactory;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertTrue;

/**
 * @author Shashi Bhushan
 *         Created on 26/2/16.
 *         For Logging-Framework
 */
public class LoggingLoggerTest {
    @Test
    public void initializeLogSuccessfully(){
        Loggable LOG = LoggerFactory.getInstance(LoggingLoggerTest.class);

        assertTrue(LOG != null);
    }

    @Test
    public void getSameLoggerTwice_ShouldReturnSameLogger(){
        Loggable loggableOne = LoggerFactory.getInstance(LoggingLoggerTest.class);

        Loggable loggabletwo = LoggerFactory.getInstance(LoggingLoggerTest.class);

        assertTrue(loggableOne == loggabletwo);
    }

    @Test
    public void getLogLevel_DefaultShouldBeInfo(){
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class);

        assertTrue(loggable.getLogLevel() == Loggable.LOG_LEVEL.DEBUG);
    }

    @Test
    public void setLogLevel_ShouldBeSame(){
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class);

        loggable.setLogLevel(Loggable.LOG_LEVEL.ERROR);
        assertTrue(loggable.getLogLevel() == Loggable.LOG_LEVEL.ERROR);
    }

    @Test
    public void printErrorLog() {
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class, Loggable.LOG_LEVEL.ERROR);

        loggable.error("Test Message");
    }

    @Test
    public void printRightLog() {
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class, Loggable.LOG_LEVEL.WARN);

        loggable.warn("Test Message");
    }

    @Test(expected = LogLevelNotSupportedException.class)
    public void printWrongLog() {
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class, Loggable.LOG_LEVEL.WARN);

        loggable.error("Test Message");
    }

    @Test
    public void changeLogFile() throws FileNotFoundException {
        Loggable loggable = LoggerFactory.getInstance(LoggingLoggerTest.class, Loggable.LOG_LEVEL.ERROR, new PrintStream(new FileOutputStream("/home/shashi/Logging.log")));

        loggable.warn("Test Message");
    }
}
