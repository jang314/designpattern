package oop;

import java.util.Iterator;
import java.util.LinkedList;

public class CarCart {
    private static int sum = 0;

    private void calcuate(String car) {
        switch (car) {
            case "audi" : sum+=10000000; break;
            case "bmw" : sum+=20000000; break;
            case "bentz" : sum+=30000000; break;
        }
    }

    private void calculate(LinkedList<Car> cars) {
        Iterator<Car> iter = cars.iterator();
        while(iter.hasNext()) {
            Car car = iter.next();
            sum += car.getPrice();
        }
    }
}
