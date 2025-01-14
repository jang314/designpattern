package factory_method.tobe;

import factory_method.asis.SchedulerFactory.SchedulingStrategyID;

public class ElevatorManagerWithResponseTimeScheduling extends ElevatorManager{
    public ElevatorManagerWithResponseTimeScheduling(int controllerCount, SchedulingStrategyID strategyID) {
        super(controllerCount, strategyID);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        return ResponseTimeScheduler.getInstance();
    }
}
