

# **TreeSet in Java**  

## **Introduction**  

### **What is `TreeSet`?**  
`TreeSet<E>` is a part of the **Java Collection Framework (JCF)** and implements the `NavigableSet<E>` and `SortedSet<E>` interfaces. It **stores elements in sorted order** and is backed by a **self-balancing Red-Black Tree**, ensuring efficient operations.  

📌 **Key Features:**  
✔ **Stores unique elements** (No duplicates).  
✔ **Maintains elements in sorted order** (Natural or custom comparator).  
✔ **Implements `NavigableSet<E>` for advanced navigation**.  
✔ **Efficient operations with `O(log n)` complexity**.  
✔ **Does not allow `null` values**.  

📌 **Common Use Cases:**  
- **Sorting elements automatically** without using `Collections.sort()`.  
- **Efficient range-based retrieval** (e.g., fetching values between a range).  
- **Maintaining a dynamically ordered dataset**.  

---

## **Hierarchy of `TreeSet`**  

```
java.lang.Iterable (Interface)
│
├── java.util.Collection (Interface)
│   ├── java.util.Set (Interface)
│   │   ├── java.util.SortedSet<E> (Interface)
│   │   │   ├── java.util.NavigableSet<E> (Interface)
│   │   │   │   ├── java.util.TreeSet<E> (Class)  ✅ (Our Focus!)
```

### **Key Takeaways:**  
- `TreeSet<E>` **implements `NavigableSet<E>`**, which extends `SortedSet<E>`.  
- Uses **Red-Black Tree**, ensuring **logarithmic (`O(log n)`) time complexity** for operations.  

---

## **How `TreeSet` Works Internally?**  

### **1. Uses a Red-Black Tree** 🌳  
- **Red-Black Tree is a self-balancing binary search tree**.  
- Guarantees **`O(log n)` complexity** for **add, remove, and search operations**.  
- Ensures balanced height, preventing worst-case linear search (`O(n)`) like in an unbalanced tree.  

### **2. Maintains Sorted Order**  
- **Natural ordering** (`Comparable<T>` implementation) if no custom comparator is provided.  
- **Custom sorting** using `Comparator<T>`.  

---

## **Creating and Using `TreeSet`**  

### **Example 1: Basic Usage of `TreeSet`**
```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        System.out.println("TreeSet: " + numbers); // [10, 20, 30, 40]
    }
}
```
**Output:**  
```
TreeSet: [10, 20, 30, 40]  // Sorted Order
```

---

## **Important Methods in `TreeSet`**  

| Method | Description |
|--------|------------|
| `add(E e)` | Adds an element while maintaining sorted order. |
| `remove(Object o)` | Removes the specified element. |
| `first()` | Returns the smallest element. |
| `last()` | Returns the largest element. |
| `headSet(E toElement, boolean inclusive)` | Returns a view of elements **less than** `toElement`. |
| `tailSet(E fromElement, boolean inclusive)` | Returns a view of elements **greater than or equal to** `fromElement`. |
| `subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)` | Returns a view of elements **between specified bounds**. |
| `floor(E e)` | Returns the greatest element ≤ `e`, or `null`. |
| `ceiling(E e)` | Returns the smallest element ≥ `e`, or `null`. |
| `lower(E e)` | Returns the greatest element < `e`, or `null`. |
| `higher(E e)` | Returns the smallest element > `e`, or `null`. |
| `descendingSet()` | Returns a reverse-ordered view of the set. |
| `pollFirst()` | Retrieves and removes the **first (smallest) element**. |
| `pollLast()` | Retrieves and removes the **last (largest) element**. |

---

## **Advanced Features in `TreeSet`**  

### **1. Custom Sorting Using `Comparator`**
```java
import java.util.*;

public class TreeSetCustomSort {
    public static void main(String[] args) {
        TreeSet<Integer> descendingOrderSet = new TreeSet<>(Comparator.reverseOrder());
        descendingOrderSet.add(10);
        descendingOrderSet.add(30);
        descendingOrderSet.add(20);

        System.out.println("Descending Order: " + descendingOrderSet);
    }
}
```
**Output:**  
```
Descending Order: [30, 20, 10]
```

---

### **2. Range Queries with `subSet()`, `headSet()`, and `tailSet()`**
```java
import java.util.*;

public class TreeSetRangeQuery {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("HeadSet (<30): " + set.headSet(30));  
        System.out.println("TailSet (≥30): " + set.tailSet(30));
        System.out.println("SubSet (20-40): " + set.subSet(20, true, 40, false));
    }
}
```
**Output:**  
```
HeadSet (<30): [10, 20]
TailSet (≥30): [30, 40, 50]
SubSet (20-40): [20, 30]
```

---

### **3. Polling First and Last Elements**
```java
import java.util.*;

public class TreeSetPolling {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(10, 20, 30, 40));

        System.out.println("Poll First: " + set.pollFirst());  
        System.out.println("Poll Last: " + set.pollLast());  
        System.out.println("Remaining Set: " + set);
    }
}
```
**Output:**  
```
Poll First: 10
Poll Last: 40
Remaining Set: [20, 30]
```

---

## **Performance Analysis of `TreeSet`**  

| Operation | Time Complexity |
|-----------|----------------|
| `add(E e)` | `O(log n)` |
| `remove(Object o)` | `O(log n)` |
| `contains(Object o)` | `O(log n)` |
| `first()`, `last()` | `O(1)` |
| `floor()`, `ceiling()` | `O(log n)` |

---

## **Comparison of `TreeSet` with Other Set Implementations**  

| Feature | `TreeSet` | `HashSet` | `LinkedHashSet` |
|---------|---------|---------|---------|
| Order Maintained? | ✅ Sorted | ❌ No Order | ✅ Insertion Order |
| Allows `null` values? | ❌ No | ✅ Yes | ✅ Yes |
| Performance (`add/remove/search`) | `O(log n)` | `O(1)` | `O(1)` |
| Implements `NavigableSet`? | ✅ Yes | ❌ No | ❌ No |

---

## **FAQ (Frequently Asked Questions)**  

### **Q1: Does `TreeSet` allow duplicate elements?**  
No, `TreeSet` **does not allow duplicates**, just like `HashSet`.  

### **Q2: Can `TreeSet` store `null` elements?**  
No, `TreeSet` **does not allow `null` values** because it uses `compareTo()` for sorting, which would throw a `NullPointerException`.  

### **Q3: When should I use `TreeSet` over `HashSet`?**  
Use `TreeSet` when **you need elements to be sorted** dynamically. If order doesn’t matter, `HashSet` is faster (`O(1)`).  

---

🔥 **Now you have a complete understanding of `TreeSet` in Java!** 🚀 Let me know if you need more details. 😊