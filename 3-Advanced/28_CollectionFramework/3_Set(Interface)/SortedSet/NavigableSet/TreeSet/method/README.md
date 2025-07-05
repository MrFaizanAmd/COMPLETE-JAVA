# 📌 **Java TreeSet - A Complete Guide**  

## 🔥 **Introduction**  

`TreeSet<E>` is a **NavigableSet** implementation based on a **Red-Black Tree**. It **stores elements in sorted order**, provides **logarithmic time complexity** for operations, and **does not allow duplicate elements**.  

✅ **Automatically sorted**  
✅ **Implements `NavigableSet` for efficient navigation**  
✅ **No duplicate elements**  
✅ **Uses a balanced Red-Black Tree for O(log n) operations**  

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

- `TreeSet<E>` implements `NavigableSet<E>` and `SortedSet<E>`.  

---

## ⭐ **Methods and Their Descriptions**  

| Method | Description |
|--------|------------|
| `add(E e)` | Inserts an element (maintains sorted order). |
| `remove(E e)` | Removes an element if it exists. |
| `contains(E e)` | Checks if an element is present. |
| `first()` | Retrieves the **smallest** element. |
| `last()` | Retrieves the **largest** element. |
| `higher(E e)` | Returns the **smallest element greater than** `e`. |
| `lower(E e)` | Returns the **largest element smaller than** `e`. |
| `ceiling(E e)` | Returns the **smallest element greater than or equal to** `e`. |
| `floor(E e)` | Returns the **largest element less than or equal to** `e`. |
| `pollFirst()` | Retrieves and removes the **smallest element**. |
| `pollLast()` | Retrieves and removes the **largest element**. |
| `descendingSet()` | Returns a **reverse order view**. |
| `subSet(E from, boolean fromInclusive, E to, boolean toInclusive)` | Retrieves a range of elements. |
| `headSet(E to, boolean inclusive)` | Retrieves elements **less than a given value**. |
| `tailSet(E from, boolean inclusive)` | Retrieves elements **greater than a given value**. |

---

## ✅ **1. Creating a `TreeSet`**  
```java
import java.util.*;

TreeSet<Integer> numbers = new TreeSet<>();
numbers.addAll(Arrays.asList(20, 10, 50, 30, 40));

System.out.println(numbers); // Output: [10, 20, 30, 40, 50]
```
- **Elements are sorted in ascending order** by default.  

---

## ✅ **2. first() and last() - Retrieve Extremes**  
```java
System.out.println(numbers.first()); // Output: 10
System.out.println(numbers.last());  // Output: 50
```

---

## ✅ **3. lower(E e) - Find Largest Element Smaller Than `e`**  
```java
System.out.println(numbers.lower(30)); // Output: 20
System.out.println(numbers.lower(10)); // Output: null
```

---

## ✅ **4. floor(E e) - Find Largest Element ≤ `e`**  
```java
System.out.println(numbers.floor(30)); // Output: 30
System.out.println(numbers.floor(25)); // Output: 20
```

---

## ✅ **5. ceiling(E e) - Find Smallest Element ≥ `e`**  
```java
System.out.println(numbers.ceiling(30)); // Output: 30
System.out.println(numbers.ceiling(35)); // Output: 40
```

---

## ✅ **6. higher(E e) - Find Smallest Element Greater Than `e`**  
```java
System.out.println(numbers.higher(30)); // Output: 40
System.out.println(numbers.higher(50)); // Output: null
```

---

## ✅ **7. pollFirst() and pollLast() - Remove First and Last Elements**  
```java
System.out.println(numbers.pollFirst()); // Output: 10
System.out.println(numbers.pollLast());  // Output: 50
System.out.println(numbers); // Output: [20, 30, 40]
```

---

## ✅ **8. descendingSet() - Reverse Order**  
```java
NavigableSet<Integer> reversed = numbers.descendingSet();
System.out.println(reversed); // Output: [40, 30, 20]
```

---

## ✅ **9. subSet(E from, boolean fromInclusive, E to, boolean toInclusive)**  
```java
NavigableSet<Integer> subset = numbers.subSet(20, true, 40, false);
System.out.println(subset); // Output: [20, 30]
```

---

## ✅ **10. headSet(E to, boolean inclusive) - Get Elements Less Than `to`**  
```java
NavigableSet<Integer> headset = numbers.headSet(30, true);
System.out.println(headset); // Output: [20, 30]
```

---

## ✅ **11. tailSet(E from, boolean inclusive) - Get Elements Greater Than `from`**  
```java
NavigableSet<Integer> tailset = numbers.tailSet(30, false);
System.out.println(tailset); // Output: [40]
```

---

## 📌 **Use Cases of `TreeSet`**  

✅ **Efficient Ordered Storage** → Automatically keeps elements sorted.  
✅ **Searching for Nearest Elements** → `higher()`, `lower()`, `floor()`, `ceiling()`.  
✅ **Efficient Range Queries** → `subSet()`, `headSet()`, `tailSet()`.  
✅ **Fast Operations** → `O(log n)` for `add()`, `remove()`, `contains()`.  

---

## 📚 **FAQs**  

1️⃣ **How is `TreeSet` different from `HashSet`?**  
   - `TreeSet` maintains **sorted order**, `HashSet` does **not**.  
   - `TreeSet` has **O(log n)** operations, `HashSet` has **O(1)** operations.  

2️⃣ **Does `TreeSet` allow `null` elements?**  
   - ❌ No, `TreeSet` **does not allow `null`** because it requires elements to be **comparable**.  

3️⃣ **How does `TreeSet` sort elements?**  
   - Uses **natural ordering (`Comparable`)** or a **custom comparator (`Comparator`)**.  

4️⃣ **What is the underlying data structure of `TreeSet`?**  
   - It uses a **Red-Black Tree**, a **self-balancing binary search tree**.  

5️⃣ **Can `TreeSet` store duplicate elements?**  
   - ❌ No, `TreeSet` **does not allow duplicates**.  

---

## 🚀 **Summary**  

1️⃣ `TreeSet<E>` maintains elements in **sorted order**.  
2️⃣ Uses a **Red-Black Tree** for `O(log n)` operations.  
3️⃣ Provides **navigation methods** (`first()`, `last()`, `higher()`, `lower()`).  
4️⃣ Supports **range queries** (`subSet()`, `headSet()`, `tailSet()`).  
5️⃣ ❌ **Does not allow `null` or duplicate elements**.  

---

## 📚 **Additional Resources**  
- [Official Java Docs - TreeSet](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/TreeSet.html)  

🚀 **Happy Coding!** 🎯