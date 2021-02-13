package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/dushi.txt");
        Scanner scanner = new Scanner(file).useDelimiter("[.,:;()?!\"\\s–]+");
        Map<String, Integer> words = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (!word.isEmpty()) {
                if (!words.containsKey(word)) {
                    words.put(word, 1);
                } else {
                    words.put(word, words.get(word) + 1);
                }
            }
        }

        Map<String, Integer> sortedMap = getSortedMap100(words);

        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value)); // Чичиков - 601
    }

    private static Map<String, Integer> getSortedMap100(Map<String, Integer> words) {
        return words.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                limit(100).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
