# 📌 Java ArrayList Methods - A Complete Guide

## 🔥 Introduction

The `ArrayList` class in Java is a **resizable array implementation** of the `List` interface. Unlike arrays, an `ArrayList` can grow and shrink dynamically, making it a flexible data structure for handling collections of data.

In this guide, we will explore **all built-in methods** of `ArrayList`, their use cases, and practical examples. Let's dive in! 🚀

---

## 🏗 ArrayList Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── List
│   │   ├── ArrayList
```

- `ArrayList` implements the `List` interface, which is a part of `Collection`.
- It provides ordered storage with **dynamic resizing**.
- **Index-based access** allows fast retrieval.

---

## 🛠 Commonly Used ArrayList Methods

### 1️⃣ **add(E e)** – Add an element

- **Adds an element at the end of the list**.

```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
System.out.println(list); // Output: [Apple, Banana]
```

### 2️⃣ **add(int index, E element)** – Insert at a specific index

- **Inserts an element at the specified index**.

```java
list.add(1, "Mango");
System.out.println(list); // Output: [Apple, Mango, Banana]
```

### 3️⃣ **get(int index)** – Retrieve an element

- **Gets the element at the specified index**.

```java
String fruit = list.get(1);
System.out.println(fruit); // Output: Mango
```

### 4️⃣ **set(int index, E element)** – Update an element

- **Modifies an existing element at the given index**.

```java
list.set(1, "Orange");
System.out.println(list); // Output: [Apple, Orange, Banana]
```

### 5️⃣ **remove(int index)** – Remove an element by index

- **Deletes an element at the specified index**.

```java
list.remove(2);
System.out.println(list); // Output: [Apple, Orange]
```

### 6️⃣ **remove(Object o)** – Remove by value

- **Removes the first occurrence of the specified element**.

```java
list.remove("Orange");
System.out.println(list); // Output: [Apple]
```

### 7️⃣ **size()** – Get the number of elements

- **Returns the total number of elements in the list**.

```java
System.out.println(list.size()); // Output: 1
```

### 8️⃣ **clear()** – Remove all elements

- **Clears all elements in the list**.

```java
list.clear();
System.out.println(list); // Output: []
```

### 9️⃣ **contains(Object o)** – Check if an element exists

- **Returns `true` if the element exists, otherwise `false`**.

```java
System.out.println(list.contains("Apple")); // Output: false
```

### 🔟 **indexOf(Object o)** – Get the index of an element

- **Returns the index of the first occurrence of an element, or -1 if not found**.

```java
list.add("Apple");
System.out.println(list.indexOf("Apple")); // Output: 0
```

### 1️⃣1️⃣ **lastIndexOf(Object o)** – Find last occurrence index

- **Returns the index of the last occurrence of an element**.

```java
list.add("Apple");
System.out.println(list.lastIndexOf("Apple")); // Output: 1
```

### 1️⃣2️⃣ **isEmpty()** – Check if the list is empty

- **Returns `true` if the list contains no elements**.

```java
System.out.println(list.isEmpty()); // Output: false
```

### 1️⃣3️⃣ **toArray()** – Convert to array

- **Converts `ArrayList` to an array**.

```java
Object[] arr = list.toArray();
System.out.println(Arrays.toString(arr)); // Output: [Apple, Apple]
```

### 1️⃣4️⃣ **subList(int fromIndex, int toIndex)** – Extract a portion of the list

- **Returns a sublist from the specified range**.

```java
List<String> subList = list.subList(0, 1);
System.out.println(subList); // Output: [Apple]
```

### 1️⃣5️⃣ **sort(Comparator c)** – Sort elements

- **Sorts the list based on a comparator**.

```java
list.add("Mango");
Collections.sort(list);
System.out.println(list); // Output: [Apple, Apple, Mango]
```

### 1️⃣6️⃣ **iterator()** – Get an iterator

- **Returns an iterator to loop over elements**.

```java
Iterator<String> iterator = list.iterator();
while(iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### 1️⃣7️⃣ **forEach(Consumer action)** – Iterate using lambda

- **Performs an action on each element using a lambda expression**.

```java
list.forEach(System.out::println);
```

### 1️⃣8️⃣ **ensureCapacity(int minCapacity)** – Increase capacity manually

- **Increases the capacity of `ArrayList` to ensure no resizing happens**.

```java
list.ensureCapacity(10);
```

### 1️⃣9️⃣ **trimToSize()** – Reduce capacity to current size

- **Trims excess capacity, keeping only the needed size**.

```java
list.trimToSize();
```

---

## ❓ FAQs

1️⃣ **What is the initial capacity of an `ArrayList`?**
   - The default capacity is **10**, but it dynamically increases.

2️⃣ **How does resizing work in `ArrayList`?**
   - When the capacity is exceeded, a new array of **1.5x the size** is created, and elements are copied.

3️⃣ **Is `ArrayList` thread-safe?**
   - No, it is **not synchronized**. Use `Collections.synchronizedList()` or `CopyOnWriteArrayList` for thread safety.

4️⃣ **How to convert `ArrayList` to `LinkedList`?**
   ```java
   LinkedList<String> linkedList = new LinkedList<>(list);
   ```

5️⃣ **Why is `ArrayList` preferred over arrays?**
   - It provides **dynamic resizing, easy insertion/deletion, and built-in methods**.

---

## 📚 Additional Resources
- [Official Java Docs - ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)

                


### **🚀 Time Complexity of ArrayList Methods**  

| **Method**                      | **Time Complexity (Average Case)** | **Explanation** |
|----------------------------------|------------------------------------|----------------|
| `add(E e)` (at end)             | **O(1) Amortized**                 | Appends element; resizing happens occasionally. |
| `add(int index, E element)`     | **O(n)**                           | Shifts elements to make space. |
| `get(int index)`                | **O(1)**                           | Direct indexed access. |
| `set(int index, E element)`     | **O(1)**                           | Replaces element at given index. |
| `remove(int index)`             | **O(n)**                           | Shifts elements to fill gap. |
| `remove(Object o)`              | **O(n)**                           | Searches for element, then shifts. |
| `indexOf(Object o)`             | **O(n)**                           | Searches for first occurrence. |
| `lastIndexOf(Object o)`         | **O(n)**                           | Searches for last occurrence. |
| `contains(Object o)`            | **O(n)**                           | Checks if an element exists. |
| `size()`                        | **O(1)**                           | Just returns the list size. |
| `isEmpty()`                     | **O(1)**                           | Checks if size is 0. |
| `clear()`                       | **O(n)**                           | Sets all elements to `null`. |
| `toArray()`                     | **O(n)**                           | Copies elements into a new array. |
| `sort(Comparator<? super E> c)` | **O(n log n)**                     | Uses `TimSort` (optimized merge sort). |
| `iterator()`                    | **O(1)**                           | Creates an iterator object. |
| `listIterator()`                | **O(1)**                           | Creates a bidirectional iterator. |
| `subList(int from, int to)`     | **O(1)**                           | Creates a **view** (not a new list). |

---

### **🔹 Key Insights**
- **Fast Operations (`O(1)`)**: `get()`, `set()`, `size()`, `isEmpty()`, `iterator()`
- **Slow Operations (`O(n)`)**: `remove(index)`, `add(index, element)`, `contains()`, `clear()`
- **Sorting Complexity (`O(n log n)`)**: Uses optimized **TimSort**, better than `O(n²)` of naive sorts.
- **Resizing Overhead (`O(n)`)**: When `ArrayList` grows beyond its capacity, it creates a new array (1.5x size) and copies elements.

---
