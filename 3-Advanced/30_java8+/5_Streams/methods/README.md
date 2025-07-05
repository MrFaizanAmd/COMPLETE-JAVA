# 📌 **Java Streams API - Complete Method Reference Guide**

## 🔥 **Introduction**
The **Java Streams API** (introduced in Java 8) allows functional-style operations on collections.
It provides **intermediate** and **terminal** operations to process data efficiently.

This guide covers **all stream methods**, their **descriptions**, **time complexity**, and **examples**.

---

## 🔄 **Stream Pipeline Overview**
A **Stream pipeline** consists of three parts:
1. **Source** → Collection, Array, or Generator
2. **Intermediate Operations** → Transformations (e.g., `map()`, `filter()`)
3. **Terminal Operations** → Final result (e.g., `collect()`, `forEach()`)

---

## 📊 **Method Table (Intermediate & Terminal Operations)**

### **1. Intermediate Operations** (Transformations - Lazy Evaluation)
| Method | Description | Complexity | Example |
|--------|------------|------------|---------|
| `filter(Predicate<T>)` | Filters elements based on a condition | **O(n)** | `list.stream().filter(n -> n > 10)` |
| `map(Function<T,R>)` | Transforms elements | **O(n)** | `list.stream().map(String::toUpperCase)` |
| `flatMap(Function<T,Stream<R>>)` | Flattens nested streams | **O(n * m)** | `list.stream().flatMap(List::stream)` |
| `distinct()` | Removes duplicates | **O(n log n)** | `list.stream().distinct()` |
| `sorted()` | Sorts elements (natural order) | **O(n log n)** | `list.stream().sorted()` |
| `sorted(Comparator<T>)` | Sorts elements (custom order) | **O(n log n)** | `list.stream().sorted(Comparator.reverseOrder())` |
| `peek(Consumer<T>)` | Performs an action without modifying | **O(n)** | `list.stream().peek(System.out::println)` |
| `limit(long n)` | Limits to first `n` elements | **O(n)** | `list.stream().limit(5)` |
| `skip(long n)` | Skips first `n` elements | **O(n)** | `list.stream().skip(3)` |

### **2. Terminal Operations** (End the Stream Processing)
| Method | Description | Complexity | Example |
|--------|------------|------------|---------|
| `forEach(Consumer<T>)` | Iterates over each element | **O(n)** | `list.stream().forEach(System.out::println)` |
| `toArray()` | Converts stream to array | **O(n)** | `Integer[] arr = list.stream().toArray(Integer[]::new)` |
| `reduce(BinaryOperator<T>)` | Reduces elements to a single value | **O(n)** | `list.stream().reduce(0, Integer::sum)` |
| `collect(Collector<T,A,R>)` | Collects elements into a collection | **O(n)** | `list.stream().collect(Collectors.toList())` |
| `min(Comparator<T>)` | Finds the minimum element | **O(n)** | `list.stream().min(Integer::compareTo)` |
| `max(Comparator<T>)` | Finds the maximum element | **O(n)** | `list.stream().max(Integer::compareTo)` |
| `count()` | Counts elements in stream | **O(n)** | `list.stream().count()` |
| `anyMatch(Predicate<T>)` | Checks if any element matches | **O(n)** | `list.stream().anyMatch(n -> n > 10)` |
| `allMatch(Predicate<T>)` | Checks if all elements match | **O(n)** | `list.stream().allMatch(n -> n > 10)` |
| `noneMatch(Predicate<T>)` | Checks if no element matches | **O(n)** | `list.stream().noneMatch(n -> n > 10)` |
| `findFirst()` | Returns the first element | **O(1)** | `list.stream().findFirst()` |
| `findAny()` | Returns any element | **O(1)** | `list.stream().findAny()` |

---
# 📌 Java Streams - Intermediate Operations


## 📖 Detailed Explanations with Examples

### 1️⃣ `filter(Predicate<T>)`
Filters elements that satisfy a given condition.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // [2, 4, 6]
    }
}
```

---

### 2️⃣ `map(Function<T, R>)`
Applies a transformation to each element.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(nameLengths); // [5, 3, 7]
    }
}
```

---

### 3️⃣ `flatMap(Function<T, Stream<R>>)`
Flattens nested streams into a single stream.
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        List<Integer> flattenedList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        
        System.out.println(flattenedList); // [1, 2, 3, 4, 5, 6]
    }
}
```

---

### 4️⃣ `distinct()`
Removes duplicate elements from the stream.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueNumbers); // [1, 2, 3, 4, 5]
    }
}
```

---

### 5️⃣ `sorted()`
Sorts elements in natural order.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 3, 8, 1, 2);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers); // [1, 2, 3, 5, 8]
    }
}
```

---

### 6️⃣ `sorted(Comparator<T>)`
Sorts elements using a custom comparator.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedComparatorExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<String> sortedNames = names.stream()
                .sorted((a, b) -> b.compareTo(a)) // Reverse order
                .collect(Collectors.toList());
        System.out.println(sortedNames); // [Charlie, Bob, Alice]
    }
}
}
```

---

### 7️⃣ `peek(Consumer<T>)`
Used for debugging; performs an action on each element.
```java
import java.util.List;

public class StreamPeekExample {
    public static void main(String[] args) {
        List.of("apple", "banana", "cherry")
                .stream()
                .peek(System.out::println)
                .count(); // Terminal operation required
    }
}
```

---

### 8️⃣ `limit(long maxSize)`
Limits the number of elements in the stream.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamLimitExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limitedNumbers); // [1, 2, 3]
    }
}
```

---

### 9️⃣ `skip(long n)`
Skips the first `n` elements.
```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamSkipExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> skippedNumbers = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skippedNumbers); // [3, 4, 5]
    }
}
```

---


- **Intermediate operations** are **lazy** and return another stream.
- Must be followed by a **terminal operation** to execute.
- Key methods: `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`, `peek()`, `limit()`, `skip()`.

🎯 **Next Step:** Learn **Terminal Operations** for Streams!

# 📌 Java Streams - Terminal Operations


## 🚀 Key Terminal Operations with Examples

### 1️⃣ `forEach()` - Iterating Over Elements
```java
import java.util.stream.Stream;

public class ForEachExample {
    public static void main(String[] args) {
        Stream.of("Apple", "Banana", "Cherry")
              .forEach(System.out::println); // Prints each element
    }
}
```
🔹 **Note**: Avoid modifying external state in `forEach()` in parallel streams.

---

### 2️⃣ `toArray()` - Converting Stream to Array
```java
import java.util.Arrays;
import java.util.stream.Stream;

public class ToArrayExample {
    public static void main(String[] args) {
        String[] fruits = Stream.of("Apple", "Banana", "Cherry")
                                .toArray(String[]::new);
        System.out.println(Arrays.toString(fruits)); // [Apple, Banana, Cherry]
    }
}
```

---

### 3️⃣ `reduce()` - Reducing Elements
```java
import java.util.stream.Stream;

public class ReduceExample {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5)
                        .reduce(0, Integer::sum); // 0 + 1 + 2 + 3 + 4 + 5
        System.out.println("Sum: " + sum); // Sum: 15
    }
}
```

---

### 4️⃣ `collect()` - Collecting Elements into a List
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExample {
    public static void main(String[] args) {
        List<String> names = Stream.of("Alice", "Bob", "Charlie")
                                   .collect(Collectors.toList());
        System.out.println(names); // [Alice, Bob, Charlie]
    }
}
```

---

### 5️⃣ `min()` & `max()` - Finding Min/Max Elements
```java
import java.util.Optional;
import java.util.stream.Stream;

public class MinMaxExample {
    public static void main(String[] args) {
        Optional<String> min = Stream.of("Dog", "Cat", "Elephant")
                                     .min(String::compareTo);
        System.out.println("Min: " + min.orElse("None")); // Cat
    }
}
```

---

### 6️⃣ `count()` - Counting Elements
```java
import java.util.stream.Stream;

public class CountExample {
    public static void main(String[] args) {
        long count = Stream.of("Java", "Python", "C++").count();
        System.out.println("Count: " + count); // Count: 3
    }
}
```

---

### 7️⃣ `anyMatch()`, `allMatch()`, `noneMatch()` - Matching Conditions
```java
import java.util.stream.Stream;

public class MatchExample {
    public static void main(String[] args) {
        boolean any = Stream.of(10, 20, 30).anyMatch(n -> n > 15); // true
        boolean all = Stream.of(10, 20, 30).allMatch(n -> n > 5); // true
        boolean none = Stream.of(10, 20, 30).noneMatch(n -> n < 5); // true

        System.out.println("Any Match: " + any);
        System.out.println("All Match: " + all);
        System.out.println("None Match: " + none);
    }
}
```

---

### 8️⃣ `findFirst()` & `findAny()` - Retrieving Elements
```java
import java.util.Optional;
import java.util.stream.Stream;

public class FindExample {
    public static void main(String[] args) {
        Optional<Integer> first = Stream.of(100, 200, 300).findFirst();
        Optional<Integer> any = Stream.of(100, 200, 300).findAny();

        System.out.println("First: " + first.orElse(-1)); // First: 100
        System.out.println("Any: " + any.orElse(-1)); // Any: 100 (or any value in parallel)
    }
}
```

---


- **Terminal operations** produce a final result, unlike **intermediate operations**.
- Methods like `forEach()`, `collect()`, and `reduce()` are used for different types of output.
- `findFirst()` and `findAny()` help retrieve stream elements.
- `count()`, `min()`, and `max()` allow numerical evaluations.
- `anyMatch()`, `allMatch()`, `noneMatch()` perform conditional checks.

---

🎯 **Mastering these methods will help you write powerful Java Stream pipelines!** 🚀



---

## 🔥 **Summary**
- **Intermediate operations**: `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`, etc.
- **Terminal operations**: `forEach()`, `reduce()`, `collect()`, `count()`, `findFirst()`, etc.
- **Lazy evaluation** ensures efficiency.
- **Parallel Streams** can improve performance (`stream().parallel()`).

---

🚀 **Happy Coding!** 🎯

