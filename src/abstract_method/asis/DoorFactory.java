package abstract_method.asis;

import abstract_method.Door;
import abstract_method.Door.HyundaiDoor;
import abstract_method.Door.LGDoor;
import abstract_method.VendorID;

public class DoorFactory {
    public static Door createDDoor(VendorID vendorID) {
        Door door = null;
        switch (vendorID) {
            case LG:
                door = new LGDoor();
                break;
            case HYUNDAI:
                door = new HyundaiDoor();
                break;
        }
        return door;

    }
}
