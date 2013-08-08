package net.thoughtforge.commons.logging.aspect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.math.BigDecimal;
import java.util.Date;

import net.thoughtforge.commons.logging.MethodLogger;
import net.thoughtforge.commons.logging.SimpleBean;
import net.thoughtforge.commons.logging.SimpleBeanSubclass;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.impl.LogMessage;
import org.slf4j.impl.MockLogger;
import org.slf4j.impl.MockLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

public class LoggingAspectTest {

    private MockLoggerFactory loggerFactory = (MockLoggerFactory) StaticLoggerBinder.getSingleton().getLoggerFactory();

    private SimpleBean simpleBean;

    private SimpleBeanSubclass simpleBeanSubclass;

    private Date datePropertyValue;

    @Before
    public void before() throws Exception {
        datePropertyValue = DateUtils.parseDate("01/01/2010", new String[] {"dd/MM/yyyy"});
        
        simpleBean = new SimpleBean();
        simpleBean.setDateProperty(datePropertyValue);
        simpleBean.setIntegerProperty(2);
        simpleBean.setStringProperty("stringProperty");

        simpleBeanSubclass = new SimpleBeanSubclass();
        simpleBeanSubclass.setDateProperty(datePropertyValue);
        simpleBeanSubclass.setDecimalProperty(new BigDecimal("0.25"));
        simpleBeanSubclass.setIntegerProperty(2);
        simpleBeanSubclass.setStringProperty("stringProperty");
        
        loggerFactory.reset();
    }
    
    @Test
    public void testSimpleBeanSetDateProperty() throws Exception {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.setDateProperty(datePropertyValue);

        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setDateProperty",
                datePropertyValue);
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
        		LogMessage.INFO,
                MethodLogger.AFTER,
                "setDateProperty");
    }

    @Test
    public void testSimpleBeanSetIntegerProperty() {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.setIntegerProperty(2);

        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setIntegerProperty",
                2);
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setIntegerProperty");
    }

    @Test
    public void testSimpleBeanSetStringProperty() {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.setStringProperty("stringProperty");

        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setStringProperty",
                "stringProperty");
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setStringProperty");
    }

    @Test
    public void testSimpleBeanGetDateProperty() {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.getDateProperty();
        
        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getDateProperty");
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getDateProperty",
                datePropertyValue);
    }

    @Test
    public void testSimpleBeanGetIntegerProperty() {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.getIntegerProperty();

        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getIntegerProperty");
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getIntegerProperty",
                2);
    }

    @Test
    public void testSimpleBeanGetStringProperty() {

    	assertThat(getLogger(SimpleBean.class).getMessages().size(), is(0));
    	
        simpleBean.getStringProperty();

        assertThat(getLogger(SimpleBean.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getStringProperty");
        
        assertEquals(getLogger(SimpleBean.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getStringProperty",
                "stringProperty");
    }

    @Test
    public void testSimpleBeanSubclassSetDateProperty() throws Exception {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.setDateProperty(datePropertyValue);

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setDateProperty",
                datePropertyValue);
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setDateProperty");
    }

    @Test
    public void testSimpleBeanSubclassSetDecimalProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.setDecimalProperty(new BigDecimal("0.25"));

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setDecimalProperty",
                new BigDecimal("0.25"));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setDecimalProperty");
    }

    @Test
    public void testSimpleBeanSubclassSetIntegerProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.setIntegerProperty(2);

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setIntegerProperty",
                2);
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setIntegerProperty");
    }

    @Test
    public void testSimpleBeanSubclassSetStringProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.setStringProperty("stringProperty");

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE_WITH_PARAMS,
                "setStringProperty",
                "stringProperty");
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER,
                "setStringProperty");
    }

    @Test
    public void testSimpleBeanSubclassGetDateProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.getDateProperty();

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getDateProperty");
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getDateProperty",
                datePropertyValue);
    }

    @Test
    public void testSimpleBeanSubclassGetDecimalProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.getDecimalProperty();

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getDecimalProperty");
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getDecimalProperty",
                new BigDecimal("0.25"));
    }

    @Test
    public void testSimpleBeanSubclassGetIntegerProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.getIntegerProperty();

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getIntegerProperty");
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getIntegerProperty",
                2);
    }

    @Test
    public void testSimpleBeanSubclassGetStringProperty() {

    	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
    	
        simpleBeanSubclass.getStringProperty();

        assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                LogMessage.INFO,
                MethodLogger.BEFORE,
                "getStringProperty");
        
        assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                LogMessage.INFO,
                MethodLogger.AFTER_RETURNING,
                "getStringProperty",
                "stringProperty");
    }

    @Test
    public void testThrowException() {

        try {
        	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(0));
        	
            simpleBeanSubclass.throwException();
        } catch (final Throwable throwable) {
        	assertThat(getLogger(SimpleBeanSubclass.class).getMessages().size(), is(2));
            
            assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(0),
                    LogMessage.INFO,
                    MethodLogger.BEFORE,
                    "throwException");
            
            assertEquals(getLogger(SimpleBeanSubclass.class).getMessages().get(1),
                    LogMessage.INFO,
                    MethodLogger.AFTER_THROWING,
                    "java.lang.RuntimeException");
        }
    }

    private MockLogger getLogger(Class<?> clazz) {

    	return (MockLogger) loggerFactory.getLogger(clazz.getName());
    }
    
    private void assertEquals(final LogMessage logMessage, final int logLevel, final String messageFormat, Object... parameters) {

    	assertThat(logMessage.getLogLevel(), equalTo(logLevel));
    	assertThat(logMessage.getMessageFormat(), equalTo(messageFormat));
        for (int i = 0; i < parameters.length ; i++) {
        	Object expected = parameters[i];
        	Object actual = logMessage.getParameters()[i];
        	
        	assertThat(actual, equalTo(expected));
        }
    }
}
