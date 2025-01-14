package command;

public class Lamp {
    public void turnOn() {
        System.out.println("Lamp On");
    }

    public static class Button {
        private Lamp lamp;
        private Alarm alarm;

        public Button(Lamp lamp) {
            this.lamp = lamp;
        }

        public Button(Alarm alarm) {
            this.alarm = alarm;
        }
        public void pressed() {
//            this.lamp.turnOn();
            this.alarm.start();
        }
    }

    public static class Alarm {
        public void start() {
            System.out.println("Alarming...");
        }
    }
    public static class Client {
        public static void main(String[] args) {
            Lamp lamp = new Lamp();
            Button button = new Button(lamp);
            button.pressed();
        }
    }
}
