package composite;

import java.util.ArrayList;
import java.util.List;

public abstract class ComputerDevice {
    public abstract int getPrice();
    public abstract int getPower();

    public static class Computer extends ComputerDevice {
        private List<ComputerDevice> components = new ArrayList<>();

        public void addComponent(ComputerDevice component) {
            this.components.add(component);
        }

        public void removeComponent(ComputerDevice component) {
            this.components.remove(component);
        }

        @Override
        public int getPrice() {
            return components.stream().mapToInt(component -> component.getPrice()).sum();
        }

        @Override
        public int getPower() {
            return components.stream().mapToInt(component -> component.getPower()).sum();
        }
    }

    public static class Keyboard extends ComputerDevice {
        public Keyboard(int price, int power) {
            this.price = price;
            this.power = power;
        }

        private int price;
        private int power;

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getPower() {
            return power;
        }
    }

    public static class Monitor extends ComputerDevice {
        private int price;
        private int power;

        public Monitor(int price, int power) {
            this.price = price;
            this.power = power;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getPower() {
            return power;
        }
    }

    public static class Body extends ComputerDevice {
        private int price;
        private int power;

        public Body(int price, int power) {
            this.price = price;
            this.power = power;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getPower() {
            return power;
        }
    }

    public static class Client {
        public static void main(String[] args) {
            Body body = new Body(100, 70);
            Keyboard keyboard = new Keyboard(5, 2);
            Monitor monitor = new Monitor(20, 30);

            Computer computer = new Computer();
            computer.addComponent(body);
            computer.addComponent(keyboard);
            computer.addComponent(monitor);

            System.out.printf("Computer Power : %dW", computer.getPower());
            System.out.printf("Computer Price : %d만원", computer.getPrice());

        }
    }
}
