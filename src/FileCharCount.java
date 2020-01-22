import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileCharCount {
    public static void main(String[] args) {

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

            List<Map.Entry<Character, Integer>> listOfEntry = new LinkedList(charCountMap.entrySet());
            Collections.sort(listOfEntry, new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
//            Map<Character, Integer> sortedIdNameMap = listOfEntry.stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

            Map<Character, Integer> sortedIdNameMap = new LinkedHashMap<Character, Integer>();

            for (Map.Entry<Character, Integer> entry : listOfEntry) {
                sortedIdNameMap.put(entry.getKey(), entry.getValue());
            }
            System.out.println("Sorted Map with Value");
            System.out.println(sortedIdNameMap);
        } catch (IOException ex) {

        }
    }
}
