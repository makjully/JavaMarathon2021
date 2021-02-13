package day19;

import java.io.*;
import java.util.HashSet;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/numbers19.txt"));
        HashSet<Integer> numbers = new HashSet<>();

        while (reader.ready()) {
            int value = Integer.parseInt(reader.readLine());
            numbers.add(value);
        }

        long count = numbers.stream().
                filter(number -> number >= 500000000 && number <= 600000000).
                count();

        System.out.println(count); // 50071
    }

}
