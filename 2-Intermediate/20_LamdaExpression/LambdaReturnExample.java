// Functional Interface
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaReturnExample {
    public static void main(String[] args) {
        // Lambda expression with explicit return
        MathOperation addition = (a, b) -> {
            return a + b;
        };
        System.out.println("Addition Result: " + addition.operate(5, 3));
        
        // Lambda expression without explicit return
        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("Subtraction Result: " + subtraction.operate(10, 4));
        
        // Lambda with a conditional return
        MathOperation max = (a, b) -> {
            if (a > b) return a;
            else return b;
        };
        System.out.println("Maximum Value: " + max.operate(8, 12));
    }
}
