# 📌 **Java WeakHashMap – A Complete Reference Guide**  

## 🔥 **Introduction**  
`WeakHashMap<K, V>` is a special implementation of `Map<K, V>` where **keys are stored as weak references**. This means that **when a key is no longer referenced elsewhere, the entry is automatically removed** by the garbage collector.  

This makes `WeakHashMap` useful for **caching and memory-sensitive applications**.  

This guide covers **all methods**, **time complexity analysis**, and examples.

---

## 🏗 **Class Hierarchy**
```plaintext
Iterable
│
├── Collection
│   ├── Map
│   │   ├── AbstractMap
│   │   │   ├── WeakHashMap
```
- **`WeakHashMap<K, V>` extends `AbstractMap<K, V>`**.
- It does **not guarantee ordering**.
- It is **not synchronized**.

---

## 📌 **Method Table (With Time Complexity)**  

| Method | Description | Time Complexity (Average) | Time Complexity (Worst) |
|--------|------------|-------------------------|--------------------------|
| `V put(K key, V value)` | Inserts or updates a key-value pair (key stored as weak reference) | **O(1)** | **O(n) (resize needed)** |
| `V get(Object key)` | Retrieves value for the given key | **O(1)** | **O(1)** |
| `V remove(Object key)` | Removes the key-value pair | **O(1)** | **O(1)** |
| `boolean containsKey(Object key)` | Checks if a key exists | **O(1)** | **O(1)** |
| `boolean containsValue(Object value)` | Checks if a value exists | **O(n)** | **O(n)** |
| `int size()` | Returns the number of key-value pairs | **O(1)** | **O(1)** |
| `boolean isEmpty()` | Checks if the map is empty | **O(1)** | **O(1)** |
| `void clear()` | Removes all key-value pairs | **O(n)** | **O(n)** |
| `Set<K> keySet()` | Returns a `Set` of all keys | **O(1)** | **O(n)** (iteration) |
| `Collection<V> values()` | Returns a `Collection` of all values | **O(1)** | **O(n)** (iteration) |
| `Set<Map.Entry<K,V>> entrySet()` | Returns a `Set` of all key-value pairs | **O(1)** | **O(n)** (iteration) |
| `V putIfAbsent(K key, V value)` | Adds key-value pair only if key is absent | **O(1)** | **O(1)** |
| `V replace(K key, V value)` | Replaces a value for a given key | **O(1)** | **O(1)** |
| `boolean replace(K key, V oldValue, V newValue)` | Replaces value only if old value matches | **O(1)** | **O(1)** |
| `void putAll(Map<? extends K, ? extends V> m)` | Copies all mappings from another map | **O(n)** | **O(n)** |
| `boolean equals(Object o)` | Compares the map with another object | **O(n)** | **O(n)** |
| `int hashCode()` | Returns the hash code of the map | **O(n)** | **O(n)** |
| `V getOrDefault(Object key, V defaultValue)` | Returns value or default if key not found | **O(1)** | **O(1)** |
| `void forEach(BiConsumer<? super K, ? super V> action)` | Performs an action for each entry | **O(n)** | **O(n)** |
| `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes a new value for a key | **O(1)** | **O(1)** |
| `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)` | Computes a value only if the key is absent | **O(1)** | **O(1)** |
| `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes a value only if key is present | **O(1)** | **O(1)** |
| `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)` | Merges a key-value pair | **O(1)** | **O(1)** |

---

## ⭐ **Key Methods With Examples**  

### ✅ **1. put() - Add Elements to WeakHashMap**
```java
import java.util.WeakHashMap;
import java.util.Map;

public class WeakHashMapExample {
    public static void main(String[] args) {
        Map<Object, String> map = new WeakHashMap<>();
        Object key1 = new Object();
        Object key2 = new Object();

        map.put(key1, "Value1");
        map.put(key2, "Value2");

        System.out.println("Before GC: " + map);

        key1 = null;  // Dereferencing the key
        System.gc();  // Requesting garbage collection

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("After GC: " + map);  // key1 entry may be removed
    }
}
```
🔹 **Unlike HashMap, key-value pairs are removed automatically when keys become unreachable**.

---

### ✅ **2. get() - Retrieve Value by Key**
```java
System.out.println(map.get(key2)); // Output: Value2
```

---

### ✅ **3. remove() - Remove a Key-Value Pair**
```java
map.remove(key2);
System.out.println(map); // Output: {}
```

---

### ✅ **4. containsKey() - Check If Key Exists**
```java
System.out.println(map.containsKey(key1)); // false (key1 was garbage collected)
```

---

### ✅ **5. keySet(), values(), entrySet() - Iteration Methods**
```java
System.out.println(map.keySet());   // Output: []
System.out.println(map.values());   // Output: []
System.out.println(map.entrySet()); // Output: []
```

---

## 🔥 **Key Differences: WeakHashMap vs. HashMap**  

| Feature | HashMap | WeakHashMap |
|---------|--------|------------|
| Key Storage | Strong Reference | Weak Reference |
| Garbage Collection | No automatic removal | Keys are removed if unreferenced |
| Performance | Slightly slower (due to hashing) | Faster in memory-sensitive applications |
| Use Case | General-purpose | Cache, temporary mappings |
| Ordering | No order | No order |

---

## 📌 **Summary**
1. `WeakHashMap` **automatically removes entries when keys become unreachable**.
2. **Faster cleanup** for memory-sensitive applications.
3. **Does not guarantee ordering**.
4. **Not synchronized** (use `Collections.synchronizedMap()` for thread safety).
5. **Ideal for caching scenarios**.

---

## ❓ **FAQs**
1️⃣ **When to use WeakHashMap instead of HashMap?**  
   - When you want **automatic cleanup** of unused entries (e.g., caching, session management).

2️⃣ **Does WeakHashMap allow `null` keys?**  
   - **Yes**, but only **one `null` key** is allowed.

3️⃣ **Is WeakHashMap thread-safe?**  
   - **No**, use `Collections.synchronizedMap(new WeakHashMap<>())`.

---

🚀 **Happy Coding!** 🎯