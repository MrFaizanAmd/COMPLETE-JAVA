# 📌 Java Primitive Streams – A Complete Reference Guide

## 🔥 Introduction
Java provides specialized streams for handling **primitive data types** efficiently, avoiding unnecessary boxing and unboxing. These are:

- **IntStream** – for `int` values
- **LongStream** – for `long` values
- **DoubleStream** – for `double` values

Primitive streams come with additional methods optimized for numerical operations such as **sum, average, min, max, range, and summary statistics**.

This guide covers **all methods**, categorized as **Intermediate & Terminal Operations**, with explanations and examples.

---

## 📌 Creating Primitive Streams
### 1️⃣ Using `of()`
```java
IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
LongStream longStream = LongStream.of(10L, 20L, 30L);
DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);
```

### 2️⃣ Using `range()` & `rangeClosed()`
```java
IntStream.range(1, 5).forEach(System.out::println);  // 1, 2, 3, 4
IntStream.rangeClosed(1, 5).forEach(System.out::println);  // 1, 2, 3, 4, 5
```

### 3️⃣ Using `generate()`
```java
IntStream.generate(() -> (int) (Math.random() * 10)).limit(5).forEach(System.out::println);
```

### 4️⃣ Using `iterate()`
```java
IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::println);  // 1, 3, 5, 7, 9
```

### 5️⃣ From Arrays
```java
int[] numbers = {1, 2, 3, 4, 5};
IntStream intStream = Arrays.stream(numbers);
```

### 6️⃣ From Random Numbers
```java
new Random().ints(5, 1, 10).forEach(System.out::println);
```

---

## 🔄 **Intermediate Operations**

| Method | Description | Example |
|--------|------------|---------|
| `filter(Predicate<T>)` | Filters elements based on a condition | `IntStream.range(1, 10).filter(n -> n % 2 == 0).forEach(System.out::println);` |
| `map(ToIntFunction<T>)` | Transforms elements | `IntStream.of(1, 2, 3).map(n -> n * n).forEach(System.out::println);` |
| `flatMap(Function<T, Stream<R>>)` | Flattens nested structures | `IntStream.of(1, 2, 3).flatMap(n -> IntStream.of(n, n * 10)).forEach(System.out::println);` |
| `distinct()` | Removes duplicates | `IntStream.of(1, 2, 2, 3).distinct().forEach(System.out::println);` |
| `sorted()` | Sorts elements | `IntStream.of(3, 1, 2).sorted().forEach(System.out::println);` |
| `limit(n)` | Limits the number of elements | `IntStream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);` |
| `skip(n)` | Skips first `n` elements | `IntStream.range(1, 10).skip(5).forEach(System.out::println);` |
| `peek()` | Performs an action without modifying elements | `IntStream.range(1, 5).peek(System.out::println).sum();` |

---

## ✅ **Terminal Operations**

| Method | Description | Example |
|--------|------------|---------|
| `forEach(Consumer<T>)` | Performs an action for each element | `IntStream.range(1, 5).forEach(System.out::println);` |
| `toArray()` | Converts stream to an array | `int[] arr = IntStream.range(1, 5).toArray();` |
| `reduce(identity, accumulator)` | Reduces stream to a single value | `int sum = IntStream.range(1, 5).reduce(0, Integer::sum);` |
| `collect(Supplier, Accumulator, Combiner)` | Collects elements into a structure | `List<Integer> list = IntStream.range(1, 5).boxed().collect(Collectors.toList());` |
| `sum()` | Returns sum of elements | `int total = IntStream.range(1, 5).sum();` |
| `average()` | Returns average as `OptionalDouble` | `OptionalDouble avg = IntStream.range(1, 5).average();` |
| `min()` | Returns min element as `OptionalInt` | `OptionalInt min = IntStream.range(1, 5).min();` |
| `max()` | Returns max element as `OptionalInt` | `OptionalInt max = IntStream.range(1, 5).max();` |
| `count()` | Returns number of elements | `long count = IntStream.range(1, 5).count();` |
| `summaryStatistics()` | Returns `IntSummaryStatistics` object | `IntSummaryStatistics stats = IntStream.range(1, 5).summaryStatistics();` |
| `anyMatch(Predicate<T>)` | Checks if any element matches | `boolean hasEven = IntStream.range(1, 5).anyMatch(n -> n % 2 == 0);` |
| `allMatch(Predicate<T>)` | Checks if all elements match | `boolean allPositive = IntStream.of(1, 2, 3).allMatch(n -> n > 0);` |
| `noneMatch(Predicate<T>)` | Checks if no elements match | `boolean noneNegative = IntStream.of(1, 2, 3).noneMatch(n -> n < 0);` |
| `findFirst()` | Returns first element | `OptionalInt first = IntStream.range(1, 5).findFirst();` |
| `findAny()` | Returns any element (useful for parallel streams) | `OptionalInt any = IntStream.range(1, 5).findAny();` |

---

## 🌟 **Working with Boxed Streams**
Primitive streams do not support generic types like `List<Integer>`. To convert, use `boxed()`:
```java
List<Integer> list = IntStream.range(1, 5).boxed().collect(Collectors.toList());
```

---

## 🚀 **Summary**
✅ Primitive Streams optimize handling of numerical data without boxing overhead.
✅ They offer additional numerical operations (`sum()`, `average()`, `min()`, etc.).
✅ Use **IntStream, LongStream, DoubleStream** for performance-efficient streaming.
✅ Convert to **boxed streams** when working with collections.

🔹 **Mastering Primitive Streams will enhance performance & efficiency in numerical computations!**

---

🎯 **Happy Coding!** 🎯

