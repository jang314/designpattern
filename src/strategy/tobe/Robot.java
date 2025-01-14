package strategy.tobe;

import strategy.tobe.attack.AttackStrategy;
import strategy.tobe.attack.MissileStrategy;
import strategy.tobe.attack.PunchStrategy;
import strategy.tobe.moving.FlyingStrategy;
import strategy.tobe.moving.MovingStrategy;
import strategy.tobe.moving.WalkingStrategy;

public abstract class Robot {
    private String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;


    public Robot(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void attack() {
        this.attackStrategy.attack();
    }

    public void move() {
        this.movingStrategy.move();
    }

    public static class TaekwonV extends Robot {
        public TaekwonV(String name) {
            super(name);
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

            taekwonV.setMovingStrategy(new WalkingStrategy());
            taekwonV.setAttackStrategy(new MissileStrategy());

            atom.setMovingStrategy(new FlyingStrategy());
            atom.setAttackStrategy(new PunchStrategy());


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
