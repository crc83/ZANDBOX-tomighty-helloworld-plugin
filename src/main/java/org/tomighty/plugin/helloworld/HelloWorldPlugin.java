package org.tomighty.plugin.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomighty.ioc.Initializable;
import org.tomighty.ioc.Inject;
import org.tomighty.ioc.New;
import org.tomighty.log.Log;
import org.tomighty.plugin.Plugin;

/**
 * The world's most famous programming greeting.
 *
 * You can have only one implementation of the Plugin interface in your
 * jar. And you must put your plugin's fully-qualified class name
 * in a tomighty-plugin.properties file at the root of your jar file.
 * See the sample file at /src/main/resources directory in this project.
 *
 * The Initializable interface is optional.
 */
public class HelloWorldPlugin implements Plugin, Initializable {

    @Inject @New
    private Log tomightyLogger;

    /**
     * This logger is here to show you that you can use whatever
     * you want with your plugin. Just don't forget to package all
     * dependency jars along with your plugin jar.
     */
    private Logger slf4jLogger = LoggerFactory.getLogger(getClass());

    public HelloWorldPlugin() {
        slf4jLogger.info("Hello world with slf4j logger");
    }

    @Override
    public void initialize() {
        tomightyLogger.info("Hello world with Tomighty's logger");
    }

    /**
     * This method is used by unit tests. You don't need to add it.
     */
    public Log getInjectedLogger() {
        return tomightyLogger;
    }

}
