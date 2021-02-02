package day14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("people.txt");

        try {
            List<Person> people = parseFileToObjList(file);
            System.out.println(people);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Person> parseFileToObjList(File file) throws Exception {
        List<Person> people = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while (reader.ready()) {
            String[] elements = reader.readLine().split(" ");
            int age = Integer.parseInt(elements[1]);
            if (age < 0) {
                people.clear();
                throw new Exception("Некорректный входной файл");
            } else
                people.add(new Person(elements[0], age));
        }
        return people;
    }
}
