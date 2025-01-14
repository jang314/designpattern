package oop;

public class Bag {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public class DiscountedBag extends Bag {
        private double discountedRate = 0;
        public void setDiscountedRate(double discountedRate) {
            this.discountedRate = discountedRate;
        }

        public void applyDiscount(int price) {
            super.setPrice(price - (int)(discountedRate * price));
        }

        public void setPrice(int price) {
            applyDiscount(price);
        }
    }
}
