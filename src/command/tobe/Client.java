package command.tobe;

public class Client {
    public static void main(String[] args) {
        Button button = new Button(new LampOnCommand(new Lamp()));
        button.pressed();
        button.setCommand(new AlarmOnCommand(new Alarm()));
        button.pressed();
    }
}
