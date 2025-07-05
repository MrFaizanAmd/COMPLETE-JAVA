# Java Learning Repository - Wrapper Classes in Java

## Introduction

Welcome to the Java Learning Repository! In this section, we will explore **Wrapper Classes in Java**, an essential topic that bridges the gap between primitive data types and objects. Understanding wrapper classes will help you work efficiently with Java's Collections Framework, generic programming, and various utility methods. Whether you are a beginner or an experienced Java developer, this guide will take you step by step through wrapper classes, their purpose, and their practical applications.

## What Are Wrapper Classes?

In Java, **primitive data types** (such as `int`, `double`, `char`, etc.) are not objects; they are simple data holders. However, Java is an **object-oriented programming language**, and sometimes, we need an object representation of these primitive types.

This is where **Wrapper Classes** come into play! Each primitive type in Java has a corresponding wrapper class that allows it to be used as an object.

### Wrapper Classes Mapping

| Primitive Type | Wrapper Class |
|---------------|--------------|
| `byte`        | `Byte`       |
| `short`       | `Short`      |
| `int`         | `Integer`    |
| `long`        | `Long`       |
| `float`       | `Float`      |
| `double`      | `Double`     |
| `char`        | `Character`  |
| `boolean`     | `Boolean`    |

## Why Do We Need Wrapper Classes?

1. **Collections Framework**: Java's collections (like `ArrayList`, `HashSet`) work only with objects, not primitive types.
2. **Utility Methods**: Wrapper classes come with many useful methods for conversions and manipulations.
3. **Synchronization**: Primitive types cannot be synchronized, but wrapper classes can.
4. **Generics Support**: Java Generics require object types, making wrapper classes necessary.
5. **Nullability**: Unlike primitives, wrapper class objects can be `null`.

## Autoboxing and Unboxing

Java provides a convenient feature called **autoboxing and unboxing** to automatically convert between primitives and their wrapper class equivalents.

### Autoboxing (Primitive to Object)

```java
int num = 10;
Integer obj = num; // Autoboxing: int to Integer
System.out.println("Autoboxed Integer: " + obj);
```

### Unboxing (Object to Primitive)

```java
Integer obj = 20;
int num = obj; // Unboxing: Integer to int
System.out.println("Unboxed int: " + num);
```

## Real-World Analogy

Think of wrapper classes like **gift-wrapping a present**:
- The primitive type is the actual gift.
- The wrapper class is the decorative gift box that makes the gift presentable and easier to handle.
- Just like you can unwrap the gift, you can unbox the wrapper class back to its primitive type.

## Common Methods in Wrapper Classes

Wrapper classes provide useful methods for parsing, conversion, and manipulation:

```java
// Parsing String to Integer
int parsedInt = Integer.parseInt("123");
System.out.println("Parsed int: " + parsedInt);

// Getting max value of an Integer
System.out.println("Max Integer Value: " + Integer.MAX_VALUE);

// Converting primitive to String
String strValue = Double.toString(45.6);
System.out.println("String Value: " + strValue);
```

## When to Use Wrapper Classes

- When working with **Collections** (`ArrayList<Integer> numbers = new ArrayList<>();`)
- When **converting between strings and numbers** (`Integer.parseInt("10")`)
- When **dealing with nullable values** (`Integer age = null;`)
- When using **Generics**, which do not support primitive types

## FAQs (Frequently Asked Questions)

### 1. **Are wrapper classes mutable?**
No, wrapper class objects are **immutable**, meaning their values cannot be changed once created.

### 2. **Do wrapper classes improve performance?**
Not necessarily. Since wrapper classes are objects, they take more memory and have performance overhead compared to primitive types.

### 3. **How does autoboxing affect performance?**
Frequent boxing/unboxing can impact performance due to object creation. If performance is critical, prefer primitives.

### 4. **Can I compare wrapper objects using `==`?**
No! Always use `.equals()` for comparison. `==` checks reference equality, which may not give the expected result.

```java
Integer a = 1000;
Integer b = 1000;
System.out.println(a == b); // false (different objects)
System.out.println(a.equals(b)); // true (same value)
```

### 5. **What happens when you compare small integer values using `==`?**
Java caches integer values from `-128` to `127`. Comparisons within this range using `==` may return `true`.

```java
Integer x = 100;
Integer y = 100;
System.out.println(x == y); // true (cached values)
```

## Further Learning Resources
- [Oracle Documentation on Wrapper Classes](https://docs.oracle.com/javase/tutorial/java/data/numberclasses.html)
- [Java Autoboxing and Unboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)

## Hands-On Practice
Find example programs and exercises related to Wrapper Classes in [this repository folder](#).

---
Happy Coding! 🚀

