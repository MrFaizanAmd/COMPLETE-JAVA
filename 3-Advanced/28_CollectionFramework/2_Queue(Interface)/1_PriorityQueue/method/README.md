# 📌 Java PriorityQueue Methods - A Complete Guide

## 🔥 Introduction

The `PriorityQueue` class in Java is a **heap-based data structure** that implements the `Queue` interface and follows the **natural ordering (min-heap by default)** or a custom comparator-defined ordering.

In this guide, we will explore **all built-in methods** of `PriorityQueue`, their use cases, practical examples, and time complexity. Let’s dive in! 🚀

---

## 🏗 PriorityQueue Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── AbstractQueue
│   │   │   ├── PriorityQueue
```

- `PriorityQueue<E>` extends `AbstractQueue<E>`, implementing the **Queue interface**.
- Elements are **ordered based on priority**, with the **head being the highest priority (lowest value in a min-heap).**

---

## **1️⃣ PriorityQueue Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element | **O(log n)** |
| `offer(E e)` | Inserts an element (preferred over `add`) | **O(log n)** |
| `poll()` | Removes and returns the head | **O(log n)** |
| `remove()` | Removes the head or a specific element | **O(log n) / O(n)** |
| `peek()` | Retrieves but does not remove the head | **O(1)** |
| `element()` | Retrieves but does not remove the head (throws exception if empty) | **O(1)** |
| `contains(Object o)` | Checks if an element exists | **O(n)** |
| `size()` | Returns the number of elements | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `toArray()` | Returns an array representation | **O(n)** |
| `comparator()` | Returns the comparator used (or `null` for natural ordering) | **O(1)** |

---

## **2️⃣ PriorityQueue Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Insert an Element**
- **Adds an element following priority order**.
- **Throws `IllegalStateException` if capacity exceeded**.
- **Time Complexity:** O(log n)

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println(pq); // Output: [10, 30, 20] (Heap order)
    }
}
```

---

### 📝 **2. `offer(E e)` - Insert an Element (Preferred over `add`)**
- **Similar to `add(E e)`, but returns `false` instead of throwing an exception**.
- **Time Complexity:** O(log n)

```java
pq.offer(40);
pq.offer(5);
System.out.println(pq); // Output: [5, 10, 20, 40, 30]
```

---

### 📝 **3. `poll()` - Remove and Return the Head**
- **Removes the highest priority element (smallest in a min-heap)**.
- **Returns `null` if the queue is empty**.
- **Time Complexity:** O(log n)

```java
System.out.println(pq.poll()); // Output: 5
System.out.println(pq); // Output: [10, 30, 20, 40]
```

---

### 📝 **4. `remove()` - Remove the Head or Specific Element**
- **Throws `NoSuchElementException` if empty**.
- **Time Complexity:** O(log n) for head, O(n) for specific elements.

```java
pq.remove(20);
System.out.println(pq); // Output: [10, 30, 40]
```

---

### 📝 **5. `peek()` - Retrieve Head Without Removing**
- **Returns the smallest element**.
- **Returns `null` if empty**.
- **Time Complexity:** O(1)

```java
System.out.println(pq.peek()); // Output: 10
```

---

### 📝 **6. `element()` - Retrieve Head Without Removing (Throws Exception if Empty)**
- **Similar to `peek()`, but throws an exception if the queue is empty**.
- **Time Complexity:** O(1)

```java
System.out.println(pq.element()); // Output: 10
```

---

### 📝 **7. `contains(Object o)` - Check if an Element Exists**
- **Returns `true` if the element exists, `false` otherwise**.
- **Time Complexity:** O(n)

```java
System.out.println(pq.contains(30)); // Output: true
System.out.println(pq.contains(50)); // Output: false
```

---

### 📝 **8. `size()` - Get Queue Size**
- **Returns the number of elements**.
- **Time Complexity:** O(1)

```java
System.out.println(pq.size()); // Output: 3
```

---

### 📝 **9. `clear()` - Remove All Elements**
- **Time Complexity:** O(n)

```java
pq.clear();
System.out.println(pq.size()); // Output: 0
```

---

### 📝 **10. `toArray()` - Convert to Array**
- **Time Complexity:** O(n)

```java
Object[] arr = pq.toArray();
for (Object obj : arr) {
    System.out.print(obj + " "); // Output: 10 30 40
}
```

---

### 📝 **11. `comparator()` - Get Comparator (if Defined)**
- **Returns the comparator used or `null` for natural ordering**.
- **Time Complexity:** O(1)

```java
System.out.println(pq.comparator()); // Output: null (default natural ordering)
```

---

## **3️⃣ Use Case Scenarios**

✅ **Task Scheduling** → Used in OS for process scheduling.

✅ **Dijkstra’s Algorithm** → Used for shortest path calculations.

✅ **Event Processing** → Manages events based on priority.

✅ **Load Balancing** → Manages resource allocation efficiently.

---

## **📌 Summary**

1. `add(E e)`, `offer(E e)` → Inserts an element.
2. `poll()`, `remove()` → Removes and returns the head.
3. `peek()`, `element()` → Retrieves the head without removal.
4. `contains(Object o)`, `size()` → Checks presence and size.
5. `clear()`, `toArray()` → Utility methods.
6. `comparator()` → Retrieves comparator (if any).

---

## ❓ FAQs

1️⃣ **What is the default ordering in `PriorityQueue`?**  
   - Min-Heap (smallest element at the top).

2️⃣ **How do I create a max-heap?**  
   - Use `PriorityQueue<>(Collections.reverseOrder())`.

3️⃣ **Does `PriorityQueue` allow null elements?**  
   - No, null elements are not allowed.

---

## 📚 Additional Resources
- [Official Java Docs - PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)

🚀 Happy Coding! 🎯

