# **Primitive Streams in Java - A Complete Guide** 🚀  

## **Introduction**  

Java's **Streams API** provides a powerful way to process collections of objects. However, when dealing with **primitive data types** (int, double, long), using **regular streams (`Stream<T>`)** can lead to unnecessary **autoboxing and unboxing**, which impacts performance.  

To solve this, Java provides **Primitive Streams** (`IntStream`, `LongStream`, `DoubleStream`) that operate directly on primitive values, making operations faster and more memory-efficient.  

---

## **1. What are Primitive Streams?**  

Primitive Streams are specialized streams designed to work with primitive data types:  

| **Primitive Stream** | **Handles**       | **Example Values**         |
|----------------------|------------------|----------------------------|
| `IntStream`         | `int` values      | `1, 2, 3, 100, -50`        |
| `LongStream`        | `long` values     | `100000L, 200000L`         |
| `DoubleStream`      | `double` values   | `3.14, 2.71, 9.99`         |

💡 **Why use Primitive Streams?**  
✅ **Avoids Autoboxing/Unboxing** → `Stream<Integer>` incurs unnecessary overhead  
✅ **More Memory Efficient** → Works directly with primitives  
✅ **Provides Additional Utility Methods** (e.g., `sum()`, `average()`, `range()`, `rangeClosed()`)  

---

## **2. Creating Primitive Streams**  

### **2.1 Using `of()` Method**  
```java
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class PrimitiveStreamExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        LongStream longStream = LongStream.of(100L, 200L, 300L);
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);

        intStream.forEach(System.out::println);
    }
}
```

---

### **2.2 Using `range()` and `rangeClosed()`**  
Used for generating sequences of numbers.  

```java
// Generates numbers from 1 to 9 (excludes 10)
IntStream.range(1, 10).forEach(System.out::print); 
// Output: 123456789

// Generates numbers from 1 to 10 (includes 10)
IntStream.rangeClosed(1, 10).forEach(System.out::print); 
// Output: 12345678910
```

---

### **2.3 Generating Streams with `generate()` and `iterate()`**  

```java
// Generate 5 random integers
IntStream.generate(() -> (int) (Math.random() * 100))
         .limit(5)
         .forEach(System.out::println);

// Generate an increasing sequence starting from 0
IntStream.iterate(0, n -> n + 2)
         .limit(5)
         .forEach(System.out::println); 
// Output: 0 2 4 6 8
```

---

### **2.4 Converting from Regular Streams**  

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Convert Stream<Integer> to IntStream
IntStream intStream = numbers.stream().mapToInt(Integer::intValue);
```

---

## **3. Operations on Primitive Streams**  

### **3.1 Sum, Average, Min, Max, Count**  

```java
IntStream numbers = IntStream.of(10, 20, 30, 40, 50);

int sum = numbers.sum();  // Sum of all elements
double avg = numbers.average().orElse(0);  // Average
int min = numbers.min().orElse(0);  // Minimum value
int max = numbers.max().orElse(0);  // Maximum value
long count = numbers.count();  // Count of elements
```

---

### **3.2 Mapping: `map()` and `mapToObj()`**  

**Transforming elements:**  

```java
// Square each element
IntStream.of(1, 2, 3, 4, 5)
         .map(n -> n * n)
         .forEach(System.out::println);
```

**Converting primitive stream to object stream:**  

```java
IntStream.of(1, 2, 3)
         .mapToObj(n -> "Number: " + n)
         .forEach(System.out::println);
```
📌 **Output:**  
```
Number: 1
Number: 2
Number: 3
```

---

### **3.3 Filtering: `filter()`**  

```java
// Print even numbers
IntStream.rangeClosed(1, 10)
         .filter(n -> n % 2 == 0)
         .forEach(System.out::println);
```
📌 **Output:**  
```
2
4
6
8
10
```

---

## **4. Primitive Streams and Reduction**  

### **4.1 Using `reduce()` for Aggregation**  

```java
int sum = IntStream.of(1, 2, 3, 4, 5)
                   .reduce(0, (a, b) -> a + b);
System.out.println(sum); // Output: 15
```

### **4.2 Using `collect()` to Convert Back to List**  

```java
List<Integer> list = IntStream.range(1, 6)
                              .boxed()
                              .collect(Collectors.toList());

System.out.println(list); // Output: [1, 2, 3, 4, 5]
```

---

## **5. Performance Benefits of Primitive Streams**  

| Feature          | `Stream<Integer>`         | `IntStream` |
|-----------------|-------------------------|------------|
| **Memory Usage** | Higher (due to boxing)  | Lower (direct primitives) |
| **Performance**  | Slower (autoboxing overhead) | Faster (no boxing/unboxing) |
| **Best Use Case** | Small datasets / when objects needed | Large datasets / performance-critical |

---

## **6. When to Use Primitive Streams?**  

✅ **Use Primitive Streams when:**  
✔ Working with large numerical datasets  
✔ Avoiding unnecessary boxing/unboxing overhead  
✔ Performing mathematical operations (sum, average, min, max)  

❌ **Avoid Primitive Streams when:**  
❌ Working with non-numeric objects (use `Stream<T>` instead)  
❌ Need to store results in collections (convert using `.boxed()`)  

---

## **7. FAQs**  

### **Q1: Why use `IntStream` instead of `Stream<Integer>`?**  
`IntStream` avoids **autoboxing**, making operations more efficient and memory-friendly.  

### **Q2: Can I convert `IntStream` back to `Stream<Integer>`?**  
Yes, use `.boxed()` method:  
```java
Stream<Integer> stream = IntStream.of(1, 2, 3).boxed();
```

### **Q3: How to create an `IntStream` from an array?**  
```java
int[] arr = {10, 20, 30};
IntStream intStream = Arrays.stream(arr);
```

### **Q4: How is `range()` different from `rangeClosed()`?**  
- `IntStream.range(1, 5)` → **Excludes** 5 (Output: 1,2,3,4)  
- `IntStream.rangeClosed(1, 5)` → **Includes** 5 (Output: 1,2,3,4,5)  

---
# **Boxing in Primitive Streams - `boxed()` Method**  

## **What is `boxed()` in Java Streams?**  

The **`boxed()`** method in primitive streams (`IntStream`, `LongStream`, `DoubleStream`) is used to **convert a primitive stream into a stream of wrapper objects** (`Stream<Integer>`, `Stream<Long>`, `Stream<Double>`).  

This is useful when you need to **store, collect, or manipulate primitive values as objects**, such as storing them in a `List<Integer>` instead of an `int[]`.  

---

## **Why Use `boxed()`?**  

🔹 **Primitive Streams (`IntStream`, `LongStream`, `DoubleStream`)** provide efficient operations, but sometimes we need an **object-based** stream.  
🔹 Many APIs (like `Collectors.toList()`) work with **object streams**, so we need to convert primitive streams.  
🔹 `boxed()` helps transition between **primitive streams and object streams** efficiently.  

---

## **How to Use `boxed()`?**  

### **Example 1: Converting `IntStream` to `Stream<Integer>`**  

```java
import java.util.*;
import java.util.stream.*;

public class BoxedExample {
    public static void main(String[] args) {
        // Convert IntStream to Stream<Integer>
        Stream<Integer> intStream = IntStream.range(1, 6)
                                            .boxed();

        // Collect as List<Integer>
        List<Integer> numberList = intStream.collect(Collectors.toList());

        System.out.println(numberList); // Output: [1, 2, 3, 4, 5]
    }
}
```

✅ **Explanation:**  
- `IntStream.range(1, 6)` creates a primitive stream (`1, 2, 3, 4, 5`).  
- `.boxed()` converts `IntStream` to `Stream<Integer>`.  
- `.collect(Collectors.toList())` gathers elements into a `List<Integer>`.  

---

### **Example 2: Convert `DoubleStream` to `Stream<Double>`**  

```java
import java.util.stream.*;
import java.util.*;

public class BoxedDoubleStream {
    public static void main(String[] args) {
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);

        // Convert DoubleStream to Stream<Double> and collect as List
        List<Double> doubleList = doubleStream.boxed().collect(Collectors.toList());

        System.out.println(doubleList); // Output: [1.1, 2.2, 3.3]
    }
}
```

---

## **Performance Considerations of `boxed()`**  

| Feature            | Primitive Stream (`IntStream`) | Boxed Stream (`Stream<Integer>`) |
|-------------------|-----------------------------|--------------------------------|
| **Memory Usage**   | Lower (works with primitives) | Higher (stores wrapper objects) |
| **Performance**    | Faster (no boxing/unboxing)  | Slower (due to boxing overhead) |
| **Use Case**       | When performing numeric operations | When collecting data as objects |

✅ **Use `boxed()` only when necessary** (e.g., collecting into a `List<Integer>`).  

---

## **FAQs About `boxed()`**  

### **Q1: When should I use `boxed()`?**  
Use `boxed()` when you need to convert a primitive stream (`IntStream`, `LongStream`, `DoubleStream`) into an **object-based stream** (`Stream<Integer>`, `Stream<Long>`, `Stream<Double>`).  

### **Q2: Is `boxed()` always necessary for collecting into a list?**  
Yes, because `Collectors.toList()` works with `Stream<T>`, not `IntStream`.  

### **Q3: Does `boxed()` affect performance?**  
Yes, **it introduces boxing overhead**, so use it only when necessary.  

---

## **Conclusion**  

- **`boxed()`** is used to convert **primitive streams into object streams**.  
- It is useful when working with APIs that expect **`Stream<T>` instead of `IntStream`**.  
- Be mindful of **performance trade-offs** when using it.  

🚀 **Tip:** Prefer **primitive streams** for calculations, and use **`boxed()`** only when necessary for collecting results into objects! 🎯

## **8. Additional Resources**  

- [Java IntStream Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html)  
- [Java Primitive Streams Guide](https://www.baeldung.com/java-primitive-streams)  

---

## **9. Hands-On Practice**  

📂 **[Click here](./primitive-streams-practice)** to access hands-on coding exercises on Primitive Streams.  

---

### **Conclusion**  
Primitive Streams (`IntStream`, `LongStream`, `DoubleStream`) provide an **efficient** and **performance-optimized** way to work with numerical data. 🚀 Keep practicing to master them! 🎯