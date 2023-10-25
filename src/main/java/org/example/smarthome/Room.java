package org.example.smarthome;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.smarthome.actions.Action;
import org.example.smarthome.actions.Actionable;
import org.example.smarthome.devices.Device;
import org.example.smarthome.devices.Door;
import org.example.smarthome.devices.Light;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room implements Actionable {
    private final List<Light> lights;
    private final List<Door> doors;
    private final String name;

    @Override
    public void execute(Action action) {
        action.execute(this);
        lights.forEach(light -> light.execute(action));
        doors.forEach(door -> door.execute(action));
    }
}
