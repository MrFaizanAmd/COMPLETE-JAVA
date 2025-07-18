import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;

public class PrimitiveStreamPractice {
    public static void main(String[] args) {
        // 1. Create an IntStream and find sum of even numbers between 1-100
        int sumEven = IntStream.rangeClosed(1, 100)
                               .filter(n -> n % 2 == 0)
                               .sum();
        System.out.println("Sum of even numbers from 1 to 100: " + sumEven);

        // 2. Find the maximum value in a LongStream of first 50 natural numbers
        OptionalInt maxValue = IntStream.rangeClosed(1, 50).max();
        maxValue.ifPresent(value -> System.out.println("Max value: " + value));

        // 3. Generate a DoubleStream of 10 random numbers and print each
        DoubleStream.generate(Math::random)
                   .limit(10)
                   .forEach(System.out::println);

        // 4. Find the average of first 100 odd numbers
        OptionalDouble avgOdd = IntStream.iterate(1, n -> n + 2)
                                         .limit(100)
                                         .average();
        avgOdd.ifPresent(value -> System.out.println("Average of first 100 odd numbers: " + value));

        // 5. Convert IntStream to DoubleStream and compute sum
        double sumDoubles = IntStream.rangeClosed(1, 10)
                                     .asDoubleStream()
                                     .sum();
        System.out.println("Sum of first 10 numbers as doubles: " + sumDoubles);

        // 6. Find the first 10 multiples of 5 using IntStream
        IntStream.iterate(5, n -> n + 5)
                 .limit(10)
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 7. Parallel processing with LongStream to sum first million numbers
        long sumParallel = LongStream.rangeClosed(1, 1_000_000)
                                     .parallel()
                                     .sum();
        System.out.println("Sum of first million numbers (parallel): " + sumParallel);

        // 8. Mapping IntStream to Objects (Square Roots of First 10 Numbers)
        IntStream.rangeClosed(1, 10)
                 .mapToDouble(Math::sqrt)
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 9. Using reduce() to find factorial of 5
        int factorial = IntStream.rangeClosed(1, 5)
                                 .reduce(1, (a, b) -> a * b);
        System.out.println("Factorial of 5: " + factorial);

        // 10. Creating and processing an IntStream of ASCII values for 'A' to 'Z'
        IntStream.rangeClosed('A', 'Z')
                 .mapToObj(c -> (char) c)
                 .forEach(System.out::print);
        System.out.println();
    }
}
