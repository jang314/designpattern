package state.tobe;

public interface State {
    void on_button_pushed(Light light);
    void off_button_pushed(Light light);
}
