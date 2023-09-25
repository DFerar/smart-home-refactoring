package org.example;

import org.example.smarthome.AppConfig;
import org.example.smarthome.eventProcessors.DoorEventProcessor;
import org.example.smarthome.eventProcessors.LightEventProcessor;
import org.example.smarthome.events.EventGenerator;
import org.example.smarthome.loader.SmartHomeLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


public class Application {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SmartHomeRunner smartHomeRunner = context.getBean(SmartHomeRunner.class);
        smartHomeRunner.run();
    }
        /*var smartHomeLoader = new SmartHomeLoader();
        var smartHome = smartHomeLoader.load();

        var eventGenerator = new EventGenerator();
        eventGenerator.setStopProbability(0.01);
        var processors = List.of(
            new DoorEventProcessor(smartHome), new LightEventProcessor(smartHome)
        );
        var smartHomeRunner = new SmartHomeRunner(processors, eventGenerator);
        smartHomeRunner.run();
    }*/
}