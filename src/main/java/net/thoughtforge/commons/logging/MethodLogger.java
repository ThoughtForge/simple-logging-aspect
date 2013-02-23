package net.thoughtforge.commons.logging;

public interface MethodLogger {

	String AFTER = "[ leaving < {} > ]";
	
	String AFTER_RETURNING = "[ leaving < {} > returning {} ]";
	
	String AFTER_THROWING = "[ exception thrown < {} > exception message {} ]";
	
	String BEFORE = "[ entering < {} > ]";

	String BEFORE_WITH_PARAMS = "[ entering < {} > with params {} ]";
	
	void logAfter(LogLevel logLevel, Class<?> loggerClass, String methodName);
	
	void logAfter(LogLevel logLevel, String loggerName, String methodName);
	
	void logAfterReturning(LogLevel logLevel, Class<?> loggerClass, String methodName, Object returnValue);
	
	void logAfterReturning(LogLevel logLevel, String loggerName, String methodName, Object returnValue);
	
	void logBefore(LogLevel logLevel, Class<?> loggerClass, String methodName, Object[] methodParameters);
	
	void logBefore(LogLevel logLevel, String loggerName, String methodName, Object[] methodParameters);
	
	void logException(LogLevel logLevel, Class<?> loggerClass, String methodName, Throwable throwable);
	
	void logException(LogLevel logLevel, String loggerName, String methodName, Throwable throwable);
	
}
