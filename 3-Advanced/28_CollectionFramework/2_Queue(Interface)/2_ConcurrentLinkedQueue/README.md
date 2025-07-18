
# **ConcurrentLinkedQueue in Java** 🚀  

## **1️⃣ Introduction**  
The **ConcurrentLinkedQueue** is a **thread-safe, lock-free, unbounded queue** based on a **non-blocking algorithm** (using **Compare-And-Swap (CAS)**).  

📌 **Key Features:**  
✔ **Thread-safe**: Uses **lock-free CAS operations** instead of locks.  
✔ **Unbounded**: No capacity limit, grows dynamically.  
✔ **FIFO (First-In-First-Out)**: Elements are processed in the same order as they are inserted.  
✔ **Non-Blocking**: Does **not** use locks, so it performs well under high contention.  
✔ **High Performance**: Better than **LinkedBlockingQueue** for concurrent reads/writes.  

📌 **Why is ConcurrentLinkedQueue Important?**  
- Ideal for **multi-threaded, concurrent applications**.  
- Used in **message passing, work queues, and producer-consumer patterns**.  
- Provides better **scalability** than blocking queues in a **multi-core** system.  

---

## **2️⃣ Hierarchy of ConcurrentLinkedQueue**  
`ConcurrentLinkedQueue` extends `AbstractQueue<E>` and implements multiple interfaces:

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── ConcurrentLinkedQueue (Class) ✅ (Our Focus!)
```

✔ **Extends**: `AbstractQueue<E>`  
✔ **Implements**: `Queue<E>, Collection<E>, Iterable<E>`  

---

## **3️⃣ Difference Between ConcurrentLinkedQueue, LinkedBlockingQueue, and ArrayBlockingQueue**  

| Feature                | **ConcurrentLinkedQueue** ✅ | **LinkedBlockingQueue** | **ArrayBlockingQueue** |
|-----------------------|----------------------|----------------------|----------------------|
| **Capacity**         | Unbounded | Bounded (default: Integer.MAX_VALUE) | Bounded (fixed size) |
| **Thread Safety**    | ✅ Yes (Lock-Free) | ✅ Yes (Locks) | ✅ Yes (Locks) |
| **Blocking Operations** | ❌ No | ✅ Yes (take(), put()) | ✅ Yes (take(), put()) |
| **Performance**      | 🔥 High (CAS-based) | Slower due to locks | 🔥 Faster (Array-based) |
| **Use Case**         | Multi-threaded fast access | Producer-Consumer, Work Stealing | High-speed bounded queue |

✔ **Use `ConcurrentLinkedQueue` when:**  
- You need **fast, non-blocking, thread-safe** operations.  
- You need a **highly scalable** queue for concurrent access.  
- You don't need **blocking behavior** (like waiting when empty/full).  

---

## **4️⃣ Real-World Analogy** 🚗  

### **Think of ConcurrentLinkedQueue like a VIP Line at a Concert 🎤**  
- Fans (**tasks**) enter **at the back** and exit **at the front**.  
- No security checkpoint (**lock-free, no waiting**).  
- Very **fast movement** (**non-blocking CAS**).  
- People can enter/leave at the **same time** without slowing others down.  

---

## **5️⃣ When to Use ConcurrentLinkedQueue?**  

✔ **Multi-threaded Task Scheduling Systems** → Fast non-blocking access.  
✔ **Message Passing Systems** → Threads communicate efficiently.  
✔ **Work-Stealing Algorithms** → Parallel task execution.  
✔ **Event Processing Pipelines** → Real-time data streaming.  

---

## **6️⃣ ConcurrentLinkedQueue Methods with Examples**  

### **1️⃣ add(E e)**
📌 Inserts an element at the **end** of the queue.  

```java
import java.util.concurrent.ConcurrentLinkedQueue;

public class AddExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        System.out.println(queue); // Output: [Alice, Bob, Charlie]
    }
}
```

---

### **2️⃣ offer(E e)**
📌 Adds an element **at the end** and returns `true` if successful.  

```java
queue.offer("David");
System.out.println(queue); // Output: [Alice, Bob, Charlie, David]
```

---

### **3️⃣ poll()**
📌 **Removes & returns the first element**, or `null` if empty.  

```java
System.out.println("Removed: " + queue.poll()); // Output: Alice
System.out.println(queue); // Output: [Bob, Charlie, David]
```

---

### **4️⃣ peek()**
📌 Returns the **first element without removing it**.  

```java
System.out.println("First Element: " + queue.peek()); // Output: Bob
```

---

### **5️⃣ isEmpty()**
📌 Checks if the queue is empty.  

```java
System.out.println("Is Queue Empty? " + queue.isEmpty()); // Output: false
```

---

### **6️⃣ size()**
📌 Returns the number of elements in the queue.  

```java
System.out.println("Queue Size: " + queue.size()); // Output: 3
```

---

### **7️⃣ remove(Object o)**
📌 Removes the **first occurrence** of an element.  

```java
queue.remove("Charlie");
System.out.println(queue); // Output: [Bob, David]
```

---

## **7️⃣ FAQs (Frequently Asked Questions) 🤔**  

### **Q1: How is ConcurrentLinkedQueue different from LinkedBlockingQueue?**  
✅ `ConcurrentLinkedQueue` is **lock-free & non-blocking**, while `LinkedBlockingQueue` uses **locks**.  

### **Q2: When should I use `offer()` instead of `add()`?**  
✅ Use `offer()` because it **does not throw exceptions** if insertion fails.  

### **Q3: Is ConcurrentLinkedQueue faster than LinkedBlockingQueue?**  
✅ **Yes!** Because it avoids locks and uses a **CAS-based lock-free algorithm**.  

### **Q4: Can multiple threads safely add and remove elements from ConcurrentLinkedQueue?**  
✅ Yes! It is **thread-safe** and supports **concurrent access**.  

---

## **8️⃣ More Resources** 📚  
🔗 [Official Java Docs on ConcurrentLinkedQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html)  
🔗 [Queue Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)  

---

## **9️⃣ Hands-on Practice** 🎯  
Check out the **[Practice Problems Folder](./practice/concurrentlinkedqueue/)** in this repository for exercises to test your understanding.

---

🚀 **Now you're ready to use ConcurrentLinkedQueue effectively in Java!** 🎯 Let me know if you have any questions. Happy coding! 👨‍💻🔥