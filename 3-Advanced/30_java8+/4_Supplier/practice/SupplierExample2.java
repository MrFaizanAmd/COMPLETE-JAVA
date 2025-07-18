// SupplierExample2.java - Generating Random Numbers
import java.util.function.Supplier;
import java.util.Random;

public class SupplierExample2 {
    public static void main(String[] args) {
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
        System.out.println("Random Number: " + randomNumberSupplier.get());
    }
}