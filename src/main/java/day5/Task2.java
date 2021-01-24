package day5;

public class Task2 {
    public static void main(String[] args) {
        Motorbike motorbike = new Motorbike("Harley-Davidson Road King", "Billiard Red", 2020);
        System.out.printf("Мотоцикл %s в цвете %s %d года выпуска", motorbike.getModel(), motorbike.getColor(), motorbike.getYearOfManufacture());
    }
}

class Motorbike {
    private int yearOfManufacture;
    private String model;
    private String color;

    Motorbike(String model, String color, int yearOfManufacture) {
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}