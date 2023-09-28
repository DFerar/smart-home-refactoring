package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.example.smarthome.devices.Door;
import org.example.smarthome.devices.Light;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class Room {
    private final Collection<Light> lights;
    private final Collection<Door> doors;
    private final String name;
}
