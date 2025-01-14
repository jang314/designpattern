package factory_method.asis;

import factory_method.Direction;

public class ResponseTimeScheduler implements ElevatorScheduler{
    private static ElevatorScheduler scheduler;

    private ResponseTimeScheduler() {}

    public static ElevatorScheduler getInstance() {
        if(scheduler==null) {
            scheduler = new ResponseTimeScheduler();
        }
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, Direction destination, int direction) {
        return 0;
    }
}
