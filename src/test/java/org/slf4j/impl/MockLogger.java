package org.slf4j.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.helpers.MarkerIgnoringBase;

public class MockLogger extends MarkerIgnoringBase {

	private static final long serialVersionUID = 8215162005673056370L;
	
	public List<LogMessage> messages = new ArrayList<LogMessage>();
	
	public MockLogger(final String loggerName) {
		
	}
	
	@Override
	public boolean isTraceEnabled() {

		return true;
	}

	@Override
	public void trace(String message) {
		
		messages.add(new LogMessage(LogMessage.TRACE, message));
	}

	@Override
	public void trace(String format, Object argument) {
		
		messages.add(new LogMessage(LogMessage.TRACE, format, argument));
	}

	@Override
	public void trace(String format, Object argument1, Object argument2) {

		messages.add(new LogMessage(LogMessage.TRACE, format, argument1, argument2));
	}

	@Override
	public void trace(String format, Object... arguments) {
		
		messages.add(new LogMessage(LogMessage.TRACE, format, arguments));
	}

	@Override
	public void trace(String message, Throwable throwable) {
		
		messages.add(new LogMessage(LogMessage.TRACE, message, throwable));
	}

	@Override
	public boolean isDebugEnabled() {
		
		return true;
	}

	@Override
	public void debug(String message) {
		
		messages.add(new LogMessage(LogMessage.DEBUG, message));
	}

	@Override
	public void debug(String format, Object argument) {
		
		messages.add(new LogMessage(LogMessage.DEBUG, format, argument));
	}

	@Override
	public void debug(String format, Object argument1, Object argument2) {

		messages.add(new LogMessage(LogMessage.DEBUG, format, argument1, argument2));
	}

	@Override
	public void debug(String format, Object... arguments) {
		
		messages.add(new LogMessage(LogMessage.DEBUG, format, arguments));
	}

	@Override
	public void debug(String message, Throwable throwable) {
		
		messages.add(new LogMessage(LogMessage.DEBUG, message, throwable));
	}

	@Override
	public boolean isInfoEnabled() {
		
		return true;
	}

	@Override
	public void info(String message) {

		messages.add(new LogMessage(LogMessage.INFO, message));
	}

	@Override
	public void info(String format, Object argument) {
		
		messages.add(new LogMessage(LogMessage.INFO, format, argument));
	}

	@Override
	public void info(String format, Object argument1, Object argument2) {

		messages.add(new LogMessage(LogMessage.INFO, format, argument1, argument2));
	}

	@Override
	public void info(String format, Object... arguments) {
		
		messages.add(new LogMessage(LogMessage.INFO, format, arguments));
	}

	@Override
	public void info(String message, Throwable throwable) {
		
		messages.add(new LogMessage(LogMessage.INFO, message, throwable));
	}

	@Override
	public boolean isWarnEnabled() {
		
		return true;
	}

	@Override
	public void warn(String message) {
		
		messages.add(new LogMessage(LogMessage.WARN, message));
	}

	@Override
	public void warn(String format, Object argument) {
		
		messages.add(new LogMessage(LogMessage.WARN, format, argument));
	}

	@Override
	public void warn(String format, Object argument1, Object argument2) {

		messages.add(new LogMessage(LogMessage.WARN, format, argument1, argument2));
	}

	@Override
	public void warn(String format, Object... arguments) {
		
		messages.add(new LogMessage(LogMessage.WARN, format, arguments));
	}

	@Override
	public void warn(String message, Throwable throwable) {
		
		messages.add(new LogMessage(LogMessage.WARN, message, throwable));
	}

	@Override
	public boolean isErrorEnabled() {
		
		return true;
	}

	@Override
	public void error(String message) {
		
		messages.add(new LogMessage(LogMessage.ERROR, message));
	}

	@Override
	public void error(String format, Object argument) {
		
		messages.add(new LogMessage(LogMessage.ERROR, format, argument));
	}

	@Override
	public void error(String format, Object argument1, Object argument2) {

		messages.add(new LogMessage(LogMessage.ERROR, format, argument1, argument2));
	}

	@Override
	public void error(String format, Object... arguments) {
		
		messages.add(new LogMessage(LogMessage.ERROR, format, arguments));
	}

	@Override
	public void error(String message, Throwable throwable) {
		
		messages.add(new LogMessage(LogMessage.ERROR, message, throwable));
	}
	
    public void reset() {

        messages = new ArrayList<LogMessage>();
    }

    public List<LogMessage> getMessages() {

        return Collections.unmodifiableList(messages);
    }
}
