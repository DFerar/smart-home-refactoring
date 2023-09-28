package org.example.smarthome.eventProcessors;

import org.example.smarthome.Room;
import org.example.smarthome.devices.Light;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.events.SensorEventType;
import org.example.smarthome.SmartHome;
import org.example.smarthome.devices.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoorEventProcessor implements EventProcessor {

    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        //TODO if door is hall => turn off all lights
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    boolean isDoorOpen = event.getType() == SensorEventType.DOOR_OPEN;
                    door.setOpen(isDoorOpen);
                    System.out.println("Door " + door.getId() + " in room " + room.getName() +
                            " was " + (isDoorOpen ? "opened" : "closed"));
                }
                if (room.getName().equals("hall")) {
                    for (Room homeRoom : smartHome.getRooms()) {
                        for (Light light : homeRoom.getLights()) {
                            light.setOn(false);
                        }
                    }
                }
            }
        }
    }
}
