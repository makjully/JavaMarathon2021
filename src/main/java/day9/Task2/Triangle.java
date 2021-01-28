package day9.Task2;

public class Triangle extends Figure {
    private int lengthSideA;
    private int lengthSideB;
    private int lengthSideC;

    public Triangle(int lengthSideA, int lengthSideB, int lengthSideC, String color) {
        super(color);
        this.lengthSideA = lengthSideA;
        this.lengthSideB = lengthSideB;
        this.lengthSideC = lengthSideC;
    }

    @Override
    public double area() {
        double semiPerimeter = perimeter()/2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - lengthSideA) * (semiPerimeter - lengthSideB) * (semiPerimeter - lengthSideC));
    }

    @Override
    public double perimeter() {
        return lengthSideA + lengthSideB + lengthSideC;
    }
}
