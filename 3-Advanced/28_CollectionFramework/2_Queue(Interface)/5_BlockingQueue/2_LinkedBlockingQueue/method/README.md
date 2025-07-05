# 📌 Java LinkedBlockingQueue Methods - A Complete Guide

## 🔥 Introduction

`LinkedBlockingQueue` is a **thread-safe, blocking queue** in Java that uses a **linked list-based** data structure. It is part of the `java.util.concurrent` package and supports **producer-consumer patterns** with optional capacity limits.

This guide covers **all built-in methods**, their explanations, use cases, practical examples, and time complexities.

---

## 🏢 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── BlockingQueue
│   │   │   ├── LinkedBlockingQueue
```

- `LinkedBlockingQueue<E>` implements `BlockingQueue<E>` and provides **thread-safe blocking queue operations**.

---

## **1️⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element if possible, else throws an exception | **O(1)** |
| `offer(E e)` | Inserts an element if possible, returns `false` if full | **O(1)** |
| `offer(E e, long timeout, TimeUnit unit)` | Inserts an element, waits for the time if full | **O(1)** |
| `put(E e)` | Inserts an element, waits if full | **O(1)** |
| `take()` | Retrieves and removes the head, waits if empty | **O(1)** |
| `poll()` | Retrieves and removes the head, returns `null` if empty | **O(1)** |
| `poll(long timeout, TimeUnit unit)` | Retrieves and removes the head, waits for time | **O(1)** |
| `peek()` | Retrieves but does not remove the head | **O(1)** |
| `size()` | Returns the number of elements | **O(1)** |
| `remainingCapacity()` | Returns remaining space in queue | **O(1)** |
| `isEmpty()` | Checks if the queue is empty | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(1)** |
| `spliterator()` | Returns a `Spliterator` for parallel iteration | **O(1)** |
| `drainTo(Collection<? super E> c)` | Transfers elements to another collection | **O(n)** |
| `drainTo(Collection<? super E> c, int maxElements)` | Transfers up to `maxElements` | **O(n)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Add Element to the Queue**

```java
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue); // Output: [10, 20, 30]
    }
}
```

### 📝 **2. `offer(E e)` - Attempt to Insert Element**

```java
System.out.println(queue.offer(40)); // Output: false (queue is full)
```

### 📝 **3. `put(E e)` - Insert Element (Blocks if Full)**

```java
new Thread(() -> {
    try {
        queue.put(40);
        System.out.println("Inserted 40 after space was available");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **4. `poll()` - Retrieve and Remove Head**

```java
System.out.println(queue.poll()); // Output: 10
System.out.println(queue); // Output: [20, 30]
```

### 📝 **5. `take()` - Retrieve and Remove Head (Blocks if Empty)**

```java
new Thread(() -> {
    try {
        System.out.println("Taken: " + queue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **6. `remainingCapacity()` - Get Available Space**

```java
System.out.println(queue.remainingCapacity()); // Output: 1
```

### 📝 **7. `iterator()` - Iterate Over Elements**

```java
for (int num : queue) {
    System.out.print(num + " ");
}
// Output: 20 30
```

### 📝 **8. `drainTo(Collection<? super E> c)` - Transfer Elements**

```java
List<Integer> list = new ArrayList<>();
queue.drainTo(list);
System.out.println(list); // Output: [20, 30]
```

### 📝 **9. `spliterator()` - Parallel Processing Support**

```java
queue.spliterator().forEachRemaining(System.out::println);
```

---

## **3️⃣ Use Case Scenarios**

👉 **Thread-safe Task Queues** → Used in producer-consumer models.

👉 **Real-time Messaging Systems** → Supports concurrent message processing.

👉 **Database Connection Pools** → Manages connections efficiently in a multi-threaded environment.

👉 **Rate Limiting** → Controls the number of requests processed at a time.

👉 **Background Job Scheduling** → Efficient for processing jobs asynchronously.

---

## **📌 Summary**

1. `add()`, `offer()`, `put()` → Insert elements with different behaviors.
2. `poll()`, `take()` → Retrieve and remove elements with different waiting policies.
3. `size()`, `remainingCapacity()` → Get queue statistics.
4. `iterator()`, `spliterator()` → Supports iteration and parallel execution.
5. `drainTo()` → Efficiently transfers elements to another collection.

---

## ❓ FAQs

1️⃣ **What is the difference between `add()` and `offer()`?**
   - `add()` throws an exception if full, while `offer()` returns `false`.

2️⃣ **How does `take()` work?**
   - It blocks until an element is available.

3️⃣ **Is `LinkedBlockingQueue` thread-safe?**
   - Yes, it provides built-in thread safety.

---

## 📚 Additional Resources
- [Official Java Docs - LinkedBlockingQueue](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/LinkedBlockingQueue.html)

🚀 Happy Coding! 🎯