package net.thoughtforge.aspects.logging;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SimpleBeanSubclass extends SimpleBean {

    private BigDecimal decimalProperty;

    @Log(logLevel=LogLevel.INFO, logParameters=true)
    public BigDecimal getDecimalProperty() {

        return decimalProperty;
    }

    @Log(logLevel=LogLevel.INFO, logParameters=true)
    public void setDecimalProperty(final BigDecimal decimalProperty) {

        this.decimalProperty = decimalProperty;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this)
                .append("decimalProperty", decimalProperty)
                .appendSuper(super.toString())
                .toString();
    }
}
