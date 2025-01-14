package command.tobe;

public class Button {
    private Command theCommand;

    public Button(Command command) {
        theCommand = command;
    }
    public void pressed() {
        this.theCommand.execute();
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

}
