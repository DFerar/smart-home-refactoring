package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Component
public class SmartHome {

    private final List<Room> rooms;

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
