# 📈 Java DelayQueue Methods - A Complete Guide

## 🔥 Introduction

`DelayQueue<E>` is an **unbounded blocking queue** in Java that holds elements until they become eligible for retrieval based on their **delay time**. It is part of the `java.util.concurrent` package and is useful for **scheduled task execution, caching mechanisms, and time-sensitive operations**.

This guide provides a **detailed explanation of all methods**, their use cases, practical examples, and **time complexity**.

---

## 💪 Class Hierarchy

```plaintext
Iterable
├── Collection
    ├── Queue
        ├── BlockingQueue
            ├── DelayQueue
```

- `DelayQueue<E>` implements `BlockingQueue<E>`.
- Stores **Delayed** elements that become available only when their delay expires.

---

## **1️⃣ Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element if it implements `Delayed` | **O(log n)** |
| `offer(E e)` | Inserts an element into the queue | **O(log n)** |
| `put(E e)` | Inserts an element, waits if necessary | **O(log n)** |
| `poll()` | Retrieves and removes the head, returns `null` if none are expired | **O(1)** |
| `poll(long timeout, TimeUnit unit)` | Retrieves and removes head, waits if necessary | **O(1)** |
| `take()` | Retrieves and removes head, waits if no expired elements | **O(1)** |
| `peek()` | Retrieves but does not remove the head | **O(1)** |
| `size()` | Returns the number of elements in the queue | **O(1)** |
| `iterator()` | Returns an iterator over elements | **O(n)** |
| `spliterator()` | Returns a `Spliterator` for parallel iteration | **O(n)** |
| `remainingCapacity()` | Always returns `Integer.MAX_VALUE` | **O(1)** |
| `drainTo(Collection<? super E> c)` | Transfers all expired elements | **O(n)** |
| `drainTo(Collection<? super E> c, int maxElements)` | Transfers up to `maxElements` expired elements | **O(n)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Add Element to the Queue**

```java
import java.util.concurrent.*;

class DelayedTask implements Delayed {
    private long startTime;
    private String message;

    public DelayedTask(String message, long delay) {
        this.startTime = System.currentTimeMillis() + delay;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return message;
    }
}

public class Main {
    public static void main(String[] args) {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        queue.add(new DelayedTask("Task 1", 5000)); // Delay of 5 seconds
    }
}
```

### 📝 **2. `poll()` - Retrieve and Remove Expired Element**

```java
System.out.println(queue.poll()); // Output: null (if delay has not expired)
```

### 📝 **3. `take()` - Retrieve and Remove Expired Element (Blocks if Empty)**

```java
new Thread(() -> {
    try {
        System.out.println("Retrieved: " + queue.take());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}).start();
```

### 📝 **4. `size()` - Get Queue Size**

```java
System.out.println(queue.size()); // Output: 1
```

### 📝 **5. `iterator()` - Iterate Over Elements**

```java
for (DelayedTask task : queue) {
    System.out.println(task);
}
```

### 📝 **6. `drainTo()` - Transfer Expired Elements to Another Collection**

```java
List<DelayedTask> completedTasks = new ArrayList<>();
queue.drainTo(completedTasks);
System.out.println(completedTasks);
```

### 📝 **7. `spliterator()` - Parallel Processing Support**

```java
queue.spliterator().forEachRemaining(System.out::println);
```

---

## **3️⃣ Use Case Scenarios**

✅ **Task Scheduling** → Delayed task execution in background threads.

✅ **Caching Mechanisms** → Automatically removes expired cache items.

✅ **Rate Limiting** → Control execution time for API requests.

✅ **Delayed Message Processing** → Hold messages until they are ready to be processed.

✅ **Job Scheduling** → Prioritize execution based on scheduled delay time.

---

## **📉 Summary**

1. `add()`, `offer()`, `put()` → Insert elements with delay constraints.
2. `poll()`, `take()` → Retrieve and remove elements based on delay expiration.
3. `size()`, `remainingCapacity()` → Get queue statistics.
4. `iterator()`, `spliterator()` → Supports iteration and parallel execution.
5. `drainTo()` → Efficiently transfers expired elements to another collection.

---

## **❓ FAQs**

1️⃣ **How does `take()` work?**
   - It waits until an element’s delay expires before retrieving it.

2️⃣ **What is the difference between `poll()` and `take()`?**
   - `poll()` returns `null` if no elements are available, while `take()` blocks until one is available.

3️⃣ **How does `DelayQueue` order elements?**
   - Elements are retrieved based on their **delay expiration time**.

4️⃣ **Can `DelayQueue` store elements without `Delayed` implementation?**
   - No, elements must implement `Delayed`.

---

## 📚 Additional Resources
- [Official Java Docs - DelayQueue](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/concurrent/DelayQueue.html)

🚀 Happy Coding! 💡

