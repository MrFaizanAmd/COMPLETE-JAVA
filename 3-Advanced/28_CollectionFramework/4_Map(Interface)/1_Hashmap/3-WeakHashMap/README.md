# **WeakHashMap in Java**

## **Table of Contents**  
1. [Introduction](#introduction)  
2. [Hierarchy](#hierarchy)  
3. [How WeakHashMap Works?](#how-weakhashmap-works)  
4. [Key Features](#key-features)  
5. [When to Use WeakHashMap?](#when-to-use-weakhashmap)  
6. [Methods and Their Complexities](#methods-and-their-complexities)  
7. [Code Examples](#code-examples)  
8. [Difference Between WeakHashMap and HashMap](#difference-between-weakhashmap-and-hashmap)  
9. [FAQs (Interview Questions)](#faqs-interview-questions)  
10. [Further Reading](#further-reading)  

---

## **1️⃣ Introduction**  

`WeakHashMap<K, V>` is a **specialized Map implementation** in Java that **uses weak references for keys**.  

When a key is **no longer referenced** anywhere else in the application, the Java **Garbage Collector (GC)** automatically removes the entry from the `WeakHashMap`.  

### **📌 Key Use Case**  
It is commonly used for **caching** and **storing metadata**, where entries should be **automatically removed when they are no longer in use**.

---

## **2️⃣ Hierarchy**  
```
java.lang.Object  
│  
└── java.util.AbstractMap<K, V>  (Implements Map Interface)  
    │  
    ├── java.util.WeakHashMap<K, V>  (Uses Weak References for keys)  
    │  
    ├── java.util.HashMap<K, V>  
    │   ├── LinkedHashMap<K, V>  
    │  
    ├── java.util.IdentityHashMap<K, V>  
    ├── java.util.EnumMap<K, V>  
```

### **Interfaces Implemented by WeakHashMap**  
✅ `Map<K, V>` → Defines key-value mappings.  
✅ `Serializable` → Enables serialization of WeakHashMap.  

---

## **3️⃣ How WeakHashMap Works?**  

In `WeakHashMap`, the keys are **held using weak references**, meaning that if no other strong references exist for a key, **it becomes eligible for garbage collection**.  

When GC removes a weakly referenced key, the corresponding entry in the `WeakHashMap` is also **removed automatically**.

### **📌 Example**:
```java
import java.util.*;

public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object key = new Object(); // Strong reference

        weakMap.put(key, "WeakHashMap Value");
        System.out.println("Before GC: " + weakMap);

        key = null; // Remove strong reference
        System.gc(); // Force garbage collection

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("After GC: " + weakMap);
    }
}
```

**Output:**  
```
Before GC: {java.lang.Object@7f31245a=WeakHashMap Value}
After GC: {}
```

🔥 **Explanation:** The entry is removed automatically after GC since the key had no strong reference.

---

## **4️⃣ Key Features**  
✅ Uses **weak references** for keys.  
✅ Entries are automatically removed when the key is garbage collected.  
✅ Suitable for **cache implementations**.  
✅ **Thread-safe** but not synchronized (requires external synchronization for multi-threading).  

---

## **5️⃣ When to Use WeakHashMap?**  
- **Caching solutions** (e.g., store recently accessed data).  
- **Memory-sensitive applications** (entries automatically removed when keys are unused).  
- **Avoiding memory leaks** in applications using **temporary mappings**.  

---

## **6️⃣ Methods and Their Complexities**  

| Method | Description | Time Complexity |
|--------|-------------|----------------|
| `put(K key, V value)` | Adds key-value pair | O(1) |
| `get(Object key)` | Retrieves value by key | O(1) |
| `remove(Object key)` | Removes an entry | O(1) |
| `containsKey(Object key)` | Checks if key exists | O(1) |
| `size()` | Returns number of entries | O(1) |

---

## **7️⃣ Code Examples**  
### **Basic Usage**
```java
import java.util.*;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<>();
        String key1 = new String("A");
        String key2 = new String("B");
        weakMap.put(key1, 100);
        weakMap.put(key2, 200);
        
        System.out.println("Before GC: " + weakMap);
        
        key1 = null;
        System.gc();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("After GC: " + weakMap);
    }
}
```

---

## **8️⃣ Difference Between WeakHashMap and HashMap**  

| Feature | WeakHashMap | HashMap |
|---------|------------|---------|
| **Key Storage** | Weak References | Strong References |
| **Garbage Collection** | Keys removed automatically | Keys not removed automatically |
| **Use Case** | Caching, Memory-sensitive operations | General-purpose key-value storage |
| **Performance** | Slightly slower due to GC handling | Faster |

---

## **9️⃣ FAQs (Interview Questions)**  

### **Q1: What is the purpose of WeakHashMap?**  
WeakHashMap is used to store key-value pairs where keys should be **automatically removed** when they are **no longer in use**, making it useful for **caching and memory optimization**.

### **Q2: How does WeakHashMap prevent memory leaks?**  
Since keys in WeakHashMap are stored using **weak references**, they are automatically **garbage collected** when no strong references exist. This ensures that objects do not remain in memory unnecessarily.

### **Q3: How does WeakHashMap differ from HashMap?**  
Unlike HashMap, **WeakHashMap does not prevent keys from being garbage collected**, making it ideal for memory-sensitive applications.

### **Q4: Is WeakHashMap thread-safe?**  
No, WeakHashMap is **not synchronized**. If multiple threads modify it concurrently, external synchronization is required.

### **Q5: Can we use WeakHashMap in a multithreaded environment?**  
Yes, but it requires **manual synchronization** using `Collections.synchronizedMap(new WeakHashMap<>())`.

---

## **🔗 10. Further Reading**  
📖 [Official Java Docs - WeakHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/WeakHashMap.html)

