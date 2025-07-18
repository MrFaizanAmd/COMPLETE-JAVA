
# **ConcurrentSkipListMap in Java**  

## **Introduction**  
`ConcurrentSkipListMap` is a thread-safe, sorted, and non-blocking implementation of **NavigableMap** that supports concurrent access. Unlike `TreeMap`, which uses a **Red-Black Tree**, it is implemented using a **Skip List**, allowing efficient operations in a concurrent environment.  

✅ **Key Features:**  
- **Thread-safe** without explicit locking  
- **Sorted** based on natural ordering or a custom comparator  
- **Non-blocking concurrent access**  
- **Higher scalability** than `TreeMap` for multi-threaded applications  
- **Performance:** O(log N) for insertion, deletion, and lookup  

---

## **Hierarchy View**  

```
Map [Interface]
│
├── NavigableMap [Interface]
│   ├── SortedMap [Interface]
│   │   ├── TreeMap
│   │   ├── ConcurrentSkipListMap  <-- (This class)
│   │   └── ConcurrentNavigableMap [Interface]
│
└── AbstractMap
```

---

## **How `ConcurrentSkipListMap` Works Internally**  

### **1. Data Structure: Skip List**  
- `ConcurrentSkipListMap` is implemented using **Skip Lists**, which consist of multiple levels of linked lists.
- Each key appears at **random levels**, making lookup and modification operations **fast and scalable**.
- Unlike `TreeMap`, there is **no need for tree rebalancing**, making it **efficient in concurrent environments**.  

### **2. Thread-Safety & Concurrency**  
- `ConcurrentSkipListMap` **does not use explicit locks**, allowing multiple threads to read and modify the map simultaneously.
- Uses **CAS (Compare-And-Swap)** operations to maintain consistency.
- Supports **higher concurrency** than `TreeMap`, which requires global locks for modification.  

### **3. Sorting Mechanism**  
- Maintains keys in **sorted order** using **natural ordering** (`Comparable`) or a custom `Comparator`.

---

## **Constructors**  

```java
// Default constructor (natural ordering)
ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

// Using custom Comparator
ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>(Comparator.reverseOrder());
```

---

## **Common Methods & Their Complexities**  

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `put(K key, V value)` | Inserts a key-value pair | **O(log N)** |
| `get(K key)` | Retrieves a value by key | **O(log N)** |
| `remove(K key)` | Removes a key-value pair | **O(log N)** |
| `containsKey(K key)` | Checks if a key exists | **O(log N)** |
| `pollFirstEntry()` | Retrieves and removes the first entry | **O(log N)** |
| `pollLastEntry()` | Retrieves and removes the last entry | **O(log N)** |
| `firstEntry()` | Returns the first key-value pair | **O(1)** |
| `lastEntry()` | Returns the last key-value pair | **O(1)** |

---

## **Example Usage**  

### **1. Basic Operations**  

```java
import java.util.concurrent.*;

public class SkipListMapExample {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        // Inserting elements
        map.put(3, "Apple");
        map.put(1, "Banana");
        map.put(2, "Mango");

        // Retrieving values
        System.out.println("Key 2: " + map.get(2)); // Output: Mango

        // Printing map (sorted order)
        System.out.println(map); // {1=Banana, 2=Mango, 3=Apple}
    }
}
```

### **2. Concurrent Access Example**  

```java
import java.util.concurrent.*;

public class ConcurrentAccess {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                map.put(i, "Value " + i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 6; i <= 10; i++) {
                map.put(i, "Value " + i);
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Map: " + map);
    }
}
```

---

## **When to Use `ConcurrentSkipListMap`?**  

| **Use Case** | **Why?** |
|-------------|---------|
| **Multi-threaded applications** | Allows concurrent access without locks |
| **Sorted data retrieval** | Always maintains sorted order |
| **Real-time data processing** | O(log N) performance for fast lookups |
| **Alternative to `TreeMap` in concurrent environments** | No need for explicit synchronization |

---

## **Difference Between `TreeMap` & `ConcurrentSkipListMap`**  

| Feature | `TreeMap` | `ConcurrentSkipListMap` |
|---------|----------|----------------------|
| **Thread-Safety** | ❌ No (requires external synchronization) | ✅ Yes (internally synchronized) |
| **Sorting** | ✅ Yes | ✅ Yes |
| **Data Structure** | Red-Black Tree | Skip List |
| **Locking Mechanism** | Global Locking | Non-blocking, CAS-based |
| **Performance in Concurrent Environment** | Slower due to locks | Faster, scalable |

---

## **Advantages & Disadvantages**  

✅ **Advantages:**  
✔ Thread-safe without external synchronization  
✔ Maintains elements in sorted order  
✔ Scales better than `TreeMap` for concurrent applications  
✔ Non-blocking operations ensure efficiency  

❌ **Disadvantages:**  
✘ Slightly higher memory consumption than `TreeMap` due to multiple levels of Skip List  
✘ Overhead in maintaining multiple pointers in the Skip List  

---

## **FAQs**  

### **1. What is the difference between `ConcurrentSkipListMap` and `ConcurrentHashMap`?**  
- `ConcurrentSkipListMap` maintains **sorted order**, while `ConcurrentHashMap` does not.
- `ConcurrentSkipListMap` is better for **range-based queries**, while `ConcurrentHashMap` is better for **fast key-value lookups**.

### **2. Is `ConcurrentSkipListMap` faster than `TreeMap`?**  
- In **single-threaded scenarios**, `TreeMap` is slightly faster.
- In **multi-threaded scenarios**, `ConcurrentSkipListMap` is better due to its non-blocking design.

### **3. How does `ConcurrentSkipListMap` maintain concurrency?**  
- It uses **CAS (Compare-And-Swap)** and **non-blocking algorithms** instead of explicit locks.

---

## **Further Learning & Resources**  
- [Java Official Documentation - ConcurrentSkipListMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ConcurrentSkipListMap.html)  
- **Topics to Master:**  
  - Understanding **Skip List data structure**  
  - Performance comparison with **TreeMap and ConcurrentHashMap**  
  - Advanced operations like `subMap()`, `higherEntry()`, etc.  

---

## **Practice Problems**  
👉 **Try implementing a concurrent banking system where multiple threads update account balances using `ConcurrentSkipListMap`.**  

---

