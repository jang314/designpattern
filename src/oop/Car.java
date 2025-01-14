package oop;

public abstract class Car {
    protected abstract void changeEngineOil();
    protected abstract int getPrice();


    private class Audi extends Car {
        private final int price = 10000000;
        @Override
        protected void changeEngineOil() {
        }

        @Override
        protected int getPrice() {
            return this.price;
        }

    }

    private class BMW extends Car {
        private final int price = 10000000;
        @Override
        protected void changeEngineOil() {
        }
        @Override
        protected int getPrice() {
            return this.price;
        }
    }
    private class Bentz extends Car {
        private final int price = 10000000;
        @Override
        protected void changeEngineOil() {
        }
        @Override
        protected int getPrice() {
            return this.price;
        }
    }
}
