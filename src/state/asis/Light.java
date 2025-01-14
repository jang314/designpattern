package state.asis;

public class Light {
    private final static int OFF = 0;
    private final static int ON = 1;
    private final static int SLEEPING = 2;
    private int state;

    public Light() {
        this.state = OFF;
    }

    public void on_button_pushed() {
        if(state == ON) {
            System.out.println("취침등 상태");
            this.state = SLEEPING;
        } else if(state == SLEEPING) {
            System.out.println("Light On!");
            this.state = ON;
        } else {
            System.out.println("Light On!");
            this.state = ON;
        }
    }

    public void off_button_pushed() {
        if(state == OFF) {
            System.out.println("반응 없음");
        } else {
            System.out.println("Light Off!");
            this.state = OFF;
        }
    }

    public static class Client {
        public static void main(String[] args) {
            Light light = new Light();
            light.off_button_pushed(); // 반응 없음
            light.on_button_pushed();
            light.off_button_pushed();
        }
    }
}
