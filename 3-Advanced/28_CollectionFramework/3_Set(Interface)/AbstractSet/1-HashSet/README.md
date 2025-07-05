
# **HashSet in Java**

## **Introduction**
### **What is `HashSet`?**
`HashSet<E>` is a **high-performance, unordered collection** in Java that stores **unique elements** using a **hashing mechanism**.

### **Why Use `HashSet`?**
✔ **No duplicates** – Automatically ensures uniqueness.  
✔ **Fast operations** – `O(1)` average time complexity for add, remove, and search.  
✔ **Efficient memory usage** – Uses a **HashMap internally** to store elements.  
✔ **Allows `null` values** – But only one `null` is permitted.  
✔ **Unordered storage** – Does not maintain insertion order.  

📌 **Note:** `HashSet` is part of the `java.util` package.

---

## **Hierarchy of `HashSet`**
```
java.lang.Iterable (Interface)
│
├── java.util.Collection (Interface)
│   ├── java.util.Set (Interface)
│   │   ├── java.util.AbstractSet<E> (Abstract Class)
│   │   │   ├── java.util.HashSet<E> (Class) ✅ (Our Focus!)
│   │   │       ├── java.util.LinkedHashSet<E> (Class)
```

### **Key Takeaways:**
- `HashSet<E>` extends `AbstractSet<E>` and implements `Set<E>`.
- Uses **`HashMap<E, Object>` internally** for storing unique elements.

---

## **Key Features of `HashSet` 🚀**
✅ **Ensures uniqueness** – No duplicate elements allowed.  
✅ **Unordered collection** – Does **not** maintain insertion order.  
✅ **Uses hashing** – Provides **fast** `O(1)` lookup, add, and remove operations.  
✅ **Allows one `null` value** – But no duplicates.  
✅ **Backed by `HashMap`** – Uses a `HashMap<E, Object>` internally.

---

## **How `HashSet` Works Internally? 🛠️**

### **1. `HashMap` as the Internal Data Structure**
- `HashSet` **does not maintain a separate data structure**.
- Internally, it uses a **`HashMap`** with the elements as keys and a **constant placeholder object** as values.

```java
private transient HashMap<E, Object> map;
private static final Object PRESENT = new Object();
```

### **2. How Elements are Stored in `HashSet`?**
- When you add an element using `add(E e)`, it actually calls:
```java
map.put(e, PRESENT);
```
- The **key** is the element, and the **value** is a dummy object (`PRESENT`).

### **3. How Uniqueness is Ensured?**
- `HashMap` does **not allow duplicate keys**, so adding the same element twice **overwrites** the existing one.

### **4. Hashing and Buckets**
- Uses the **hashing mechanism** of `HashMap`, where elements are stored in **buckets** based on their `hashCode()`.
- **Collision Handling**: Uses **Separate Chaining with Linked Lists** (or **Balanced Trees in Java 8+** for efficiency).

### **5. Order of Elements**
- `HashSet` **does NOT maintain the insertion order**.  
- If you need **ordered elements**, use `LinkedHashSet` instead.

---

## **Creating and Using a `HashSet`**
### **Example 1: Basic Usage**
```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("Java");  // Duplicate, ignored
        set.add(null);    // Allowed

        System.out.println(set); // Output: [null, Java, Python] (Unordered)
    }
}
```

---

### **Example 2: Iterating Over a `HashSet`**
```java
import java.util.*;

public class IterateHashSet {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>(Arrays.asList(10, 20, 30, 40, 50));

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

## **When to Use `HashSet`?** ✅
✔ When **fast lookup, insertion, and deletion** is required.  
✔ When **order of elements doesn’t matter**.  
✔ When **duplicates need to be eliminated automatically**.  

## **When NOT to Use `HashSet`?** ❌
✘ If **insertion order must be preserved**, use `LinkedHashSet`.  
✘ If **sorted elements** are required, use `TreeSet`.  
✘ If **random access (index-based access)** is needed, use `ArrayList`.  

---

## **`HashSet` vs Other Set Implementations**
| Feature | `HashSet` | `LinkedHashSet` | `TreeSet` |
|---------|----------|----------------|-----------|
| Allows Duplicates? | ❌ No | ❌ No | ❌ No |
| Maintains Order? | ❌ No | ✅ Yes (Insertion Order) | ✅ Yes (Sorted Order) |
| Allows `null`? | ✅ Yes (1 `null`) | ✅ Yes (1 `null`) | ❌ No |
| Performance (Add/Remove) | ✅ `O(1)` | ✅ `O(1)` | ❌ `O(log n)` |
| Performance (Search) | ✅ `O(1)` | ✅ `O(1)` | ❌ `O(log n)` |

---

## **Common Methods in `HashSet`**
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
- `HashSet` is a **high-performance implementation** of `Set` backed by `HashMap`.
- **Ensures uniqueness** by storing elements as keys in `HashMap`.
- **Order is NOT guaranteed** since it uses hashing.
- **Average `O(1)` time complexity** for add, remove, and contains operations.
- Ideal for **fast lookups and removing duplicates**, but not for ordered elements.

---

## **FAQ (Frequently Asked Questions) 🙋‍♂️**

### **Q1: How does `HashSet` ensure uniqueness?**
`HashSet` relies on `HashMap`, which does **not allow duplicate keys**.

### **Q2: What happens when I insert a duplicate in `HashSet`?**
It **overwrites** the existing entry, meaning the new duplicate is **ignored**.

### **Q3: Can `HashSet` store `null` values?**
Yes, but only **one `null`** value is allowed.

### **Q4: Why is `HashSet` faster than `TreeSet`?**
Because `HashSet` uses **hashing** (`O(1)` lookup) while `TreeSet` uses a **Red-Black Tree (`O(log n)`)**.

### **Q5: How is `HashSet` different from `HashMap`?**
- `HashSet` is backed by `HashMap`, but only stores **keys** with a constant dummy value.
- `HashMap` stores **key-value pairs**, while `HashSet` only stores **unique keys**.

---

🔥 **Now you have a complete understanding of `HashSet` in Java!** 🚀 Let me know if you need more details. 😊