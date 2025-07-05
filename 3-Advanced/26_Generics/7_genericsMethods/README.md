

# Java Generics: Generic Methods

## Introduction

Generics in Java allow us to write flexible, reusable, and type-safe code. A **generic method** is a method that is parameterized over types, meaning it can operate on different types while ensuring type safety at compile time. In this guide, we’ll explore **generic methods** from basic to advanced concepts with practical examples and real-world analogies.

### Why Are Generic Methods Important?
- **Code Reusability**: Write once, use with multiple data types.
- **Type Safety**: Ensures that the types are checked at compile time, preventing runtime errors.
- **Flexibility**: Works with primitive wrapper types (`Integer`, `Double`, etc.) and user-defined classes.
- **Eliminates Type Casting**: Avoids costly and error-prone casting that can lead to `ClassCastException`.

---

## Key Concepts and Terminologies

### 1. Generic Type Parameter
Generic methods use **type parameters** to enable code that can handle different data types. Commonly used parameters include:
- `T` (Type)
- `E` (Element, often used for collections)
- `K` (Key) and `V` (Value, used in maps)
- `N` (Number)

### 2. Declaring a Generic Method
A generic method is defined by specifying a **type parameter** in angle brackets (`<>`) before the return type.

#### Syntax:
```java
public <T> void methodName(T parameter) {
    // Method body
}
```

#### Example:
```java
public class GenericExample {
    public static <T> void printElement(T element) {
        System.out.println("Element: " + element);
    }

    public static void main(String[] args) {
        printElement("Hello, Generics!");  // T inferred as String
        printElement(100);                 // T inferred as Integer
    }
}
```

### 3. Calling a Generic Method
The type parameter is **inferred** based on the argument passed when the method is called.

### Real-World Analogy
Imagine a **vending machine** that dispenses snacks, drinks, or candies. The **generic vending machine** can work with any type of snack, just as a generic method can work with any type of data.

```java
public class VendingMachine {
    public static <T> void dispense(T item) {
        System.out.println("Dispensing: " + item);
    }

    public static void main(String[] args) {
        dispense("Chips");
        dispense("Soda");
        dispense("Candy");
    }
}
```

---

## Advanced Concepts

### 1. Generic Methods with Multiple Type Parameters
A generic method can be designed to accept multiple type parameters, offering greater flexibility.

```java
public class PairUtil {
    public static <K, V> void displayPair(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    public static void main(String[] args) {
        displayPair("ID", 101);
        displayPair(1, "Admin");
    }
}
```

### 2. Bounded Type Parameters
You can restrict the types that a generic method can accept using **bounded type parameters**.

#### Example: Generic Method for Numbers Only
```java
public class MathUtil {
    public static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(square(5));        // Integer
        System.out.println(square(3.14));     // Double
    }
}
```

### 3. Wildcards (`?`)
Wildcards (`?`) are used when the exact type is not known and is represented by an unknown type.

#### Example: Using Wildcards in Generic Methods
```java
public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob");
        printList(names);
    }
}
```

### 4. Generic Methods with Return Types Different from Parameter Types
The return type of a generic method **does not** need to be the same as the type parameter.

#### Example: Returning the Class Name of Any Object
```java
public static <T> String getClassName(T object) {
    return object.getClass().getName();
}
```

---

## Practical Considerations

### 1. Performance Implications
Although generics in Java offer many advantages in terms of type safety and flexibility, they may have some performance overhead. However, **Java’s type erasure** mechanism ensures that generic types are replaced with their non-generic counterparts at runtime, preventing performance degradation.

### 2. Limitations of Generics
- **No Primitive Types**: Java generics do not work with primitive types directly (e.g., `int`, `char`, `boolean`), but work with their wrapper classes (e.g., `Integer`, `Character`, `Boolean`).
- **Type Erasure**: The generic type is erased at runtime, so information about the specific type parameter is not available.

---

## Frequently Asked Questions (FAQs)

### 1. Can a generic method be static?
Yes, generic methods can be static because they define their type parameters independently of instance-level variables.

### 2. Can I use multiple generic parameters in one method?
Yes! Multiple type parameters can be used by separating them with commas (`<T, U, V>`).

### 3. What happens if a generic type is assigned an incompatible value?
The compiler will throw a **type mismatch** error, preventing runtime errors related to incompatible types.

### 4. Can a generic method have a return type different from its type parameter?
Yes, the return type can be different from the generic type parameters defined.

---

## Further Reading and References
- [Java Generics Official Documentation](https://docs.oracle.com/javase/tutorial/java/generics/)
- [Effective Java - Joshua Bloch (Chapter on Generics)](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)
- [Generic Types in Java (Tutorial)](https://www.baeldung.com/java/java-generics)

---

## Hands-On Practice
Check out the [practice folder](./practice/generic-methods) in this repository for hands-on coding exercises!

---

