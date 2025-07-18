// SupplierExample1.java - Basic Supplier Usage
import java.util.function.Supplier;

public class SupplierExample1 {
    public static void main(String[] args) {
        Supplier<String> supplyMessage = () -> "Hello, World!";
        System.out.println(supplyMessage.get());
    }
}
