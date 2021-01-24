package day5;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColor("Midnight green");
        car.setYearOfManufacture(2016);
        car.setModel("Tesla Model S");
        System.out.println("Автомобиль " + car.getModel() +
                " в цвете " + car.getColor() + " " +
                car.getYearOfManufacture() + " года выпуска");
    }
}

class Car {
    private int yearOfManufacture;
    private String model;
    private String color;

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