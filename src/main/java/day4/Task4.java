package day4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        fillArray(numbers);

        findMax(numbers);
    }

    private static void findMax(int[] numbers) {
        List<Integer> sums = getSums(numbers);

        int max = Collections.max(sums);
        int elemNumber = 0;
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) == max) {
                elemNumber = i;
            }
        }

        System.out.println("Максимальная сумма соседних элементов = " + max);
        System.out.println("Позиция первого элента в тройке: " + elemNumber);
    }

    private static List<Integer> getSums(int[] numbers) {
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < numbers.length - 2; i++) {
            int sum = numbers[i] + numbers[i + 1] + numbers[i + 2];
            sums.add(sum);
        }
        return sums;
    }

    private static void fillArray(int[] numbers) {
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }
    }
}
