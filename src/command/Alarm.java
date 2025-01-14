package command;

public class Alarm {
    public void start() {
        System.out.println("Alarming...");
    }

    public static class Button {
        private Alarm alarm;


        public Button(Alarm alarm) {
            this.alarm = alarm;
        }
        public void pressed() {
            this.alarm.start();
        }
    }


    public static class Client {
        public static void main(String[] args) {
            Alarm alarm = new Alarm();
            Button button = new Button(alarm);
            button.pressed();
        }
    }
}
