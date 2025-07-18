# 📌 **Java NavigableSet - A Complete Guide**  

## 🔥 **Introduction**  

`NavigableSet<E>` is an **extension of `SortedSet<E>`** that provides additional **navigation methods** for retrieving elements **lower, higher, floor, and ceiling** relative to a given element.  

✅ **Maintains elements in sorted order**  
✅ **Supports bidirectional navigation**  
✅ **Efficient range queries**  
✅ **Common implementation: `TreeSet<E>`**  

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

- `NavigableSet<E>` extends `SortedSet<E>`  
- `TreeSet<E>` is the most used implementation  

---

## ⭐ **Methods and Their Descriptions**  

| Method | Description |
|--------|------------|
| `lower(E e)` | Returns the **greatest** element **less than** `e`, or `null` if none exists. |
| `floor(E e)` | Returns the **greatest** element **less than or equal to** `e`, or `null` if none exists. |
| `ceiling(E e)` | Returns the **smallest** element **greater than or equal to** `e`, or `null` if none exists. |
| `higher(E e)` | Returns the **smallest** element **greater than** `e`, or `null` if none exists. |
| `pollFirst()` | Removes and returns the **first (smallest) element**. |
| `pollLast()` | Removes and returns the **last (largest) element**. |
| `descendingSet()` | Returns a **reverse-ordered view** of the set. |
| `subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)` | Returns a subset in the given range with **inclusive/exclusive control**. |
| `headSet(E toElement, boolean inclusive)` | Returns a **headSet** with an option to include `toElement`. |
| `tailSet(E fromElement, boolean inclusive)` | Returns a **tailSet** with an option to include `fromElement`. |

---

## ✅ **1. Creating a `NavigableSet` Using `TreeSet`**  
```java
import java.util.*;

NavigableSet<Integer> numbers = new TreeSet<>();
numbers.addAll(Arrays.asList(10, 20, 30, 40, 50));

System.out.println(numbers); // Output: [10, 20, 30, 40, 50]
```

---

## ✅ **2. lower(E e) - Find the Greatest Element Less Than a Given Value**  
```java
System.out.println(numbers.lower(30)); // Output: 20
System.out.println(numbers.lower(10)); // Output: null
```
- Returns **null** if no element is less than `e`.  

---

## ✅ **3. floor(E e) - Find the Greatest Element Less Than or Equal to a Given Value**  
```java
System.out.println(numbers.floor(30)); // Output: 30
System.out.println(numbers.floor(25)); // Output: 20
```

---

## ✅ **4. ceiling(E e) - Find the Smallest Element Greater Than or Equal to a Given Value**  
```java
System.out.println(numbers.ceiling(30)); // Output: 30
System.out.println(numbers.ceiling(35)); // Output: 40
```

---

## ✅ **5. higher(E e) - Find the Smallest Element Greater Than a Given Value**  
```java
System.out.println(numbers.higher(30)); // Output: 40
System.out.println(numbers.higher(50)); // Output: null
```

---

## ✅ **6. pollFirst() - Remove and Return the First Element**  
```java
System.out.println(numbers.pollFirst()); // Output: 10
System.out.println(numbers); // Output: [20, 30, 40, 50]
```

---

## ✅ **7. pollLast() - Remove and Return the Last Element**  
```java
System.out.println(numbers.pollLast()); // Output: 50
System.out.println(numbers); // Output: [20, 30, 40]
```

---

## ✅ **8. descendingSet() - Get a Reverse-Ordered View**  
```java
NavigableSet<Integer> reversed = numbers.descendingSet();
System.out.println(reversed); // Output: [40, 30, 20]
```

---

## ✅ **9. subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)**  
Returns a **range of elements**, allowing **inclusive/exclusive** control.  

```java
NavigableSet<Integer> subset = numbers.subSet(20, true, 40, false);
System.out.println(subset); // Output: [20, 30]
```
- `true` means **include 20**, `false` means **exclude 40**.  

---

## ✅ **10. headSet(E toElement, boolean inclusive) - Get Elements Less Than a Value**  
```java
NavigableSet<Integer> headset = numbers.headSet(30, true);
System.out.println(headset); // Output: [20, 30]
```
- If `true`, `30` is included.  

---

## ✅ **11. tailSet(E fromElement, boolean inclusive) - Get Elements Greater Than a Value**  
```java
NavigableSet<Integer> tailset = numbers.tailSet(30, false);
System.out.println(tailset); // Output: [40]
```
- If `false`, `30` is excluded.  

---

## 📌 **Use Cases of `NavigableSet`**  

✅ **Efficient searching for nearest elements**  
✅ **Ordered and bidirectional navigation**  
✅ **Efficient subset range retrieval**  
✅ **Maintaining unique sorted elements**  

---

## 📚 **FAQs**  

1️⃣ **What is the difference between `NavigableSet` and `SortedSet`?**  
   - `NavigableSet` extends `SortedSet` and adds methods for **finding closest elements (floor, ceiling, lower, higher)** and **bidirectional navigation**.  

2️⃣ **What is the primary implementation of `NavigableSet`?**  
   - **`TreeSet<E>`** is the main implementation, using a **Red-Black Tree** for sorting.  

3️⃣ **What is the time complexity of `TreeSet` operations?**  
   - `add()`, `remove()`, `contains()` → **O(log n)** (balanced tree operations).  

4️⃣ **Can `NavigableSet` contain `null` values?**  
   - No, `TreeSet` **does not allow `null` values** if it uses **natural ordering**.  

---

## 🚀 **Summary**  

1️⃣ `NavigableSet<E>` extends `SortedSet<E>` and provides **extra navigation methods**.  
2️⃣ `TreeSet<E>` is the most used implementation.  
3️⃣ Supports **bidirectional navigation** (`descendingSet()`, `pollFirst()`, `pollLast()`).  
4️⃣ Efficient **range operations**: `subSet()`, `headSet()`, `tailSet()`.  
5️⃣ Uses a **balanced tree (Red-Black Tree)** for efficient performance (`O(log n)`).  

---

## 📚 **Additional Resources**  
- [Official Java Docs - NavigableSet](https://docs.oracle.com/javase/8/docs/api/java/util/NavigableSet.html)  

🚀 **Happy Coding!** 🎯