package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
@Component
public class SmartHome {
    private final Collection<Room> rooms;

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
