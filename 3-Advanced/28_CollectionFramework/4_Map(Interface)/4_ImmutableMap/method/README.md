

# 📌 **Java Immutable Map – Method Guide**

## 🔥 **Introduction**
An **Immutable Map** in Java is a `Map` whose contents **cannot be modified** after creation. Java provides several ways to create immutable maps using:

- `Collections.unmodifiableMap()`
- `Map.of()`
- `Map.copyOf()`
- `ImmutableMap` from Guava



## 📌 **Method Table (With Time Complexity & Examples)**  

| Method | Description | Time Complexity | Example |
|--------|------------|-----------------|---------|
| `get(Object key)` | Retrieves value by key | **O(1)** | `map.get("A")` |
| `containsKey(Object key)` | Checks if key exists | **O(1)** | `map.containsKey("A")` |
| `containsValue(Object value)` | Checks if value exists | **O(n)** | `map.containsValue("Apple")` |
| `size()` | Returns number of key-value pairs | **O(1)** | `map.size()` |
| `isEmpty()` | Checks if map is empty | **O(1)** | `map.isEmpty()` |
| `keySet()` | Returns a Set of all keys | **O(1)** | `Set<K> keys = map.keySet()` |
| `values()` | Returns a Collection of values | **O(n)** | `Collection<V> values = map.values()` |
| `entrySet()` | Returns a Set of key-value entries | **O(1)** | `Set<Map.Entry<K, V>> entries = map.entrySet()` |
| `forEach(BiConsumer<K, V>)` | Iterates through the map | **O(n)** | `map.forEach((k, v) -> System.out.println(k + "=" + v))` |

---

## ⭐ **Key Methods with Examples**

### 1️⃣ **`get(Object key)` - Retrieve Value**
```java
import java.util.Map;

public class GetExample {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("Java", "Language", "Python", "Scripting");
        System.out.println(map.get("Java")); // Output: Language
    }
}
```

---

### 2️⃣ **`containsKey(Object key)` - Check if Key Exists**
```java
import java.util.Map;

public class ContainsKeyExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("One", 1, "Two", 2);
        System.out.println(map.containsKey("One")); // Output: true
    }
}
```

---

### 3️⃣ **`containsValue(Object value)` - Check if Value Exists**
```java
import java.util.Map;

public class ContainsValueExample {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("A", "Apple", "B", "Banana");
        System.out.println(map.containsValue("Apple")); // Output: true
    }
}
```

---

### 4️⃣ **`size()` - Get Map Size**
```java
import java.util.Map;

public class SizeExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("X", 10, "Y", 20);
        System.out.println(map.size()); // Output: 2
    }
}
```

---

### 5️⃣ **`keySet()` - Retrieve All Keys**
```java
import java.util.Map;
import java.util.Set;

public class KeySetExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("One", 1, "Two", 2);
        Set<String> keys = map.keySet();
        System.out.println(keys); // Output: [One, Two]
    }
}
```

---

### 6️⃣ **`values()` - Retrieve All Values**
```java
import java.util.Map;
import java.util.Collection;

public class ValuesExample {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("Java", "OOP", "Python", "Scripting");
        Collection<String> values = map.values();
        System.out.println(values); // Output: [OOP, Scripting]
    }
}
```

---

### 7️⃣ **`entrySet()` - Retrieve All Key-Value Pairs**
```java
import java.util.Map;
import java.util.Set;

public class EntrySetExample {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("One", 1, "Two", 2);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

---

### 8️⃣ **`forEach()` - Iterate Over Map**
```java
import java.util.Map;

public class ForEachExample {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("A", "Apple", "B", "Banana");

        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
```

---

## 🔥 **Summary**
- **Immutable Maps** are unmodifiable after creation.
- Use **`Map.of()`**, **`Map.copyOf()`**, or **`Collections.unmodifiableMap()`** to create immutable maps.
- **Efficient read operations (`O(1)`)**, but modification methods (`put()`, `remove()`) **throw `UnsupportedOperationException`**.
- Ideal for **constants, configurations, and thread-safe usage**.

---

## 📚 **Additional Resources**
- [Official Java Docs - Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)

🚀 **Happy Coding!** 🎯