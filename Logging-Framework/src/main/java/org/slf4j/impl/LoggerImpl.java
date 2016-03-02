package org.slf4j.impl;

import com.shashi.logging.exception.LogLevelNotSupportedException;
import org.slf4j.Logger;
import org.slf4j.Marker;

import java.io.PrintStream;

/**
 * This class is the implementation class for slf4j's {@link Logger} class.
 * Along with the implementation of the methods such as {@link #warn(Marker, String)}, {@link #error(Marker, String)} etc,
 * it also Provides options for Setting and getting different {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL}, setting
 * {@code out} viz output to print to log to, methods to check if different {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL} has
 * been enabled for current settings or not.
 *
 * @author Shashi Bhushan
 *         Created on 26/2/16.
 *         For Logging-Framework
 */
public class LoggerImpl implements Logger {

    private LOG_LEVEL currentLogLevel;

    private final String clazz;

    private PrintStream out;

    /**
     * Public Constructor of the Class. Provides options to set {@code clazz}, default {@code log_level} of
     * {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL#DEBUG} and {@code out} prints to {@link System#out} i.e. these are the
     * default values for the {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL} and {@link PrintStream} respectively.
     *
     * @param clazz
     *      The class for which this {@link Logger} object has been created
     */
    LoggerImpl(String clazz)  {
        this.clazz = clazz;
        this.currentLogLevel = LOG_LEVEL.DEBUG;
        this.out = System.out;
    }

    /**
     * Returns the name of the Class along with the {@link Class}, for which this is the Logger.
     * The format for this is LoggerImpl[Sample.class]
     *
     * @return
     *      Quantified name of the class along with the Logging Class's name.
     */
    public String getName() {
        return String.format("%s[%s.class]", this.getClass().getName(), clazz);
    }

    /**
     * Does not support Trace operations
     * @return
     */
    public boolean isTraceEnabled() {
        return false;
    }

    public void trace(String s) {

    }

    public void trace(String s, Object o) {

    }

    public void trace(String s, Object o, Object o1) {

    }

    public void trace(String s, Object... objects) {

    }

    public void trace(String s, Throwable throwable) {

    }

    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    public void trace(Marker marker, String s) {

    }

    public void trace(Marker marker, String s, Object o) {

    }

    public void trace(Marker marker, String s, Object o, Object o1) {

    }

    public void trace(Marker marker, String s, Object... objects) {

    }

    public void trace(Marker marker, String s, Throwable throwable) {

    }

    /**
     * Checks if the {@code currentLogLevel} is greater than or equals to Debug's {@code currentLogLevel}.
     * @return
     *      true if the {@code currentLogLevel} is greater than or equal to {@link com.shashi.logging.Loggable.LOG_LEVEL}'s Debug
     *      log level otherwise false
     */
    public boolean isDebugEnabled(){
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.DEBUG.getLogLevel()) ? true : false;
    }

    /**
     * Get the current {@code currentLogLevel}
     * @return
     *      the current {@code currentLogLevel}
     */
    public LOG_LEVEL getCurrentLogLevel(){
        return this.currentLogLevel;
    }

    /**
     * Sets the current {@link com.shashi.logging.Loggable.LOG_LEVEL} to the Specified {@code currentLogLevel}
     */
    public void setCurrentLogLevel(LOG_LEVEL currentLogLevel){
        this.currentLogLevel = currentLogLevel;
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

    public void info(String s, Object o) {

    }

    public void info(String s, Object o, Object o1) {

    }

    public void info(String s, Object... objects) {

    }

    public void info(String s, Throwable throwable) {

    }

    public boolean isInfoEnabled(Marker marker) {
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.INFO.getLogLevel()) ? true : false;
    }

    public void info(Marker marker, String s) {

    }

    public void info(Marker marker, String s, Object o) {

    }

    public void info(Marker marker, String s, Object o, Object o1) {

    }

    public void info(Marker marker, String s, Object... objects) {

    }

    public void info(Marker marker, String s, Throwable throwable) {

    }

    public boolean isWarnEnabled() {
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.WARN.getLogLevel()) ? true : false;
    }

    public void debug(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.DEBUG);
    }

    public void debug(String s, Object o) {

    }

    public void debug(String s, Object o, Object o1) {

    }

    public void debug(String s, Object... objects) {

    }

    public void debug(String s, Throwable throwable) {

    }

    public boolean isDebugEnabled(Marker marker) {
        return this.isDebugEnabled();
    }

    public void debug(Marker marker, String s) {

    }

    public void debug(Marker marker, String s, Object o) {

    }

    public void debug(Marker marker, String s, Object o, Object o1) {

    }

    public void debug(Marker marker, String s, Object... objects) {

    }

    public void debug(Marker marker, String s, Throwable throwable) {

    }

    public boolean isInfoEnabled() {
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.INFO.getLogLevel()) ? true : false;
    }

    public void warn(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.WARN);
    }

    public void warn(String s, Object o) {

    }

    public void warn(String s, Object... objects) {

    }

    public void warn(String s, Object o, Object o1) {

    }

    public void warn(String s, Throwable throwable) {

    }

    public boolean isWarnEnabled(Marker marker) {
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.WARN.getLogLevel()) ? true : false;
    }

    public void warn(Marker marker, String s) {

    }

    public void warn(Marker marker, String s, Object o) {

    }

    public void warn(Marker marker, String s, Object o, Object o1) {

    }

    public void warn(Marker marker, String s, Object... objects) {

    }

    public void warn(Marker marker, String s, Throwable throwable) {

    }

    public boolean isErrorEnabled() {
        return (this.currentLogLevel.getLogLevel() >= LOG_LEVEL.ERROR.getLogLevel()) ? true : false;
    }

    public void error(String message) throws LogLevelNotSupportedException {
        printMessageInternal(message, LOG_LEVEL.ERROR);
    }

    public void error(String s, Object o) {

    }

    public void error(String s, Object o, Object o1) {

    }

    public void error(String s, Object... objects) {

    }

    public void error(String s, Throwable throwable) {

    }

    public boolean isErrorEnabled(Marker marker) {
        return this.isErrorEnabled();
    }

    public void error(Marker marker, String s) {

    }

    public void error(Marker marker, String s, Object o) {

    }

    public void error(Marker marker, String s, Object o, Object o1) {

    }

    public void error(Marker marker, String s, Object... objects) {

    }

    public void error(Marker marker, String s, Throwable throwable) {

    }

    /**
     * Enumeration for different log levels. Supports Info, Debug, Warn and Error Log Levels.
     * Internally, each {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL} is represented by a integer, Starting with 1.
     * Reason for this is to facilitate comparison between different {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL}s, and provide
     * a better implementation for Log Level's getter methods such as {@link #isDebugEnabled()} etc.
     * Notice the snake casing in naming
     */
    public enum LOG_LEVEL{
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

    /**
     * Internal Implementation of Logging for different Log Levels. Takes the argument to log, along with the log level
     * for which to log.
     *
     * @param message
     *      Message to log
     * @param logLevel
     *      {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL}, for which the message should be logged
     *
     * @throws LogLevelNotSupportedException
     *      when the invalid {@link org.slf4j.impl.LoggerImpl.LOG_LEVEL} has been passed.
     */
    private void printMessageInternal(String message, LOG_LEVEL logLevel) throws LogLevelNotSupportedException {
        if(this.currentLogLevel.getLogLevel() >= logLevel.getLogLevel()){
            out.println(message);
        }else{
            throw new LogLevelNotSupportedException(logLevel + " is not Supported at this level of Logging.");
        }
    }

}
