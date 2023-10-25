package org.example.smarthome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.smarthome.actions.Action;
import org.example.smarthome.actions.Actionable;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class SmartHome implements Actionable {
    private final List<Room> rooms;

    @Override
    public void execute(Action action) {
        action.execute(this);
        rooms.forEach(room -> room.execute(action));
    }
}
