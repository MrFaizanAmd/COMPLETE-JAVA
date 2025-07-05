

# **LinkedBlockingDeque in Java** 🚀  

## **1️⃣ Introduction**  
The **LinkedBlockingDeque** is a **double-ended, blocking queue** that allows elements to be inserted and removed from both ends (**Deque = Double-Ended Queue**).  

📌 **Key Features:**  
✔ **Thread-safe**: Uses **locks** for concurrency control.  
✔ **Bounded**: Can specify a maximum capacity (default: `Integer.MAX_VALUE`).  
✔ **FIFO or LIFO**: Supports both **queue (FIFO)** and **stack (LIFO)** operations.  
✔ **Blocking Operations**: Can **wait** for space or elements when needed.  

📌 **Why is LinkedBlockingDeque Important?**  
- Efficient **multi-threaded task processing**.  
- Ideal for **work-stealing algorithms** (where tasks are dequeued from either end).  
- Supports both **producer-consumer** and **stack-like (LIFO)** usage.  

---

## **2️⃣ Hierarchy of LinkedBlockingDeque**  
`LinkedBlockingDeque` is a class that extends `AbstractQueue<E>` and implements multiple interfaces:

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── Deque (Interface)  
│   │   │   ├── BlockingDeque (Interface)  
│   │   │   │   ├── LinkedBlockingDeque (Class) ✅ (Our Focus!)
```

✔ **Extends**: `AbstractQueue<E>`  
✔ **Implements**: `BlockingDeque<E>, Deque<E>, BlockingQueue<E>, Queue<E>, Collection<E>, Iterable<E>`  

---

## **3️⃣ Difference Between LinkedBlockingDeque, ArrayDeque, and ConcurrentLinkedDeque**  

| Feature                | **LinkedBlockingDeque** ✅ | **ArrayDeque** | **ConcurrentLinkedDeque** |
|-----------------------|----------------------|----------------------|----------------------|
| **Capacity**         | Bounded (default: Integer.MAX_VALUE) | Unbounded | Unbounded |
| **Thread Safety**    | ✅ Yes (Locks) | ❌ No | ✅ Yes (Lock-Free) |
| **Blocking Operations** | ✅ Yes (take(), put()) | ❌ No | ❌ No |
| **Performance**      | Slower due to locks | Faster (Array-based) | Faster (CAS-based) |
| **Use Case**         | Producer-Consumer, Work Stealing | Fast Stack/Queue | Fast multi-threaded access |

✔ **Use `LinkedBlockingDeque` when:**  
- You need **safe multi-threaded access**.  
- You want **blocking behavior** (waiting if empty/full).  
- You need **both queue (FIFO) and stack (LIFO) operations**.  

---

## **4️⃣ Real-World Analogy** 🚗  

### **Think of LinkedBlockingDeque like a Double-Sided Toll Booth** 🚦  
- Vehicles (**tasks**) can enter from **either side**.  
- If one lane is full, vehicles must **wait** (blocking).  
- Supports **FIFO (queue behavior)** or **LIFO (stack behavior)**, depending on the flow.  

---

## **5️⃣ When to Use LinkedBlockingDeque?**  

✔ **Task Scheduling Systems** → Allows processing from both ends.  
✔ **Multi-Threaded Work-Stealing Algorithms** → Distribute workload efficiently.  
✔ **Producer-Consumer Scenarios** → Multiple producers and consumers can operate.  

---

## **6️⃣ LinkedBlockingDeque Methods with Examples**  

### **1️⃣ addFirst(E e)**
📌 Inserts an element at the **front** of the deque.  
✅ Throws an exception if full.  

```java
import java.util.concurrent.LinkedBlockingDeque;

public class AddFirstExample {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(3);
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
✅ Throws an exception if full.  

```java
deque.addLast("D");
System.out.println(deque); // Output: [C, B, A, D]
```

---

### **3️⃣ putFirst(E e)**
📌 **Blocks** if the deque is **full**, waits until space is available.  

```java
import java.util.concurrent.LinkedBlockingDeque;

public class PutFirstExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>(2);

        deque.putFirst(1);
        deque.putFirst(2);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Removing: " + deque.takeLast());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        deque.putFirst(3); // Blocks until space is available
        System.out.println(deque);
    }
}
```

---

### **4️⃣ takeLast()**
📌 **Removes & returns the last element** (blocks if empty).  

```java
System.out.println("Removed: " + deque.takeLast());
```

---

### **5️⃣ pollFirst(long timeout, TimeUnit unit)**
📌 **Waits for a specific time**, then returns `null` if deque is still empty.  

```java
import java.util.concurrent.*;

public class PollFirstExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>();

        String result = deque.pollFirst(2, TimeUnit.SECONDS);
        System.out.println("Result: " + result); // Output: Result: null
    }
}
```

---

### **6️⃣ peekFirst() & peekLast()**
📌 Returns the **first/last** element **without removing it**.  

```java
System.out.println(deque.peekFirst()); // Get first element
System.out.println(deque.peekLast()); // Get last element
```

---

## **7️⃣ FAQs (Frequently Asked Questions) 🤔**  

### **Q1: How is LinkedBlockingDeque different from LinkedBlockingQueue?**  
✅ `LinkedBlockingDeque` allows **insertion/removal from both ends**, while `LinkedBlockingQueue` only allows **FIFO operations**.  

### **Q2: When should I use `putFirst()` instead of `addFirst()`?**  
✅ Use `putFirst()` when you want **blocking behavior** (wait if full), and `addFirst()` if you want an **exception when full**.  

### **Q3: Can I use LinkedBlockingDeque in a multi-threaded environment?**  
✅ Yes! It's **thread-safe** and ideal for **work-stealing algorithms**.  

### **Q4: Is LinkedBlockingDeque faster than ArrayDeque?**  
❌ No, **ArrayDeque** is faster because it's **not thread-safe** and doesn't use locks.  

---

## **8️⃣ More Resources** 📚  
🔗 [Official Java Docs on LinkedBlockingDeque](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBlockingDeque.html)  
🔗 [Deque Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)  

---

## **9️⃣ Hands-on Practice** 🎯  
Check out the **[Practice Problems Folder](./practice/linkedblockingdeque/)** in this repository for exercises to test your understanding.

---

🚀 **Now you're ready to use LinkedBlockingDeque effectively in Java!** 🎯 Let me know if you have any questions. Happy coding! 👨‍💻🔥