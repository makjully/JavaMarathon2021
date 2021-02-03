package day15;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/resources/shoes.csv"));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/resources/missing_shoes.txt"));

            while (reader.ready()) {
                String[] elements = reader.readLine().split(";");
                if (Integer.parseInt(elements[2]) == 0) {
                    writer.write(elements[0] + ", " + elements[1] + ", " + elements[2]);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
