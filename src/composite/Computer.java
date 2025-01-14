package composite;

public class Computer {
    private Body body;
    private Keyboard keyboard;
    private Monitor monitor;
    private Speaker speaker;

    public void addBody(Body body) {
        this.body = body;
    }

    public void addKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;

    }

    public void addMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    public int getPrice() {
        return this.body.getPrice() + this.keyboard.getPrice() + this.monitor.getPrice() + this.speaker.getPrice();
    }

    public int getPower() {
        return this.body.getPower() + this.keyboard.getPower() + this.monitor.getPower() + this.speaker.getPower();
    }

    public static class Keyboard {
        private int price;
        private int power;

        public Keyboard(int price, int power) {
            this.price = price;
            this.power = power;
        }

        public int getPrice() {
            return price;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Body {
        private int price;
        private int power;

        public Body(int price, int power) {
            this.price = price;
            this.power = power;
        }

        public int getPrice() {
            return price;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Monitor {
        private int price;
        private int power;

        public Monitor(int price, int power) {
            this.price = price;
            this.power = power;
        }

        public int getPrice() {
            return price;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Speaker {
        private int price;
        private int power;

        public Speaker(int price, int power) {
            this.price = price;
            this.power = power;
        }

        public int getPrice() {
            return price;
        }

        public int getPower() {
            return power;
        }
    }

    public static class Client {
        public static void main(String[] args) {
            // 컴퓨터의 부품으로 Body, Keyboard, Monitor객체를 생성
            Body body = new Body(100, 70);
            Keyboard keyboard = new Keyboard(5, 2);
            Monitor monitor = new Monitor(20, 30);
            Speaker speaker = new Speaker(20, 10);

            Computer computer = new Computer();
            computer.addBody(body);
            computer.addKeyboard(keyboard);
            computer.addMonitor(monitor);

            // 컴퓨터의 가격과 전력 소비량을 구함
            int computerPrice = computer.getPrice();
            int computerPower = computer.getPower();
            System.out.printf("computer power : %dW \n", computerPower);
            System.out.printf("computer price : %d만 원 \n", computerPrice);

        }
    }
}
