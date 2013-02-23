package org.slf4j.impl;

import org.slf4j.spi.LocationAwareLogger;

public class LogMessage {

	public static final int TRACE = LocationAwareLogger.TRACE_INT;
	
	public static final int DEBUG = LocationAwareLogger.DEBUG_INT;
	
	public static final int INFO = LocationAwareLogger.INFO_INT;
	
	public static final int WARN = LocationAwareLogger.WARN_INT;
	
	public static final int ERROR = LocationAwareLogger.ERROR_INT;
	
	private final int logLevel;

	private final String messageFormat;
        
	private final Object[] parameters;

	public LogMessage(final int logLevel, final String messageFormat, Object... parameters) {

		this.logLevel = logLevel;
		this.messageFormat = messageFormat;
		this.parameters = parameters;
	}

	public int getLogLevel() {

		return logLevel;
	}

	public String getMessageFormat() {

		return messageFormat;
	}
        
	public Object[] getParameters() {
        	
		return parameters;
	}
}
