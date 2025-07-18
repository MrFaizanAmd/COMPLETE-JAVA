# 📌 **Java IdentityHashMap – A Complete Reference Guide**  

## 🔥 **Introduction**  
`IdentityHashMap<K, V>` is a specialized implementation of `Map<K, V>` that **compares keys by reference (==) instead of `.equals()`**.  

Unlike `HashMap`, which uses **logical equality (`.equals()`)**, `IdentityHashMap` only considers two keys **equal if they are the exact same object in memory**.

This guide covers **all methods** with explanations, examples, and **time complexity analysis**.

---

## 🏗 **Class Hierarchy**
```plaintext
Iterable
│
├── Collection
│   ├── Map
│   │   ├── AbstractMap
│   │   │   ├── IdentityHashMap
```
- **`IdentityHashMap<K, V>` extends `AbstractMap<K, V>`**.
- It **does not guarantee ordering** and is **not synchronized**.

---

## 📌 **Method Table (With Time Complexity)**  

| Method | Description | Time Complexity (Average) | Time Complexity (Worst) |
|--------|------------|-------------------------|--------------------------|
| `V put(K key, V value)` | Inserts or updates a key-value pair (compares keys by reference) | **O(1)** | **O(n) (resize needed)** |
| `V get(Object key)` | Retrieves value for the given key (reference-based lookup) | **O(1)** | **O(1)** |
| `V remove(Object key)` | Removes the key-value pair | **O(1)** | **O(1)** |
| `boolean containsKey(Object key)` | Checks if a key exists (by reference) | **O(1)** | **O(1)** |
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


## 📌 Methods and Examples

### 1️⃣ `put(K key, V value)`
**Inserts or updates a key-value pair based on reference equality.**

```java
import java.util.IdentityHashMap;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();
        String key1 = new String("name");
        String key2 = new String("name");
        
        map.put(key1, "Alice");
        map.put(key2, "Bob"); // Treated as a different key due to reference equality
        
        System.out.println(map); // {name=Alice, name=Bob}
    }
}
```

### 2️⃣ `get(Object key)`
**Retrieves the value associated with the key, using reference equality.**

```java
String value = map.get(key1);
System.out.println(value); // Alice
```

### 3️⃣ `remove(Object key)`
**Removes a key-value pair.**

```java
map.remove(key1);
System.out.println(map); // {name=Bob}
```

### 4️⃣ `containsKey(Object key)`
**Checks if a key exists based on reference comparison.**

```java
boolean exists = map.containsKey(key2);
System.out.println(exists); // true
```

### 5️⃣ `containsValue(Object value)`
**Checks if a value exists.**

```java
boolean hasValue = map.containsValue("Bob");
System.out.println(hasValue); // true
```

### 6️⃣ `size()`
**Returns the number of key-value pairs.**

```java
System.out.println(map.size()); // 1
```

### 7️⃣ `isEmpty()`
**Checks if the map is empty.**

```java
System.out.println(map.isEmpty()); // false
```

### 8️⃣ `clear()`
**Removes all key-value pairs.**

```java
map.clear();
System.out.println(map.isEmpty()); // true
```

### 9️⃣ `keySet()`
**Returns a set of keys.**

```java
for (String key : map.keySet()) {
    System.out.println(key);
}
```

### 🔟 `values()`
**Returns a collection of values.**

```java
for (String value : map.values()) {
    System.out.println(value);
}
```

### 1️⃣1️⃣ `entrySet()`
**Returns a set of key-value pairs.**

```java
for (var entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

### 1️⃣2️⃣ `putIfAbsent(K key, V value)`
**Only adds if key is not already present.**

```java
map.putIfAbsent(key1, "Charlie");
```

### 1️⃣3️⃣ `replace(K key, V value)`
**Replaces value for the given key if it exists.**

```java
map.replace(key2, "David");
```

### 1️⃣4️⃣ `equals(Object o)`
**Compares two maps based on key-value pairs.**

```java
IdentityHashMap<String, String> anotherMap = new IdentityHashMap<>(map);
System.out.println(map.equals(anotherMap)); // true
```

### 1️⃣5️⃣ `hashCode()`
**Returns the hash code of the map.**

```java
System.out.println(map.hashCode());
```

### 1️⃣6️⃣ `getOrDefault(Object key, V defaultValue)`
**Returns value or default if key is not found.**

```java
System.out.println(map.getOrDefault("unknown", "Not Found"));
```

### 1️⃣7️⃣ `forEach(BiConsumer<? super K, ? super V> action)`
**Performs an action for each key-value pair.**

```java
map.forEach((k, v) -> System.out.println(k + " -> " + v));
```

### 1️⃣8️⃣ `compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
**Computes a new value for a given key.**

```java
map.compute(key2, (k, v) -> v + " Updated");
```

### 1️⃣9️⃣ `computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`
**Computes a value if the key is absent.**

```java
map.computeIfAbsent("newKey", k -> "Generated Value");
```

### 2️⃣0️⃣ `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
**Computes a value only if key is present.**

```java
map.computeIfPresent(key2, (k, v) -> v + " Updated");
```

### 2️⃣1️⃣ `merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`
**Merges a key-value pair.**

```java
map.merge(key2, " Extra", (oldVal, newVal) -> oldVal + newVal);
```

---


## 🔥 **Key Differences: IdentityHashMap vs. HashMap**  

| Feature | HashMap | IdentityHashMap |
|---------|--------|----------------|
| Key Comparison | `.equals()` method | `==` (reference-based) |
| Duplicate Key Handling | Logical equality | Reference-based, so duplicate objects exist |
| Ordering | No order | No order |
| Performance | Slightly slower (hash-based lookup) | Faster in scenarios with reference-based keys |
| Use Case | General-purpose | Reference equality scenarios (e.g., caching, object identity tracking) |

---

## 📌 **Summary**
1. `IdentityHashMap` **compares keys using `==` (reference equality), not `.equals()`**.
2. **Faster lookups** for scenarios where reference comparison is required.
3. **Does not guarantee ordering**.
4. **Not synchronized** (use `Collections.synchronizedMap()` for thread safety).
5. **Saves memory in certain cases** compared to `HashMap`.

---

## ❓ **FAQs**
1️⃣ **When to use IdentityHashMap instead of HashMap?**  
   - When **identity-based (==) key comparison** is required.

2️⃣ **Does IdentityHashMap allow `null` keys?**  
   - **Yes**, but only **one `null` key** is allowed.

3️⃣ **Is IdentityHashMap thread-safe?**  
   - **No**, use `Collections.synchronizedMap(new IdentityHashMap<>())`.

---

🚀 **Happy Coding!** 🎯