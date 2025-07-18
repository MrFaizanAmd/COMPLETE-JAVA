// PredicateExample5.java - Predicate with Strings
import java.util.function.Predicate;

public class PredicateExample5 {
    public static void main(String[] args) {
        Predicate<String> startsWithA = str -> str.startsWith("A");
        System.out.println(startsWithA.test("Apple")); // true
        System.out.println(startsWithA.test("Banana")); // false
    }
}
