package factory_method.tobe;

import factory_method.Direction;

public class ThroughputScheduler implements ElevatorScheduler {
    private static ElevatorScheduler scheduler;
    private ThroughputScheduler() {}

    public static ElevatorScheduler getInstance(){
        if(scheduler==null) {
            scheduler = new ThroughputScheduler();
        }
        return scheduler;
    }


    @Override
    public int selectElevator(ElevatorManager elevatorManager, Direction destination, int direction) {
        return 0;
    }
}
