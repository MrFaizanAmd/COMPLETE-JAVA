# **Immutable Maps in Java - A Complete Guide** 🚀  

## **Introduction**  

In Java, a **Map** is a collection of key-value pairs, but by default, it is **mutable**, meaning you can modify it after creation. However, sometimes you need a **read-only (immutable) Map** to ensure data integrity and avoid accidental modifications.  

An **immutable Map** is a Map that **cannot be modified** after it is created—no adding, removing, or updating elements. Java provides multiple ways to create immutable Maps, and starting from **Java 9**, it has built-in support for immutable collections.  

---

## **Why Use an Immutable Map?**  

✅ **Thread-Safety** – Immutable Maps can be safely shared across multiple threads.  
✅ **Data Integrity** – Prevents unintended modifications to critical data.  
✅ **Memory Optimization** – Reduces memory overhead by avoiding unnecessary modifications.  
✅ **Better Performance** – No need for synchronization, making it efficient in concurrent applications.  

---

## **Ways to Create an Immutable Map in Java**  

### **1. Using `Collections.unmodifiableMap()` (Java 5+)**  

The **`Collections.unmodifiableMap()`** method wraps a mutable `Map` and **prevents modifications**.  

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> mutableMap = new HashMap<>();
        mutableMap.put("Apple", 1);
        mutableMap.put("Banana", 2);
        mutableMap.put("Cherry", 3);

        Map<String, Integer> immutableMap = Collections.unmodifiableMap(mutableMap);

        System.out.println(immutableMap);

        // Attempting to modify the map will throw UnsupportedOperationException
        immutableMap.put("Date", 4); // Throws exception!
    }
}
```

❌ **Limitation:** The original `mutableMap` is still modifiable, and changes in `mutableMap` reflect in `immutableMap`!  

---

### **2. Using `Map.of()` (Java 9+)**  

Java 9 introduced **`Map.of()`**, which creates a truly **immutable Map**.  

```java
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> immutableMap = Map.of(
            "Apple", 1, 
            "Banana", 2, 
            "Cherry", 3
        );

        System.out.println(immutableMap);

        // immutableMap.put("Date", 4); // Throws UnsupportedOperationException
    }
}
```

✅ **Truly Immutable** – No modifications allowed, and no dependency on a backing mutable Map.  
✅ **Concise and Readable** – Best for small, fixed-size Maps.  
❌ **Limit of 10 Entries** – If you need more, use `Map.ofEntries()`.  

---

### **3. Using `Map.ofEntries()` (Java 9+)**  

If you need an immutable Map with **more than 10 elements**, use **`Map.ofEntries()`**:  

```java
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> largeImmutableMap = Map.ofEntries(
            Map.entry("Apple", 1),
            Map.entry("Banana", 2),
            Map.entry("Cherry", 3),
            Map.entry("Date", 4),
            Map.entry("Elderberry", 5)
        );

        System.out.println(largeImmutableMap);

        // largeImmutableMap.put("Fig", 6); // Throws UnsupportedOperationException
    }
}
```

✅ **Supports Large Maps** – No 10-entry limit.  
✅ **More Readable than `Map.of()` for Large Maps**.  

---

### **4. Using `Collectors.toUnmodifiableMap()` (Java 10+)**  

Java 10 introduced **`Collectors.toUnmodifiableMap()`**, which allows you to create an immutable Map from a Stream.  

```java
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnmodifiableMapStreamExample {
    public static void main(String[] args) {
        Map<String, Integer> immutableMap = Stream.of(
            Map.entry("Apple", 1),
            Map.entry("Banana", 2),
            Map.entry("Cherry", 3)
        ).collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(immutableMap);

        // immutableMap.put("Date", 4); // Throws UnsupportedOperationException
    }
}
```

✅ **Great for Transforming Data** from Streams into an immutable Map.  
✅ **Works Dynamically** – Unlike `Map.of()`, which requires manual entry.  

---

## **Comparison of Different Methods**  

| **Method** | **Introduced In** | **Truly Immutable?** | **Allows More than 10 Elements?** | **Backed by Mutable Map?** |
|-----------|-----------------|----------------|----------------|----------------|
| `Collections.unmodifiableMap()` | Java 5 | ❌ (If original map is modified, it changes) | ✅ | ✅ |
| `Map.of()` | Java 9 | ✅ | ❌ (Limited to 10 elements) | ❌ |
| `Map.ofEntries()` | Java 9 | ✅ | ✅ | ❌ |
| `Collectors.toUnmodifiableMap()` | Java 10 | ✅ | ✅ | ❌ |

---

## **FAQs About Immutable Maps**  

### **Q1: Can I modify an immutable Map?**  
No, any attempt to add, remove, or update an immutable Map will throw `UnsupportedOperationException`.  

### **Q2: What happens if I modify the original Map in `Collections.unmodifiableMap()`?**  
The changes **will reflect** in the "immutable" Map, because it is only a wrapper around the original Map.  

### **Q3: Which method should I use for creating an immutable Map?**  
- **For small fixed-size Maps** → Use `Map.of()`.  
- **For large Maps** → Use `Map.ofEntries()`.  
- **For Streams** → Use `Collectors.toUnmodifiableMap()`.  
- **If you already have a mutable Map and want to prevent modifications** → Use `Collections.unmodifiableMap()`.  

### **Q4: Are Immutable Maps thread-safe?**  
Yes, immutable Maps are **thread-safe**, as they cannot be modified once created.  

---

## **Conclusion**  

🔹 Immutable Maps **prevent accidental modifications** and are **thread-safe**.  
🔹 Java **9+ provides built-in support** (`Map.of()`, `Map.ofEntries()`).  
🔹 Use **`Collectors.toUnmodifiableMap()`** for **dynamic Map creation**.  
🔹 Avoid `Collections.unmodifiableMap()` unless necessary, as it does not provide true immutability.  

By using immutable Maps, you can write **safer, more predictable, and thread-safe** Java code! 🚀  

---

## **Hands-On Practice**  

📂 **[Click here](./immutable-map-practice)** to access coding exercises for Immutable Maps in Java.  

---

### **Further Reading**  

📖 [Java 9 Immutable Collections Documentation](https://docs.oracle.com/javase/9/docs/api/java/util/Map.html)  
📚 [Java 10 `Collectors.toUnmodifiableMap()`](https://docs.oracle.com/javase/10/docs/api/java/util/stream/Collectors.html#toUnmodifiableMap)  