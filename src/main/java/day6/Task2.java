package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane = new Airplane("Airbus A220", 2018, 38, 63100);
        airplane.info();
        airplane.fillUp(100);
        airplane.setYear(2020);
        airplane.setLength(35);
        airplane.fillUp(50);
        airplane.info();
    }
}
