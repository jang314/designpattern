package strategy.asis;

public abstract class Robot {
    private String name;
    public Robot(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public abstract void attack();
    public abstract void move();

    public static class TaekwonV extends Robot {

        public TaekwonV(String name) {
            super(name);
        }

        @Override
        public void attack() {
            System.out.println("I have Missile and can attack with it.");
        }

        @Override
        public void move() {
            System.out.println("I can only walk");
        }
    }

    public static class Atom extends Robot {

        public Atom(String name) {
            super(name);
        }

        @Override
        public void attack() {
            System.out.println("I have strong punch and can attack with it.");
        }

        @Override
        public void move() {
            System.out.println("I can fly.");
        }
    }

    public static class Client {
        public static void main(String[] args) {
            Robot taekwonV = new TaekwonV("TaekwonV");
            Robot atom = new Atom("Atom");

            System.out.printf("My name is %s. \n", taekwonV.getName());
            taekwonV.move();
            taekwonV.attack();

            System.out.println();

            System.out.printf("My name is %s. \n", atom.getName());
            atom.move();
            atom.attack();
        }
    }
}
