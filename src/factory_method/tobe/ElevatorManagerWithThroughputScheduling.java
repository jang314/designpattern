package factory_method.tobe;

import factory_method.asis.SchedulerFactory.SchedulingStrategyID;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{
    public ElevatorManagerWithThroughputScheduling(int controllerCount, SchedulingStrategyID strategyID) {
        super(controllerCount, strategyID);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        return ThroughputScheduler.getInstance();
    }
}
