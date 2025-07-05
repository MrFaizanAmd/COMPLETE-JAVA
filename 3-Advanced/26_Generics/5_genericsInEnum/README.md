# Java Generics: Generics in Enum

## Introduction

Enums in Java are a powerful feature used to define a fixed set of constants. But did you know that Java allows generics in enums? This combination provides more flexibility and type safety when working with enumerations. Using generics in enums, we can create strongly-typed enums that store different types of values and perform specific operations while maintaining compile-time type checking.

### Why are Generics in Enum Important?
- They **increase reusability** by allowing enums to hold different data types.
- They provide **type safety**, ensuring that only the correct types are used.
- They enable **flexible and extensible** enum-based logic for structured programming.

## Key Concepts and Terminologies

### What is a Generic Enum?
A **generic enum** is an enumeration that takes a type parameter, allowing it to work with different data types while maintaining type safety.

#### Syntax:
```java
enum EnumName<T> {
    // Enum values with generic types
}
```

## Real-World Analogy
Imagine you are creating a **Rating System** that supports different data types. Some ratings may be **numeric** (like star ratings), while others may be **text-based** (like reviews). Using a generic enum, we can create a reusable rating system that handles both cases efficiently.

```java
enum Rating<T> {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    CUSTOM(null);

    private final T value;

    Rating(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Rating<Integer> starRating = Rating.LOW;
        System.out.println("Star Rating: " + starRating.getValue());

        Rating<String> textRating = Rating.CUSTOM;
        System.out.println("Text Rating: " + textRating.getValue());
    }
}
```

### Explanation:
- `Rating<T>` is a generic enum with a type parameter `T`.
- Each enum constant has an associated value.
- The constructor assigns values to each rating type, which can be retrieved with `getValue()`.

## When to Use Generics in Enums
- When creating **type-safe enumerations** that work with multiple data types.
- When defining **custom attributes** in enums that vary by type.
- When making **flexible API designs** that support different kinds of data.

## Advanced Example: Enum with Multiple Generic Parameters
You can also use multiple generic parameters in an enum. Let's say we are building a **currency converter** that maps different currencies to their exchange rates dynamically.

```java
enum Currency<T, U> {
    USD("Dollar", 1.0),
    EUR("Euro", 0.85),
    JPY("Yen", 110.53);

    private final T name;
    private final U exchangeRate;

    Currency(T name, U exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public T getName() {
        return name;
    }

    public U getExchangeRate() {
        return exchangeRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Currency<String, Double> currency = Currency.EUR;
        System.out.println("Currency: " + currency.getName() + " Exchange Rate: " + currency.getExchangeRate());
    }
}
```

### Key Takeaways:
- We used two type parameters: `T` for the currency name and `U` for the exchange rate.
- This makes the `Currency` enum flexible for future modifications.

## Frequently Asked Questions (FAQs)

### 1. Can enums extend other classes?
No, enums **cannot extend** other classes because they already extend `java.lang.Enum`. However, they **can implement interfaces**.

### 2. Can I use wildcards (`? extends T`) in enums?
Yes! You can use wildcards in generic enums, especially when passing them to methods.

```java
public static void printCurrency(Currency<?, ?> currency) {
    System.out.println("Currency: " + currency.getName());
}
```

### 3. Why use generics in enums instead of regular fields?
Generics provide **compile-time safety** and prevent type mismatches. Without generics, you would need to cast objects manually, increasing the chance of runtime errors.

## Further Reading
- [Java Enum Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
- [Java Generics Guide](https://docs.oracle.com/javase/tutorial/java/generics/)

## Hands-On Practice
Check out the [practice folder](./practice/generic-enums) in this repository for hands-on coding exercises!

---
This guide takes you from **basics to advanced** concepts of using generics in enums, ensuring you understand their real-world applications. Keep practicing, and happy coding! 🚀

