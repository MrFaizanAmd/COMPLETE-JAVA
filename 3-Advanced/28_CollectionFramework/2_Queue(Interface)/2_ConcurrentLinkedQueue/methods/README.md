# 📌 Java ConcurrentLinkedQueue Methods - A Complete Guide

## 🔥 Introduction

The `ConcurrentLinkedQueue<E>` class in Java is an **unbounded, thread-safe, non-blocking queue** based on a **lock-free linked node algorithm**. It is part of the **java.util.concurrent** package and is well-suited for **high-performance, multi-threaded environments**.

This guide covers **all built-in methods** of `ConcurrentLinkedQueue`, their explanations, practical examples, and time complexity.

---

## 🏗 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Queue
│   │   ├── ConcurrentLinkedQueue
```

- Implements `Queue<E>`, inheriting methods for **FIFO (First-In, First-Out) operations**.
- Uses **non-blocking algorithms**, making it efficient for concurrent access.

---

## **1️⃣ ConcurrentLinkedQueue Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `boolean add(E e)` | Inserts an element into the queue (throws exception on failure). | **O(1)** |
| `boolean offer(E e)` | Inserts an element into the queue (returns false on failure). | **O(1)** |
| `E poll()` | Retrieves and removes the head element, returning `null` if empty. | **O(1)** |
| `E peek()` | Retrieves but does not remove the head element, returning `null` if empty. | **O(1)** |
| `boolean isEmpty()` | Checks if the queue is empty. | **O(1)** |
| `int size()` | Returns an approximate count of elements (not always accurate due to concurrency). | **O(n)** |
| `boolean remove(Object o)` | Removes a single instance of the specified element. | **O(n)** |
| `boolean contains(Object o)` | Checks if an element exists in the queue. | **O(n)** |
| `void clear()` | Removes all elements from the queue. | **O(n)** |
| `Iterator<E> iterator()` | Returns an iterator over the elements. | **O(1)** |
| `Spliterator<E> spliterator()` | Returns a `Spliterator` for parallel iteration. | **O(1)** |

---

## **2️⃣ Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Insert an Element**

- Inserts the specified element.
- **Throws `NullPointerException` if element is null.**
- **Time Complexity:** O(1)

```java
import java.util.concurrent.ConcurrentLinkedQueue;

public class CLQExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("Apple");
        queue.add("Banana");
        System.out.println(queue); // Output: [Apple, Banana]
    }
}
```

---

### 📝 **2. `offer(E e)` - Insert an Element (Preferred Method)**

- Similar to `add(E e)`, but returns `false` instead of throwing an exception.
- **Time Complexity:** O(1)

```java
queue.offer("Orange");
System.out.println(queue); // Output: [Apple, Banana, Orange]
```

---

### 📝 **3. `poll()` - Remove and Return the Head Element**

- Removes and returns the **head** of the queue.
- Returns `null` if the queue is empty.
- **Time Complexity:** O(1)

```java
System.out.println(queue.poll()); // Output: Apple
System.out.println(queue); // Output: [Banana, Orange]
```

---

### 📝 **4. `peek()` - Get the Head Element Without Removing**

- Retrieves the **head** without removing it.
- Returns `null` if the queue is empty.
- **Time Complexity:** O(1)

```java
System.out.println(queue.peek()); // Output: Banana
```

---

### 📝 **5. `isEmpty()` - Check if the Queue is Empty**

- Returns `true` if the queue has no elements.
- **Time Complexity:** O(1)

```java
System.out.println(queue.isEmpty()); // Output: false
```

---

### 📝 **6. `size()` - Get Approximate Size of the Queue**

- Returns an **approximate** count of elements (not guaranteed due to concurrency).
- **Time Complexity:** O(n)

```java
System.out.println(queue.size()); // Output: 2
```

---

### 📝 **7. `remove(Object o)` - Remove a Specific Element**

- Removes the **first occurrence** of the specified element.
- Returns `true` if successful, `false` otherwise.
- **Time Complexity:** O(n)

```java
System.out.println(queue.remove("Banana")); // Output: true
System.out.println(queue); // Output: [Orange]
```

---

### 📝 **8. `contains(Object o)` - Check if an Element Exists**

- Returns `true` if the element exists, `false` otherwise.
- **Time Complexity:** O(n)

```java
System.out.println(queue.contains("Orange")); // Output: true
```

---

### 📝 **9. `clear()` - Remove All Elements**

- Clears all elements from the queue.
- **Time Complexity:** O(n)

```java
queue.clear();
System.out.println(queue.isEmpty()); // Output: true
```

---


### **1️0 `spliterator()` Method**

#### **📌 Description**
- The `spliterator()` method returns a `Spliterator` over the elements in the `ConcurrentLinkedQueue`.
- It is useful for parallel processing of elements.

#### **📌 Example**
```java
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");

        Spliterator<String> spliterator = queue.spliterator();
        spliterator.forEachRemaining(System.out::println);
    }
}
```
**🔹 Output:**
```
Apple
Banana
Cherry
```
**🔹 Key Notes:**
- `forEachRemaining()` iterates through all elements.
- `Spliterator` supports parallel iteration.

---

### **11 `iterator()` Method**

#### **📌 Description**
- The `iterator()` method returns an **iterator** over the elements in the `ConcurrentLinkedQueue`.
- Unlike `Spliterator`, this is used for sequential traversal.

#### **📌 Example**
```java
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```
**🔹 Output:**
```
1
2
3
```
**🔹 Key Notes:**
- `hasNext()` checks if more elements are present.
- `next()` retrieves the next element.
- **Unlike some other iterators, this one does not throw `ConcurrentModificationException` if modified during iteration.**

---

## **3️⃣ Use Case Scenarios**

✅ **Multi-threaded Task Queues** → Thread-safe queue for producer-consumer tasks.

✅ **Logging Systems** → Concurrent queue for efficient log event handling.

✅ **Event-Driven Systems** → Handles events in concurrent applications.

✅ **Non-blocking Data Sharing** → Suitable for real-time concurrent applications.

---

## **📌 Summary**

1. `add(E e)` → Inserts an element (throws exception if it fails).
2. `offer(E e)` → Inserts an element (returns false if it fails).
3. `poll()` → Retrieves and removes the head element.
4. `peek()` → Retrieves but does not remove the head element.
5. `isEmpty()` → Checks if the queue is empty.
6. `size()` → Gets the approximate size of the queue.
7. `remove(Object o)` → Removes a specific element.
8. `contains(Object o)` → Checks if an element exists.
9. `clear()` → Removes all elements from the queue.

---

## ❓ FAQs

1️⃣ **How is `ConcurrentLinkedQueue` different from `LinkedList`?**  
   - `ConcurrentLinkedQueue` is **thread-safe and non-blocking**, while `LinkedList` is **not thread-safe**.

2️⃣ **Does `ConcurrentLinkedQueue` allow `null` elements?**  
   - No, it throws `NullPointerException` if `null` is added.

3️⃣ **Is `size()` always accurate?**  
   - No, due to concurrent modifications, `size()` is an estimate.

---

## 📚 Additional Resources
- [Official Java Docs - ConcurrentLinkedQueue](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/ConcurrentLinkedQueue.html)

🚀 Happy Coding! 🎯

