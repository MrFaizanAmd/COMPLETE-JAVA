
// FunctionExample5.java - Function to Extract Length of String
import java.util.function.Function;

public class FunctionExample5 {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply("Hello")); // 5
        System.out.println(stringLength.apply("Functional Interfaces")); // 21
    }
}
