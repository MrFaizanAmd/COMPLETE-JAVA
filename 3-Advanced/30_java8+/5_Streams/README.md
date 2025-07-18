# Java Streams - A Complete Guide  

## Introduction  

In modern Java development, handling collections of data efficiently is a common requirement. The **Streams API** in Java provides a powerful way to process collections of data using functional-style programming. It simplifies operations like filtering, mapping, and reducing data, making the code more readable and maintainable.  

### Why Use Streams?  

Before Java 8, processing collections required **explicit loops** and **conditional statements**, which led to verbose and repetitive code. Streams allow us to:  

✅ **Write concise and readable code**  
✅ **Process data in parallel for better performance**  
✅ **Use functional programming paradigms (e.g., lambda expressions)**  

Think of Streams like an **assembly line in a factory**: raw materials (data) enter at one end, undergo multiple transformations (operations), and finally emerge as a refined product (result).  

---

## 1. What is a Stream?  

A **Stream** is a sequence of data elements supporting **functional-style operations**. It does **not store data** but rather processes it **on demand**.  

**Key Characteristics:**  
- **Does not modify the original data** (immutable)  
- **Processes elements lazily** (only when needed)  
- **Supports both sequential and parallel execution**  

**Example (Without Streams)**:  
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Filtering names starting with 'A' (Traditional way)
List<String> filteredNames = new ArrayList<>();
for (String name : names) {
    if (name.startsWith("A")) {
        filteredNames.add(name);
    }
}
System.out.println(filteredNames); // Output: [Alice]
```

**Example (Using Streams)**:  
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Filtering names starting with 'A' (Using Streams)
List<String> filteredNames = names.stream()
                                  .filter(name -> name.startsWith("A"))
                                  .collect(Collectors.toList());

System.out.println(filteredNames); // Output: [Alice]
```

---

## 2. How to Create a Stream  

### 2.1 From a Collection  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = numbers.stream();
```

### 2.2 From an Array  
```java
String[] names = {"Alice", "Bob", "Charlie"};
Stream<String> nameStream = Arrays.stream(names);
```

### 2.3 Using `Stream.of()`  
```java
Stream<String> stream = Stream.of("Apple", "Banana", "Cherry");
```

### 2.4 Infinite Streams (Generated on Demand)  
```java
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2); // 0, 2, 4, 6...
```

---

## 3. Stream Operations  

Streams have two types of operations:  
- **Intermediate Operations**: Return another stream (e.g., `filter`, `map`, `sorted`)  
- **Terminal Operations**: Produce a result (e.g., `collect`, `forEach`, `count`)  

### 3.1 Intermediate Operations  

#### `map()` – Transform Each Element  
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<Integer> nameLengths = names.stream()
                                 .map(String::length)
                                 .collect(Collectors.toList());

System.out.println(nameLengths); // Output: [5, 3, 7]
```

#### `filter()` – Keep Matching Elements  
```java
List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());

System.out.println(evenNumbers); // Output: [10, 20, 30]
```

#### `sorted()` – Sort Elements  
```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

List<String> sortedNames = names.stream()
                                .sorted()
                                .collect(Collectors.toList());

System.out.println(sortedNames); // Output: [Alice, Bob, Charlie]
```

### 3.2 Terminal Operations  

#### `collect()` – Convert Stream to a Collection  
```java
List<String> uppercaseNames = names.stream()
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());
System.out.println(uppercaseNames); // Output: [ALICE, BOB, CHARLIE]
```

#### `forEach()` – Perform an Action  
```java
names.stream().forEach(System.out::println);
```

#### `count()` – Count Elements  
```java
long count = names.stream().filter(n -> n.length() > 3).count();
System.out.println(count); // Output: 2
```

#### `reduce()` – Aggregate Elements  
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream().reduce(0, Integer::sum);
System.out.println(sum); // Output: 15
```

---

## 4. Parallel Streams  

For large datasets, parallel processing improves performance.  

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

int sum = numbers.parallelStream()
                 .reduce(0, Integer::sum);

System.out.println(sum); // Output: 36
```

💡 **Note:** Parallel streams work best when operations are independent and can be executed in parallel safely.

---

## 5. Common Pitfalls & Best Practices  

### 🚨 Avoid modifying state inside a Stream  
❌ Bad Example (Modifies external variable):  
```java
int sum = 0;
numbers.stream().forEach(n -> sum += n); // Incorrect usage
```
✅ Correct Approach:  
```java
int sum = numbers.stream().reduce(0, Integer::sum);
```

### 🚨 Use Streams for transformations, not for side-effects  
❌ Bad Example:  
```java
names.stream().forEach(name -> System.out.println(name.toUpperCase()));
```
✅ Correct Approach:  
```java
List<String> uppercaseNames = names.stream()
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());
```

---

## 6. Frequently Asked Questions (FAQs)  

### Q1: Are Streams faster than loops?  
✔️ **Not always**. Streams improve readability, but for small data sets, traditional loops can be faster due to lower overhead.  

### Q2: Can a Stream be reused?  
❌ No. Streams are **consumed** once and cannot be reused. You must create a new Stream.  

### Q3: When should I use parallel streams?  
✔️ When processing **large datasets** where parallel execution can **significantly** improve performance. Avoid parallel streams for small lists, as the overhead might reduce efficiency.  

---

## 7. Additional Resources  

- [Java Streams API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)  
- [Oracle Java Tutorials - Streams](https://docs.oracle.com/javase/tutorial/collections/streams/)  

---

## 8. Hands-On Practice  

📂 **[Click here](./streams-practice)** to access hands-on coding exercises on Streams.  

---

With this guide, you should have a solid understanding of Java Streams! 🚀 Keep practicing and happy coding! 🎯