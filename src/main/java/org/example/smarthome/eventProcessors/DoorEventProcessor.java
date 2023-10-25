package org.example.smarthome.eventProcessors;

import org.example.smarthome.actions.Action;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.events.SensorEventType;
import org.example.smarthome.SmartHome;
import org.example.smarthome.devices.Door;
import org.springframework.stereotype.Component;

import static org.example.smarthome.events.SensorEventType.*;

@Component
public class DoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private Action parseEvent(SensorEvent sensorEvent) {
        SensorEventType sensorEventType = sensorEvent.getType();
        if (sensorEventType != DOOR_CLOSED && sensorEventType != DOOR_OPEN) {
            return null;
        }
        boolean newDoorState = (sensorEventType == DOOR_OPEN);
        return object -> {
            if (!(object instanceof Door door)) {
                return;
            }
            if (door.getId().equals(sensorEvent.getObjectId())) {
                door.setOpen(newDoorState);
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
