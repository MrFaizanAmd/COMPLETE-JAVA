# 📌 Java ConcurrentLinkedDeque Methods - A Complete Guide

## 🔥 Introduction

`ConcurrentLinkedDeque` is a **thread-safe, non-blocking, lock-free, doubly-ended queue (Deque)** in Java. It is part of the `java.util.concurrent` package and provides efficient **concurrent access** for multiple threads.

This guide covers **all built-in methods**, their explanations, use cases, practical examples, and time complexities.

---

## 🏗 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── Deque
│   │   │   ├── ConcurrentLinkedDeque
```

- `ConcurrentLinkedDeque<E>` implements `Deque<E>` and allows **lock-free concurrent operations** at both ends.

---

## **1️⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Adds an element to the end | **O(1)** |
| `addFirst(E e)` | Inserts an element at the front | **O(1)** |
| `addLast(E e)` | Inserts an element at the end | **O(1)** |
| `offer(E e)` | Offers an element at the end | **O(1)** |
| `offerFirst(E e)` | Offers an element at the front | **O(1)** |
| `offerLast(E e)` | Offers an element at the end | **O(1)** |
| `remove()` | Removes and returns the first element | **O(1)** |
| `removeFirst()` | Removes and returns the first element | **O(1)** |
| `removeLast()` | Removes and returns the last element | **O(1)** |
| `poll()` | Retrieves and removes the first element | **O(1)** |
| `pollFirst()` | Retrieves and removes the first element | **O(1)** |
| `pollLast()` | Retrieves and removes the last element | **O(1)** |
| `element()` | Retrieves but does not remove the first element | **O(1)** |
| `peek()` | Retrieves but does not remove the first element | **O(1)** |
| `peekFirst()` | Retrieves but does not remove the first element | **O(1)** |
| `peekLast()` | Retrieves but does not remove the last element | **O(1)** |
| `size()` | Returns the number of elements (traverses the list) | **O(n)** |
| `isEmpty()` | Checks if the deque is empty | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(1)** |
| `descendingIterator()` | Returns a reverse-order iterator | **O(1)** |
| `spliterator()` | Returns a `Spliterator` for parallel iteration | **O(1)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Add Element at the End**

```java
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        System.out.println(deque); // Output: [10, 20, 30]
    }
}
```

### 📝 **2. `addFirst(E e)` - Add Element to the Front**

```java
deque.addFirst(5);
System.out.println(deque); // Output: [5, 10, 20, 30]
```

### 📝 **3. `remove()` - Remove First Element**

```java
System.out.println(deque.remove()); // Output: 5
System.out.println(deque); // Output: [10, 20, 30]
```

### 📝 **4. `peek()` - Get First Element Without Removing**

```java
System.out.println(deque.peek()); // Output: 10
```

### 📝 **5. `pollLast()` - Remove and Return Last Element**

```java
System.out.println(deque.pollLast()); // Output: 30
System.out.println(deque); // Output: [10, 20]
```

### 📝 **6. `size()` - Get Size of Deque**

```java
System.out.println(deque.size()); // Output: 2
```

### 📝 **7. `iterator()` - Iterate Over Elements**

```java
for (int num : deque) {
    System.out.print(num + " ");
}
// Output: 10 20
```

### 📝 **8. `spliterator()` - Parallel Processing Support**

```java
deque.spliterator().forEachRemaining(System.out::println);
// Output: 10 20
```

---

## **3️⃣ Use Case Scenarios**

✅ **Thread-safe Task Queues** → Used in concurrent systems to process tasks efficiently.

✅ **Real-time Messaging Systems** → Supports high-throughput message passing between threads.

✅ **Undo/Redo Functionality** → Manages previous and next states in concurrent applications.

✅ **Background Job Scheduling** → Efficient for managing background tasks that need to run asynchronously.

✅ **Log Processing** → Handles logs in multi-threaded environments for high-speed processing.

---

## **📌 Summary**

1. `addFirst()` / `addLast()` → Add elements at both ends.
2. `removeFirst()` / `removeLast()` → Remove elements from both ends.
3. `peekFirst()` / `peekLast()` → Retrieve elements without removing them.
4. `iterator()` / `spliterator()` → Supports iteration and parallel execution.
5. `size()`, `isEmpty()`, `clear()` → Utility methods for deque management.

---

## ❓ FAQs

1️⃣ **How is `ConcurrentLinkedDeque` different from `ArrayDeque`?**
   - `ConcurrentLinkedDeque` is **thread-safe**, whereas `ArrayDeque` is not.

2️⃣ **Is `ConcurrentLinkedDeque` blocking?**
   - No, it is a **non-blocking, lock-free** deque.

3️⃣ **Does `ConcurrentLinkedDeque` allow `null` elements?**
   - No, `null` values are **not allowed**.

4️⃣ **Can I use `ConcurrentLinkedDeque` in a multi-threaded environment?**
   - Yes, it is **designed for concurrent access**.

---

## 📚 Additional Resources
- [Official Java Docs - ConcurrentLinkedDeque](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedDeque.html)

🚀 Happy Coding! 🎯

