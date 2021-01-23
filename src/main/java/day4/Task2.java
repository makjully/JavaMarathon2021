package day4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        fillArray(numbers);

        System.out.println("Наибольший элемент массива: " + findMax(numbers));
        System.out.println("Наименьший элемент массива: " + findMin(numbers));
        System.out.println("Количество элементов массива, оканчивающихся на 0: " + countTen(numbers));
        System.out.println("Сумма элементов массива, оканчивающихся на 0: " + sumTen(numbers));
    }

    private static int findMin(int[] numbers) {
        int min = numbers[0];

        for (int i : numbers) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static int findMax(int[] numbers) {
        int max = 0;

        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static void fillArray(int[] numbers) {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }
    }

    private static int countTen(int[] numbers) {
        int count = 0;

        for (int i : numbers) {
            if (i % 10 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int sumTen(int[] numbers) {
        int sum = 0;

        for (int i : numbers) {
            if (i % 10 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
