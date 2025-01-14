package template_method.asis;

import template_method.DoorStatus;

public class Door {
    private DoorStatus doorStatus;

    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void close() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public void open() {
        this.doorStatus = DoorStatus.OPENED;
    }
}
