// SupplierExample3.java - Supplying Current Timestamp
import java.util.function.Supplier;
import java.time.LocalDateTime;

public class SupplierExample3 {
    public static void main(String[] args) {
        Supplier<LocalDateTime> currentTimeSupplier = LocalDateTime::now;
        System.out.println("Current Time: " + currentTimeSupplier.get());
    }
}