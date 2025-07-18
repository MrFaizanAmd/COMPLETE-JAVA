# **EnumMap in Java 🚀**

## **Introduction**

### **What is EnumMap?**
`EnumMap` is a specialized `Map` implementation designed for use with `enum` keys. It is part of the `java.util` package and provides an efficient way to map enum constants to values.

### **Why is EnumMap Important?**
✔ **Optimized for Enums** – Specifically designed to handle enum keys efficiently.  
✔ **Fast & Memory Efficient** – Uses an internal array instead of a hash table, making it faster than `HashMap` when used with enums.  
✔ **Maintains Natural Order** – Keys are stored in the order of their enum declaration.  
✔ **Null Keys Not Allowed** – Prevents `null` keys, ensuring safety.  

### **Real-life Analogy** 📌
Imagine a **traffic light system** where each light (RED, YELLOW, GREEN) represents a different action. Using an `EnumMap`, we can efficiently map each light to its respective action without the overhead of a general-purpose `HashMap`.

---

## **Hierarchy of EnumMap**

```
Iterable (Interface)
│
├── Collection (Interface)
│   ├── Map (Interface)
│   │   ├── AbstractMap (Abstract Class)
│   │   │   ├── EnumMap (Implementation) ✅ (Our Focus!)
```

### **Key Points:**
- `EnumMap` is a subclass of `AbstractMap` and implements `Map`.
- It is **not synchronized** by default.
- Uses an **array-based** internal structure for performance efficiency.

---

## **Key Features of EnumMap 🚀**

✅ **Optimized Storage** – Uses an array internally, making lookups and inserts very fast.  
✅ **Preserves Enum Order** – Maintains the order of keys as defined in the enum.  
✅ **Prevents Null Keys** – Unlike `HashMap`, `EnumMap` doesn’t allow `null` as a key.  
✅ **Efficient Iteration** – Iterates quickly compared to other map implementations.  
✅ **Not Thread-Safe** – Requires external synchronization for concurrent access.

---

## **How EnumMap Works Internally? 🛠️**

1. **Uses an Internal Array** – Each enum constant is mapped to an index in an array.
2. **No Hashing Needed** – Unlike `HashMap`, it does not compute hash codes, making lookups O(1).
3. **Fixed Size** – The array size is fixed to the number of enum constants.
4. **Order Maintained** – The order of elements is as per enum declaration.

---

## **Creating an EnumMap in Java**

### **Example 1: Basic Usage**  
```java
import java.util.*;

enum TrafficLight {
    RED, YELLOW, GREEN;
}

public class EnumMapExample {
    public static void main(String[] args) {
        EnumMap<TrafficLight, String> signals = new EnumMap<>(TrafficLight.class);
        
        signals.put(TrafficLight.RED, "Stop");
        signals.put(TrafficLight.YELLOW, "Get Ready");
        signals.put(TrafficLight.GREEN, "Go");
        
        System.out.println(signals);
    }
}
```

### **Output:**
```
{RED=Stop, YELLOW=Get Ready, GREEN=Go}
```

📌 **Note:** Enum keys are ordered based on their natural declaration order.

---

## **When to Use EnumMap?** ✅
✔ When working with **fixed sets of keys** that are enums.  
✔ When **performance is crucial**, as `EnumMap` is faster than `HashMap` for enums.  
✔ When maintaining **insertion order** of enum keys is important.  
✔ When **type safety** is required to avoid incorrect keys.

## **When NOT to Use EnumMap?** ❌
✘ If you need to use **non-enum keys**.  
✘ If you require **thread safety** (without external synchronization).  
✘ If null keys are required (use `HashMap` instead).  

---

## **EnumMap vs Other Maps**

| Feature | EnumMap | HashMap | TreeMap |
|---------|--------|---------|---------|
| Optimized for Enums | ✅ Yes | ❌ No | ❌ No |
| Maintains Order | ✅ Yes (Enum order) | ❌ No (Hash order) | ✅ Yes (Sorted order) |
| Allows Null Keys | ❌ No | ✅ Yes | ✅ Yes |
| Thread-Safe | ❌ No | ❌ No | ❌ No |
| Performance | 🚀 Fastest | ⚡ Medium | 🐢 Slow |

---

## **Common Methods in EnumMap**  

| Method | Description |
|--------|------------|
| `put(K key, V value)` | Adds a key-value pair to the EnumMap. |
| `get(Object key)` | Retrieves the value associated with a key. |
| `remove(Object key)` | Removes a key-value pair. |
| `containsKey(Object key)` | Checks if a key exists. |
| `containsValue(Object value)` | Checks if a value exists. |
| `keySet()` | Returns a set of keys. |
| `size()` | Returns the number of key-value mappings. |

---

## **Summary** 🎯
- `EnumMap` is a highly efficient **specialized map** for enum keys.  
- Uses an **internal array** for fast lookups (O(1) time complexity).  
- **Maintains natural order** of enums and prevents `null` keys.  
- **Best suited** for applications dealing with **fixed sets of keys**.  

---

## **FAQs** ❓

### **1. Can EnumMap store null keys?**
No, `EnumMap` does not allow `null` keys. Attempting to insert a `null` key will throw a `NullPointerException`.

### **2. Is EnumMap synchronized?**
No, `EnumMap` is **not synchronized**. If multiple threads modify it concurrently, external synchronization is required.

### **3. How is EnumMap different from HashMap?**
Unlike `HashMap`, `EnumMap` uses an **array-based** storage mechanism, making it faster and more memory-efficient for enum keys.

### **4. Does EnumMap maintain insertion order?**
Yes, it maintains the order of keys as they appear in the enum declaration.

### **5. Can EnumMap be used with custom classes?**
No, `EnumMap` can only be used with **enum types** as keys.

---

🔥 **With this guide, you now have a clear understanding of EnumMap!** 🚀 Let me know if you need any refinements! 😊