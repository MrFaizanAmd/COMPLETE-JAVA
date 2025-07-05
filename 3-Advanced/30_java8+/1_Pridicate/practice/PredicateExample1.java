// PredicateExample1.java - Basic Predicate Usage
import java.util.function.Predicate;

public class PredicateExample1 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
    }
}