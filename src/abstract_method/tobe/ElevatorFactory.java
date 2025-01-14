package abstract_method.tobe;

import abstract_method.Direction;
import abstract_method.Door;
import abstract_method.Door.HyundaiDoor;
import abstract_method.Door.LGDoor;
import abstract_method.Door.SamsungDoor;
import abstract_method.Motor;
import abstract_method.Motor.HyundaiMotor;
import abstract_method.Motor.LGMotor;
import abstract_method.Motor.SamsungMotor;
import abstract_method.VendorID;

import static abstract_method.VendorID.LG;

public abstract class ElevatorFactory {
    public abstract Motor createMotor();
    public abstract Door createDoor();


    public static class LGElevatorFactory extends ElevatorFactory {
        private static ElevatorFactory factory ;
        private LGElevatorFactory() {}

        public static ElevatorFactory getInstance() {
            if(factory == null) {
                factory = new LGElevatorFactory();
            }
            return factory;
        }


        @Override
        protected Motor createMotor() {
            return new LGMotor();
        }

        @Override
        protected Door createDoor() {
            return new LGDoor();
        }
    }

    public static class HyundaiElevatorFactory extends ElevatorFactory {
        private static ElevatorFactory factory ;
        private HyundaiElevatorFactory() {}

        public static ElevatorFactory getInstance() {
            if (factory == null) {
                factory = new HyundaiElevatorFactory();
            }
            return factory;
        }
        @Override
        protected Motor createMotor() {
            return new HyundaiMotor();
        }

        @Override
        protected Door createDoor() {
            return new HyundaiDoor();
        }
    }

    public static class SamsungElevatorFactory extends ElevatorFactory {
        private static ElevatorFactory factory ;
        private SamsungElevatorFactory() {}

        public static ElevatorFactory getInstance() {
            if (factory == null) {
                factory = new SamsungElevatorFactory();
            }
            return factory;
        }
        @Override
        protected Motor createMotor() {
            return new SamsungMotor();
        }

        @Override
        protected Door createDoor() {
            return new SamsungDoor();
        }
    }

    public static class Client {
        public static void main(String[] args) {
            ElevatorFactory factory = null;
            VendorID vendorID = LG;
            switch (vendorID) {
                case LG :
                    factory = new LGElevatorFactory();
                    break;
                case HYUNDAI:
                    factory = new HyundaiElevatorFactory();
                    break;
                case SAMSUNG:
                    factory = new SamsungElevatorFactory();
            }

            Door door = factory.createDoor();
            Motor motor = factory.createMotor();

            motor.setDoor(door);
            door.open();
            motor.move(Direction.UP);
        }
    }
}
