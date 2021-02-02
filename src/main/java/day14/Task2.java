package day14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("people.txt");

        List<String> people = parseFileToStringList(file);
        System.out.println(people);
    }

    public static List<String> parseFileToStringList(File file) {
        List<String> people = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while (reader.ready()) {
                people.add(reader.readLine());
            }

            for (String person : people) {
                String[] elements = person.split(" ");
                if (Integer.parseInt(elements[1]) < 0) {
                    people.clear();
                    throw new Exception("Некорректный входной файл");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return people;
    }
}
