# 📌 **Java HashMap Methods - A Complete Guide**  

## 🔥 **Introduction**  

`HashMap<K, V>` is a part of the Java Collection Framework that implements the `Map<K, V>` interface using a **hash table**. It provides **O(1) average time complexity** for basic operations like insertion, deletion, and lookup.  

This guide covers **all built-in methods** of `HashMap`, with explanations and practical examples.  

---

## 🏗 **Class Hierarchy**  

```plaintext
java.lang.Object
   ├── java.util.AbstractMap<K,V>
       ├── java.util.HashMap<K,V>
```

`HashMap<K, V>` extends `AbstractMap<K, V>` and implements `Map<K, V>`, `Cloneable`, and `Serializable`.

---

## 📌 **HashMap Methods & Time Complexity**  

| Method | Description | Time Complexity (Average) | Time Complexity (Worst) |
|--------|------------|-------------------------|--------------------------|
| `V put(K key, V value)` | Inserts or updates a key-value pair | **O(1)** | **O(n)** (hash collision) |
| `V get(Object key)` | Retrieves the value for the given key | **O(1)** | **O(n)** |
| `V remove(Object key)` | Removes the key-value pair | **O(1)** | **O(n)** |
| `boolean containsKey(Object key)` | Checks if a key exists | **O(1)** | **O(n)** |
| `boolean containsValue(Object value)` | Checks if a value exists | **O(n)** | **O(n)** |
| `int size()` | Returns the number of key-value pairs | **O(1)** | **O(1)** |
| `boolean isEmpty()` | Checks if the map is empty | **O(1)** | **O(1)** |
| `void clear()` | Removes all key-value pairs | **O(n)** | **O(n)** |
| `Set<K> keySet()` | Returns a `Set` of all keys | **O(1)** | **O(n)** (iteration) |
| `Collection<V> values()` | Returns a `Collection` of all values | **O(1)** | **O(n)** (iteration) |
| `Set<Map.Entry<K,V>> entrySet()` | Returns a `Set` of all key-value pairs | **O(1)** | **O(n)** (iteration) |
| `V putIfAbsent(K key, V value)` | Adds key-value pair only if the key is absent | **O(1)** | **O(n)** |
| `V replace(K key, V value)` | Replaces a value for a given key | **O(1)** | **O(n)** |
| `boolean replace(K key, V oldValue, V newValue)` | Replaces value only if old value matches | **O(1)** | **O(n)** |
| `void putAll(Map<? extends K, ? extends V> m)` | Copies all mappings from another map | **O(n)** | **O(n)** |
| `boolean equals(Object o)` | Compares the map with another object | **O(n)** | **O(n)** |
| `int hashCode()` | Returns the hash code of the map | **O(n)** | **O(n)** |
| `V getOrDefault(Object key, V defaultValue)` | Returns value or default if key not found | **O(1)** | **O(n)** |
| `void forEach(BiConsumer<? super K, ? super V> action)` | Performs an action for each entry | **O(n)** | **O(n)** |
| `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes a new value for a key | **O(1)** | **O(n)** |
| `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)` | Computes a value only if the key is absent | **O(1)** | **O(n)** |
| `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | Computes a value only if key is present | **O(1)** | **O(n)** |
| `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)` | Merges a key-value pair | **O(1)** | **O(n)** |

---


## 🔹 Methods and Examples

### 1️⃣ `V put(K key, V value)`
**Adds a key-value pair to the map.**
```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(2, "Banana");
System.out.println(map); // {1=Apple, 2=Banana}
```

### 2️⃣ `V get(Object key)`
**Retrieves the value associated with a key.**
```java
System.out.println(map.get(1)); // Apple
```

### 3️⃣ `V remove(Object key)`
**Removes the key-value pair for the specified key.**
```java
map.remove(1);
System.out.println(map); // {2=Banana}
```

### 4️⃣ `boolean containsKey(Object key)`
**Checks if a key exists in the map.**
```java
System.out.println(map.containsKey(2)); // true
```

### 5️⃣ `boolean containsValue(Object value)`
**Checks if a value exists in the map.**
```java
System.out.println(map.containsValue("Banana")); // true
```

### 6️⃣ `int size()`
**Returns the number of key-value pairs.**
```java
System.out.println(map.size()); // 1
```

### 7️⃣ `boolean isEmpty()`
**Checks if the map is empty.**
```java
System.out.println(map.isEmpty()); // false
```

### 8️⃣ `void clear()`
**Removes all elements from the map.**
```java
map.clear();
System.out.println(map); // {}
```

### 9️⃣ `Set<K> keySet()`
**Returns a `Set` of all keys.**
```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "Apple");
map.put(2, "Banana");
System.out.println(map.keySet()); // [1, 2]
```

### 🔟 `Collection<V> values()`
**Returns a `Collection` of all values.**
```java
System.out.println(map.values()); // [Apple, Banana]
```

### 1️⃣1️⃣ `Set<Map.Entry<K,V>> entrySet()`
**Returns a `Set` of all key-value pairs.**
```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

### 1️⃣2️⃣ `V putIfAbsent(K key, V value)`
**Adds a key-value pair if the key is not already present.**
```java
map.putIfAbsent(2, "Grapes");
System.out.println(map); // {1=Apple, 2=Banana}
```

### 1️⃣3️⃣ `V replace(K key, V value)`
**Replaces the value for a given key.**
```java
map.replace(2, "Cherry");
System.out.println(map); // {1=Apple, 2=Cherry}
```

### 1️⃣4️⃣ `boolean replace(K key, V oldValue, V newValue)`
**Replaces a value only if it matches the old value.**
```java
map.replace(2, "Banana", "Orange");
System.out.println(map); // {1=Apple, 2=Cherry} (unchanged because "Banana" ≠ "Cherry")
```

### 1️⃣5️⃣ `void putAll(Map<? extends K, ? extends V> m)`
**Copies all mappings from another map.**
```java
HashMap<Integer, String> newMap = new HashMap<>();
newMap.put(3, "Grapes");
map.putAll(newMap);
System.out.println(map); // {1=Apple, 2=Cherry, 3=Grapes}
```

### 1️⃣6️⃣ `boolean equals(Object o)`
**Compares the map with another object for equality.**
```java
HashMap<Integer, String> anotherMap = new HashMap<>(map);
System.out.println(map.equals(anotherMap)); // true
```

### 1️⃣7️⃣ `int hashCode()`
**Returns the hash code for the map.**
```java
System.out.println(map.hashCode());
```

### 1️⃣8️⃣ `V getOrDefault(Object key, V defaultValue)`
**Returns the value or a default if the key is not found.**
```java
System.out.println(map.getOrDefault(5, "Default")); // Default
```

### 1️⃣9️⃣ `void forEach(BiConsumer<? super K, ? super V> action)`
**Performs an action for each entry.**
```java
map.forEach((key, value) -> System.out.println(key + ": " + value));
```

### 2️⃣0️⃣ `V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
**Computes a new value for the given key.**
```java
map.compute(2, (k, v) -> v + " Fruit");
System.out.println(map); // {1=Apple, 2=Cherry Fruit}
```

### 2️⃣1️⃣ `V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`
**Computes a value only if the key is absent.**
```java
map.computeIfAbsent(4, k -> "Mango");
System.out.println(map); // {1=Apple, 2=Cherry Fruit, 4=Mango}
```

### 2️⃣2️⃣ `V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`
**Computes a value only if the key is present.**
```java
map.computeIfPresent(2, (k, v) -> v.toUpperCase());
System.out.println(map); // {1=Apple, 2=CHERRY FRUIT, 4=Mango}
```

### 2️⃣3️⃣ `V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`
**Merges a key-value pair.**
```java
map.merge(2, "New", (oldVal, newVal) -> oldVal + " & " + newVal);
System.out.println(map); // {1=Apple, 2=CHERRY FRUIT & New, 4=Mango}
```

---




## **📌 Summary**  
1. `put()`, `get()`, `remove()` → Core HashMap operations.  
2. `containsKey()`, `containsValue()` → Existence checks.  
3. `keySet()`, `values()`, `entrySet()` → Collection views.  
4. `compute()`, `computeIfAbsent()` → Advanced computations.  

---

## **❓ FAQs**  

### 1️⃣ **What is the time complexity of `put()`, `get()`, and `remove()`?**  
- **Average case**: `O(1)`, since it uses hashing.  
- **Worst case**: `O(n)`, when many keys have the same hash (hash collisions).  

### 2️⃣ **Can `HashMap` store `null` keys and values?**  
- Yes, `HashMap` allows **one `null` key** and multiple `null` values.  

### 3️⃣ **Is `HashMap` thread-safe?**  
- No, `HashMap` is **not synchronized**. Use `ConcurrentHashMap` or `Collections.synchronizedMap()` for thread safety.  

---

## 📚 **Additional Resources**  
🔗 [Official Java Docs - HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)  

🚀 **Happy Coding!** 🎯