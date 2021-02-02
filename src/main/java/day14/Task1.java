package day14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("0202.txt");
        try {
            printSumDigits(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printSumDigits(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Integer> numbers = new ArrayList<>();

        while (reader.ready()) {
            String line = reader.readLine();
            String[] elements = line.split(" ");
            for (String element : elements) {
                numbers.add(Integer.parseInt(element));
            }
        }

        if (numbers.size() != 10) {
            throw new Exception("Некорректный входной файл");
        } else {
            int sum = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            System.out.println(sum);
        }
    }
}
