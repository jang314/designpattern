package factory_method.tobe;

import factory_method.asis.SchedulerFactory.SchedulingStrategyID;

import java.util.Calendar;

public class ElevatorManagerWithDynamicScheduling extends ElevatorManager{
    public ElevatorManagerWithDynamicScheduling(int controllerCount, SchedulingStrategyID strategyID) {
        super(controllerCount, strategyID);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        ElevatorScheduler scheduler = null;
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(hour < 12) { // 오전에는 ResponseTimeScheduler를 이용함
            scheduler = ResponseTimeScheduler.getInstance();
        } else {
            scheduler = ThroughputScheduler.getInstance();
        }
        return scheduler;
    }
}
