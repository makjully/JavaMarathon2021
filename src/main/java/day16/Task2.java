package day16;

import java.io.*;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Users\\iumakaro\\Documents\\JavaMarathon\\JavaMarathon2021\\file1.txt");
        File file2 = new File("C:\\Users\\iumakaro\\Documents\\JavaMarathon\\JavaMarathon2021\\file2.txt");
        BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2));

        for (int i = 0; i < 1000; i += 20) {
            int sum = 0;
            for (int j = 0; j < 20; j++) {
                Random random = new Random();
                int number = random.nextInt(100);
                sum += number;
                writer1.write(number + " ");
            }
            double arithmeticalMean = (double) sum / 20;
            writer2.write(arithmeticalMean + " ");
        }
        writer1.close();
        writer2.close();

        printResult(file2);
    }

    public static void printResult(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            double sumDouble = 0.0;

            while (reader.ready()) {
                String[] elements = reader.readLine().split(" ");
                for (String element : elements) {
                    sumDouble += Double.parseDouble(element);
                }
            }

            System.out.println((int) sumDouble);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
