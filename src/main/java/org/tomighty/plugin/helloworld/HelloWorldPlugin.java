package org.tomighty.plugin.helloworld;

import org.apache.commons.math.random.JDKRandomGenerator;
import org.apache.commons.math.random.RandomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomighty.bus.Bus;
import org.tomighty.plugin.Plugin;

import javax.annotation.PostConstruct;
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
    private final Logger slf4jLogger = LoggerFactory.getLogger(getClass());

    /**
     * This random generator is here to show you that you can use whatever
     * libraries you want with your plugin. Just don't forget to include
     * them in your plugin distribution.
     */
    private final RandomGenerator randomGenerator = new JDKRandomGenerator();

    @Inject
    public HelloWorldPlugin(Bus bus) {
        this.bus = bus;
    }

    @PostConstruct
    public void initialize() {
        int randomNumber = randomGenerator.nextInt();
        slf4jLogger.info("Hello world! Look the random number I just generated {}", randomNumber);
    }

    /**
     * This method is used by unit tests. You don't need to add it.
     */
    public Bus getInjectedBus() {
        return bus;
    }

}
