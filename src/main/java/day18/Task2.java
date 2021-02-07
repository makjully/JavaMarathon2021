package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237));
    }

    public static int count7(int wholeNumber) {
        if (wholeNumber < 0) {
            return 0;
        }

        String s = String.valueOf(wholeNumber);

        if (s.length() == 1) {
            if (s.equals("7")) {
                return 1;
            } else {
                return 0;
            }
        }

        int remaining = Integer.parseInt(s.substring(0, s.length() - 1));

        if (s.substring(s.length() - 1).equals("7")) {
            return 1 + count7(remaining);
        }
        return count7(remaining);
    }
}
