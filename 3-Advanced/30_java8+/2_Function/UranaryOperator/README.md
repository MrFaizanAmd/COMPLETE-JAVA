# UnaryOperator in Java

## Introduction

In Java, `UnaryOperator<T>` is a functional interface in the `java.util.function` package that represents an operation on a single operand of type `T`, producing a result of the same type `T`. It is a specialized form of `Function<T, T>` where both the input and output types are the same.

### Why is `UnaryOperator` Useful?
- It simplifies cases where we need to perform operations on a single value of a specific type.
- Often used in lambda expressions, stream operations, and functional programming paradigms.
- Helps in modifying values within collections in a concise and readable way.

## Key Concepts and Terminologies

- **Functional Interface**: An interface with a single abstract method, enabling the use of lambda expressions and method references.
- **Lambda Expression**: A concise way to define anonymous functions.
- **Method Reference**: A shorthand for calling existing methods using `::` notation.

## Real-World Analogy

Think of `UnaryOperator` like a simple coffee machine:
- You insert a coffee cup (input of type `T`).
- The machine processes it (applies an operation like adding milk or sugar).
- You get back a modified cup of coffee (output of type `T`).

## Usage and Examples

### 1. Basic Example: Increment a Number
```java
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> increment = num -> num + 1;
        System.out.println("Incremented Value: " + increment.apply(5)); // Output: 6
    }
}
```

### 2. Convert String to Uppercase
```java
import java.util.function.UnaryOperator;

public class StringToUpperCase {
    public static void main(String[] args) {
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("hello")); // Output: HELLO
    }
}
```

### 3. Modify Elements in a List using `UnaryOperator`
```java
import java.util.*;
import java.util.function.UnaryOperator;

public class ListModification {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.replaceAll(num -> num * 2);
        System.out.println(numbers); // Output: [2, 4, 6, 8, 10]
    }
}
```

### 4. Chaining `UnaryOperator`
```java
import java.util.function.UnaryOperator;

public class UnaryOperatorChaining {
    public static void main(String[] args) {
        UnaryOperator<Integer> multiplyByTwo = x -> x * 2;
        UnaryOperator<Integer> subtractFive = x -> x - 5;
        
        UnaryOperator<Integer> combined = multiplyByTwo.andThen(subtractFive);
        System.out.println(combined.apply(10)); // Output: (10 * 2) - 5 = 15
    }
}
```

## Frequently Asked Questions (FAQs)

### 1. How is `UnaryOperator<T>` different from `Function<T, R>`?
`UnaryOperator<T>` is a specialized version of `Function<T, R>` where both input and output types are the same (`T`).

### 2. When should I use `UnaryOperator<T>` instead of `Function<T, T>`?
Use `UnaryOperator<T>` when the input and output types are identical for better readability and clarity.

### 3. Can I use `UnaryOperator<T>` with streams?
Yes, `UnaryOperator<T>` is commonly used with `Stream.map()` and `List.replaceAll()` to apply transformations.

## Additional Resources
- [Official Java Documentation - UnaryOperator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/UnaryOperator.html)
- [Java Functional Interfaces Guide](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

## Hands-on Practice
For practice, check out the folder in this repository: `[Link to practice files]`