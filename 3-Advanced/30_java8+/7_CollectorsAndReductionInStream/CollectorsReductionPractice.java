import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsReductionPractice {
    public static void main(String[] args) {
        // 1. Sum of a list using reduce
        List<Integer> numbers = Arrays.asList(3, 5, 7, 9, 11);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // 2. Find max using reduce
        int max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max: " + max);

        // 3. Find min using reduce
        int min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Min: " + min);

        // 4. Concatenate Strings using reduce
        List<String> words = Arrays.asList("Hello", "World", "Stream", "API");
        String concatenated = words.stream().reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated String: " + concatenated.trim());

        // 5. Collect to a List using Collectors
        List<Integer> collectedList = numbers.stream().collect(Collectors.toList());
        System.out.println("Collected List: " + collectedList);

        // 6. Collect to a Set
        Set<Integer> collectedSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("Collected Set: " + collectedSet);

        // 7. Joining strings using Collectors.joining
        String joined = words.stream().collect(Collectors.joining(", "));
        System.out.println("Joined String: " + joined);

        // 8. Counting elements using Collectors.counting
        long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 9. Averaging numbers using Collectors.averagingInt
        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average: " + average);

        // 10. Summing numbers using Collectors.summingInt
        int totalSum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total Sum: " + totalSum);

        // 11. Grouping elements using Collectors.groupingBy
        Map<Integer, List<Integer>> groupedByEvenOdd = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? 0 : 1));
        System.out.println("Grouped by Even/Odd: " + groupedByEvenOdd);

        // 12. Partitioning elements using Collectors.partitioningBy
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned by Even/Odd: " + partitioned);

        // 13. Mapping elements using Collectors.mapping
        List<String> mappedList = numbers.stream()
                .collect(Collectors.mapping(String::valueOf, Collectors.toList()));
        System.out.println("Mapped List: " + mappedList);

        // 14. Finding max/min using Collectors.maxBy/minBy
        Optional<Integer> maxUsingCollector = numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        Optional<Integer> minUsingCollector = numbers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Max using Collector: " + maxUsingCollector.orElse(-1));
        System.out.println("Min using Collector: " + minUsingCollector.orElse(-1));

        // 15. Reducing using Collectors.reducing
        int sumUsingReducing = numbers.stream().collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Sum using Collectors.reducing: " + sumUsingReducing);

        // 16. Collecting into an unmodifiable list
        List<Integer> unmodifiableList = numbers.stream().collect(Collectors.toUnmodifiableList());
        System.out.println("Unmodifiable List: " + unmodifiableList);

        // 17. Summarizing statistics using Collectors.summarizingInt
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Statistics: " + stats);

        // 18. Using reduce with custom BinaryOperator
        BinaryOperator<Integer> customOperator = (a, b) -> (a + b) * 2;
        int customReduce = numbers.stream().reduce(0, customOperator);
        System.out.println("Custom Reduce Result: " + customReduce);

        // 19. Using parallel streams with reduction
        int parallelSum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("Parallel Sum: " + parallelSum);

        // 20. Finding longest word using reduce
        String longestWord = words.stream().reduce("", (a, b) -> a.length() >= b.length() ? a : b);
        System.out.println("Longest Word: " + longestWord);
    }
}
