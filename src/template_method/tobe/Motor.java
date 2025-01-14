package template_method.tobe;

import template_method.Direction;
import template_method.DoorStatus;
import template_method.MotorStatus;
import template_method.asis.Door;

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

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction) {
        // LG Motor와 Hyundai Motor의 move()에 중복되는 코드를 가짐
        MotorStatus motorStatus = getMotorStatus();
        if(motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        if(doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        // 각 구현체에서 오버라이드 해서 정의하도록 함
        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    protected abstract void moveMotor(Direction direction);

    public class HyundaiMotor extends Motor {

        public HyundaiMotor(Door door) {
            super(door);
        }


        @Override
        protected void moveMotor(Direction direction) {

        }
    }

    public static class LGMotor extends Motor{
        public LGMotor(Door door) {
            super(door);
        }

        @Override
        protected void moveMotor(Direction direction) {
            // Motor 구동

        }
    }
}
