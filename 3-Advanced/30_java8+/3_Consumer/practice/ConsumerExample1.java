// ConsumerExample1.java - Basic Consumer Usage
import java.util.function.Consumer;

public class ConsumerExample1 {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, World!");
        printMessage.accept("Java Functional Interfaces");
    }
}