package abstract_method;

import abstract_method.asis.DoorFactory;

import static abstract_method.VendorID.LG;

public class Client {
    public static void main(String[] args) {
        Door lgDoor = DoorFactory.createDDoor(LG);
        Motor lgMotor = MotorFactory.createMotor(LG);
        lgMotor.setDoor(lgDoor);

        lgDoor.open();
        lgMotor.move(Direction.UP);

    }
}
