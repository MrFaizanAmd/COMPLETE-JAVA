# **Collectors and Reduction in Java Streams - A Complete Guide** 🚀  

## **Introduction**  

The **Streams API** in Java provides powerful tools for **processing collections of data**. Two of the most essential concepts in stream processing are:  

1. **Collectors**: Used to **accumulate, group, and transform** stream elements into collections (List, Set, Map, etc.).  
2. **Reduction**: Used to **aggregate** stream elements into a single result (sum, average, concatenation, etc.).  

Understanding these concepts will help you write **clean, concise, and efficient** Java code.  

---

## **1. What is a Collector?**  

A **Collector** is a utility provided by the `java.util.stream.Collectors` class that helps in **accumulating elements from a Stream** into a collection or performing summarization.  

🔹 **Common uses of Collectors:**  
- Convert a stream into a **List, Set, or Map**  
- Group and partition data  
- Compute summary statistics  

### **Basic Example: Convert Stream to List**  
```java
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Convert stream to List
        List<String> nameList = names.stream()
                                     .collect(Collectors.toList());

        System.out.println(nameList); // Output: [Alice, Bob, Charlie, David]
    }
}
```

---

## **2. Common Collectors Operations**  

### **2.1 Collecting into a Collection**  

#### **Convert Stream to List, Set, or Map**  

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Convert to List
List<Integer> numberList = numbers.stream()
                                  .collect(Collectors.toList());

// Convert to Set (removes duplicates)
Set<Integer> numberSet = numbers.stream()
                                .collect(Collectors.toSet());

// Convert to Map (key = element, value = squared value)
Map<Integer, Integer> numberMap = numbers.stream()
                                         .collect(Collectors.toMap(n -> n, n -> n * n));

System.out.println(numberList); // Output: [1, 2, 3, 4, 5]
System.out.println(numberSet);  // Output: [1, 2, 3, 4, 5]
System.out.println(numberMap);  // Output: {1=1, 2=4, 3=9, 4=16, 5=25}
```

---

### **2.2 Grouping Elements (`groupingBy`)**  

💡 **Use case**: Categorizing data into groups (like SQL `GROUP BY`)  

```java
import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    String city;

    Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class GroupingExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", "New York"),
            new Person("Bob", "Los Angeles"),
            new Person("Charlie", "New York"),
            new Person("David", "Los Angeles")
        );

        // Group people by city
        Map<String, List<Person>> peopleByCity = people.stream()
            .collect(Collectors.groupingBy(person -> person.city));

        System.out.println(peopleByCity);
    }
}
```
📌 **Output:**  
```
{New York=[Alice, Charlie], Los Angeles=[Bob, David]}
```

---

### **2.3 Partitioning Elements (`partitioningBy`)**  

💡 **Use case**: Divide elements into **two groups** based on a condition.  

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// Partition numbers into even and odd
Map<Boolean, List<Integer>> partitioned = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));

System.out.println(partitioned);
// Output: {false=[1, 3, 5], true=[2, 4, 6]}
```

---

### **2.4 Summarization (`summarizingInt`, `summarizingDouble`)**  

💡 **Use case**: Compute **count, sum, min, max, average** in one go.  

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

IntSummaryStatistics stats = numbers.stream()
                                    .collect(Collectors.summarizingInt(n -> n));

System.out.println(stats);
// Output: IntSummaryStatistics{count=5, sum=150, min=10, average=30.000000, max=50}
```

---

## **3. What is Reduction? (`reduce()`)**  

A **Reduction operation** (also known as **fold**) takes a sequence of elements and **reduces** them into a **single value**.  

🔹 **Common use cases:**  
- Summing numbers  
- Finding max/min values  
- Concatenating strings  

### **3.1 Basic Reduction with `reduce()`**  

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// Sum of numbers
int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);

System.out.println(sum); // Output: 15
```
✅ **Explanation:**  
- **`0`** → Initial value  
- **`(a, b) -> a + b`** → Accumulator function  

---

### **3.2 Finding Maximum and Minimum**  

```java
List<Integer> numbers = Arrays.asList(10, 50, 30, 20, 40);

// Find max value
int max = numbers.stream()
                 .reduce(Integer.MIN_VALUE, Integer::max);

System.out.println(max); // Output: 50
```

---

### **3.3 Concatenating Strings**  

```java
List<String> words = Arrays.asList("Hello", "World", "Java");

// Reduce to concatenate strings
String sentence = words.stream()
                       .reduce("", (a, b) -> a + " " + b);

System.out.println(sentence.trim()); // Output: Hello World Java
```

---

## **4. Performance Considerations: Collect vs Reduce**  

| Feature          | `collect()` (Collectors)   | `reduce()` (Reduction) |
|-----------------|---------------------------|------------------------|
| **Purpose**      | Collects elements into a collection | Produces a single result |
| **Performance**  | Optimized for mutability | May be slower for large collections |
| **Usage**        | Aggregating into Lists, Sets, Maps | Summing, finding min/max, concatenation |

✅ **Rule of Thumb:** Use `collect()` for **collections** and `reduce()` for **aggregations**.

---

## **5. FAQs**  

### **Q1: When should I use `collect()` vs `reduce()`?**  
- Use `collect()` when you need to **accumulate results into a collection** (List, Set, Map).  
- Use `reduce()` when you need to **aggregate values** (sum, max, min).  

### **Q2: Is `reduce()` faster than a traditional loop?**  
Not always! For **simple summation**, a `for` loop might be **faster** due to reduced overhead.  

### **Q3: Can I use `parallelStream()` with `collect()` and `reduce()`?**  
Yes! But ensure the operation is **thread-safe** when using `parallelStream()`.  

---

## **6. Additional Resources**  

- [Java Collectors Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)  
- [Java Reduction Operations](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce--)  

---

## **7. Hands-On Practice**  

📂 **[Click here](./collectors-reduction-practice)** to access hands-on coding exercises on Collectors and Reduction.  

---

### **Conclusion**  
With **Collectors** and **Reduction**, you can efficiently process large datasets using Java Streams. 🚀 Keep practicing and mastering these concepts for writing clean and optimized Java code! 🎯