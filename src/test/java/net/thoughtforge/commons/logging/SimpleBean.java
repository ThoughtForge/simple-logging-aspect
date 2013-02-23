package net.thoughtforge.commons.logging;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SimpleBean {

    private Date dateProperty;

    private Integer integerProperty;

    private String stringProperty;

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public void methodWithMultipleParameters(final Integer integerParameter, final Date dateParameter,
    		final SimpleBean simpleBeanParameter) {

    }
	
	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public Date getDateProperty() {

        return dateProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public void setDateProperty(final Date dateProperty) {

        this.dateProperty = dateProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public Integer getIntegerProperty() {

        return integerProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public void setIntegerProperty(final Integer integerProperty) {

        this.integerProperty = integerProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public String getStringProperty() {

        return stringProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public void setStringProperty(final String stringProperty) {

        this.stringProperty = stringProperty;
    }

	@Log(logLevel=LogLevel.INFO, logParameters=true)
    public void throwException() {

        throw new RuntimeException();
    }

    public String toString() {

        return new ToStringBuilder(this)
                .append("dateProperty", dateProperty)
                .append("integerProperty", integerProperty)
                .append("stringProperty", stringProperty)
                .toString();
    }
}
