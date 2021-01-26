package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Boeing 787 Dreamliner", 2012, 63, 254011);
        Airplane airplane2 = new Airplane("Airbus A320", 1994, 38, 77000);

        Airplane.compareAirplanes(airplane1, airplane2);
    }
}