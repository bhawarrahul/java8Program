import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindPairOfTwoNumberMatchGivenSum {
    public static void main(String[] args) {
        Integer[] input = {2, 4, 3, 3};
        int sum = 6;
        IntStream.range(0, input.length)
                .forEach(i -> IntStream.range(0, input.length)
                        .filter(j -> i != j && input[i] + input[j] == sum)
                        .forEach(j -> System.out.println((input[i] + " " + input[j])))
                );

        List<Integer> list = Arrays.asList(input);
        for (int value: list) {
            int value1= sum-value;
            if(list.contains(value1)) {
                System.out.println("val1: " + value + " val2: " + value1);
                break;
            }
        }
        list.stream().forEach(value-> {
            int value1 =sum-value;
            if(list.contains(value1)) {
                System.out.println("val11: " + value + " val22: " + value1);
            }
        });
    }
}
