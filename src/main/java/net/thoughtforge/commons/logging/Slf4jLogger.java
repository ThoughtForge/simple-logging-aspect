package net.thoughtforge.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogger extends AbstractLogger {

	@Override
	public void debug(String loggerName, String messageFormat, Object... parameters) {
		
		getLogger(loggerName).debug(messageFormat, parameters);
	}
	
	@Override
	public void error(String loggerName, String messageFormat, Object... parameters) {
		
		getLogger(loggerName).error(messageFormat, parameters);
	}
	
	@Override
	public void info(String loggerName, String messageFormat, Object... parameters) {
		
		getLogger(loggerName).info(messageFormat, parameters);
	}
	
	@Override
	public void warn(String loggerName, String messageFormat, Object... parameters) {
		
		getLogger(loggerName).warn(messageFormat, parameters);
	}
	
	@Override
	public void trace(String loggerName, String messageFormat, Object... parameters) {
		
		getLogger(loggerName).trace(messageFormat, parameters);
	}
	
	@Override
	public boolean isLogLevelEnabled(LogLevel logLevel, String loggerName) {
		
		if (logLevel.isDebug()) {
			
			return isDebugEnabled(loggerName);
		} else if (logLevel.isError()) {
			
			return isErrorEnabled(loggerName);
		} else if (logLevel.isInfo()) {
			
			return isInfoEnabled(loggerName);
		} else if (logLevel.isTrace()) {
			
			return isTraceEnabled(loggerName);
		} else if (logLevel.isWarn()) {
			
			return isWarnEnabled(loggerName);
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isDebugEnabled(String loggerName) {
		
		return getLogger(loggerName).isDebugEnabled();
	}
	
	@Override
	public boolean isErrorEnabled(String loggerName) {
		
		return getLogger(loggerName).isErrorEnabled();
	}
	
	@Override
	public boolean isInfoEnabled(String loggerName) {
		
		return getLogger(loggerName).isInfoEnabled();
	}
	
	@Override
	public boolean isWarnEnabled(String loggerName) {
		
		return getLogger(loggerName).isWarnEnabled();
	}
	
	@Override
	public boolean isTraceEnabled(String loggerName) {
		
		return getLogger(loggerName).isTraceEnabled();
	}
	
    private Logger getLogger(final String loggerName) {

        return LoggerFactory.getLogger(loggerName);
    }
}
