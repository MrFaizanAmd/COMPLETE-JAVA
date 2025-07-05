// PredicateExample3.java - Combining Predicates using and & or
import java.util.function.Predicate;

public class PredicateExample3 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = num -> num > 0;
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isPositiveEven = isPositive.and(isEven);
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);
        System.out.println(isPositiveEven.test(10)); // true
        System.out.println(isPositiveEven.test(-10)); // false
        System.out.println(isPositiveOrEven.test(-2)); // true
    }
}