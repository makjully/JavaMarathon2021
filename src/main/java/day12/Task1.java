package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>(Arrays.asList("Tesla", "Opel", "Chevrolet", "Volvo", "BMW"));
        printList(cars);

        cars.add(3, "Renault");
        cars.remove(0);

        System.out.println("\nПосле изменений:");
        printList(cars);
    }

    private static void printList(List<String> cars) {
        for(String car : cars) {
            System.out.println(car);
        }
    }

}
