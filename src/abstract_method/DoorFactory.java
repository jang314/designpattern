package abstract_method;

import abstract_method.Door.HyundaiDoor;
import abstract_method.Door.LGDoor;

public class DoorFactory {
    public static Door createDoor(VendorID vendorID) {
        Door door = null;
        switch (vendorID) {
            case LG : door = new LGDoor();
            break;
            case HYUNDAI: door = new HyundaiDoor();
            break;
        }
        return door;
    }
}
