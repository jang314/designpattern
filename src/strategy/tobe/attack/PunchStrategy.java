package strategy.tobe.attack;

public class PunchStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have Punch and can attack with it.");
    }
}
