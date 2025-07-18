
// ConsumerExample5.java - Consumer to iterate and print a list
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printName = name -> System.out.println("Name: " + name);
        names.forEach(printName);
    }
}
