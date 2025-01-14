package template_method.asis;

public class Client {
    public static void main(String[] args) {
        Door door = new Door();
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.UP);

    }

    public enum DoorStatus {
        CLOSED, OPENED
    }

    public enum MotorStatus {
        MOVING, STOPPED
    }

    public enum Direction {
        UP, DOWN
    }

    public static class Door {
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

    public static class HyundaiMotor {
        private Door door;
        private MotorStatus motorStatus;

        public HyundaiMotor(Door door) {
            this.door = door;
            this.motorStatus = MotorStatus.STOPPED;
        }

        private void moveHyundaiMotor(Direction direction) {
            // Motor 구동
        }

        public MotorStatus getMotorStatus() {
            return motorStatus;
        }

        private void setMotorStatus(MotorStatus motorStatus) {
            this.motorStatus = motorStatus;
        }

        public void move(Direction direction) {
            MotorStatus motorStatus = getMotorStatus();
            if(motorStatus == MotorStatus.MOVING) {
                return;
            }

            DoorStatus doorStatus = door.getDoorStatus();
            if(doorStatus == DoorStatus.OPENED) {
                door.close();
            }

            moveHyundaiMotor(direction);
            setMotorStatus(MotorStatus.MOVING);
        }
    }

    public static class LGMotor {
        private Door door;
        private MotorStatus motorStatus;

        public LGMotor(Door door) {
            this.door = door;
            this.motorStatus = MotorStatus.STOPPED;
        }

        private void moveLGMotor(Direction direction) {
            // Motor 구동
        }

        public MotorStatus getMotorStatus() {
            return motorStatus;
        }

        private void setMotorStatus(MotorStatus motorStatus) {
            this.motorStatus = motorStatus;
        }

        public void move(Direction direction) {
            MotorStatus motorStatus = getMotorStatus();
            if(motorStatus == MotorStatus.MOVING) {
                return;
            }

            DoorStatus doorStatus = door.getDoorStatus();
            if(doorStatus == DoorStatus.OPENED) {
                door.close();
            }

            moveLGMotor(direction);
            setMotorStatus(MotorStatus.MOVING);
        }
    }
}
