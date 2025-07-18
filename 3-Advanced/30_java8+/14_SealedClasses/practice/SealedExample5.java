// SealedExample5.java - Sealed Class with Records
sealed interface Operation permits Addition, Multiplication {}

record Addition(int a, int b) implements Operation {
    int result() { return a + b; }
}

record Multiplication(int a, int b) implements Operation {
    int result() { return a * b; }
}

public class SealedExample5 {
    public static void main(String[] args) {
        Operation add = new Addition(3, 5);
        Operation mul = new Multiplication(4, 6);
        System.out.println("Addition Result: " + ((Addition) add).result());
        System.out.println("Multiplication Result: " + ((Multiplication) mul).result());
    }
}
