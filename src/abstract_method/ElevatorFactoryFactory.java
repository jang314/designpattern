package abstract_method;

import abstract_method.tobe.ElevatorFactory;
import abstract_method.tobe.ElevatorFactory.HyundaiElevatorFactory;
import abstract_method.tobe.ElevatorFactory.LGElevatorFactory;
import abstract_method.tobe.ElevatorFactory.SamsungElevatorFactory;

import static abstract_method.VendorID.LG;

public class ElevatorFactoryFactory {
    public static ElevatorFactory getFactory(VendorID vendorID) {
        ElevatorFactory factory = null;
        switch (vendorID) {
            case LG :
                factory = LGElevatorFactory.getInstance();
                break;
            case HYUNDAI:
                factory = HyundaiElevatorFactory.getInstance();
                break;
            case SAMSUNG:
                factory = SamsungElevatorFactory.getInstance();
                break;
        }
        return factory;
    }

    public static class Client {
        public static void main(String[] args) {
            ElevatorFactory factory = ElevatorFactoryFactory.getFactory(LG);
            Door door = factory.createDoor();
            Motor motor = factory.createMotor();
            motor.setDoor(door);
            door.open();
            motor.move(Direction.UP);
        }
    }
}
