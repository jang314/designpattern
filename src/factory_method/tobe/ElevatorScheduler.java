package factory_method.tobe;

import factory_method.Direction;

public interface ElevatorScheduler {
    int selectElevator(ElevatorManager elevatorManager, Direction destination, int direction);
}
