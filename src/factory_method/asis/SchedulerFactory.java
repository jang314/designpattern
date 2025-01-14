package factory_method.asis;

import java.util.Calendar;

public class SchedulerFactory {
    public enum SchedulingStrategyID { RESPONSE_TIME, THROUGHPUT, DYNAMIC }

    public static ElevatorScheduler getScheduler(SchedulingStrategyID strategyID) {
        ElevatorScheduler scheduler = null;
        switch (strategyID) {
            case RESPONSE_TIME:
                scheduler = ResponseTimeScheduler.getInstance();
                break;
            case THROUGHPUT:
                scheduler = ThroughputScheduler.getInstance();
                break;
            case DYNAMIC:
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if(hour < 12) {
                    scheduler = ResponseTimeScheduler.getInstance();
                } else {
                    scheduler = ThroughputScheduler.getInstance();
                }
                break;
        }
        return scheduler;
    }
}
