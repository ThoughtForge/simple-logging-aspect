package net.thoughtforge.aspects.logging;

public interface Logger {

	void debug(String loggerName, String messageFormat, Object... parameters);
	
	void error(String loggerName, String messageFormat, Object... parameters);
	
	void info(String loggerName, String messageFormat, Object... parameters);
	
	void warn(String loggerName, String messageFormat, Object... parameters);
	
	void trace(String loggerName, String messageFormat, Object... parameters);
	
	boolean isLogLevelEnabled(LogLevel logLevel, String loggerName);
	
	boolean isDebugEnabled(String loggerName);
	
	boolean isErrorEnabled(String loggerName);
	
	boolean isInfoEnabled(String loggerName);
	
	boolean isWarnEnabled(String loggerName);
	
	boolean isTraceEnabled(String loggerName);
}
