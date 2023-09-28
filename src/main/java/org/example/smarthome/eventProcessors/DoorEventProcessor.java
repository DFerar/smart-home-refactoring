package org.example.smarthome.eventProcessors;

import lombok.RequiredArgsConstructor;
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
        boolean isDoorOpen = event.getType() == SensorEventType.DOOR_OPEN;
        RoomAndDoor roomAndDoor = findRoomAndDoorForEvent(event);
        if (roomAndDoor == null) return;

        roomAndDoor.door.setOpen(isDoorOpen);
        System.out.println("Door " + roomAndDoor.door.getId() + " in room " + roomAndDoor.room.getName() +
            " was " + (isDoorOpen ? "opened" : "closed"));
        turnOffAllLightsIfHallDoor(isDoorOpen, roomAndDoor.room);
    }

    private RoomAndDoor findRoomAndDoorForEvent(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    return new RoomAndDoor(room, door);
                }
            }
        }
        return null;
    }

    private void turnOffAllLightsIfHallDoor(boolean isDoorOpen, Room room) {
        if (!room.getName().equals("hall") || !isDoorOpen) return;

        for (Room homeRoom : smartHome.getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
            }
        }
    }

    @RequiredArgsConstructor
    private static class RoomAndDoor {
        private final Room room;
        private final Door door;
    }
}
