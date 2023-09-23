package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class SmartHome {
    private final Collection<Room> rooms;

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
