package org.example;

import org.example.smarthome.eventProcessors.DoorEventProcessor;
import org.example.smarthome.eventProcessors.LightEventProcessor;
import org.example.smarthome.events.EventGenerator;
import org.example.smarthome.loader.SmartHomeLoader;

import java.util.List;

public class Application {
    public static String SMART_HOME_DUMP_FILE = "smart-home-1.json";

    public static void main(String... args) {
        var smartHomeLoader = new SmartHomeLoader(SMART_HOME_DUMP_FILE);
        var smartHome = smartHomeLoader.load();

        var eventGenerator = new EventGenerator();
        eventGenerator.setStopProbability(0.01);
        var processors = List.of(
            new DoorEventProcessor(smartHome), new LightEventProcessor(smartHome)
        );
        var smartHomeRunner = new SmartHomeRunner(processors, eventGenerator);
        smartHomeRunner.run();
    }
}