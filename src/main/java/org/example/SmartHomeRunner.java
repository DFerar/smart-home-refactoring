package org.example;

import lombok.RequiredArgsConstructor;
import org.example.smarthome.eventProcessors.EventProcessor;
import org.example.smarthome.events.EventGenerator;
import org.example.smarthome.events.SensorEvent;

import java.util.List;

@RequiredArgsConstructor
public class SmartHomeRunner {
    private final List<EventProcessor> processors;
    private final EventGenerator eventGenerator;

    public void run() {
        while (true) {
            SensorEvent event = eventGenerator.generateNextSensorEvent();
            if (event == null) break;
            System.out.println("Got event: " + event);
            processors.forEach(processor -> processor.processEvent(event));
        }
    }
}
