package org.tomighty.plugin.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomighty.bus.Bus;
import org.tomighty.plugin.Plugin;

import javax.inject.Inject;

/**
 * The world's most famous programming greeting.
 *
 * You can have only one implementation of the Plugin interface in your
 * jar. And you must put your plugin's fully-qualified class name
 * in a tomighty-plugin.properties file at the root of your jar file.
 * See the sample file at /src/main/resources directory in this project.
 */
public class HelloWorldPlugin implements Plugin {

    private final Bus bus;

    /**
     * This logger is here to show you that you can use whatever
     * you want with your plugin. Just don't forget to package all
     * dependency jars along with your plugin jar.
     */
    private final Logger slf4jLogger;

    @Inject
    public HelloWorldPlugin(Bus bus) {
        this.bus = bus;
        slf4jLogger = LoggerFactory.getLogger(getClass());
        slf4jLogger.info("Hello world with slf4j logger");
    }

    /**
     * This method is used by unit tests. You don't need to add it.
     */
    public Bus getInjectedBus() {
        return bus;
    }

}
