
// FunctionExample3.java - Function with String Manipulation
import java.util.function.Function;

public class FunctionExample3 {
    public static void main(String[] args) {
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<String, String> addExclamation = str -> str + "!";
        Function<String, String> shout = toUpperCase.andThen(addExclamation);
        System.out.println(shout.apply("hello")); // HELLO!
    }
}