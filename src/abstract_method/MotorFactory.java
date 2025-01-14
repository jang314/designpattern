package abstract_method;

import abstract_method.Motor.HyundaiMotor;
import abstract_method.Motor.LGMotor;

public class MotorFactory {
    public static Motor createMotor(VendorID vendorID) {
        Motor motor = null;
        switch (vendorID) {
            case LG :
                motor = new LGMotor();
                break;
            case HYUNDAI:
                motor = new HyundaiMotor();
                break;
        }
        return motor;
    }
}
