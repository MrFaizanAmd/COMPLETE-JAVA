import java.util.function.*;
import java.util.*;

public class UnaryOperatorPractice {
    public static void main(String[] args) {
        // 1. UnaryOperator: Increment a number
        UnaryOperator<Integer> increment = num -> num + 1;
        System.out.println("Incremented Value: " + increment.apply(5)); // Output: 6
        
        // 2. UnaryOperator: Convert string to uppercase
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println("Uppercased: " + toUpperCase.apply("hello")); // Output: HELLO
        
        // 3. UnaryOperator: Square a number
        UnaryOperator<Integer> square = num -> num * num;
        System.out.println("Square of 4: " + square.apply(4)); // Output: 16
        
        // 4. Using UnaryOperator with List.replaceAll
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        numbers.replaceAll(num -> num * 2);
        System.out.println("Modified List: " + numbers); // Output: [2, 4, 6, 8, 10]
        
        // 5. Chaining UnaryOperators
        UnaryOperator<Integer> multiplyByTwo = x -> x * 2;
        UnaryOperator<Integer> subtractFive = x -> x - 5;
        System.out.println("Chained Operation Result: " + multiplyByTwo.andThen(subtractFive).apply(10)); // Output: 15
        
        // 6. UnaryOperator: Reverse a string
        UnaryOperator<String> reverseString = str -> new StringBuilder(str).reverse().toString();
        System.out.println("Reversed: " + reverseString.apply("Java")); // Output: avaJ
        
        // 7. UnaryOperator: Remove spaces from a string
        UnaryOperator<String> removeSpaces = str -> str.replaceAll(" ", "");
        System.out.println("No spaces: " + removeSpaces.apply("Hello World")); // Output: HelloWorld
    }
}
