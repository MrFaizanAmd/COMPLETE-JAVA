// PredicateExample2.java - Using negate to check odd numbers
import java.util.function.Predicate;

public class PredicateExample2 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(10)); // false
        System.out.println(isOdd.test(7));  // true
    }
}