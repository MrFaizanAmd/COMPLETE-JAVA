

# **ConcurrentLinkedDeque in Java** 🚀  

## **1️⃣ Introduction**  
The **ConcurrentLinkedDeque** is a **lock-free, thread-safe** **double-ended queue (Deque)** based on a **non-blocking algorithm** (using **Compare-And-Swap (CAS)**).  

📌 **Key Features:**  
✔ **Thread-safe**: Uses **lock-free CAS operations** instead of locks.  
✔ **Unbounded**: No capacity limit.  
✔ **FIFO or LIFO**: Supports both **queue (FIFO)** and **stack (LIFO)** operations.  
✔ **Non-Blocking**: Does **not** use locks, so it performs well under high contention.  
✔ **High Performance**: Better than **LinkedBlockingDeque** for concurrent reads/writes.  

📌 **Why is ConcurrentLinkedDeque Important?**  
- Ideal for **multi-threaded, concurrent applications**.  
- Used in **work-stealing** and **non-blocking** algorithms.  
- Provides better **scalability** than blocking queues in a **multi-core** system.  

---

## **2️⃣ Hierarchy of ConcurrentLinkedDeque**  
`ConcurrentLinkedDeque` extends `AbstractCollection<E>` and implements multiple interfaces:

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── Deque (Interface)  
│   │   │   ├── ConcurrentLinkedDeque (Class) ✅ (Our Focus!)
```

✔ **Extends**: `AbstractCollection<E>`  
✔ **Implements**: `Deque<E>, Queue<E>, Collection<E>, Iterable<E>`  

---

## **3️⃣ Difference Between ConcurrentLinkedDeque, LinkedBlockingDeque, and ArrayDeque**  

| Feature                | **ConcurrentLinkedDeque** ✅ | **LinkedBlockingDeque** | **ArrayDeque** |
|-----------------------|----------------------|----------------------|----------------------|
| **Capacity**         | Unbounded | Bounded (default: Integer.MAX_VALUE) | Unbounded |
| **Thread Safety**    | ✅ Yes (Lock-Free) | ✅ Yes (Locks) | ❌ No |
| **Blocking Operations** | ❌ No | ✅ Yes (take(), put()) | ❌ No |
| **Performance**      | 🔥 High (CAS-based) | Slower due to locks | 🔥 Fastest (Single-threaded) |
| **Use Case**         | Multi-threaded fast access | Producer-Consumer, Work Stealing | Fast Stack/Queue |

✔ **Use `ConcurrentLinkedDeque` when:**  
- You need **fast, non-blocking, thread-safe** operations.  
- You need a **highly scalable** deque for concurrent access.  
- You don't need **blocking behavior** (like waiting when empty/full).  

---

## **4️⃣ Real-World Analogy** 🚗  

### **Think of ConcurrentLinkedDeque like a VIP Entrance with Two Doors** 🚦  
- People (**tasks**) can enter/exit **from either door**.  
- No security checkpoint (**lock-free, no waiting**).  
- Very **fast movement** (**non-blocking CAS**).  
- People can enter/leave at the **same time** without slowing others down.  

---

## **5️⃣ When to Use ConcurrentLinkedDeque?**  

✔ **Multi-threaded Task Scheduling Systems** → Fast non-blocking access.  
✔ **Work-Stealing Algorithms** → Efficient parallel task execution.  
✔ **High-Performance Caches** → Supports LRU (Least Recently Used) caching.  
✔ **Event Processing Pipelines** → Used in real-time data streaming.  

---

## **6️⃣ ConcurrentLinkedDeque Methods with Examples**  

### **1️⃣ addFirst(E e)**
📌 Inserts an element at the **front** of the deque.  

```java
import java.util.concurrent.ConcurrentLinkedDeque;

public class AddFirstExample {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");

        System.out.println(deque); // Output: [C, B, A]
    }
}
```

---

### **2️⃣ addLast(E e)**
📌 Inserts an element at the **end** of the deque.  

```java
deque.addLast("D");
System.out.println(deque); // Output: [C, B, A, D]
```

---

### **3️⃣ pollFirst()**
📌 **Removes & returns the first element**, or `null` if empty.  

```java
System.out.println("Removed: " + deque.pollFirst());
```

---

### **4️⃣ pollLast()**
📌 **Removes & returns the last element**, or `null` if empty.  

```java
System.out.println("Removed: " + deque.pollLast());
```

---

### **5️⃣ peekFirst() & peekLast()**
📌 Returns the **first/last** element **without removing it**.  

```java
System.out.println(deque.peekFirst()); // Get first element
System.out.println(deque.peekLast()); // Get last element
```

---

### **6️⃣ OfferFirst() & OfferLast()**
📌 Adds an element **at the front or back**, returning `true` if successful.  

```java
deque.offerFirst("X");
deque.offerLast("Y");
System.out.println(deque); // Output: [X, C, B, A, D, Y]
```

---

### **7️⃣ RemoveFirstOccurrence() & RemoveLastOccurrence()**
📌 Removes the **first or last occurrence** of an element.  

```java
deque.removeFirstOccurrence("A");
deque.removeLastOccurrence("B");
System.out.println(deque);
```

---

## **7️⃣ FAQs (Frequently Asked Questions) 🤔**  

### **Q1: How is ConcurrentLinkedDeque different from LinkedBlockingDeque?**  
✅ `ConcurrentLinkedDeque` is **lock-free & non-blocking**, while `LinkedBlockingDeque` uses **locks**.  

### **Q2: When should I use `offerFirst()` instead of `addFirst()`?**  
✅ Use `offerFirst()` because it **does not throw exceptions** if insertion fails.  

### **Q3: Is ConcurrentLinkedDeque faster than LinkedBlockingDeque?**  
✅ **Yes!** Because it avoids locks and uses a **CAS-based lock-free algorithm**.  

### **Q4: Can multiple threads safely add and remove elements from ConcurrentLinkedDeque?**  
✅ Yes! It is **thread-safe** and supports **concurrent access**.  

---

## **8️⃣ More Resources** 📚  
🔗 [Official Java Docs on ConcurrentLinkedDeque](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedDeque.html)  
🔗 [Deque Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)  

---

## **9️⃣ Hands-on Practice** 🎯  
Check out the **[Practice Problems Folder](./practice/concurrentlinkeddeque/)** in this repository for exercises to test your understanding.

---

🚀 **Now you're ready to use ConcurrentLinkedDeque effectively in Java!** 🎯 Let me know if you have any questions. Happy coding! 👨‍💻🔥