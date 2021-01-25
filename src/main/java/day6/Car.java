package day6;

public class Car {
    private int yearOfManufacture;
    private String model;
    private String color;

    public Car (){

    }

    public Car(String model, String color, int yearOfManufacture) {
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYear(int yearOfManufacture) {
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

    public void info() {
        System.out.println("Это автомобиль");
    }

    public int yearDifference(int inputYear) {
        return Math.abs(inputYear - this.yearOfManufacture);
    }
}