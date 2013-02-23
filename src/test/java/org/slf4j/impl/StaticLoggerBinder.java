package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

	private static final String loggerFactoryClassStr = MockLoggerFactory.class.getName();
	
	private final ILoggerFactory loggerFactory;
	
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
	
	public static String REQUESTED_API_VERSION = "1.6.99";
	
	public static final StaticLoggerBinder getSingleton() {
	  
		return SINGLETON;
	}

	private StaticLoggerBinder() {
		
		loggerFactory = new MockLoggerFactory();
	}

	public ILoggerFactory getLoggerFactory() {
		
		return loggerFactory;
	}

	public String getLoggerFactoryClassStr() {
		
		return loggerFactoryClassStr;
	}
}
