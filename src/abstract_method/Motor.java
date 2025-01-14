package abstract_method;

public abstract class Motor {
    private MotorStatus motorStatus;
    public Motor() {}

    public MotorStatus getMotorStatus() {
        return this.motorStatus;
    }

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }


    /**
     * 1. 이미 이동 중이면 무시한다.
     * 2. 만약 문이 열려 있으면 문을 닫느다.
     * 3. 모터를 구동해서 이동시킨다.
     * 4. 모터의 상태를 이동 중으로 설정한다.
     * */
    public void move(Direction direction) {
    }

    public void setDoor(Door door) {

    }

    protected abstract void moveMotor(Direction direction);

    public static class LGMotor extends Motor{
        @Override
        protected void moveMotor(Direction direction) {

        }
    }

    public static class HyundaiMotor extends Motor{
        @Override
        protected void moveMotor(Direction direction) {

        }
    }

    public static class SamsungMotor extends Motor {
        @Override
        protected void moveMotor(Direction direction) {

        }
    }
}
