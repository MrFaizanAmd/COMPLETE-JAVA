# Wildcards in Java Generics

## Introduction

Generics in Java provide a powerful way to ensure type safety and reusability. However, there are scenarios where we need flexibility in handling different types of data. This is where **wildcards** come into play.

A wildcard (`?`) in Java generics represents an **unknown type**. It allows for more **flexible and dynamic** code by permitting type variability in generic classes and methods.

### Why Are Wildcards Important?
- Enable generic methods to **accept multiple types** without over-restricting.
- Provide a way to work with **collections of different types** while maintaining type safety.
- Help in designing **more generic and reusable** APIs.

Wildcards are widely used in Java collections, APIs, and framework designs, allowing developers to work with different data types without losing the benefits of generics.

## Understanding Wildcards

A wildcard in generics is represented by `?`. It can be used in **method parameters, return types, and variables** where the type is not specified upfront.

### Basic Syntax:
```java
List<?> list;
```
Here, `?` represents an unknown type. The list can hold elements of any type, but type-specific operations are restricted.

## Types of Wildcards
Java provides three types of wildcards:

### 1. **Unbounded Wildcards (`?`)**
Used when the type is unknown, and we need to work with different types **without modification**.

#### Example:
```java
public void printList(List<?> list) {
    for (Object element : list) {
        System.out.println(element);
    }
}
```
#### Usage:
```java
List<String> strings = List.of("Apple", "Banana");
List<Integer> numbers = List.of(1, 2, 3);

printList(strings); // Works
printList(numbers); // Works
```
Since we use `?`, the method can accept any list type without knowing the exact type.

### 2. **Upper-Bounded Wildcards (`? extends T`)**
Used when we need to specify an **upper limit** for the wildcard. The wildcard represents a type that is a **subclass** (or the same type) of `T`.

#### Example:
```java
public double sumNumbers(List<? extends Number> numbers) {
    double sum = 0;
    for (Number num : numbers) {
        sum += num.doubleValue();
    }
    return sum;
}
```
#### Usage:
```java
List<Integer> intList = List.of(1, 2, 3);
List<Double> doubleList = List.of(1.1, 2.2, 3.3);

System.out.println(sumNumbers(intList));  // Valid
System.out.println(sumNumbers(doubleList)); // Valid
```

#### Key Points:
- `List<? extends Number>` allows lists of `Integer`, `Double`, `Float`, etc.
- We **can read** elements, but **cannot add new elements** (except `null`).
- This is an example of **covariance** (preserving subtype relationships).

### 3. **Lower-Bounded Wildcards (`? super T`)**
Used when we need to specify a **lower limit** for the wildcard. The wildcard represents a type that is a **superclass** (or the same type) of `T`.

#### Example:
```java
public void addNumbers(List<? super Integer> list) {
    list.add(100);
    list.add(200);
}
```
#### Usage:
```java
List<Number> numList = new ArrayList<>();
addNumbers(numList); // Valid
```

#### Key Points:
- `List<? super Integer>` can hold `Integer`, `Number`, or `Object`.
- We **can add** `Integer` values but **cannot read specific types** (only `Object`).
- This is an example of **contravariance** (reversing subtype relationships).

## Comparing Wildcard Types

| Wildcard Type  | Read | Write | Example |
|---------------|------|-------|---------|
| `?` (Unbounded) | ✅ Yes | ❌ No | `List<?>` |
| `? extends T` (Upper Bound) | ✅ Yes | ❌ No | `List<? extends Number>` |
| `? super T` (Lower Bound) | ❌ No (except `Object`) | ✅ Yes | `List<? super Integer>` |

## Common Use Cases

### 1. **Generic Method with Wildcards**
```java
public static void printCollection(List<?> collection) {
    for (Object obj : collection) {
        System.out.println(obj);
    }
}
```
This method can print elements from **any list type**, such as `List<String>`, `List<Integer>`, etc.

### 2. **Restricting Method Parameters**
```java
public static void processNumbers(List<? extends Number> numbers) {
    for (Number num : numbers) {
        System.out.println(num);
    }
}
```
This ensures only subtypes of `Number` (e.g., `Integer`, `Double`) are allowed.

### 3. **Allowing Modification with Lower Bounds**
```java
public static void addElements(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```
This method allows adding integers but restricts reading beyond `Object` type.

## FAQs

### 1. **Can I add elements to a `List<?>`?**
No, because the type is unknown. However, `null` can be added.

### 2. **What is the difference between `? extends T` and `? super T`?**
- `? extends T` → **Read-only**, can accept any subtype of `T`.
- `? super T` → **Write-only**, can accept any supertype of `T`.

### 3. **Why does `List<Dog>` not work with `List<Animal>`?**
Java generics are **invariant**, meaning `List<Dog>` is not a subtype of `List<Animal>`. You need wildcards to handle such cases.

### 4. **When should I use wildcards?**
Use them when writing **methods that operate on generic types** without modifying them explicitly.

## Further Reading
- [Java Generics Official Documentation](https://docs.oracle.com/javase/tutorial/java/generics/)
- [Effective Java by Joshua Bloch](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)

## Hands-On Practice
For practice files related to wildcards in Java, visit the [Wildcards Practice Folder](./practice/wildcards).

---
By mastering wildcards in Java Generics, you can write **flexible, reusable, and type-safe** code efficiently!

