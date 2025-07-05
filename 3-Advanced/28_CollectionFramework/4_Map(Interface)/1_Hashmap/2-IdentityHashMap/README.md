

# **IdentityHashMap in Java**  

## **Table of Contents**  
1. [Introduction](#introduction)  
2. [Hierarchy](#hierarchy)  
3. [How IdentityHashMap Works](#how-identityhashmap-works)  
4. [Key Features](#key-features)  
5. [When to Use IdentityHashMap?](#when-to-use-identityhashmap)  
6. [Methods and Their Complexities](#methods-and-their-complexities)  
7. [Code Examples](#code-examples)  
8. [Difference Between IdentityHashMap and HashMap](#difference-between-identityhashmap-and-hashmap)  
9. [FAQs (Interview Questions)](#faqs-interview-questions)  
10. [Further Reading](#further-reading)  

---

## **1️⃣ Introduction**  

`IdentityHashMap<K, V>` is a special implementation of the **Map** interface in Java that compares keys **using reference equality (`==`) instead of logical equality (`equals()`)**.  

🔹 Unlike `HashMap`, which considers two keys **equal** if `key1.equals(key2)`, an `IdentityHashMap` only considers them equal if **both references point to the same object (`key1 == key2`)**.  

### **📌 Example Use Case**  
Imagine storing objects where **distinct identity is important, even if they are logically equal** (e.g., caching proxies or tracking object identity).  

---

## **2️⃣ Hierarchy**  

```
java.lang.Object  
│  
└── java.util.AbstractMap<K, V>  (Implements Map Interface)  
    │  
    ├── java.util.IdentityHashMap<K, V>  (Uses == for key comparison)  
    │  
    ├── java.util.HashMap<K, V>  
    │   ├── LinkedHashMap<K, V>  
    │  
    ├── java.util.WeakHashMap<K, V>  
    ├── java.util.EnumMap<K, V>  
```

### **Interfaces Implemented by IdentityHashMap**  
✅ `Map<K, V>` → Defines key-value mappings.  
✅ `Cloneable` → Allows cloning of IdentityHashMap.  
✅ `Serializable` → Enables serialization of IdentityHashMap.  

---

## **3️⃣ How IdentityHashMap Works?**  

Unlike `HashMap`, `IdentityHashMap` compares keys **using reference equality (`==`)**, not logical equality (`equals()`).  

📌 **Key Differences in Working:**  
- If two different `String` objects hold the same value, `HashMap` treats them as equal, but `IdentityHashMap` does not.  
- `IdentityHashMap` uses **open-addressing** instead of separate chaining, reducing memory overhead.  
- No predictable order of elements.  

🔹 **Example:**
```java
import java.util.*;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> identityMap = new IdentityHashMap<>();

        String key1 = new String("A");
        String key2 = new String("A"); // Different object with the same value

        hashMap.put(key1, "HashMapValue");
        hashMap.put(key2, "HashMapValue");

        identityMap.put(key1, "IdentityMapValue");
        identityMap.put(key2, "IdentityMapValue");

        System.out.println("HashMap Size: " + hashMap.size());       // Output: 1
        System.out.println("IdentityHashMap Size: " + identityMap.size()); // Output: 2
    }
}
```

🚀 **In `IdentityHashMap`, `key1` and `key2` are different because they are different objects in memory!**

---

## **4️⃣ Key Features of IdentityHashMap**  
🔹 **Compares keys using `==`, not `equals()`**  
🔹 **No predictable order** (unlike `LinkedHashMap`)  
🔹 **Faster lookups for object identity comparisons**  
🔹 **Uses open-addressing for storing elements**  
🔹 **Not thread-safe** (use `Collections.synchronizedMap()` for thread safety)  

---

## **5️⃣ When to Use IdentityHashMap?**  

✅ When **tracking object identity** is crucial (e.g., caching or proxy handling).  
✅ When using **keys that are dynamically created objects** instead of static literals.  
✅ When implementing **serialization-sensitive mappings** where object identity matters.  
✅ **NOT** when `equals()`-based comparison is required (use `HashMap` instead).  

---

## **6️⃣ Methods and Their Complexities**  

| **Method**              | **Description**                              | **Time Complexity** |
|-------------------------|----------------------------------------------|---------------------|
| `put(K key, V value)`   | Adds a key-value pair                        | O(1) (amortized)   |
| `get(Object key)`       | Retrieves a value for a key                  | O(1) (amortized)   |
| `remove(Object key)`    | Removes a key-value pair                     | O(1) (amortized)   |
| `containsKey(Object k)` | Checks if a key exists                        | O(1)               |
| `containsValue(Object v)` | Checks if a value exists                    | O(n)               |
| `size()`               | Returns the number of elements               | O(1)               |
| `clear()`              | Removes all elements                         | O(1)               |

---

## **7️⃣ Code Examples**  

### **Creating an IdentityHashMap**
```java
import java.util.*;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        IdentityHashMap<Integer, String> map = new IdentityHashMap<>();

        Integer key1 = new Integer(10);
        Integer key2 = new Integer(10); // Different object with the same value

        map.put(key1, "Object 1");
        map.put(key2, "Object 2");

        System.out.println("Size of IdentityHashMap: " + map.size()); // Output: 2
    }
}
```

---

## **8️⃣ Difference Between IdentityHashMap and HashMap**  

| Feature               | `IdentityHashMap`                         | `HashMap`                         |
|----------------------|---------------------------------|---------------------------------|
| Key Comparison      | Uses `==` (reference equality)  | Uses `.equals()` (value equality) |
| Performance        | Faster when tracking identity   | Slower if `.equals()` is costly |
| Order              | No predictable order            | No predictable order            |
| Suitable for      | Object identity-based caching   | General key-value storage       |

---

## **9️⃣ FAQs (Interview Questions)**  

❓ **Q1: What is the primary difference between IdentityHashMap and HashMap?**  
✅ **IdentityHashMap** compares keys **using `==`** (reference equality), while **HashMap** uses **`.equals()`** for comparison.  

❓ **Q2: Can we store `null` keys in an IdentityHashMap?**  
✅ Yes, `IdentityHashMap` **allows one `null` key**, just like `HashMap`.  

❓ **Q3: Is IdentityHashMap synchronized?**  
❌ No, it is **not thread-safe**. You can wrap it using `Collections.synchronizedMap()`.  

❓ **Q4: How does IdentityHashMap store elements internally?**  
✅ It uses **open-addressing** instead of separate chaining (like HashMap).  

---

## **🔗 10️⃣ Further Reading**  

📌 [Official Java Docs: IdentityHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/IdentityHashMap.html)  

---
