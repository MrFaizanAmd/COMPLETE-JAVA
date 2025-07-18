// ConsumerExample2.java - Consumer Chaining using andThen
import java.util.function.Consumer;

public class ConsumerExample2 {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        Consumer<String> printLength = str -> System.out.println("Length: " + str.length());
        Consumer<String> combined = printUpperCase.andThen(printLength);
        combined.accept("hello");
    }
}