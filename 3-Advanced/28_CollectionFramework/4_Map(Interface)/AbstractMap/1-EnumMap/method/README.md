Here’s a **complete method guide for `EnumMap`**, covering **all methods**, their **time complexities**, and **examples**.  

---

# 📌 **Java `EnumMap` – Method Guide**  

## 🔥 **Introduction**  
`EnumMap<K, V>` is a specialized `Map` implementation designed **exclusively for enum keys**. It is highly efficient compared to other `Map` implementations.  

### ✅ **Key Features**
- **Optimized for Enums** (uses an internal array for performance).
- **Maintains natural enum order** (based on declaration).
- **Faster than `HashMap<Enum, V>`** (O(1) lookup time).
- **Does not allow `null` keys** but allows `null` values.  

---

## 🏗 **Creating an `EnumMap`**
```java
import java.util.EnumMap;
import java.util.Map;

enum Day { MONDAY, TUESDAY, WEDNESDAY }

public class EnumMapExample {
    public static void main(String[] args) {
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);
        schedule.put(Day.MONDAY, "Gym");
        schedule.put(Day.TUESDAY, "Work");
        schedule.put(Day.WEDNESDAY, "Rest");

        System.out.println(schedule); // Output: {MONDAY=Gym, TUESDAY=Work, WEDNESDAY=Rest}
    }
}
```

---

## 📌 **Method Table (With Time Complexity & Examples)**  

| Method | Description | Time Complexity | Example |
|--------|------------|-----------------|---------|
| `V put(K key, V value)` | Inserts a key-value pair | **O(1)** | `map.put(Day.MONDAY, "Meeting")` |
| `V get(Object key)` | Retrieves value by key | **O(1)** | `map.get(Day.MONDAY)` |
| `V remove(Object key)` | Removes a key-value pair | **O(1)** | `map.remove(Day.TUESDAY)` |
| `boolean containsKey(Object key)` | Checks if key exists | **O(1)** | `map.containsKey(Day.WEDNESDAY)` |
| `boolean containsValue(Object value)` | Checks if value exists | **O(n)** | `map.containsValue("Rest")` |
| `Set<K> keySet()` | Returns a set of all keys | **O(1)** | `Set<Day> keys = map.keySet()` |
| `Collection<V> values()` | Returns a collection of values | **O(n)** | `Collection<String> values = map.values()` |
| `Set<Map.Entry<K,V>> entrySet()` | Returns a set of key-value entries | **O(1)** | `Set<Map.Entry<K, V>> entries = map.entrySet()` |
| `void putAll(Map<? extends K,? extends V> m)` | Copies all mappings from another map | **O(n)** | `map.putAll(otherMap)` |
| `void clear()` | Removes all entries from the map | **O(n)** | `map.clear()` |
| `int size()` | Returns the number of entries | **O(1)** | `map.size()` |
| `boolean isEmpty()` | Checks if the map is empty | **O(1)** | `map.isEmpty()` |
| `void forEach(BiConsumer<K, V>)` | Iterates through the map | **O(n)** | `map.forEach((k, v) -> System.out.println(k + "=" + v))` |

---

## ⭐ **Key Methods with Examples**

### 1️⃣ **`put()` & `get()` - Insert and Retrieve Values**
```java
import java.util.EnumMap;

enum Status { ACTIVE, INACTIVE, PENDING }

public class PutGetExample {
    public static void main(String[] args) {
        EnumMap<Status, String> map = new EnumMap<>(Status.class);
        map.put(Status.ACTIVE, "User is active");
        map.put(Status.INACTIVE, "User is inactive");

        System.out.println(map.get(Status.ACTIVE)); // Output: User is active
    }
}
```

---

### 2️⃣ **`containsKey()` - Check if Key Exists**
```java
import java.util.EnumMap;

enum Status { NEW, PROCESSING, COMPLETED }

public class ContainsKeyExample {
    public static void main(String[] args) {
        EnumMap<Status, String> map = new EnumMap<>(Status.class);
        map.put(Status.NEW, "Order received");

        System.out.println(map.containsKey(Status.NEW)); // Output: true
        System.out.println(map.containsKey(Status.COMPLETED)); // Output: false
    }
}
```

---

### 3️⃣ **`remove()` - Remove an Entry**
```java
import java.util.EnumMap;

enum Priority { HIGH, MEDIUM, LOW }

public class RemoveExample {
    public static void main(String[] args) {
        EnumMap<Priority, String> map = new EnumMap<>(Priority.class);
        map.put(Priority.HIGH, "Critical task");
        map.remove(Priority.HIGH);

        System.out.println(map); // Output: {}
    }
}
```

---

### 4️⃣ **`size()` - Get Map Size**
```java
import java.util.EnumMap;

enum Level { BEGINNER, INTERMEDIATE, ADVANCED }

public class SizeExample {
    public static void main(String[] args) {
        EnumMap<Level, String> map = new EnumMap<>(Level.class);
        map.put(Level.BEGINNER, "Basic lessons");

        System.out.println(map.size()); // Output: 1
    }
}
```

---

### 5️⃣ **`keySet()` - Retrieve All Keys**
```java
import java.util.EnumMap;
import java.util.Set;

enum Month { JAN, FEB, MAR }

public class KeySetExample {
    public static void main(String[] args) {
        EnumMap<Month, String> map = new EnumMap<>(Month.class);
        map.put(Month.JAN, "Winter");

        Set<Month> keys = map.keySet();
        System.out.println(keys); // Output: [JAN]
    }
}
```

---

### 6️⃣ **`values()` - Retrieve All Values**
```java
import java.util.EnumMap;
import java.util.Collection;

enum Fruit { APPLE, BANANA, CHERRY }

public class ValuesExample {
    public static void main(String[] args) {
        EnumMap<Fruit, String> map = new EnumMap<>(Fruit.class);
        map.put(Fruit.APPLE, "Red");

        Collection<String> values = map.values();
        System.out.println(values); // Output: [Red]
    }
}
```

---

### 7️⃣ **`entrySet()` - Retrieve All Entries**
```java
import java.util.EnumMap;
import java.util.Set;

enum Color { RED, BLUE, GREEN }

public class EntrySetExample {
    public static void main(String[] args) {
        EnumMap<Color, String> map = new EnumMap<>(Color.class);
        map.put(Color.RED, "Hot");
        map.put(Color.BLUE, "Cold");

        Set<Map.Entry<Color, String>> entries = map.entrySet();
        for (Map.Entry<Color, String> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

---

### 8️⃣ **`forEach()` - Iterate Over Map**
```java
import java.util.EnumMap;

enum Size { SMALL, MEDIUM, LARGE }

public class ForEachExample {
    public static void main(String[] args) {
        EnumMap<Size, String> map = new EnumMap<>(Size.class);
        map.put(Size.SMALL, "Compact");
        map.put(Size.LARGE, "Spacious");

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
```

---

## 🔥 **Summary**
- `EnumMap` is **optimized for enum keys**, making it faster than `HashMap<Enum, V>`.
- **Keys must be enums**, and values can be `null`.
- Uses **internal array representation**, ensuring **constant-time performance** for most operations.
- **Maintains the natural order of enum keys**.
- **Not thread-safe**, so use `Collections.synchronizedMap()` if needed.

---

## 📚 **Additional Resources**
- [Official Java Docs - EnumMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/EnumMap.html)

🚀 **Happy Coding!** 🎯