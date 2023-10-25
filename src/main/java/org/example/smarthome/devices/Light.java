package org.example.smarthome.devices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.smarthome.actions.Action;
import org.example.smarthome.actions.Actionable;

@Getter
@Setter
@AllArgsConstructor
public class Light implements Device, Actionable {
    private final String id;
    private boolean isOn;

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
