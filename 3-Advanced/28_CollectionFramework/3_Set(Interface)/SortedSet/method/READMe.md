# 📌 **Java SortedSet - A Complete Guide**  

## 🔥 **Introduction**  

`SortedSet<E>` is a **specialized `Set`** in Java that maintains **elements in a sorted order** based on their natural ordering (`Comparable`) or a custom comparator (`Comparator`).  

✅ **Sorted automatically** (ascending order by default)  
✅ **No duplicate elements**  
✅ **Supports range operations** (subset, headset, tailset)  

The **most common implementation** of `SortedSet` is **`TreeSet<E>`**, which uses a **Red-Black Tree** internally to maintain sorted order and provides **O(log n) complexity** for basic operations.  

---

## 🏗 **Class Hierarchy**  

```plaintext
Iterable
│
├── Collection
│   ├── Set
│   │   ├── SortedSet
│   │   │   ├── NavigableSet
│   │   │   │   ├── TreeSet
```

- `SortedSet<E>` is an interface  
- `TreeSet<E>` is the primary concrete implementation  
- `NavigableSet<E>` extends `SortedSet<E>` and adds navigation methods  

---

## ⭐ **Methods and Their Descriptions**  

| Method | Description |
|--------|------------|
| `comparator()` | Returns the comparator used for sorting, or `null` if natural ordering is used. |
| `first()` | Returns the first (lowest) element. |
| `last()` | Returns the last (highest) element. |
| `headSet(E toElement)` | Returns a subset with elements **less than** `toElement`. |
| `tailSet(E fromElement)` | Returns a subset with elements **greater than or equal to** `fromElement`. |
| `subSet(E fromElement, E toElement)` | Returns a subset with elements **in the range** `[fromElement, toElement)`. |
| `add(E e)` | Adds an element to the set. |
| `remove(E e)` | Removes an element from the set. |
| `size()` | Returns the number of elements. |
| `isEmpty()` | Checks if the set is empty. |
| `contains(E e)` | Checks if an element exists. |
| `iterator()` | Returns an iterator for traversing the elements. |

---

## ✅ **1. Creating a `SortedSet` Using `TreeSet`**  
```java
import java.util.*;

SortedSet<Integer> numbers = new TreeSet<>();
numbers.add(40);
numbers.add(10);
numbers.add(30);
numbers.add(20);

System.out.println(numbers); // Output: [10, 20, 30, 40] (Sorted Order)
```
- **TreeSet** automatically sorts the elements.  

---

## ✅ **2. first() - Get the Smallest Element**  
```java
System.out.println(numbers.first()); // Output: 10
```

---

## ✅ **3. last() - Get the Largest Element**  
```java
System.out.println(numbers.last()); // Output: 40
```

---

## ✅ **4. headSet(E toElement) - Get Elements Less Than a Value**  
```java
SortedSet<Integer> headSet = numbers.headSet(30);
System.out.println(headSet); // Output: [10, 20]
```
- **Includes all elements `< toElement` (exclusive).**

---

## ✅ **5. tailSet(E fromElement) - Get Elements Greater Than or Equal to a Value**  
```java
SortedSet<Integer> tailSet = numbers.tailSet(30);
System.out.println(tailSet); // Output: [30, 40]
```
- **Includes all elements `>= fromElement`.**

---

## ✅ **6. subSet(E fromElement, E toElement) - Get a Range of Elements**  
```java
SortedSet<Integer> subSet = numbers.subSet(20, 40);
System.out.println(subSet); // Output: [20, 30]
```
- **Includes all elements in `[fromElement, toElement)`** → Excludes `toElement` (`40` in this case).  

---

## ✅ **7. Custom Sorting Using Comparator**  
By default, `SortedSet` uses **natural ordering** (`Comparable`), but we can define a custom sorting rule using a `Comparator`.  

```java
SortedSet<String> words = new TreeSet<>(Comparator.reverseOrder());
words.add("Apple");
words.add("Banana");
words.add("Cherry");

System.out.println(words); // Output: [Cherry, Banana, Apple] (Descending Order)
```

---

## ✅ **8. Checking for an Element Using contains()**  
```java
System.out.println(numbers.contains(30)); // Output: true
System.out.println(numbers.contains(50)); // Output: false
```

---

## ✅ **9. Removing an Element**  
```java
numbers.remove(20);
System.out.println(numbers); // Output: [10, 30, 40]
```

---

## ✅ **10. Checking Size and Empty Status**  
```java
System.out.println(numbers.size()); // Output: 3
System.out.println(numbers.isEmpty()); // Output: false
```

---

## ✅ **11. Iterating Over a `SortedSet`**  
```java
for (Integer num : numbers) {
    System.out.print(num + " "); // Output: 10 30 40
}
```

---

## 📌 **Use Cases of `SortedSet`**  

✅ **Maintaining a sorted collection** (e.g., leaderboards, priority tasks)  
✅ **Efficient range queries** (e.g., finding elements within a range)  
✅ **Unique ordered elements** (e.g., processing unique timestamps)  

---

## 📚 **FAQs**  

1️⃣ **Why use `SortedSet` instead of `HashSet`?**  
   - `SortedSet` maintains **sorted order**, while `HashSet` **does not guarantee any order**.  

2️⃣ **What is the time complexity of `TreeSet` operations?**  
   - `add()`, `remove()`, `contains()` → **O(log n)** (Red-Black Tree operations).  

3️⃣ **Can we store `null` in `TreeSet`?**  
   - **No**, `TreeSet` does **not allow `null`** elements if it uses **natural ordering**.  

---

## 🚀 **Summary**  

1️⃣ `SortedSet<E>` maintains elements in **ascending order** (natural or custom).  
2️⃣ `TreeSet<E>` is the most used implementation.  
3️⃣ Supports **range operations**: `headSet()`, `tailSet()`, `subSet()`.  
4️⃣ Uses a **balanced tree (Red-Black Tree)** for efficient performance (`O(log n)`).  
5️⃣ Great for scenarios where **sorted unique elements** are required.  

---

## 📚 **Additional Resources**  
- [Official Java Docs - SortedSet](https://docs.oracle.com/javase/8/docs/api/java/util/SortedSet.html)  

🚀 **Happy Coding!** 🎯