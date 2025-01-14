package factory_method.tobe;

import factory_method.Direction;
import factory_method.ElevatorController;
import factory_method.asis.SchedulerFactory.SchedulingStrategyID;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManager {
    private List<ElevatorController> controllers;


    // 주어진 만큼 ElevatorController를 생성함
    public ElevatorManager(int controllerCount, SchedulingStrategyID strategyID) {
        controllers = new ArrayList<>(controllerCount);
        for(int i =0; i<controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
    }
    protected abstract ElevatorScheduler getScheduler(); // primitive 또는 hook 메소드

    void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler = getScheduler();
        int selectedElevator = scheduler.selectElevator(this, direction, destination);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}
