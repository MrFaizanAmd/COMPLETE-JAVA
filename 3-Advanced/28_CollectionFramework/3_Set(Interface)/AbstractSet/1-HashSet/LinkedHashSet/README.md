

# **LinkedHashSet in Java**  

## **Introduction**  

### **What is `LinkedHashSet`?**  
`LinkedHashSet<E>` is a **Set implementation** that maintains **insertion order** while ensuring **uniqueness** of elements. It is a subclass of `HashSet` but **preserves the order of elements** based on their insertion sequence.  

### **Why Use `LinkedHashSet`?**  
✔ **Maintains insertion order** – Unlike `HashSet`, which is unordered.  
✔ **Ensures uniqueness** – No duplicate elements allowed.  
✔ **Fast operations** – `O(1)` average time complexity for `add()`, `remove()`, and `contains()`.  
✔ **Uses a combination of HashMap + Linked List** – For efficiency and order retention.  
✔ **Allows one `null` value** – But no duplicates.  

📌 **Note:** `LinkedHashSet` is part of the `java.util` package.  

---

## **Hierarchy of `LinkedHashSet`**  

```
java.lang.Iterable (Interface)
│
├── java.util.Collection (Interface)
│   ├── java.util.Set (Interface)
│   │   ├── java.util.AbstractSet<E> (Abstract Class)
│   │   │   ├── java.util.HashSet<E> (Class)
│   │   │   │   ├── java.util.LinkedHashSet<E> (Class) ✅ (Our Focus!)
```

### **Key Takeaways:**  
- `LinkedHashSet<E>` **extends `HashSet<E>`** and **inherits `Set<E>` interface**.  
- Uses **`LinkedHashMap` internally** to store unique elements in order.  

---

## **Key Features of `LinkedHashSet` 🚀**  
✅ **Ensures uniqueness** – No duplicate elements allowed.  
✅ **Maintains insertion order** – Unlike `HashSet`, which is unordered.  
✅ **Uses a Linked List + HashMap** – Provides **fast lookup** and **ordered storage**.  
✅ **Allows one `null` value** – But no duplicates.  
✅ **Performance is close to `HashSet`** – Slightly slower due to order maintenance.  

---

## **How `LinkedHashSet` Works Internally? 🛠️**  

### **1. `LinkedHashMap` as the Internal Data Structure**  
- `LinkedHashSet` extends `HashSet`, but internally it **uses `LinkedHashMap`** instead of `HashMap`.  
- The `LinkedHashMap` maintains **a doubly linked list** of all entries to preserve insertion order.  

```java
private transient LinkedHashMap<E, Object> map;
private static final Object PRESENT = new Object();
```

### **2. How Elements are Stored in `LinkedHashSet`?**  
- When you add an element using `add(E e)`, it actually calls:  
```java
map.put(e, PRESENT);
```
- The **key** is the element, and the **value** is a dummy object (`PRESENT`).  

### **3. How Insertion Order is Maintained?**  
- Unlike `HashSet`, `LinkedHashMap` **uses a linked list** to connect all elements in their insertion order.  
- When iterating over a `LinkedHashSet`, elements appear **in the order they were inserted**.  

### **4. Performance Comparison**  
- **Adding, Removing, and Searching elements** – `O(1)` (same as `HashSet` in most cases).  
- **Iterating elements** – `O(n)`, but **faster than `TreeSet`** since no sorting is involved.  

---

## **Creating and Using a `LinkedHashSet`**  

### **Example 1: Basic Usage**  
```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java");  // Duplicate, ignored
        set.add(null);    // Allowed

        System.out.println(set); // Output: [Java, Python, C++, null] (Maintains Insertion Order)
    }
}
```

---

### **Example 2: Iterating Over a `LinkedHashSet`**  
```java
import java.util.*;

public class IterateLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>(Arrays.asList(10, 20, 30, 40, 50));

        // Using Iterator
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using Enhanced For-Loop
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

---

## **When to Use `LinkedHashSet`?** ✅  
✔ When **fast lookup, insertion, and deletion** is required.  
✔ When **order of elements must be maintained**.  
✔ When **duplicates need to be eliminated automatically**.  

## **When NOT to Use `LinkedHashSet`?** ❌  
✘ If **sorting of elements is needed**, use `TreeSet`.  
✘ If **random access (index-based access)** is needed, use `ArrayList`.  
✘ If **high performance is a priority**, `HashSet` may be slightly faster.  

---

## **`LinkedHashSet` vs Other Set Implementations**  

| Feature | `LinkedHashSet` | `HashSet` | `TreeSet` |
|---------|---------------|----------|-----------|
| Allows Duplicates? | ❌ No | ❌ No | ❌ No |
| Maintains Order? | ✅ Yes (Insertion Order) | ❌ No | ✅ Yes (Sorted Order) |
| Allows `null`? | ✅ Yes (1 `null`) | ✅ Yes (1 `null`) | ❌ No |
| Performance (Add/Remove) | ✅ `O(1)` | ✅ `O(1)` | ❌ `O(log n)` |
| Performance (Search) | ✅ `O(1)` | ✅ `O(1)` | ❌ `O(log n)` |

---

## **Common Methods in `LinkedHashSet`**  

| Method | Description |
|--------|------------|
| `add(E e)` | Adds an element if it is not already present. |
| `remove(Object o)` | Removes an element from the set. |
| `contains(Object o)` | Checks if an element is present in the set. |
| `size()` | Returns the number of elements in the set. |
| `clear()` | Removes all elements from the set. |
| `isEmpty()` | Checks if the set is empty. |
| `iterator()` | Returns an iterator for the set. |

---

## **Summary** 🎯  
- `LinkedHashSet` is a **Set implementation** that maintains **insertion order**.  
- Internally, it uses a **`LinkedHashMap`**, which maintains a **doubly linked list** of entries.  
- **Ensures uniqueness** of elements, just like `HashSet`.  
- **Maintains order of insertion**, unlike `HashSet`.  
- **Performance is close to `HashSet`**, but slightly slower due to order maintenance.  

---

## **FAQ (Frequently Asked Questions) 🙋‍♂️**  

### **Q1: How does `LinkedHashSet` ensure uniqueness?**  
`LinkedHashSet` relies on `LinkedHashMap`, which does **not allow duplicate keys**.  

### **Q2: What happens when I insert a duplicate in `LinkedHashSet`?**  
It **overwrites** the existing entry, meaning the new duplicate is **ignored**.  

### **Q3: Can `LinkedHashSet` store `null` values?**  
Yes, but only **one `null`** value is allowed.  

### **Q4: Why is `LinkedHashSet` slower than `HashSet`?**  
Because `LinkedHashSet` **maintains insertion order**, which requires additional **linked list maintenance**.  

---

🔥 **Now you have a complete understanding of `LinkedHashSet` in Java!** 🚀 Let me know if you need more details. 😊