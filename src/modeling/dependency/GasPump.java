package modeling.dependency;

public class GasPump {
    public int gas;

    public int getGas(int amount) {
        setGas(amount);
        return gas;
    }

    public void setGas(int amount) {
        this.gas = amount;
    }
}