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

AspectJ compile time weaving weaves the logging aspect into your code at
compile time.  As a result, there are no directives or agents required at
runtime.

Assuming you are using Maven, in order to enable AspectJ weaving process you
need to use the aspectj-maven-plugin plugin and configure it appropriately in
the pom.xml. Below is an example of the aspectj-maven-plugin configuration:

<pre>
	<plugin>
		<groupId>org.codehaus.mojo</groupId>
		<artifactId>aspectj-maven-plugin</artifactId>
		<version>1.4</version>
		<executions>
			<execution>
				<configuration>
					<source>${project.build.source}</source>
					<target>${project.build.target}</target>
	
					<outxml>true</outxml>
				</configuration>
				<goals>
					<goal>compile</goal>
					<goal>test-compile</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
</pre>

Using with AspectJ Load Time Weaving
------------------------------------

TODO


Using with Spring AOP Proxy Based Weaving
-----------------------------------------

TODO