Simple Logging Aspect
=====================


Introduction
------------

The Simple Logging Aspect (SLA) facilitates logging method invocation details
before a method is invoked and after a method returns.  The logger name is the
class name of the enclosing class and the log level is specified via an
annotation parameter.

It is possible to specify if the method parameters and return value should be
logged.  Method parameters and return values are logged by their string
representation as returned by invoking toString.

Below is an example of annotating a method to be logged:

@Log(logLevel=LogLevel.INFO, logParameters=true)


Using with AspectJ Compile Time Weaving
---------------------------------------

TODO


Using with AspectJ Load Time Weaving
------------------------------------

TODO


Using with Spring AOP Proxy Based Weaving
-----------------------------------------

TODO