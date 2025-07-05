

# **NavigableSet Interface in Java**  

## **Introduction**  

### **What is `NavigableSet`?**  
`NavigableSet<E>` is a **subinterface of `SortedSet<E>`** that provides **navigation methods** to traverse elements in both **ascending and descending order**. It enhances `SortedSet` with additional capabilities such as:  

📌 **Key Features:**  
✔ **Bidirectional navigation** – Access elements in **both ascending & descending order**.  
✔ **Extended range queries** – Methods like `ceiling()`, `floor()`, `higher()`, `lower()`.  
✔ **Subsets with precise control** – `headSet()`, `tailSet()`, `subSet()` with inclusive/exclusive options.  
✔ **Descending order support** – `descendingSet()` returns a reverse-ordered view.  
✔ **Main Implementation: `TreeSet<E>`** – Uses a **Red-Black Tree** internally.  

📌 **Example Implementations:**  
- `TreeSet<E>` (Most commonly used implementation)  

---

## **Hierarchy of `NavigableSet`**  

```
java.lang.Iterable (Interface)
│
├── java.util.Collection (Interface)
│   ├── java.util.Set (Interface)
│   │   ├── java.util.SortedSet<E> (Interface)
│   │   │   ├── java.util.NavigableSet<E> (Interface)  ✅ (Our Focus!)
│   │   │   │   ├── java.util.TreeSet<E> (Class)
```

### **Key Takeaways:**  
- `NavigableSet<E>` **extends `SortedSet<E>`** and provides **additional navigation methods**.  
- `TreeSet<E>` **implements `NavigableSet<E>`** and uses a **Red-Black Tree**.  

---

## **Key Features of `NavigableSet`** 🚀  

✅ **Maintains Sorted Order** – Elements are arranged in **ascending order** by default.  
✅ **Bidirectional Navigation** – You can access elements in **ascending or descending order**.  
✅ **Floor & Ceiling Methods** – Get the closest lower/higher elements efficiently.  
✅ **Inclusive/Exclusive Range Queries** – Extended versions of `headSet()`, `tailSet()`, and `subSet()`.  
✅ **`TreeSet` is the Primary Implementation** – Uses a **Red-Black Tree**, ensuring `O(log n)` operations.  

---

## **How `NavigableSet` Works Internally? 🛠️**  

### **1. Uses `TreeSet` Internally**  
- `NavigableSet` is **implemented by `TreeSet`**, which is based on a **Red-Black Tree**.  
- Red-Black Trees ensure **logarithmic (`O(log n)`) time complexity** for insertion, deletion, and search.  

### **2. Extended Range Queries**  
- **`floor(E e)`** – Returns **largest element ≤ e**.  
- **`ceiling(E e)`** – Returns **smallest element ≥ e**.  
- **`lower(E e)`** – Returns **largest element < e**.  
- **`higher(E e)`** – Returns **smallest element > e**.  

### **3. Descending Order View**  
- `descendingSet()` returns a **reverse-ordered** view of the set.  
- `descendingIterator()` iterates elements **in descending order**.  

---

## **Creating and Using a `NavigableSet`**  

### **Example 1: Basic Usage of `NavigableSet` (`TreeSet`)**  
```java
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original Set: " + numbers); // [10, 20, 30, 40]
        System.out.println("Descending Set: " + numbers.descendingSet()); // [40, 30, 20, 10]
    }
}
```

---

### **Example 2: Using Floor, Ceiling, Higher, and Lower Methods**  
```java
import java.util.*;

public class NavigableSetOperations {
    public static void main(String[] args) {
        NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("Set: " + set);
        System.out.println("Floor (≤ 35): " + set.floor(35));  // 30
        System.out.println("Ceiling (≥ 35): " + set.ceiling(35));  // 40
        System.out.println("Lower (< 30): " + set.lower(30));  // 20
        System.out.println("Higher (> 30): " + set.higher(30));  // 40
    }
}
```

---

## **Important Methods in `NavigableSet`**  

| Method | Description |
|--------|------------|
| `floor(E e)` | Returns the greatest element ≤ `e`, or `null` if none exists. |
| `ceiling(E e)` | Returns the smallest element ≥ `e`, or `null` if none exists. |
| `lower(E e)` | Returns the greatest element < `e`, or `null` if none exists. |
| `higher(E e)` | Returns the smallest element > `e`, or `null` if none exists. |
| `pollFirst()` | Retrieves and removes the **first (smallest) element**. |
| `pollLast()` | Retrieves and removes the **last (largest) element**. |
| `descendingSet()` | Returns a reverse-ordered view of the set. |
| `descendingIterator()` | Returns an iterator traversing elements in descending order. |
| `headSet(E toElement, boolean inclusive)` | Returns a view of elements **less than** `toElement`. |
| `tailSet(E fromElement, boolean inclusive)` | Returns a view of elements **greater than or equal to** `fromElement`. |
| `subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)` | Returns a view of elements **between specified bounds** with control over inclusivity. |

---

## **Example: Polling First and Last Elements**  

```java
import java.util.*;

public class NavigableSetPolling {
    public static void main(String[] args) {
        NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40));

        System.out.println("Original Set: " + set);
        System.out.println("Poll First (Smallest): " + set.pollFirst());  // 10
        System.out.println("Poll Last (Largest): " + set.pollLast());  // 40
        System.out.println("Remaining Set: " + set);  // [20, 30]
    }
}
```

---

## **Comparison of `NavigableSet` with Other Set Implementations**  

| Feature | `NavigableSet` | `SortedSet` | `HashSet` |
|---------|--------------|------------|---------|
| Order Maintained? | ✅ Sorted Order | ✅ Sorted Order | ❌ No |
| Allows Bidirectional Navigation? | ✅ Yes | ❌ No | ❌ No |
| Provides Floor, Ceiling, Higher, Lower? | ✅ Yes | ❌ No | ❌ No |
| Implementation | `TreeSet` | `TreeSet` | `HashSet` |
| Performance (`add/remove/search`) | `O(log n)` | `O(log n)` | `O(1)` |

---

## **Summary** 🎯  
- `NavigableSet<E>` extends `SortedSet<E>` and provides **advanced navigation methods**.  
- `TreeSet<E>` is the **main implementation**, using a **Red-Black Tree** for efficient storage.  
- Supports **floor, ceiling, higher, and lower** methods for range-based retrieval.  
- Allows **descending order traversal** using `descendingSet()`.  
- Performance is **`O(log n)`** for insertion, deletion, and search.  

---

## **FAQ (Frequently Asked Questions) 🙋‍♂️**  

### **Q1: How does `NavigableSet` differ from `SortedSet`?**  
`NavigableSet` adds **advanced navigation methods** like `floor()`, `ceiling()`, `higher()`, and `lower()`, which `SortedSet` does not have.  

### **Q2: Can `NavigableSet` store `null` values?**  
No, `TreeSet` (which implements `NavigableSet`) **does not allow `null` elements**.  

🔥 **Now you have a complete understanding of `NavigableSet` in Java!** 🚀 Let me know if you need more details. 😊