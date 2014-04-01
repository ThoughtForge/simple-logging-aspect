package net.thoughtforge.aspects.logging;

import org.apache.commons.lang3.ArrayUtils;

public abstract class AbstractLogger implements MethodLogger, Logger {

	public void logAfter(LogLevel logLevel, Class<?> loggerClass, String methodName) {
		
		logAfter(logLevel, loggerClass.getName(), methodName);
	}
	
	public void logAfter(LogLevel logLevel, String loggerName, String methodName) {
		
		if (!isLogLevelEnabled(logLevel, loggerName)) {
			return;
		}
		
		log(logLevel, loggerName, AFTER, methodName);
	}
	
	public void logAfterReturning(LogLevel logLevel, Class<?> loggerClass, String methodName, Object returnValue) {
		
		logAfterReturning(logLevel, loggerClass.getName(), methodName, returnValue);
	}
	
	public void logAfterReturning(LogLevel logLevel, String loggerName, String methodName, Object returnValue) {
		
		if (!isLogLevelEnabled(logLevel, loggerName)) {
			return;
		}
		
		log(logLevel, loggerName, AFTER_RETURNING, methodName, returnValue);
	}
	
	public void logBefore(LogLevel logLevel, Class<?> loggerClass, String methodName, Object[] methodParameters) {

		logBefore(logLevel, loggerClass.getName(), methodName, methodParameters);
	}
	
	public void logBefore(LogLevel logLevel, String loggerName, String methodName, Object[] methodParameters) {
		
		if (!isLogLevelEnabled(logLevel, loggerName)) {
			return;
		}
			
		if (ArrayUtils.isEmpty(methodParameters)) {
			
			log(logLevel, loggerName, BEFORE, methodName);
		} else {

			log(logLevel, loggerName, BEFORE_WITH_PARAMS, ArrayUtils.addAll(new Object[] {methodName}, methodParameters));
		}
	}
	
	public void logException(LogLevel logLevel, Class<?> loggerClass, String methodName, Throwable throwable) {
		
		logException(logLevel, loggerClass.getName(), methodName, throwable);
	}
	
	public void logException(LogLevel logLevel, String loggerName, String methodName, Throwable throwable) {

		if (!isLogLevelEnabled(logLevel, loggerName)) {
			return;
		}
		
		log(logLevel, loggerName, AFTER_THROWING, throwable.getClass().getName(), throwable.getLocalizedMessage());
	}
	
    private void log(final LogLevel logLevel, final String loggerName, final String messageFormat, final Object... parameters) {

        switch (logLevel) {

            case DEBUG:
            	debug(loggerName, messageFormat, parameters);
                break;

            case ERROR:
            	error(loggerName, messageFormat, parameters);
                break;

            case INFO:
            	info(loggerName, messageFormat, parameters);
                break;

            case TRACE:
            	trace(loggerName, messageFormat, parameters);
                break;

            case WARN:
            	warn(loggerName, messageFormat, parameters);
                break;
        }
    }
}
