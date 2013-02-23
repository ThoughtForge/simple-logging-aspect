package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class MockLoggerFactory implements ILoggerFactory {

	final static MockLoggerFactory INSTANCE = new MockLoggerFactory();

	Map<String, Logger> loggerMap;

	public MockLoggerFactory() {
	  
		loggerMap = new HashMap<String, Logger>();
	}

	public Logger getLogger(String name) {
	  
		Logger slogger = null;

		synchronized (this) {
			slogger = loggerMap.get(name);
    	
			if (slogger == null) {
				slogger = new MockLogger(name);
				loggerMap.put(name, slogger);
			}
		}
		
		return slogger;
	}
	
    public void reset() {

    	loggerMap = new HashMap<String, Logger>();
    }
}
