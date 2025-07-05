// SupplierExample5.java - Using Supplier in a Method
import java.util.function.Supplier;

public class SupplierExample5 {
    public static void main(String[] args) {
        System.out.println(getMessage(() -> "This is a supplied message."));
    }
    
    public static String getMessage(Supplier<String> supplier) {
        return supplier.get();
    }
}
