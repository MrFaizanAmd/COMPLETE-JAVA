

# 📌 **Java LinkedHashMap Methods - A Complete Guide**  

## 🔥 **Introduction**  
`LinkedHashMap<K, V>` is a **hash table with predictable iteration order**. It maintains a **doubly-linked list** of entries, preserving the order in which keys are inserted (or access order, if specified).  

This guide covers **all methods** with explanations, examples, and **time complexity analysis**.

---

## 🏗 **Class Hierarchy**
```plaintext
Iterable
│
├── Collection
│   ├── Map
│   │   ├── AbstractMap
│   │   │   ├── HashMap
│   │   │   │   ├── LinkedHashMap
```
- `LinkedHashMap<K, V>` extends `HashMap<K, V>` and maintains **insertion order**.
- Unlike `HashMap`, it uses a **doubly-linked list** internally.

---

## 📌 **Method Table (With Time Complexity)**  

| Method | Description | Time Complexity (Average) | Time Complexity (Worst) |
|--------|------------|-------------------------|--------------------------|
| `V put(K key, V value)` | Inserts or updates a key-value pair | **O(1)** | **O(1)** |
| `V get(Object key)` | Retrieves value for the given key | **O(1)** | **O(1)** |
| `V remove(Object key)` | Removes the key-value pair | **O(1)** | **O(1)** |
| `boolean containsKey(Object key)` | Checks if a key exists | **O(1)** | **O(1)** |
| `boolean containsValue(Object value)` | Checks if a value exists | **O(n)** | **O(n)** |
| `int size()` | Returns the number of key-value pairs | **O(1)** | **O(1)** |
| `boolean isEmpty()` | Checks if the map is empty | **O(1)** | **O(1)** |
| `void clear()` | Removes all key-value pairs | **O(n)** | **O(n)** |
| `Set<K> keySet()` | Returns a `Set` of all keys in order | **O(1)** | **O(n)** (iteration) |
| `Collection<V> values()` | Returns a `Collection` of all values in order | **O(1)** | **O(n)** (iteration) |
| `Set<Map.Entry<K,V>> entrySet()` | Returns a `Set` of all key-value pairs in order | **O(1)** | **O(n)** (iteration) |
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
## 📌 **Methods of `LinkedHashMap` with Examples**

### 1️⃣ `V put(K key, V value)`
📌 **Adds a key-value pair to the map. If the key already exists, it updates the value.**
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println(map);  // Output: {1=Apple, 2=Banana, 3=Cherry}
    }
}
```
⏳ **Time Complexity:** Average: `O(1)`, Worst: `O(1)`

---

### 2️⃣ `V get(Object key)`
📌 **Retrieves the value associated with a key. Returns `null` if the key is absent.**
```java
System.out.println(map.get(2));  // Output: Banana
System.out.println(map.get(4));  // Output: null
```
⏳ **Time Complexity:** `O(1)`

---

### 3️⃣ `V remove(Object key)`
📌 **Removes the key-value pair for the specified key.**
```java
map.remove(2);
System.out.println(map);  // Output: {1=Apple, 3=Cherry}
```
⏳ **Time Complexity:** `O(1)`

---

### 4️⃣ `boolean containsKey(Object key)`
📌 **Checks if a specific key exists in the map.**
```java
System.out.println(map.containsKey(3));  // Output: true
System.out.println(map.containsKey(5));  // Output: false
```
⏳ **Time Complexity:** `O(1)`

---

### 5️⃣ `boolean containsValue(Object value)`
📌 **Checks if a value exists in the map.**
```java
System.out.println(map.containsValue("Banana"));  // Output: false
```
⏳ **Time Complexity:** `O(n)`

---

### 6️⃣ `int size()`
📌 **Returns the number of key-value pairs in the map.**
```java
System.out.println(map.size());  // Output: 2
```
⏳ **Time Complexity:** `O(1)`

---

### 7️⃣ `boolean isEmpty()`
📌 **Checks if the map is empty.**
```java
System.out.println(map.isEmpty());  // Output: false
```
⏳ **Time Complexity:** `O(1)`

---

### 8️⃣ `void clear()`
📌 **Removes all key-value pairs from the map.**
```java
map.clear();
System.out.println(map.isEmpty());  // Output: true
```
⏳ **Time Complexity:** `O(n)`

---

### 9️⃣ `Set<K> keySet()`
📌 **Returns a `Set` of all keys in insertion order.**
```java
System.out.println(map.keySet());  // Output: [1, 2, 3]
```
⏳ **Time Complexity:** `O(1)`

---

### 🔟 `Collection<V> values()`
📌 **Returns a `Collection` of all values in insertion order.**
```java
System.out.println(map.values());  // Output: [Apple, Banana, Cherry]
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣1️⃣ `Set<Map.Entry<K,V>> entrySet()`
📌 **Returns a `Set` of all key-value pairs in insertion order.**
```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣2️⃣ `V putIfAbsent(K key, V value)`
📌 **Inserts key-value pair only if the key is not already present.**
```java
map.putIfAbsent(4, "Date");
System.out.println(map);  // Output: {1=Apple, 3=Cherry, 4=Date}
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣3️⃣ `V replace(K key, V value)`
📌 **Replaces a value for a given key only if it exists.**
```java
map.replace(1, "Apricot");
System.out.println(map);  // Output: {1=Apricot, 3=Cherry, 4=Date}
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣4️⃣ `boolean replace(K key, V oldValue, V newValue)`
📌 **Replaces a value only if the old value matches.**
```java
map.replace(1, "Apricot", "Avocado");
System.out.println(map);  // Output: {1=Avocado, 3=Cherry, 4=Date}
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣5️⃣ `V getOrDefault(Object key, V defaultValue)`
📌 **Returns the value or a default value if the key is not found.**
```java
System.out.println(map.getOrDefault(5, "Default Fruit"));  // Output: Default Fruit
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣6️⃣ `void forEach(BiConsumer<? super K, ? super V> action)`
📌 **Performs an action for each key-value pair.**
```java
map.forEach((k, v) -> System.out.println(k + " -> " + v));
```
⏳ **Time Complexity:** `O(n)`

---

### 1️⃣7️⃣ `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
📌 **Computes a new value for the given key.**
```java
map.compute(1, (k, v) -> v + " Juice");
System.out.println(map);  // Output: {1=Avocado Juice, 3=Cherry, 4=Date}
```
⏳ **Time Complexity:** `O(1)`

---

### 1️⃣8️⃣ `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`
📌 **Merges a value into the map.**
```java
map.merge(1, " Fresh", (oldVal, newVal) -> oldVal + newVal);
System.out.println(map);  // Output: {1=Avocado Juice Fresh, 3=Cherry, 4=Date}
```
⏳ **Time Complexity:** `O(1)`

---



## 🔥 **Key Differences: LinkedHashMap vs. HashMap**  

| Feature | HashMap | LinkedHashMap |
|---------|--------|--------------|
| Order of Keys | **Unordered** | **Maintains Insertion Order** |
| Performance | **Slightly Faster** | **Slightly Slower** (due to linked list) |
| Memory Overhead | **Lower** | **Higher (due to linked structure)** |
| Access Order Mode | ❌ No | ✅ Yes |

---

## 📌 **Summary**
1. `LinkedHashMap` is an **ordered version of HashMap**.
2. **Preserves insertion order** (or **access order**, if configured).
3. **Most operations run in O(1) time complexity**.
4. Slightly **higher memory usage** due to **linked list**.

---

## ❓ **FAQs**
1️⃣ **When to use LinkedHashMap instead of HashMap?**  
   - When **preserving insertion order** is required.

2️⃣ **Is LinkedHashMap synchronized?**  
   - **No**, use `Collections.synchronizedMap(new LinkedHashMap<>())` for thread safety.

3️⃣ **Can LinkedHashMap store `null` keys?**  
   - **Yes**, it allows **one `null` key**.

---

🚀 **Happy Coding!** 🎯