Here's a comprehensive README for **HashMap** covering everything from **basics to advanced concepts**, including **initialization, inner workings, resizing, collision handling, methods, and performance analysis**.

---

# 📌 **HashMap in Java - Complete Guide**  

## **📖 Table of Contents**
1. [Introduction](#introduction)  
2. [Why Use HashMap?](#why-use-hashmap)  
3. [Hierarchy](#hierarchy)  
4. [How HashMap Works Internally](#how-hashmap-works-internally)  
5. [Collision Handling](#collision-handling)  
6. [Resizing and Rehashing](#resizing-and-rehashing)  
7. [Important Methods & Time Complexity](#important-methods--time-complexity)  
8. [Iteration Over HashMap](#iteration-over-hashmap)  
9. [Thread Safety & Synchronization](#thread-safety--synchronization)  
10. [HashMap vs Other Map Implementations](#hashmap-vs-other-map-implementations)  
11. [Common Interview Questions](#common-interview-questions)  

---

## 🔹 **Introduction**
`HashMap` is a widely used **key-value pair** data structure in Java that implements the `Map` interface. It provides **constant-time performance (O(1)) for get and put operations on average**. However, in the worst case (high collisions), the time complexity can go up to **O(n)**.

🔹 **Package:** `java.util.HashMap`  
🔹 **Implements:** `Map<K, V>, Cloneable, Serializable`  
🔹 **Underlying Data Structure:** Array of linked lists (before Java 8), Array of **TreeNodes** (after Java 8 for collision handling).  

---

## 🔹 **Why Use HashMap?**
✅ **Fast Lookup & Insertion** → `O(1)` average time complexity  
✅ **No Duplicate Keys** → Only unique keys are allowed  
✅ **Allows One Null Key & Multiple Null Values**  
✅ **Unordered Storage** → No guarantee of insertion order  
✅ **Efficient for Large Data Sets**  

🚨 **Limitations:**  
❌ Not thread-safe (use `ConcurrentHashMap` for concurrency)  
❌ Does not maintain insertion order (use `LinkedHashMap` if needed)  

---

## 🔹 **Hierarchy**
```
java.lang.Object
   └── java.util.AbstractMap<K,V>
       └── java.util.HashMap<K,V>
```

🔹 **Implements:** `Map<K,V>` Interface  
🔹 **Extends:** `AbstractMap<K,V>`  

---

## 🔹 **How HashMap Works Internally**
### **Step 1: Understanding Hashing**
- HashMap stores **key-value pairs**.
- It calculates the **hash code** of the key using the `hashCode()` method.
- The index for storing the key-value pair is computed using:
  ```java
  index = (hashCode(key) & (n - 1))
  ```
  where `n` is the capacity of the array.

### **Step 2: Initial Structure**
- `HashMap` internally uses an **array of Node<K, V> (also called buckets)**.
- Each node contains:
  ```java
  static class Node<K, V> {
      final int hash;
      final K key;
      V value;
      Node<K, V> next;  // Linked list for collision handling
  }
  ```
- Initially, the default capacity is **16** and the load factor is **0.75**.

### **Step 3: Storing a Key-Value Pair**
1. Compute `hashCode(key)`.
2. Compute `index = hash & (n - 1)`.
3. Store the value at `index` in the bucket array.
4. If multiple values are mapped to the same index (collision), they are stored using **Linked List** (before Java 8) or **Balanced Tree** (after Java 8, when collisions exceed 8).

---

## 🔹 **Collision Handling**
When two keys generate the same index (collision), **HashMap** uses two strategies:
1. **Chaining (Linked List)**
   - Before Java 8, HashMap used a simple linked list to store collided values.
   - This results in O(n) worst-case time complexity when searching for an element in a long chain.

2. **Treeification (Balanced Tree)**
   - After Java 8, if the number of collisions exceeds **8**, HashMap converts the linked list into a **Red-Black Tree**.
   - This improves lookup time complexity from **O(n) to O(log n)**.

---

## 🔹 **Resizing and Rehashing**
- When the number of elements **exceeds** `capacity * load factor`, HashMap **doubles its size**.
- The default **load factor** is **0.75**.
- **Example:**  
  If capacity = 16, resizing happens when the size reaches **16 * 0.75 = 12**.
- During resizing, all elements are **rehashed** and moved to new positions.

---

## 🔹 **Important Methods & Time Complexity**
| Method | Description | Average Time Complexity |
|--------|------------|-----------------------|
| `put(K key, V value)` | Inserts a key-value pair | **O(1)** (O(n) worst) |
| `get(Object key)` | Retrieves the value by key | **O(1)** (O(n) worst) |
| `remove(Object key)` | Removes a key-value pair | **O(1)** (O(n) worst) |
| `containsKey(Object key)` | Checks if key exists | **O(1)** |
| `containsValue(Object value)` | Checks if value exists | **O(n)** |
| `size()` | Returns number of entries | **O(1)** |
| `keySet()` | Returns set of keys | **O(n)** |
| `values()` | Returns collection of values | **O(n)** |
| `entrySet()` | Returns set of key-value pairs | **O(n)** |

---

## 🔹 **Iteration Over HashMap**
There are **four ways** to iterate over a HashMap:
1. **Using `entrySet()` with for-each loop** ✅ **(Best Performance)**
   ```java
   for (Map.Entry<Integer, String> entry : map.entrySet()) {
       System.out.println(entry.getKey() + " -> " + entry.getValue());
   }
   ```
2. **Using `keySet()` (Less Efficient)**
   ```java
   for (Integer key : map.keySet()) {
       System.out.println(key + " -> " + map.get(key));
   }
   ```
3. **Using Java 8 `forEach()`**
   ```java
   map.forEach((key, value) -> System.out.println(key + " -> " + value));
   ```
4. **Using `Iterator`**
   ```java
   Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
   while (iterator.hasNext()) {
       Map.Entry<Integer, String> entry = iterator.next();
       System.out.println(entry.getKey() + " -> " + entry.getValue());
   }
   ```

---

## 🔹 **Thread Safety & Synchronization**
- `HashMap` is **not thread-safe**.
- Use `ConcurrentHashMap` for multi-threaded environments.
- Use `Collections.synchronizedMap()` for simple synchronization.

---

## 🔹 **HashMap vs Other Map Implementations**
| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` | `Hashtable` |
|---------|----------|----------------|----------|------------|
| Ordering | No order | Insertion order | Sorted order | No order |
| Performance | O(1) avg | O(1) avg | O(log n) | O(1) avg |
| Thread-safe | ❌ No | ❌ No | ❌ No | ✅ Yes |
| Null Keys | ✅ Allowed | ✅ Allowed | ❌ Not allowed | ❌ Not allowed |

---

Here’s a **FAQ-style document** for **common HashMap interview questions** along with detailed answers.

---

# 📌 **HashMap Interview Questions - FAQ**

## 🔹 **1. How does HashMap work internally?**  
**Answer:**  
- `HashMap` uses an **array of Node<K, V>** (also called buckets) to store key-value pairs.  
- It computes the index using:  
  ```java
  index = (hashCode(key) & (n - 1))
  ```
- If multiple keys generate the same index (**collision**), elements are stored using **Linked List** (before Java 8) or **Red-Black Tree** (after Java 8 when collision count exceeds 8).

---

## 🔹 **2. What is the default capacity and load factor of HashMap?**  
**Answer:**  
- **Default Capacity** = `16` (i.e., `new HashMap<>()` creates an array of size 16).  
- **Default Load Factor** = `0.75` (rehashing occurs when `size > 16 * 0.75 = 12`).  
- **Why 0.75?** → It's a balance between space (memory usage) and performance (collision reduction).  

---

## 🔹 **3. What happens when HashMap reaches its threshold?**  
**Answer:**  
- When `size > capacity * load factor`, **HashMap resizes** by **doubling the capacity** and **rehashing all entries**.  
- Example: If the capacity is `16`, it becomes `32` when the size reaches `12`.  
- All elements are **recalculated and moved** to new positions.

---

## 🔹 **4. How does HashMap handle collisions?**  
**Answer:**  
1. **Before Java 8** → Uses a **Linked List** in the bucket to store collided values (O(n) lookup).  
2. **After Java 8** → Converts to a **Balanced Red-Black Tree** if collisions exceed `8`, improving lookup from **O(n) to O(log n)**.

---

## 🔹 **5. Why does HashMap use `(n - 1) & hashCode` instead of `hashCode % n`?**  
**Answer:**  
- `(n - 1) & hashCode` is a **bitwise AND operation**, which is **faster than modulus (%)**.
- It works efficiently when `n` is a power of **2**, ensuring uniform distribution across buckets.

---

## 🔹 **6. Can HashMap have `null` keys and values?**  
**Answer:**  
✅ **Yes!**  
- HashMap **allows one `null` key** but multiple `null` values.  
- Example:  
  ```java
  HashMap<Integer, String> map = new HashMap<>();
  map.put(null, "NullKey");  // Allowed
  map.put(1, null);          // Allowed
  ```

---

## 🔹 **7. What is the time complexity of HashMap operations?**  
**Answer:**  
| Operation | Average Case | Worst Case (high collisions) |
|-----------|------------|-----------------------------|
| `put(K, V)` | **O(1)** | **O(n)** (linked list) or **O(log n)** (RB-tree) |
| `get(K)` | **O(1)** | **O(n)** (linked list) or **O(log n)** (RB-tree) |
| `remove(K)` | **O(1)** | **O(n)** (linked list) or **O(log n)** (RB-tree) |
| `containsKey(K)` | **O(1)** | **O(n) / O(log n)** |

---

## 🔹 **8. What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?**  
**Answer:**  
| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` |
|---------|----------|----------------|----------|
| **Ordering** | ❌ No order | ✅ Insertion order | ✅ Sorted order |
| **Null Keys** | ✅ Allowed | ✅ Allowed | ❌ Not allowed |
| **Performance** | O(1) avg | O(1) avg | O(log n) |

---

## 🔹 **9. Why is `keySet()` iteration slower than `entrySet()`?**  
**Answer:**  
- `keySet()` requires an **additional lookup** for each key:  
  ```java
  for (K key : map.keySet()) {
      map.get(key); // Extra lookup (O(1) per call)
  }
  ```
- `entrySet()` directly provides key-value pairs, avoiding extra lookups:  
  ```java
  for (Map.Entry<K, V> entry : map.entrySet()) {
      entry.getKey();
      entry.getValue(); // No extra lookup
  }
  ```
🚀 **Use `entrySet()` for better performance!**

---

## 🔹 **10. What happens if two keys have the same `hashCode()`?**  
**Answer:**  
- HashMap **uses equals() to distinguish keys**.  
- If `equals()` returns `true`, it **updates** the existing value.  
- If `equals()` returns `false`, it treats them as **different keys** and stores them in a **Linked List or Tree**.

---

## 🔹 **11. Is HashMap thread-safe?**  
**Answer:**  
❌ **No, HashMap is not thread-safe.**  
✅ Use `ConcurrentHashMap` for thread safety.  

---

## 🔹 **12. What is the difference between `HashMap` and `Hashtable`?**  
**Answer:**  
| Feature | `HashMap` | `Hashtable` |
|---------|----------|------------|
| **Thread-safe?** | ❌ No | ✅ Yes |
| **Performance** | ✅ Faster | ❌ Slower |
| **Null Keys/Values?** | ✅ Allowed | ❌ Not allowed |

---

## 🔹 **13. What is `ConcurrentHashMap` and how is it different from `HashMap`?**  
**Answer:**  
✅ **ConcurrentHashMap** is thread-safe because:  
- It divides the map into **segments** to allow **concurrent modifications**.  
- It does not lock the entire map, improving performance in multi-threaded applications.

---

## 🔹 **14. Why is rehashing expensive?**  
**Answer:**  
- Rehashing involves:  
  1. **Doubling the capacity** of the bucket array.  
  2. **Recomputing hash codes** for all existing keys.  
  3. **Reinserting all elements** into new buckets.  
- This is an **O(n) operation** and slows down performance temporarily.

---

## 🔹 **15. How to iterate over a HashMap efficiently?**  
**Answer:**  
✅ **Best way:**  
```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```
🚀 **Avoid `keySet()` iteration for better performance!**

---

## 🔹 **16. Can HashMap store primitive types like `int` or `double`?**  
**Answer:**  
❌ No, `HashMap` only works with **objects**, not primitives.  
✅ Use **Wrapper classes (`Integer`, `Double`)** instead:  
```java
HashMap<Integer, String> map = new HashMap<>();
```

---

## 🔹 **17. Why does HashMap require `equals()` and `hashCode()` to be overridden?**  
**Answer:**  
- `hashCode()` determines **bucket placement**.  
- `equals()` ensures **key uniqueness**.  
- If these are not overridden correctly, **duplicate keys or incorrect retrieval** may occur.

---

## 🔹 **18. What are the key changes in HashMap from Java 8 onwards?**  
**Answer:**  
✅ **Major improvements:**  
1. **Red-Black Trees for Collisions** → Improves lookup from **O(n) to O(log n)**.  
2. **Improved Hashing Mechanism** → More uniform key distribution.  

---

## 🔹 **19. What happens if `hashCode()` always returns the same value?**  
**Answer:**  
- All keys **map to the same bucket**, causing a **single long linked list**.  
- Lookup time degrades from **O(1) to O(n)**.
- **Fix** → Ensure `hashCode()` distributes keys uniformly.

---

## 🔹 **20. How to make HashMap immutable?**  
**Answer:**  
```java
Map<Integer, String> immutableMap = Collections.unmodifiableMap(new HashMap<>());
```
🚀 **This prevents modifications after creation!**

---


---

This is a **comprehensive guide** covering **everything from basics to internals** of `HashMap`. Let me know if you need any modifications! 🚀