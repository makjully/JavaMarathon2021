package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Задайте длину массива:");
        int size = Integer.parseInt(reader.readLine());

        int[] numbers = new int[size];
        fillArray(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println("Длина массива: " + numbers.length);
        System.out.println("Количество чисел больше 8: " + countMoreEight(numbers));
        System.out.println("Количество чисел равных 1: " + countEqualOne(numbers));
        countEvenAndOdd(numbers);
        System.out.println("Сумма всех элементов массива: " + sumOfElements(numbers));
    }

    private static void fillArray(int[] numbers) {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
    }

    private static int countMoreEight(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 8) {
                count++;
            }
        }
        return count;
    }

    private static int countEqualOne(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                count++;
            }
        }
        return count;
    }

    private static void countEvenAndOdd(int[] numbers) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Количество четных чисел: " + even);
        System.out.println("Количество нечетных чисел: " + odd);
    }

    private static int sumOfElements(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
