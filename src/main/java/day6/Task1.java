package day6;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car("Tesla Model S", "Midnight green", 2016);
        Motorbike motorbike = new Motorbike("Harley-Davidson Road King", "Billiard Red", 2020);

        car.info();
        System.out.println(car.yearDifference(2021));

        motorbike.info();
        System.out.println(motorbike.yearDifference(2021));
    }
}
