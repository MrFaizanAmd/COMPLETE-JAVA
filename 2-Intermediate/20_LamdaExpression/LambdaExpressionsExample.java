// LambdaExpressionsExample.java

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        // Example 1: Simple Greeting using Lambda Expression
        Greeting greet = (name) -> System.out.println("Hello, " + name + "!");
        greet.sayHello("Alice");

        // Example 2: Lambda for Basic Math Operations
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        int result1 = addition.operate(10, 5);
        int result2 = subtraction.operate(10, 5);

        System.out.println("Addition Result: " + result1);
        System.out.println("Subtraction Result: " + result2);

        // Example 3: Lambda Expression with Multiple Statements
        Greeting detailedGreet = (name) -> {
            System.out.println("Hello, " + name + "!");
            System.out.println("Welcome to Java Lambda Expressions.");
        };
        detailedGreet.sayHello("Bob");
    }
}