package org.slf4j.impl;

import com.shashi.logging.Loggable;
import com.shashi.logging.exception.LogLevelNotSupportedException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static org.junit.Assert.assertTrue;

/**
 * @author Shashi Bhushan
 *         Created on 2/3/16.
 *         For Logging-Framework
 */
public class SLF4JCustomLoggerTest {

    @Test
    public void initiateLogger(){
        Logger logger = LoggerFactory.getLogger(this.getClass());

        logger.info("Class is " + logger.getClass());
    }

    @Test
    public void initializeLogSuccessfully(){
        Logger logger = LoggerFactory.getLogger(this.getClass());

        assertTrue(logger != null);
    }

    @Test
    public void getSameLoggerTwice_ShouldReturnSameLogger(){
        Logger loggableOne = LoggerFactory.getLogger(this.getClass());

        Logger loggabletwo = LoggerFactory.getLogger(this.getClass());

        assertTrue(loggableOne == loggabletwo);
    }

    @Test
    public void getLogLevel_DefaultShouldBeInfo(){
        Logger loggable = LoggerFactory.getLogger(this.getClass());

        assertTrue(loggable.isDebugEnabled());
    }

    @Test
    public void setLogLevel_ShouldBeSame(){
        Logger loggable = LoggerFactory.getLogger(this.getClass());

        ((LoggerImpl)loggable).setCurrentLogLevel(LoggerImpl.LOG_LEVEL.ERROR);
        assertTrue(((LoggerImpl)loggable).getCurrentLogLevel() == LoggerImpl.LOG_LEVEL.ERROR);
    }

    @Test
    public void printErrorLog() {
        Logger loggable = LoggerFactory.getLogger(this.getClass());

        ((LoggerImpl)loggable).setCurrentLogLevel(LoggerImpl.LOG_LEVEL.ERROR);

        loggable.error("Test Message");
    }

    @Test
    public void printRightLog() {
        Logger loggable = LoggerFactory.getLogger(this.getClass());

        ((LoggerImpl)loggable).setCurrentLogLevel(LoggerImpl.LOG_LEVEL.WARN);

        loggable.warn("Test Message");
    }

    @Test(expected = LogLevelNotSupportedException.class)
    public void printWrongLog() {
        Logger loggable = LoggerFactory.getLogger(this.getClass());

        ((LoggerImpl)loggable).setCurrentLogLevel(LoggerImpl.LOG_LEVEL.WARN);

        loggable.error("Test Message");
    }

    @Test
    public void changeLogFile() throws FileNotFoundException {

        final String filePath = "/home/shashi/Logger.log";
        final String message = "Test Message For Logger";
        File file = new File(filePath);
        file.delete();

        Logger loggable = LoggerFactory.getLogger(this.getClass());

        ((LoggerImpl)loggable).setCurrentLogLevel(LoggerImpl.LOG_LEVEL.ERROR);

        ((LoggerImpl)loggable).setOutput(new PrintStream(new FileOutputStream(filePath)));

        loggable.warn(message);

        FileReader input = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(input);

        try {
            assertTrue(reader.readLine().equals(message));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
