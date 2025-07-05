# 📌 Java SynchronousQueue Methods - A Complete Guide

## 🔥 Introduction

`SynchronousQueue` is a **blocking queue** in Java that does not store elements. Each insert operation must wait for a corresponding remove operation by another thread. It is part of the `java.util.concurrent` package and is often used in **producer-consumer scenarios**.

This guide covers **all built-in methods**, their explanations, practical examples, and use cases.

---

## 🏗 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── BlockingQueue
│   │   │   ├── SynchronousQueue
```

- `SynchronousQueue<E>` implements `BlockingQueue<E>` but has **no capacity** and allows direct handoff between threads.

---

## **1️⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element, throws `IllegalStateException` if no waiting consumer | **O(1)** |
| `offer(E e)` | Tries to insert an element, returns `false` if no waiting consumer | **O(1)** |
| `offer(E e, long timeout, TimeUnit unit)` | Tries to insert, waits for timeout duration if needed | **O(1)** |
| `put(E e)` | Inserts an element, waits indefinitely for a consumer | **O(1)** |
| `poll()` | Retrieves and removes an element if available, otherwise `null` | **O(1)** |
| `poll(long timeout, TimeUnit unit)` | Waits for timeout duration to retrieve an element | **O(1)** |
| `take()` | Retrieves and removes an element, waits indefinitely if empty | **O(1)** |
| `isEmpty()` | Always returns `true` (since queue holds no elements) | **O(1)** |
| `iterator()` | Returns an empty iterator (since no elements are stored) | **O(1)** |
| `spliterator()` | Returns an empty `Spliterator` | **O(1)** |
| `remainingCapacity()` | Always returns `0` since capacity is always zero | **O(1)** |
| `clear()` | Has no effect (since no elements are stored) | **O(1)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Insert an Element**
```java
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        queue.add(10); // Throws IllegalStateException if no consumer is waiting
    }
}
```

### 📝 **2. `offer(E e)` - Attempt to Insert Element**
```java
SynchronousQueue<Integer> queue = new SynchronousQueue<>();
System.out.println(queue.offer(20)); // Output: false (no consumer is waiting)
```

### 📝 **3. `put(E e)` - Insert Element (Blocks if No Consumer)**
```java
new Thread(() -> {
    try {
        queue.put(30);
        System.out.println("Inserted 30");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **4. `poll()` - Retrieve and Remove Element**
```java
System.out.println(queue.poll()); // Output: null (no producer-consumer handoff)
```

### 📝 **5. `take()` - Retrieve and Remove Element (Blocks if Empty)**
```java
new Thread(() -> {
    try {
        System.out.println("Taken: " + queue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **6. `remainingCapacity()` - Always Returns `0`**
```java
System.out.println(queue.remainingCapacity()); // Output: 0
```

### 📝 **7. `iterator()` - Always Empty Iterator**
```java
System.out.println(queue.iterator().hasNext()); // Output: false
```

---

## **3️⃣ Use Case Scenarios**

✅ **Producer-Consumer Pattern** → Used for direct handoff between producer and consumer.

✅ **Thread Synchronization** → Ensures one-to-one message passing.

✅ **Task Dispatching** → Useful for assigning tasks between worker threads.

✅ **Event-Driven Systems** → Used where immediate handoff of data is required.

---

## **📌 Summary**

1. `add()`, `offer()`, `put()` → Insert elements, but they require a waiting consumer.
2. `poll()`, `take()` → Retrieve elements, but they require a waiting producer.
3. `size()`, `remainingCapacity()` → Always return `0` as `SynchronousQueue` does not store elements.
4. `iterator()`, `spliterator()` → Always return empty iterators.

---

## ❓ FAQs

1️⃣ **What happens if a producer inserts an element without a waiting consumer?**
   - The operation blocks until a consumer is available.

2️⃣ **Can `SynchronousQueue` hold more than one element?**
   - No, it does not store elements and requires immediate handoff.

3️⃣ **Is `SynchronousQueue` thread-safe?**
   - Yes, it is designed for concurrent use.

4️⃣ **What is the difference between `put()` and `offer()`?**
   - `put()` blocks indefinitely if no consumer is available, while `offer()` returns `false` immediately if no consumer is waiting.

---

## 📚 Additional Resources
- [Official Java Docs - SynchronousQueue](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/SynchronousQueue.html)

🚀 Happy Coding! 🎯

