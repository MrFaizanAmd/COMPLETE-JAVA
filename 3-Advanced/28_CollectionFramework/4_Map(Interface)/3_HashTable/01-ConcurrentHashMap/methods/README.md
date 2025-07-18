# 📌 **Java ConcurrentHashMap – A Complete Reference Guide**  

## 🔥 **Introduction**  
`ConcurrentHashMap<K, V>` is a **thread-safe** implementation of `Map` in Java.  
Unlike `HashMap`, it **supports concurrent operations** without external synchronization.  
It is highly efficient for **multi-threaded applications**.

This guide covers **all methods**, **time complexity analysis**, and **examples**.

---

## 🏗 **Class Hierarchy**
```plaintext
Iterable
│
├── Collection
│   ├── Map
│   │   ├── ConcurrentMap
│   │   │   ├── ConcurrentHashMap
```
- **Implements `ConcurrentMap<K, V>`, `Map<K, V>`, and `Serializable`**.
- Uses **Segmented Locking** for high concurrency.
- **No null keys or null values allowed**.

---

## 📌 **Method Table (With Time Complexity)**  

| Method | Description | Time Complexity |
|--------|------------|-----------------|
| `V put(K key, V value)` | Inserts or updates a key-value pair | **O(1)** (Amortized) |
| `V get(Object key)` | Retrieves value for the given key | **O(1)** |
| `V remove(Object key)` | Removes a key-value pair | **O(1)** |
| `boolean containsKey(Object key)` | Checks if a key exists | **O(1)** |
| `boolean containsValue(Object value)` | Checks if a value exists | **O(n)** |
| `int size()` | Returns the number of key-value pairs | **O(n)** (May not be exact in concurrent environments) |
| `boolean isEmpty()` | Checks if the map is empty | **O(1)** |
| `void clear()` | Removes all key-value pairs | **O(n)** |
| `V putIfAbsent(K key, V value)` | Adds key-value pair only if key is absent | **O(1)** |
| `boolean remove(Object key, Object value)` | Removes key only if it matches value | **O(1)** |
| `boolean replace(K key, V oldValue, V newValue)` | Replaces value only if old value matches | **O(1)** |
| `V replace(K key, V value)` | Replaces value for a key | **O(1)** |
| `Set<K> keySet()` | Returns a `Set` of all keys | **O(n)** |
| `Collection<V> values()` | Returns a `Collection` of all values | **O(n)** |
| `Set<Map.Entry<K,V>> entrySet()` | Returns a `Set` of all key-value pairs | **O(n)** |
| `void putAll(Map<? extends K, ? extends V> m)` | Copies all mappings from another map | **O(n)** |
| `boolean equals(Object o)` | Compares the map with another object | **O(n)** |
| `int hashCode()` | Returns the hash code of the map | **O(n)** |
| `long mappingCount()` | Returns approximate count of elements | **O(1)** |
| `V compute(K key, BiFunction<K, V, V> remappingFunction)` | Computes a new value for a key | **O(1) - O(n)** |
| `V computeIfAbsent(K key, Function<K, V> mappingFunction)` | Computes value if key is missing | **O(1) - O(n)** |
| `V computeIfPresent(K key, BiFunction<K, V, V> remappingFunction)` | Computes new value if key exists | **O(1) - O(n)** |
| `void forEach(long parallelismThreshold, BiConsumer<K, V> action)` | Applies function in parallel | **O(n)** |
| `V merge(K key, V value, BiFunction<V, V, V> remappingFunction)` | Merges values for a key | **O(1) - O(n)** |

---

## ⭐ **Key Methods With Examples**  

### ✅ **1. put() - Add Elements to ConcurrentHashMap**
```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);  // Output: {1=One, 2=Two, 3=Three}
    }
}
```
🔹 **Thread-safe and allows concurrent updates.**  
🔹 **Does not allow `null` keys or `null` values.**

---

### ✅ **2. get() - Retrieve Value by Key**
```java
System.out.println(map.get(2)); // Output: Two
```

---

### ✅ **3. remove() - Remove a Key-Value Pair**
```java
map.remove(2);
System.out.println(map); // Output: {1=One, 3=Three}
```

---

### ✅ **4. putIfAbsent() - Add Only if Key is Missing**
```java
map.putIfAbsent(3, "Three Updated");
System.out.println(map.get(3)); // Output: Three (No update since key exists)
```

---

### ✅ **5. replace() - Update Value if Key Exists**
```java
map.replace(3, "Three Updated");
System.out.println(map.get(3)); // Output: Three Updated
```

---

### ✅ **6. computeIfAbsent() - Compute Value if Key is Missing**
```java
map.computeIfAbsent(4, key -> "Four");
System.out.println(map.get(4)); // Output: Four
```

---

### ✅ **7. computeIfPresent() - Compute Value if Key Exists**
```java
map.computeIfPresent(4, (key, value) -> value + " Updated");
System.out.println(map.get(4)); // Output: Four Updated
```

---

### ✅ **8. merge() - Merge Values for a Key**
```java
map.merge(1, "ONE", (oldVal, newVal) -> oldVal + "-" + newVal);
System.out.println(map.get(1)); // Output: One-ONE
```

---

### ✅ **9. forEach() - Apply Function to All Entries**
```java
map.forEach(1, (key, value) -> System.out.println(key + " = " + value));
```

---

## 🔥 **Key Differences: ConcurrentHashMap vs. HashMap vs. SynchronizedMap**  

| Feature | HashMap | ConcurrentHashMap | Collections.synchronizedMap() |
|---------|--------|------------------|---------------------------|
| Thread-Safe | ❌ No | ✅ Yes | ✅ Yes |
| Performance | ✅ Fast (Single Thread) | ⚡ Very Fast (Multi-Thread) | 🚀 Slower |
| Synchronization | ❌ None | 🔒 **Fine-grained (Segmented Locks)** | 🔒 **Full Lock on Map** |
| Null Keys | ✅ Allowed | ❌ Not Allowed | ✅ Allowed |
| Null Values | ✅ Allowed | ❌ Not Allowed | ✅ Allowed |

---

## 📌 **Summary**
1. `ConcurrentHashMap` is **thread-safe** and **highly efficient**.
2. **O(1) performance** for insert, delete, search.
3. **Does not allow `null` keys or `null` values**.
4. Uses **segmented locking** instead of synchronizing the whole map.
5. **Useful for multi-threaded applications** where high concurrency is required.

---

## ❓ **FAQs**
1️⃣ **Why use ConcurrentHashMap instead of HashMap?**  
   - **Thread-safety** without performance bottlenecks.

2️⃣ **Can ConcurrentHashMap store `null` keys or values?**  
   - ❌ No, it **throws `NullPointerException`**.

3️⃣ **Is ConcurrentHashMap faster than Synchronized HashMap?**  
   - ✅ Yes, because it **does not lock the entire map**.

---

🚀 **Happy Coding!** 🎯