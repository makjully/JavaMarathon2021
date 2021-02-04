package day16;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("0202.txt");
        printResult(file);
    }

    public static void printResult(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int count = 0;
            int sum = 0;

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (int i = 0; i < line.length; i++) {
                    sum += Integer.parseInt(line[i]);
                    count++;
                }
            }
            reader.close();

            if (count > 0) {
                double arithmeticalMean = (double) sum / count;
                System.out.print(arithmeticalMean);
                System.out.printf(" --> %.3f", arithmeticalMean);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

