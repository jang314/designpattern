package modeling.dependency;

public class Car {
    private int amount;

    public void fillGas(GasPump gas) {
        gas.getGas(amount);
    }
}
