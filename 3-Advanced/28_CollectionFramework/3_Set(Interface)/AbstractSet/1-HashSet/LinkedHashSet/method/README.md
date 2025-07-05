

# 📌 Java LinkedHashSet Methods - A Complete Guide  

## 🔥 Introduction  

`LinkedHashSet<E>` is a part of the Java Collections Framework and extends `HashSet`. It maintains the **insertion order** of elements while providing **constant-time performance** for basic operations like `add()`, `remove()`, and `contains()`.  

This guide covers **all built-in methods**, explanations, practical examples, real-life use cases, and performance considerations.  

---

## 🏗 Class Hierarchy  

```plaintext
Iterable
│
├── Collection
│   ├── Set
│   │   ├── HashSet
│   │   │   ├── LinkedHashSet
```

- `LinkedHashSet<E>` extends `HashSet<E>` and implements `Set<E>`.  
- It internally maintains a **linked list** to preserve insertion order.  

---

## 📜 List of All LinkedHashSet Methods  

| Method | Description |
|--------|------------|
| `size()` | Returns the number of elements in the set. |
| `isEmpty()` | Checks if the set is empty. |
| `contains(Object o)` | Checks if a specific element is in the set. |
| `add(E e)` | Adds an element to the set. |
| `remove(Object o)` | Removes a specific element from the set. |
| `clear()` | Removes all elements from the set. |
| `iterator()` | Returns an iterator to traverse elements in insertion order. |
| `toArray()` | Converts the set into an array. |
| `addAll(Collection<? extends E> c)` | Adds all elements from a given collection. |
| `removeAll(Collection<?> c)` | Removes all elements present in the specified collection. |
| `retainAll(Collection<?> c)` | Retains only the elements present in the specified collection. |
| `clone()` | Creates a shallow copy of the LinkedHashSet. |
| `spliterator()` | Returns a `Spliterator` for parallel iteration. |

---

## ⭐ Methods and Their Descriptions  

### ✅ **1. size() - Get Number of Elements**  
```java
public int size();
```
- Returns the number of elements in the set.  

**Example:**  
```java
Set<String> set = new LinkedHashSet<>();
set.add("A");
set.add("B");
System.out.println(set.size()); // Output: 2
```

---  

### ✅ **2. isEmpty() - Check if Set is Empty**  
```java
public boolean isEmpty();
```
- Returns `true` if the set is empty, `false` otherwise.  

**Example:**  
```java
Set<Integer> set = new LinkedHashSet<>();
System.out.println(set.isEmpty()); // Output: true
set.add(5);
System.out.println(set.isEmpty()); // Output: false
```

---  

### ✅ **3. contains(Object o) - Check if Element Exists**  
```java
public boolean contains(Object o);
```
- Checks if the set contains the specified element.  

**Example:**  
```java
Set<String> set = new LinkedHashSet<>();
set.add("Java");
System.out.println(set.contains("Java")); // Output: true
System.out.println(set.contains("Python")); // Output: false
```

---  

### ✅ **4. add(E e) - Add an Element**  
```java
public boolean add(E e);
```
- Adds an element to the set while **preserving insertion order**.  

**Example:**  
```java
Set<Integer> set = new LinkedHashSet<>();
set.add(10);
set.add(20);
set.add(30);
System.out.println(set); // Output: [10, 20, 30] (Insertion order is maintained)
```

---  

### ✅ **5. remove(Object o) - Remove an Element**  
```java
public boolean remove(Object o);
```
- Removes the specified element from the set.  

**Example:**  
```java
Set<String> set = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
set.remove("A");
System.out.println(set); // Output: [B, C]
```

---  

### ✅ **6. clear() - Remove All Elements**  
```java
public void clear();
```
- Removes all elements from the set.  

**Example:**  
```java
Set<String> set = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
set.clear();
System.out.println(set.isEmpty()); // Output: true
```

---  

### ✅ **7. iterator() - Iterate Over Elements (Maintains Order)**  
```java
public Iterator<E> iterator();
```
- Returns an iterator to traverse the elements **in insertion order**.  

**Example:**  
```java
Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
Iterator<Integer> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
// Output: 1 2 3 (Maintains order)
```

---  

### ✅ **8. toArray() - Convert Set to Array**  
```java
public Object[] toArray();
```
- Converts the set into an array.  

**Example:**  
```java
Set<String> set = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
Object[] arr = set.toArray();
System.out.println(Arrays.toString(arr)); // Output: [A, B, C]
```

---  

### ✅ **9. removeAll(Collection<?> c) - Remove Multiple Elements**  
```java
public boolean removeAll(Collection<?> c);
```
- Removes all elements in the specified collection.  

**Example:**  
```java
Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4));
set.removeAll(Arrays.asList(2, 3));
System.out.println(set); // Output: [1, 4]
```

---  

### ✅ **10. retainAll(Collection<?> c) - Retain Only Matching Elements**  
```java
public boolean retainAll(Collection<?> c);
```
- Keeps only elements that are in the specified collection.  

**Example:**  
```java
Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4));
set.retainAll(Arrays.asList(2, 3));
System.out.println(set); // Output: [2, 3]
```

---  

### ✅ **11. clone() - Create a Copy of LinkedHashSet**  
```java
public Object clone();
```
- Creates a shallow copy of the `LinkedHashSet`.  

**Example:**  
```java
Set<String> original = new LinkedHashSet<>(Arrays.asList("A", "B", "C"));
Set<String> copy = (LinkedHashSet<String>) ((LinkedHashSet<String>) original).clone();
System.out.println(copy); // Output: [A, B, C]
```

---  

## **3️⃣ Use Case Scenarios**  

✅ **Ordered Unique Elements** → `LinkedHashSet` maintains the **insertion order** while ensuring uniqueness.  

✅ **Efficient Lookups** → Provides O(1) average time complexity for `contains()`.  

✅ **Database Row Caching** → Useful for maintaining unique database rows while preserving order.  

✅ **Maintaining a Recent Access List** → Keeps recently added elements in order.  

---  

## **📌 Summary**  

1. `add()`, `remove()`, `contains()` → Core set operations.  
2. `size()`, `isEmpty()`, `clear()` → Manage set elements.  
3. `iterator()`, `toArray()` → Ordered iteration over elements.  
4. `removeAll()`, `retainAll()` → Bulk modifications.  
5. `clone()` → Create a duplicate set.  

---  

## ❓ FAQs  

1️⃣ **How is `LinkedHashSet` different from `HashSet`?**  
   - `LinkedHashSet` **preserves insertion order**, while `HashSet` does not.  

2️⃣ **Is `LinkedHashSet` synchronized?**  
   - No, it is **not thread-safe**. Use `Collections.synchronizedSet()` for thread safety.  

3️⃣ **Does `LinkedHashSet` allow `null` values?**  
   - Yes, but only one `null` value is allowed.  

---  

## 📚 Additional Resources  

- [Official Java Docs - LinkedHashSet](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/LinkedHashSet.html)  

🚀 Happy Coding! 🎯  