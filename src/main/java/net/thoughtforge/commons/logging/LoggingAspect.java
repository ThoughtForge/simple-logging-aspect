package net.thoughtforge.commons.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {

	private MethodLogger methodLogger = new Slf4jLogger();
	
    @Before(value = "execution(* *.*(..)) && @annotation(log)", argNames = "joinPoint, log")
    public void before(final JoinPoint joinPoint, final Log log) {
        
    	LogLevel logLevel = log.logLevel();
    	Class<?> clazz = joinPoint.getTarget().getClass();
    	String methodName = joinPoint.getSignature().getName();
    	Object[] parameters = new Object[] {};
    	if (log.logParameters()) {
    		parameters = joinPoint.getArgs();
    	}
    	
    	methodLogger.logBefore(logLevel, clazz, methodName, parameters);	
    }

    @AfterReturning(value = "execution(* *.*(..)) && @annotation(log)", returning = "returnValue", argNames = "joinPoint, log, returnValue")
    public void afterReturning(final JoinPoint joinPoint, final Log log, final Object returnValue) {

    	LogLevel logLevel = log.logLevel();
    	Class<?> clazz = joinPoint.getTarget().getClass();
    	String methodName = joinPoint.getSignature().getName();
    	Class<?> returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
    	
    	if (returnType.getName().equals("void") || !log.logParameters()) {
    		methodLogger.logAfter(logLevel, clazz, methodName);
    	} else {
    		methodLogger.logAfterReturning(logLevel, clazz, methodName, returnValue);
    	}
    }
    
    @AfterThrowing(value = "execution(* *.*(..)) && @annotation(log)", throwing = "throwable", argNames = "joinPoint, log, throwable")
    public void afterThrowing(final JoinPoint joinPoint, final Log log, final Throwable throwable) {

    	LogLevel logLevel = log.logLevel();
    	Class<?> clazz = joinPoint.getTarget().getClass();
    	String methodName = joinPoint.getSignature().getName();
    	
    	methodLogger.logException(logLevel, clazz, methodName, throwable);
    }
}
