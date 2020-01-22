import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileCharacterWordWithMaxCount {
    public static void main(String[] args) {
        FileCharacterWordWithMaxCount.CharacterCount();
        FileCharacterWordWithMaxCount.wordCount();
    }

    public static void CharacterCount() {
        try {
            Map<Character, Integer> charCountMap
                    = new HashMap<>();
            Files.lines(Paths.get("/home/krawler/abc.txt")).forEach(strLine -> {
                char[] strArray = strLine.toCharArray();
                for (char character : strArray) {
                    if (charCountMap.containsKey(character)) {
                        charCountMap.put(character, charCountMap.get(character) + 1);
                    } else {
                        charCountMap.put(character, 1);
                    }
                }
            });
            System.out.println("Map with Character CountValue");
            System.out.println(charCountMap);
            Integer maxAppearedElement = charCountMap.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getValue)
                    .get();
            System.out.println("Max Count: " + maxAppearedElement);

        } catch (IOException ex) {

        }

    }

    public static void wordCount() {
        try {
            Map<String, Integer> wordCountMap
                    = new HashMap<>();
            Files.lines(Paths.get("/home/krawler/abc.txt")).forEach(strLine -> {
                String[] strArray = strLine.split(" ");
                for (String str : strArray) {
                    if (wordCountMap.containsKey(str)) {
                        wordCountMap.put(str, wordCountMap.get(str) + 1);
                    } else {
                        wordCountMap.put(str, 1);
                    }
                }
            });
            System.out.println("Map with word CountValue");
            System.out.println(wordCountMap);
            Integer maxAppearedElement = wordCountMap.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getValue)
                    .get();
            System.out.println("Max Count: " + maxAppearedElement);

        } catch (IOException ex) {

        }
    }
}
