package day7;

public class Airplane {
    private String producer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void info() {
        System.out.printf("Изготовитель: %s, год выпуска: %d, длина: %d, вес: %d, количество топлива в баке: %d\n",
                producer, year, length, weight, fuel);
    }

    public void fillUp(int n) {
        this.fuel += n;
    }

    public static void compareAirplanes(Airplane airplane1, Airplane airplane2) {
        int result = (airplane1.length < airplane2.length) ? -1 : ((airplane1.length == airplane2.length) ? 0 : 1);

        switch (result) {
            case -1:
                System.out.println("Второй самолет длиннее");
                break;
            case 0:
                System.out.println("Длины самолетов равны");
                break;
            case 1:
                System.out.println("Первый самолет длиннее");
                break;
        }
    }
}
