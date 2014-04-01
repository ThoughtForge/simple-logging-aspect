package net.thoughtforge.aspects.logging;

public enum LogLevel {
    DEBUG,
    ERROR,
    INFO,
    TRACE,
    WARN;
    
    public boolean isDebug() {
    	
    	return this.equals(DEBUG);
    }
    
    public boolean isError() {
    	
    	return this.equals(ERROR);
    }
    
    public boolean isInfo() {
    	
    	return this.equals(INFO);
    }
    
    public boolean isTrace() {
    	
    	return this.equals(TRACE);
    }
    
    public boolean isWarn() {
    	
    	return this.equals(WARN);
    }
}
