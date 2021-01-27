package day8;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String string = "";

        long start = System.currentTimeMillis();
        for (int i = 0; i <= 20000; i++) {
            sb.append(i + " ");
        }
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(sb);
        System.out.println("Время исполнения (StringBuilder): " + timeConsumedMillis); // = 20

        start = System.currentTimeMillis();
        for (int i = 0; i <= 20000; i++) {
            string += i + " ";
        }
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println(string);
        System.out.println("Время исполнения (String): " + timeConsumedMillis); // = 170
    }
}
