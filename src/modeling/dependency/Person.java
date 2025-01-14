package modeling.dependency;

public class Person {
    private Car owns;

    public void setCar(Car car) {
        this.owns = car;
    }

    public Car getCar() {
        return this.owns;
    }
}
