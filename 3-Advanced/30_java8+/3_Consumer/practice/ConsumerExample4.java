// ConsumerExample4.java - Consumer for logging messages
import java.util.function.Consumer;

public class ConsumerExample4 {
    public static void main(String[] args) {
        Consumer<String> logInfo = message -> System.out.println("INFO: " + message);
        Consumer<String> logError = message -> System.err.println("ERROR: " + message);
        logInfo.accept("Application started");
        logError.accept("An unexpected error occurred");
    }
}