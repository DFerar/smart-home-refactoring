package org.example.smarthome.eventProcessors;

import org.example.smarthome.events.SensorEvent;
import org.springframework.stereotype.Component;


public interface EventProcessor {
    void processEvent(SensorEvent event);
}
