package org.example.smarthome.devices;

public class Door implements Device{
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
