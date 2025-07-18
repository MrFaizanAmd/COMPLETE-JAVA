# 📌 Java PriorityBlockingQueue Methods - A Complete Guide

## 🔥 Introduction

`PriorityBlockingQueue` is a **thread-safe, unbounded priority queue** that **orders elements based on natural ordering or a custom comparator**. It is part of the `java.util.concurrent` package and supports **efficient priority-based retrieval**.

This guide covers **all built-in methods**, their explanations, use cases, practical examples, and time complexities.

---

## 🏢 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── BlockingQueue
│   │   ├── PriorityBlockingQueue
```

- `PriorityBlockingQueue<E>` implements `BlockingQueue<E>` and provides **priority-based retrieval behavior**.

---

## **1⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element based on priority | **O(log n)** |
| `offer(E e)` | Inserts an element without blocking | **O(log n)** |
| `put(E e)` | Inserts an element (same as offer) | **O(log n)** |
| `poll()` | Retrieves and removes the head (smallest element) | **O(log n)** |
| `poll(long timeout, TimeUnit unit)` | Retrieves the head, waits if empty | **O(log n)** |
| `take()` | Retrieves and removes the head, blocks if empty | **O(log n)** |
| `peek()` | Retrieves but does not remove the head | **O(1)** |
| `size()` | Returns the number of elements | **O(1)** |
| `remainingCapacity()` | Always returns `Integer.MAX_VALUE` (unbounded) | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(n)** |
| `spliterator()` | Returns a `Spliterator` for parallel iteration | **O(n)** |
| `drainTo(Collection<? super E> c)` | Transfers elements to another collection | **O(n log n)** |
| `drainTo(Collection<? super E> c, int maxElements)` | Transfers up to `maxElements` | **O(n log n)** |

---

## **2⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Insert Element Based on Priority**

```java
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.add(30);
        queue.add(10);
        queue.add(20);
        System.out.println(queue); // Output: [10, 30, 20] (Sorted order)
    }
}
```

### 📝 **2. `offer(E e)` - Insert Without Blocking**

```java
System.out.println(queue.offer(40)); // Output: true
```

### 📝 **3. `take()` - Retrieve and Remove Head (Blocks if Empty)**

```java
new Thread(() -> {
    try {
        System.out.println("Taken: " + queue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **4. `poll()` - Retrieve and Remove Head**

```java
System.out.println(queue.poll()); // Output: 10 (smallest element)
System.out.println(queue); // Output: [20, 30]
```

### 📝 **5. `peek()` - Retrieve Head Without Removing**

```java
System.out.println(queue.peek()); // Output: 20 (smallest element)
```

### 📝 **6. `iterator()` - Iterate Over Elements**

```java
for (int num : queue) {
    System.out.print(num + " ");
}
// Output: Elements in priority order
```

### 📝 **7. `drainTo(Collection<? super E> c)` - Transfer Elements**

```java
List<Integer> list = new ArrayList<>();
queue.drainTo(list);
System.out.println(list); // Output: [20, 30, 40]
```

### 📝 **8. `spliterator()` - Parallel Processing Support**

```java
queue.spliterator().forEachRemaining(System.out::println);
```

---

## **3⃣ Use Case Scenarios**

👉 **Task Scheduling** → Ensures higher priority tasks execute first.

👉 **Dijkstra's Algorithm** → Useful for shortest path problems.

👉 **CPU Job Scheduling** → Prioritizes high-priority processes.

👉 **Emergency Response Systems** → Critical tasks processed first.

👉 **Background Task Processing** → Orders tasks based on priority.

---

## **💚 Summary**

1. `add()`, `offer()`, `put()` → Insert elements with priority ordering.
2. `poll()`, `take()` → Retrieve elements with different waiting policies.
3. `size()`, `remainingCapacity()` → Get queue statistics.
4. `iterator()`, `spliterator()` → Supports iteration and parallel execution.
5. `drainTo()` → Transfers elements efficiently.

---

## **❓ FAQs**

1️⃣ **How is `PriorityBlockingQueue` different from `PriorityQueue`?**
   - `PriorityBlockingQueue` is **thread-safe**, whereas `PriorityQueue` is not.

2️⃣ **What happens if two elements have the same priority?**
   - They are ordered arbitrarily.

3️⃣ **Is `PriorityBlockingQueue` bounded?**
   - No, it grows dynamically.

4️⃣ **Does it maintain FIFO order for same priority elements?**
   - No, it does not guarantee FIFO ordering for equal elements.

---

## 📚 Additional Resources
- [Official Java Docs - PriorityBlockingQueue](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/PriorityBlockingQueue.html)

🚀 Happy Coding! 🎯

