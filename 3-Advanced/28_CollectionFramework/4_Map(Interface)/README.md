

# **📌 Java `Map` Interface - A Complete Guide**  

## 🔹 **Introduction**  
The `Map` interface in Java is a part of the **Java Collections Framework** and is used to store key-value pairs. Unlike collections such as `List` and `Set`, a `Map` **does not allow duplicate keys** but allows duplicate values.  

### 🛠 **Key Features of Map Interface**  
✔ Stores **key-value pairs** (like a dictionary).  
✔ **No duplicate keys** allowed; values can be duplicated.  
✔ **Efficient retrieval** of values based on keys.  
✔ Supports **various implementations** with different performance characteristics.  

---

## 🔹 **Hierarchy of `Map` in Java**  

```
├── Map [Interface]
│   ├── HashMap
│   │   ├── LinkedHashMap
│   │   ├── IdentityHashMap
│   │   ├── WeakHashMap
│   │
│   ├── SortedMap [Interface]
│   │   └── NavigableMap [Interface]
│   │       ├── TreeMap
│   │       ├── ConcurrentSkipListMap
│   │       └── ConcurrentNavigableMap [Interface]
│   │           └── ConcurrentSkipListMap
│   │
│   ├── Hashtable
│   │   ├── ConcurrentHashMap
│   │   └── Properties
│   │
│   ├── AbstractMap
│   │   ├── EnumMap
```

---

## 🔹 **Key Implementations & When to Use Them**  

| Implementation | Ordered? | Synchronized? | Null Keys? | Null Values? | Use Case |
|--------------|------------|--------------|------------|------------|------------|
| `HashMap` | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Fastest lookup, general-purpose use |
| `LinkedHashMap` | ✅ Yes (Insertion Order) | ❌ No | ✅ Yes | ✅ Yes | Maintain order of insertion |
| `IdentityHashMap` | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Uses reference equality (`==`) instead of `.equals()` |
| `WeakHashMap` | ❌ No | ❌ No | ✅ Yes | ✅ Yes | Automatically removes entries if keys are garbage collected |
| `TreeMap` | ✅ Yes (Sorted) | ❌ No | ❌ No | ✅ Yes | Sorted key-value storage |
| `ConcurrentHashMap` | ❌ No | ✅ Yes | ❌ No | ✅ Yes | Thread-safe, high performance in multi-threaded applications |
| `Hashtable` | ❌ No | ✅ Yes | ❌ No | ❌ No | Legacy thread-safe map, replaced by `ConcurrentHashMap` |

---

## 🔹 **Basic Methods of `Map` Interface**  

| Method | Description |
|--------|------------|
| `put(K key, V value)` | Adds a key-value pair to the map |
| `get(Object key)` | Retrieves the value associated with the key |
| `remove(Object key)` | Removes a key-value pair |
| `containsKey(Object key)` | Checks if the key exists in the map |
| `containsValue(Object value)` | Checks if the value exists in the map |
| `size()` | Returns the number of key-value pairs |
| `isEmpty()` | Checks if the map is empty |
| `keySet()` | Returns a `Set` of all keys |
| `values()` | Returns a `Collection` of all values |
| `entrySet()` | Returns a `Set` of all key-value pairs |

---

## 🔹 **Example: Using `Map` in Java**  

### ✅ **Basic Usage of `HashMap`**  

```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> scores = new HashMap<>();

        // Adding key-value pairs
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 88);

        // Retrieving a value
        System.out.println("Bob's Score: " + scores.get("Bob"));

        // Checking if a key exists
        if (scores.containsKey("Alice")) {
            System.out.println("Alice's score exists.");
        }

        // Iterating through the map
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Removing a key-value pair
        scores.remove("Charlie");
    }
}
```

---

## 🔹 **Frequently Asked Questions (FAQs)**  

### ❓ **Q1: Can `Map` contain duplicate keys?**  
🚀 **No.** Each key must be unique, but values can be duplicated.  

### ❓ **Q2: How is `HashMap` different from `TreeMap`?**  
📌 `HashMap` is **unordered** and offers fast lookups, while `TreeMap` maintains a **sorted order** of keys but is slower.  

### ❓ **Q3: Why is `Hashtable` not recommended for new projects?**  
✅ Because `ConcurrentHashMap` provides better performance and scalability for multithreading.  

### ❓ **Q4: Can we store `null` keys in a `TreeMap`?**  
❌ **No.** `TreeMap` does not allow `null` keys because it uses comparisons to sort keys.  

---

## 🔹 **When to Use `Map` Implementations?**  

| Scenario | Best Choice |
|------------|------------|
| Fast lookups, unordered storage | `HashMap` |
| Maintain insertion order | `LinkedHashMap` |
| Sorted storage | `TreeMap` |
| Thread-safe access | `ConcurrentHashMap` |
| Weak reference keys (auto GC cleanup) | `WeakHashMap` |

---

## 🔹 **Further Learning & References**  

🔗 **Java Official Documentation:** [Map Interface](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)  
🔗 **Oracle Java Collections Guide:** [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)  

---

## 📂 **Hands-on Practice**  

📌 You can find hands-on practice problems and example implementations in the **[Map Implementations](./Map_Implementations)** folder.  

---

# 🚀 **Conclusion**  
The `Map` interface is a **powerful and essential** data structure in Java that provides efficient key-value storage. Understanding its various implementations helps in **choosing the right map** based on performance and use case needs.  

This guide covered:  
✅ **Hierarchy of `Map` in Java**  
✅ **Differences between implementations**  
✅ **When to use each type of map**  
✅ **Code examples & best practices**  

Keep practicing, and soon you'll master Java Maps like a pro! 🚀🔥  

---
