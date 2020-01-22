import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileContentMatch {
    public static void main(String[] args) {
        try {
            System.out.println("Match Program");
            List<String> list1 = Files.lines(Paths.get("/home/krawler/abc.txt")).collect(Collectors.toList());
            List<String> list2 = Files.lines(Paths.get("/home/krawler/abc1.txt")).collect(Collectors.toList());
            long totalCount = list1.size() >= list2.size() ? list1.size() : list2.size();
            System.out.println("Total count " + totalCount);
//            long matchCount = list1.stream()
//                    .filter(e -> (list2.stream().filter(d -> d.equalsIgnoreCase(e)).count()) > 0
//                    ).count();
            long matchCount = list1.stream()
                    .filter(e -> (list2.contains(e)) ).count();
            System.out.println("Match Count " + matchCount);
            System.out.println("Match Percentage :" + (matchCount * 100) / totalCount);
        } catch (Exception e) {

        }
    }
}
