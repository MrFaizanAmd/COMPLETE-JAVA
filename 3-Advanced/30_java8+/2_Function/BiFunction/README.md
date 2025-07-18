# BiFunction in Java

## Introduction
The `BiFunction<T, U, R>` interface in Java is a functional interface that represents a function that takes **two input arguments** of types `T` and `U` and returns a result of type `R`. 

This is useful when operations require two inputs, such as mathematical calculations, string manipulations, or combining objects.

---

## Why is `BiFunction` Important?
- **Handles Two Inputs**: Unlike `Function<T, R>`, which works with a single input, `BiFunction` allows operations requiring two parameters.
- **Encourages Functional Programming**: Reduces the need for explicit loops and procedural code by using functional-style operations.
- **Improves Code Readability and Reusability**: Allows defining common logic in one place, making it reusable across the application.

---

## Syntax and Definition
The `BiFunction` interface is defined as:

```java
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
```

- `T` → Type of the first input argument.
- `U` → Type of the second input argument.
- `R` → Type of the result returned by the function.

---

## Example: Basic `BiFunction` Usage
### **Adding Two Numbers**
```java
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 20));  // Output: 30
    }
}
```

### **Real-World Analogy**
Think of a **restaurant bill calculator**. You input the **food cost (`T`)** and **tax percentage (`U`)**, and the system returns the **final bill (`R`)**.

---

## Advanced Usage
### 1. **Combining Two Strings**
```java
import java.util.function.BiFunction;

public class StringConcatenation {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;
        System.out.println(concatenate.apply("Hello", "World!"));  // Output: Hello World!
    }
}
```

### 2. **Multiplying Two Doubles and Formatting Output**
```java
import java.util.function.BiFunction;

public class MultiplyAndFormat {
    public static void main(String[] args) {
        BiFunction<Double, Double, String> multiplyAndFormat = (x, y) -> "Result: " + (x * y);
        System.out.println(multiplyAndFormat.apply(5.5, 3.2));  // Output: Result: 17.6
    }
}
```

---

## Chaining `BiFunction` with `andThen()`
Sometimes, we need to **process** the result of a `BiFunction` before returning it. This is done using `.andThen(Function<R, V>)`.

### **Example: Convert Sum to a String Message**
```java
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionChaining {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function<Integer, String> formatResult = result -> "The sum is " + result;
        
        String output = sum.andThen(formatResult).apply(10, 20);
        System.out.println(output);  // Output: The sum is 30
    }
}
```

---

## Frequently Asked Questions (FAQs)
### 1. What is the difference between `Function` and `BiFunction`?
- `Function<T, R>` takes **one** argument and returns a result.
- `BiFunction<T, U, R>` takes **two** arguments and returns a result.

### 2. Can `BiFunction` return a different type than its inputs?
Yes! The return type (`R`) can be different from the input types (`T`, `U`). Example:
```java
BiFunction<Integer, Double, String> example = (a, b) -> "Total: " + (a + b);
System.out.println(example.apply(10, 5.5));  // Output: Total: 15.5
```

### 3. Can I chain multiple `BiFunction` instances?
No, `BiFunction` does not support direct chaining. However, you can chain it with a `Function<R, V>` using `.andThen()`.

---

## Further Reading
- [Official Java Documentation: BiFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html)
- [Baeldung Guide on Java Functional Interfaces](https://www.baeldung.com/java-8-functional-interfaces)

---

## Hands-on Practice
Check out the [practice files](./bifunction/) in this repository for more examples and exercises.

Happy coding! 🚀

