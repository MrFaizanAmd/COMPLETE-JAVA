# 📌 Java TransferQueue Methods - A Complete Guide

## 🔥 Introduction

`TransferQueue<E>` is an extension of `BlockingQueue<E>` that provides additional methods to transfer elements between producer and consumer threads more efficiently. It belongs to the `java.util.concurrent` package and is implemented by `LinkedTransferQueue`.

This guide covers **all built-in methods**, explanations, practical examples, real-life use cases, and performance considerations.

---

## 🏗 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── BlockingQueue
│   │   │   ├── TransferQueue
```

- `TransferQueue<E>` extends `BlockingQueue<E>` and introduces **transfer operations**.

---

## **1️⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element if possible, else throws an exception | **O(1)** |
| `offer(E e)` | Inserts an element if possible, returns `false` if full | **O(1)** |
| `offer(E e, long timeout, TimeUnit unit)` | Inserts an element, waits for the time if full | **O(1)** |
| `put(E e)` | Inserts an element, waits if full | **O(1)** |
| `transfer(E e)` | Transfers an element and waits until it is consumed | **O(1) / O(n)** |
| `tryTransfer(E e)` | Transfers an element without waiting | **O(1)** |
| `tryTransfer(E e, long timeout, TimeUnit unit)` | Transfers an element, waits for timeout | **O(1) / O(n)** |
| `take()` | Retrieves and removes the head, waits if empty | **O(1)** |
| `poll()` | Retrieves and removes the head, returns `null` if empty | **O(1)** |
| `poll(long timeout, TimeUnit unit)` | Retrieves and removes the head, waits for time | **O(1)** |
| `peek()` | Retrieves but does not remove the head | **O(1)** |
| `hasWaitingConsumer()` | Checks if a consumer is waiting | **O(1)** |
| `getWaitingConsumerCount()` | Returns the number of waiting consumers | **O(1)** |
| `size()` | Returns the number of elements | **O(1)** |
| `remainingCapacity()` | Returns remaining space in queue | **O(1)** |
| `isEmpty()` | Checks if the queue is empty | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(1)** |
| `spliterator()` | Returns a `Spliterator` for parallel iteration | **O(1)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `transfer(E e)` - Transfer Element to Consumer**

```java
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<>();
        
        new Thread(() -> {
            try {
                System.out.println("Consumer received: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        try {
            queue.transfer("Hello World");
            System.out.println("Element transferred");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### 📝 **2. `tryTransfer(E e)` - Transfer Without Waiting**

```java
System.out.println(queue.tryTransfer("Test")); // Output: false (if no waiting consumer)
```

### 📝 **3. `tryTransfer(E e, long timeout, TimeUnit unit)` - Conditional Transfer**

```java
if (queue.tryTransfer("Delayed", 2, TimeUnit.SECONDS)) {
    System.out.println("Element transferred");
} else {
    System.out.println("No consumer available, transfer failed");
}
```

### 📝 **4. `hasWaitingConsumer()` - Check if Consumers Are Waiting**

```java
System.out.println("Consumers waiting: " + queue.hasWaitingConsumer());
```

### 📝 **5. `getWaitingConsumerCount()` - Get Waiting Consumers Count**

```java
System.out.println("Waiting Consumers: " + queue.getWaitingConsumerCount());
```

### 📝 **6. `poll()` - Retrieve and Remove Head Element**

```java
System.out.println(queue.poll()); // Output: Element or null
```

### 📝 **7. `spliterator()` - Parallel Processing Support**

```java
queue.spliterator().forEachRemaining(System.out::println);
```

---

## **3️⃣ Use Case Scenarios**

✅ **Efficient Producer-Consumer Synchronization** → Transfers elements directly to consumers.

✅ **Task Dispatching** → Ensures real-time message processing in multi-threaded environments.

✅ **Event-Driven Systems** → Suitable for event-driven architectures where tasks need immediate handling.

✅ **Asynchronous Data Sharing** → Allows seamless communication between multiple threads.

✅ **Real-time Data Pipelines** → Ensures data is processed in order and consumed immediately.

---

## **📌 Summary**

1. `transfer()`, `tryTransfer()` → Send elements directly to consumers with different waiting strategies.
2. `hasWaitingConsumer()`, `getWaitingConsumerCount()` → Check consumer availability.
3. `poll()`, `take()` → Retrieve and remove elements with different waiting conditions.
4. `spliterator()` → Supports parallel processing.

---

## ❓ FAQs

1️⃣ **What is the key difference between `transfer()` and `put()`?**
   - `transfer()` blocks until an element is consumed, whereas `put()` only inserts an element.

2️⃣ **How does `tryTransfer(E e)` work?**
   - It returns `false` if no consumer is waiting, unlike `transfer()` which waits.

3️⃣ **Is `TransferQueue` thread-safe?**
   - Yes, it is designed for concurrent environments.

4️⃣ **When should I use `TransferQueue` instead of `BlockingQueue`?**
   - When you want a producer to directly hand off elements to consumers without storing them in a queue.

---

## 📚 Additional Resources
- [Official Java Docs - TransferQueue](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/TransferQueue.html)

🚀 Happy Coding! 🎯

