package template_method.asis;

import template_method.Direction;
import template_method.DoorStatus;
import template_method.MotorStatus;

public abstract class Motor {
    protected Door door;
    private MotorStatus motorStatus;

    public Motor(Door door) {
        this.door = door;
        motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    protected void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public class HyundaiMotor extends Motor {

        public HyundaiMotor(Door door) {
            super(door);
        }

        private void moveHyundaiMotor(Direction direction) {
            // 현대 모토 기동
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

    public static class LGMotor extends Motor{
        public LGMotor(Door door) {
            super(door);
        }

        private void moveLGMotor(Client.Direction direction) {
            // Motor 구동
        }


        public void move(Client.Direction direction) {
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
