package org.example.smarthome.devices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Door implements Device {
    private final String id;
    private boolean isOpen;
}
