# **Parallel Streams in Java - A Complete Guide** 🚀  

## **Introduction**  

Java **Streams API** provides a convenient way to process collections of data, but when dealing with large datasets, sequential processing may become a bottleneck. This is where **Parallel Streams** come into play, enabling **multi-threaded processing** to improve performance.  

### **Why Use Parallel Streams?**  

✅ **Improves performance** for large datasets by utilizing multiple CPU cores  
✅ **Processes data concurrently** rather than sequentially  
✅ **Simplifies parallel execution** compared to using traditional multi-threading  

Imagine **Parallel Streams** like a restaurant kitchen with multiple chefs:  
- **Sequential Processing** → A single chef prepares all the dishes one by one.  
- **Parallel Processing** → Multiple chefs work on different dishes simultaneously, reducing wait time.  

However, parallel processing is not always faster—it depends on the dataset size and the type of operations performed.  

---

## **1. What is a Parallel Stream?**  

A **Parallel Stream** is a type of Java Stream that divides the data into **subtasks**, processes them in parallel, and then combines the results.  

💡 **Key Characteristics of Parallel Streams:**  
- Utilizes **ForkJoinPool** internally for parallel execution  
- Automatically splits data into multiple chunks for processing  
- May process elements **out of order** (unordered execution)  
- Works best for **CPU-intensive** operations  

**Example: Converting a Sequential Stream to a Parallel Stream**  
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Sequential stream
names.stream().forEach(System.out::println);

// Parallel stream
names.parallelStream().forEach(System.out::println);
```
⚠ **Note:** The output order in a **parallel stream** may differ from a sequential stream.

---

## **2. How to Create a Parallel Stream?**  

There are multiple ways to create a parallel stream in Java.  

### **2.1 Using `.parallelStream()` on Collections**  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> parallelStream = numbers.parallelStream();
```

### **2.2 Using `.parallel()` on a Regular Stream**  
```java
Stream<Integer> sequentialStream = numbers.stream();
Stream<Integer> parallelStream = sequentialStream.parallel();
```

### **2.3 Using `Stream.of()` in Parallel Mode**  
```java
Stream<String> stream = Stream.of("A", "B", "C", "D").parallel();
```

---

## **3. How Parallel Streams Work Internally?**  

Parallel Streams use **ForkJoinPool** to break the task into **subtasks** and execute them concurrently using multiple threads.

💡 **Behind the scenes:**  
1. The input collection is split into smaller **chunks**.  
2. Each chunk is processed **in parallel** using a thread from the ForkJoinPool.  
3. The results are combined to produce the final output.  

---

## **4. Parallel Stream Operations**  

Parallel Streams support the same operations as Sequential Streams, but they execute them concurrently.  

### **4.1 `forEach()` – Unordered Execution**  
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Parallel forEach
names.parallelStream().forEach(System.out::println);
```
⚠ **Note:** The output order may vary each time you run it.  

### **4.2 `forEachOrdered()` – Maintain Order**  
To maintain order in parallel execution, use `forEachOrdered()`.  
```java
names.parallelStream().forEachOrdered(System.out::println);
```

### **4.3 `map()` – Transform Elements in Parallel**  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

List<Integer> squaredNumbers = numbers.parallelStream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());

System.out.println(squaredNumbers); // Output: [1, 4, 9, 16, 25] (Order may vary)
```

### **4.4 `reduce()` – Parallel Reduction**  
Parallel streams optimize reduction operations for better performance.  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.parallelStream().reduce(0, Integer::sum);
System.out.println(sum); // Output: 15
```

### **4.5 `collect()` – Collecting Results in Parallel**  
```java
Set<String> uniqueNames = names.parallelStream()
                               .collect(Collectors.toSet());

System.out.println(uniqueNames);
```

---

## **5. Performance Comparison: Sequential vs. Parallel Streams**  

Let's compare the execution time for **sequential** vs. **parallel** processing.  

### **Example: Processing Large Numbers**
```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamPerformance {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());

        // Sequential processing
        long start = System.currentTimeMillis();
        numbers.stream().map(n -> n * 2).count();
        long end = System.currentTimeMillis();
        System.out.println("Sequential Time: " + (end - start) + "ms");

        // Parallel processing
        start = System.currentTimeMillis();
        numbers.parallelStream().map(n -> n * 2).count();
        end = System.currentTimeMillis();
        System.out.println("Parallel Time: " + (end - start) + "ms");
    }
}
```
📌 **Output (varies based on CPU cores):**  
```
Sequential Time: 80ms  
Parallel Time: 30ms  
```
💡 **Observation:** Parallel streams perform better for large datasets but may have **overhead** for smaller datasets.

---

## **6. When to Use Parallel Streams?**  

### ✅ **Best Use Cases for Parallel Streams:**  
✔ Large datasets (e.g., **1M+ elements**)  
✔ CPU-intensive tasks (e.g., **mathematical computations, data transformations**)  
✔ Stateless operations (i.e., **no shared mutable state**)  

### ❌ **When NOT to Use Parallel Streams:**  
❌ Small collections (**<1000 elements**) → Overhead outweighs benefits  
❌ Operations with **side effects** (e.g., modifying shared variables)  
❌ IO-based operations (e.g., **file processing, database transactions**)  

---

## **7. Common Pitfalls & Best Practices**  

### ❌ **Modifying Shared Variables in Parallel Streams**  
Avoid shared mutable state as it can cause unpredictable results.  
```java
int sum = 0;
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// ❌ Incorrect: Modifies shared variable
numbers.parallelStream().forEach(n -> sum += n);
```
✅ **Solution:** Use `reduce()`
```java
int sum = numbers.parallelStream().reduce(0, Integer::sum);
```

### ❌ **Using Parallel Streams for Small Data**  
Parallel streams have overhead and are inefficient for small datasets.  
✅ **Solution:** Use sequential streams for small collections.

### ✅ **Measure Performance Before Using Parallel Streams**  
Use `System.currentTimeMillis()` or `System.nanoTime()` to compare execution times before deciding.

---

## **8. Frequently Asked Questions (FAQs)**  

### **Q1: How many threads does Parallel Stream use?**  
Parallel Streams use **ForkJoinPool.commonPool()**, which by default has **number of CPU cores - 1** threads.  

### **Q2: Can we customize the thread pool size?**  
Yes! You can set a custom ForkJoinPool using:  
```java
ForkJoinPool customPool = new ForkJoinPool(4);
customPool.submit(() -> numbers.parallelStream().forEach(System.out::println)).join();
```

### **Q3: Why is my Parallel Stream slower?**  
Parallel Streams introduce overhead. If the dataset is small or the task is simple, the overhead **reduces performance** instead of improving it.

---

## **9. Additional Resources**  

- [Java Parallel Streams Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#parallel--)
- [ForkJoinPool in Java](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html)  

---

## **10. Hands-On Practice**  

📂 **[Click here](./parallel-streams-practice)** to access hands-on coding exercises on Parallel Streams.  

---

### **Conclusion**  
Parallel Streams are a powerful tool when used correctly. Always test and benchmark before using them in performance-critical applications. 🚀 Happy coding! 🎯