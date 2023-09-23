package org.example.smarthome.eventProcessors;

import org.example.smarthome.Room;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.events.SensorEventType;
import org.example.smarthome.SmartHome;
import org.example.smarthome.devices.Light;

public class LightEventProcessor implements  EventProcessor{
    private final SmartHome smartHome;

    public LightEventProcessor(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void processEvent(SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    boolean isLightOn = event.getType() == SensorEventType.LIGHT_ON;
                    light.setOn(isLightOn);
                    System.out.println("Light " + light.getId() + " in room " + room.getName() +
                            " was turned " + (isLightOn ? "on" : "off"));
                }
            }
        }
    }
}
