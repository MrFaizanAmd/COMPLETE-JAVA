// PredicateExample4.java - Filtering a List using Predicate
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
    }
}