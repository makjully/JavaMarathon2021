package day4;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = new int[12][8];

        fillMatrix(matrix);
        printMatrix(matrix);

        System.out.println("Индекс строки, сумма чисел в которой максимальна: " + findLine(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findLine(int[][] matrix) {
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            sums.add(sum);
        }

        int max = Collections.max(sums);
        int line = 0;

        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) == max) {
                line = i;
            }
        }
        return line;
    }

    private static void fillMatrix(int[][] matrix) {
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50);
            }
        }
    }
}
