package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class SmartHome {
    private final List<Room> rooms;

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
