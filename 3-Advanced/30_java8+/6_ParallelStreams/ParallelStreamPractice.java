import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.*;

public class ParallelStreamPractice {
    public static void main(String[] args) {
        // Problem 1: Sum of squares of even numbers in parallel
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        int sumSquares = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Sum of squares of even numbers: " + sumSquares);

        // Problem 2: Convert a list of strings to uppercase in parallel
        List<String> names = Arrays.asList("john", "jane", "doe", "smith");
        List<String> upperNames = names.parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);

        // Problem 3: Count elements greater than 50 using parallel stream
        long count = numbers.parallelStream()
                .filter(n -> n > 50)
                .count();
        System.out.println("Count of numbers > 50: " + count);

        // Problem 4: Find the maximum number in a parallel stream
        int max = numbers.parallelStream().max(Integer::compareTo).orElse(-1);
        System.out.println("Maximum number: " + max);

        // Problem 5: Find the first element greater than 50 in parallel
        Optional<Integer> firstAbove50 = numbers.parallelStream().filter(n -> n > 50).findFirst();
        System.out.println("First number > 50: " + firstAbove50.orElse(-1));

        // Problem 6: Generate and process a large dataset in parallel
        List<Integer> largeList = IntStream.rangeClosed(1, 1_000_000).boxed().collect(Collectors.toList());
        long start = System.currentTimeMillis();
        long sumLarge = largeList.parallelStream().mapToLong(Integer::longValue).sum();
        long end = System.currentTimeMillis();
        System.out.println("Sum of large dataset: " + sumLarge + " (Time: " + (end - start) + "ms)");

        // Problem 7: Remove duplicates in a parallel stream
        List<Integer> duplicateList = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = duplicateList.parallelStream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique numbers: " + uniqueNumbers);

        // Problem 8: Sort elements in parallel
        List<Integer> sortedList = numbers.parallelStream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted list (first 10 elements): " + sortedList.subList(0, 10));

        // Problem 9: Group elements by odd/even in parallel
        Map<Boolean, List<Integer>> grouped = numbers.parallelStream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("Grouped by odd/even: " + grouped);

        // Problem 10: Convert list to set using parallel stream
        Set<Integer> numberSet = numbers.parallelStream().collect(Collectors.toSet());
        System.out.println("Converted to set (size): " + numberSet.size());

        // Problem 11: Check if all elements are positive in parallel
        boolean allPositive = numbers.parallelStream().allMatch(n -> n > 0);
        System.out.println("All numbers positive? " + allPositive);

        // Problem 12: Check if any element is greater than 90 in parallel
        boolean anyAbove90 = numbers.parallelStream().anyMatch(n -> n > 90);
        System.out.println("Any number > 90? " + anyAbove90);

        // Problem 13: Reduce operation for sum using parallel stream
        int reducedSum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("Reduced sum: " + reducedSum);

        // Problem 14: Create a comma-separated string from list in parallel
        String joinedString = numbers.parallelStream()
                .limit(10)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Joined string (first 10 elements): " + joinedString);

        // Problem 15: Partition numbers into odd/even using parallel streams
        Map<Boolean, List<Integer>> partitioned = numbers.parallelStream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned map: " + partitioned);

        // Problem 16: Convert list of numbers to a map in parallel
        Map<Integer, String> numberMap = numbers.parallelStream()
                .collect(Collectors.toMap(n -> n, n -> "Number: " + n, (e1, e2) -> e1));
        System.out.println("Map entry example: " + numberMap.get(5));

        // Problem 17: Compute statistics using IntSummaryStatistics in parallel
        IntSummaryStatistics stats = numbers.parallelStream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Statistics - Count: " + stats.getCount() + ", Max: " + stats.getMax());

        // Problem 18: Execute a parallel forEachOrdered operation
        System.out.print("First 10 elements in order: ");
        numbers.parallelStream().limit(10).forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();

        // Problem 19: Custom thread pool for parallel streams
        ForkJoinPool customPool = new ForkJoinPool(4);
        try {
            customPool.submit(() -> numbers.parallelStream().forEach(n -> {})).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customPool.shutdown();
        }
        System.out.println("Parallel stream executed with custom thread pool.");

        // Problem 20: Parallel stream performance comparison
        long sequentialStart = System.currentTimeMillis();
        numbers.stream().mapToInt(n -> n * 2).sum();
        long sequentialEnd = System.currentTimeMillis();

        long parallelStart = System.currentTimeMillis();
        numbers.parallelStream().mapToInt(n -> n * 2).sum();
        long parallelEnd = System.currentTimeMillis();

        System.out.println("Sequential time: " + (sequentialEnd - sequentialStart) + "ms");
        System.out.println("Parallel time: " + (parallelEnd - parallelStart) + "ms");
    }
}
