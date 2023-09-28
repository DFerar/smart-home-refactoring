package org.example;

import org.example.smarthome.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


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
