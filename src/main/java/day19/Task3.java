package day19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/taxi_cars.txt"));
        HashMap<Integer, Point> taxi = new HashMap<>();

        while (fileReader.ready()) {
            String[] elements = fileReader.readLine().split(" ");
            int id = Integer.parseInt(elements[0]);
            int x = Integer.parseInt(elements[1]);
            int y = Integer.parseInt(elements[2]);

            taxi.put(id, new Point(x, y));
        }

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isCorrect;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        do {
            isCorrect = true;
            try {
                System.out.println("Введите координаты квадрата поиска (формат: x1, y1, x2, y2):");
                String[] input = consoleReader.readLine().trim().split(",");
                x1 = Integer.parseInt(input[0]);
                y1 = Integer.parseInt(input[1]);
                x2 = Integer.parseInt(input[2]);
                y2 = Integer.parseInt(input[3]);
            } catch (Exception e) {
                System.out.println("Некорректный ввод!");
                isCorrect = false;
            }
        } while (!isCorrect);

        int count = 0;

        for (Map.Entry<Integer, Point> entry : taxi.entrySet()) {
            int id = entry.getKey();
            Point point = entry.getValue();
            if (point.getX() > x1 && point.getX() < x2 && point.getY() > y1 && point.getY() < y2) {
                System.out.println("Номер такси " + id);
                count++;
            }
        }

        System.out.println("Количество машин в квадрате: " + count);
    }
}
