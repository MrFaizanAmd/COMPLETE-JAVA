# 📌 Java LinkedBlockingDeque Methods - A Complete Guide

## 🔥 Introduction

`LinkedBlockingDeque` is a **thread-safe, double-ended queue** in Java, backed by linked nodes. It supports **optional capacity bounds** and provides **blocking operations** for concurrent programming.

In this guide, we will explore **all built-in methods** of `LinkedBlockingDeque`, their use cases, practical examples, and time complexity. Let's dive in! 🚀

---

## 🏗 LinkedBlockingDeque Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Deque
│   │   ├── BlockingDeque
│   │   │   ├── LinkedBlockingDeque
```

- `LinkedBlockingDeque<E>` implements `BlockingDeque<E>` and allows **concurrent access** with blocking capabilities.

---

## **1️⃣ LinkedBlockingDeque Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Adds an element to the end | **O(1)** |
| `addFirst(E e)` | Inserts an element at the front | **O(1)** |
| `addLast(E e)` | Inserts an element at the end | **O(1)** |
| `offer(E e)` | Offers an element at the end | **O(1)** |
| `offerFirst(E e, long timeout, TimeUnit unit)` | Inserts at the front, waiting if necessary | **O(1)** |
| `offerLast(E e, long timeout, TimeUnit unit)` | Inserts at the end, waiting if necessary | **O(1)** |
| `poll()` | Retrieves and removes the first element | **O(1)** |
| `pollFirst(long timeout, TimeUnit unit)` | Retrieves and removes first element, waiting if necessary | **O(1)** |
| `pollLast(long timeout, TimeUnit unit)` | Retrieves and removes last element, waiting if necessary | **O(1)** |
| `peek()` | Retrieves but does not remove the first element | **O(1)** |
| `peekFirst()` | Retrieves but does not remove the first element | **O(1)** |
| `peekLast()` | Retrieves but does not remove the last element | **O(1)** |
| `take()` | Retrieves and removes first element, blocking if necessary | **O(1)** |
| `takeFirst()` | Retrieves and removes first element, blocking if necessary | **O(1)** |
| `takeLast()` | Retrieves and removes last element, blocking if necessary | **O(1)** |
| `put(E e)` | Inserts element at the end, blocking if full | **O(1)** |
| `putFirst(E e)` | Inserts element at the front, blocking if full | **O(1)** |
| `putLast(E e)` | Inserts element at the end, blocking if full | **O(1)** |
| `size()` | Returns the number of elements | **O(1)** |
| `isEmpty()` | Checks if the deque is empty | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(1)** |
| `descendingIterator()` | Returns a reverse-order iterator | **O(1)** |

---

## **2️⃣ LinkedBlockingDeque Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Add an Element at the End**

```java
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        System.out.println(deque); // Output: [10, 20, 30]
    }
}
```

---

### 📝 **2. `addFirst(E e)` - Add Element to Front**

```java
deque.addFirst(5);
System.out.println(deque); // Output: [5, 10, 20, 30]
```

---

### 📝 **3. `remove()` - Remove First Element**

```java
System.out.println(deque.remove()); // Output: 5
System.out.println(deque); // Output: [10, 20, 30]
```

---

### 📝 **4. `pollLast(long timeout, TimeUnit unit)` - Poll Last with Timeout**

```java
import java.util.concurrent.*;

LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
deque.offer(100);
deque.offer(200);
System.out.println(deque.pollLast(2, TimeUnit.SECONDS)); // Output: 200
```

---

### 📝 **5. `take()` - Blocking Remove First Element**

```java
new Thread(() -> {
    try {
        System.out.println(deque.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

---

### 📝 **6. `putLast(E e)` - Blocking Insert at the End**

```java
deque.putLast(50);
System.out.println(deque); // Output: [10, 20, 30, 50]
```

---

### 📝 **7. `iterator()` - Iterate Over Elements**

```java
for (int num : deque) {
    System.out.print(num + " ");
}
// Output: 10 20 30 50
```

---

### 📝 **8. `descendingIterator()` - Reverse Order Iteration**

```java
for (Iterator<Integer> it = deque.descendingIterator(); it.hasNext(); ) {
    System.out.print(it.next() + " ");
}
// Output: 50 30 20 10
```

---

## **3️⃣ Use Case Scenarios**

✅ **Producer-Consumer Problem** → Used in multi-threaded applications for task scheduling.

✅ **Log Processing** → Ensures correct order of processing with blocking retrieval.

✅ **Task Queues** → Stores tasks that need processing in a FIFO/LIFO manner.

✅ **Multi-threaded Caches** → Helps in building thread-safe caches.

✅ **Order Processing Systems** → Ensures fair task execution in an e-commerce system.

---

## **📌 Summary**

1. `put()`, `take()` → **Blocking** operations for concurrency.
2. `offer()`, `poll()` → **Non-blocking** operations.
3. `addFirst()`, `addLast()` → Insert at both ends.
4. `iterator()`, `descendingIterator()` → Supports traversal.
5. `size()`, `isEmpty()`, `clear()` → Utility methods.

---

## ❓ FAQs

1️⃣ **How is `LinkedBlockingDeque` different from `ArrayDeque`?**
   - `LinkedBlockingDeque` is **thread-safe**, while `ArrayDeque` is **not**.

2️⃣ **Is `LinkedBlockingDeque` bounded?**
   - It can be **bounded or unbounded**, depending on initialization.

3️⃣ **Does `LinkedBlockingDeque` support concurrent reads and writes?**
   - Yes, it supports **full concurrency** for reads and **single-threaded updates**.

---

🚀 Happy Coding! 🎯

