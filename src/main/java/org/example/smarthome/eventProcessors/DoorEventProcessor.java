package org.example.smarthome.eventProcessors;

import org.example.smarthome.Room;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.events.SensorEventType;
import org.example.smarthome.SmartHome;
import org.example.smarthome.devices.Door;

public class DoorEventProcessor implements EventProcessor {
    private final SmartHome smartHome;

    public DoorEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    boolean isDoorOpen = event.getType() == SensorEventType.DOOR_OPEN;
                    door.setOpen(isDoorOpen);
                    System.out.println("Door " + door.getId() + " in room " + room.getName() +
                            " was " + (isDoorOpen ? "opened" : "closed"));
                }
            }
        }
    }
}
