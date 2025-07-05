# **Hashtable in Java 🚀**

## **Introduction**

### **What is a Hashtable?**
A `Hashtable` is a **legacy class** in Java that implements a **key-value pair data structure** using **hashing**. It belongs to the `java.util` package and provides **thread-safe** operations to store and retrieve elements efficiently.

### **Why is Hashtable Important?**
✔ **Fast lookup time** (O(1) in average cases, O(n) in worst cases due to collisions).  
✔ **Thread-safe** and **synchronized**, making it suitable for multi-threaded applications.  
✔ **Does not allow `null` keys or values**, ensuring data integrity.  
✔ **Based on hash table data structure**, making it highly efficient for retrieval.  

### **Real-life Analogy** 📌
Think of a `Hashtable` like a **library catalog system**:
- Each book has a **unique identifier (key)**.
- The **title of the book (value)** is stored and quickly retrievable using the unique ID.
- If a book has the same ID as another, a **collision occurs**, which the system handles through chaining or rehashing.

---

## **Hierarchy of Hashtable**

```
Iterable (Interface)
│
├── Collection (Interface)
│   ├── Map (Interface)
│   │   ├── AbstractMap (Class)
│   │   │   ├── Hashtable (Class) ✅ (Our Focus!)
│   │   │   │   ├── Properties (Subclass)
```

### **Key Points:**
- `Hashtable` implements the `Map` interface.
- It extends `Dictionary`, making it an older alternative to `HashMap`.
- It is **synchronized**, unlike `HashMap`, making it **thread-safe**.

---

## **Key Features of Hashtable 🚀**

✅ **Key-Value Mapping** – Stores elements as **key-value pairs** using hashing.  
✅ **Synchronized** – Thread-safe, but may have performance overhead.  
✅ **No Null Keys or Values** – Ensures integrity by not allowing `null` keys or values.  
✅ **Collision Handling** – Uses **bucket-based** structure for handling hash collisions.  
✅ **Legacy Class** – Introduced in Java 1.0, replaced in many cases by `ConcurrentHashMap`.

---

## **How Hashtable Works Internally? 🛠️**

### **1. Hashing Mechanism**
- When a key-value pair is inserted, the key’s **hash code** is computed using the `hashCode()` method.
- The computed hash value determines the **bucket index** in the hashtable.
- If multiple keys hash to the same index, **collision handling** occurs via **chaining** (linked list-based storage in buckets).

### **2. Collision Handling**
- `Hashtable` **uses chaining** to handle hash collisions.
- Multiple values stored in the same bucket are linked together.
- During retrieval, Java searches the bucket and traverses the linked list if needed.

### **3. Thread Safety**
- `Hashtable` **synchronizes every method**, making it thread-safe.
- However, this **reduces performance** compared to `HashMap` in single-threaded applications.

---

## **Creating a Hashtable in Java**

### **Example 1: Basic Hashtable Operations**
```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        // Creating a Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        
        // Adding key-value pairs
        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Cherry");
        
        // Retrieving values
        System.out.println("Value for key 2: " + hashtable.get(2));
        
        // Checking if a key exists
        System.out.println("Contains key 3? " + hashtable.containsKey(3));
        
        // Removing an entry
        hashtable.remove(1);
        
        // Iterating through the Hashtable
        for (Integer key : hashtable.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
        }
    }
}
```

### **Output:**
```
Value for key 2: Banana
Contains key 3? true
Key: 2, Value: Banana
Key: 3, Value: Cherry
```
📌 **Notice:** The order of elements **is not guaranteed** as `Hashtable` does not maintain insertion order.

---

## **When to Use Hashtable?** ✅
✔ When **thread safety** is required in multi-threaded applications.  
✔ When **fast lookups** are needed in a concurrent environment.  
✔ When **null keys and values should not be allowed**.  

## **When NOT to Use Hashtable?** ❌
✘ If performance is critical, `ConcurrentHashMap` is a **better alternative**.  
✘ If synchronization is **not needed**, `HashMap` is **faster**.  
✘ If insertion order matters, use **LinkedHashMap** instead.

---

## **Hashtable vs Other Maps**

| Feature | Hashtable | HashMap | ConcurrentHashMap |
|---------|----------|---------|------------------|
| Thread-Safe | ✅ Yes | ❌ No | ✅ Yes |
| Allows Null Key/Values | ❌ No | ✅ Yes | ❌ No |
| Performance | 🔴 Slower (due to synchronization) | 🟢 Faster | 🟢 Faster |
| Best For | Multi-threaded apps | Single-threaded apps | High-concurrency apps |

---
### **Time Complexity of Common Methods in Hashtable**  

| Method | Average Case | Worst Case | Description |
|--------|-------------|------------|-------------|
| `put(K key, V value)` | **O(1)** | **O(n)** | Inserts a key-value pair. Worst case happens when all keys collide, forming a single chain (rare with good hashing). |
| `get(Object key)` | **O(1)** | **O(n)** | Retrieves a value by key. Worst case occurs when all elements are in one bucket due to hash collisions. |
| `remove(Object key)` | **O(1)** | **O(n)** | Removes a key-value pair. Worst case happens when all elements hash to the same bucket. |
| `containsKey(Object key)` | **O(1)** | **O(n)** | Checks if a key exists, similar to `get()`. |
| `containsValue(Object value)` | **O(n)** | **O(n)** | Scans all entries to find a value since values are not indexed. |
| `keySet()` | **O(n)** | **O(n)** | Returns a set of keys, iterating through all entries. |
| `size()` | **O(1)** | **O(1)** | Returns the number of key-value mappings, stored as a variable. |

📌 **Note:** The **average case** remains `O(1)` for most operations due to **constant-time hashing**, but in case of **poorly distributed hashes** or excessive collisions, the worst case can degrade to **O(n)**.

---
## **Summary** 🎯
- `Hashtable` is a **thread-safe**, **synchronized** key-value storage class.
- It uses **hashing** and **collision handling** through chaining.
- **Does not allow `null` keys or values**, making it more restrictive than `HashMap`.
- **Best suited for multi-threaded environments**, but `ConcurrentHashMap` is usually preferred today.

---
🔥 **With this guide, you now have a complete understanding of Hashtable!** 🚀 Let me know if you need any refinements! 😊

