package org.example.smarthome.eventProcessors;

import org.example.smarthome.Room;
import org.example.smarthome.actions.Action;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.events.SensorEventType;
import org.example.smarthome.SmartHome;
import org.example.smarthome.devices.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import static org.example.smarthome.events.SensorEventType.*;


@Component
public class LightEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private Action parseEvent(SensorEvent sensorEvent) {
        SensorEventType sensorEventType = sensorEvent.getType();
        if (sensorEventType != LIGHT_ON && sensorEventType != LIGHT_OFF) {
            return null;
        }
        boolean newLightState = (sensorEventType == LIGHT_ON);
        return object -> {
            if (!(object instanceof Light light)) {
                return;
            }
            if (light.getId().equals(sensorEvent.getObjectId())) {
                light.setOn(newLightState);
            }
        };
    }

    @Override
    public void processEvent(SensorEvent event) {
        Action action = parseEvent(event);
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
