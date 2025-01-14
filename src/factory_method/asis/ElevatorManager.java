package factory_method.asis;

import factory_method.Direction;
import factory_method.ElevatorController;
import factory_method.asis.SchedulerFactory.SchedulingStrategyID;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElevatorManager {
    private List<ElevatorController> controllers;
    private SchedulingStrategyID strategyID;


    // 주어진 만큼 ElevatorController를 생성함
    public ElevatorManager(int controllerCount, SchedulingStrategyID strategyID) {
        controllers = new ArrayList<>(controllerCount);
        for(int i =0; i<controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
        this.strategyID = strategyID; // 스케줄링 전략 설정
    }

    public void setStrategyID(SchedulingStrategyID strategyID) {
        this.strategyID = strategyID;
    }

    void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler= SchedulerFactory.getScheduler(strategyID);

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if(hour < 12) { // 오전에는 ResponseTimeScheduler를 이용함
            scheduler = ResponseTimeScheduler.getInstance();
        } else {
            scheduler = ThroughputScheduler.getInstance();
        }
        int selectedElevator = scheduler.selectElevator(this, direction, destination);
        controllers.get(selectedElevator).gotoFloor(destination);
    }

    public static class Client {
        public static void main(String[] args) {
            ElevatorManager emWithResponseTimeScheduler = new ElevatorManager(2, SchedulingStrategyID.RESPONSE_TIME);
            emWithResponseTimeScheduler.requestElevator(10, Direction.UP);

            ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, SchedulingStrategyID.THROUGHPUT);
            emWithThroughputScheduler.requestElevator(10, Direction.UP);

            ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, SchedulingStrategyID.DYNAMIC);
            emWithDynamicScheduler.requestElevator(10, Direction.UP);
        }
    }
}
