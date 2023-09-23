package org.example.smarthome.eventProcessors;

import org.example.smarthome.events.SensorEvent;

public interface EventProcessor {
    void processEvent(SensorEvent event);
}
