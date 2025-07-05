# 📚 **Queue in Java - The FIFO Data Structure!**
This repository is designed to take you on an **organized, step-by-step journey** through Java programming. We start with the **Queue data structure**, and from there, we will explore every implementation class of Queue **one-by-one** in subfolders of this project. Our goal is to make Java learning structured, easy to understand, and highly practical!

---
## 🔹 **Hierarchy of Queue**
Before diving into **Queue**, let's understand where it fits in the **Java Collection Framework**.

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  ✅ (Our Focus!)
│   │   ├── PriorityQueue
│   │   ├── ArrayDeque
│   │   ├── LinkedList
```

### 🚀 **What is a Queue?**
A **Queue** is a **FIFO (First-In-First-Out)** data structure where elements are added at the **rear** and removed from the **front**.

### 🔹 **Why is a Queue Important?**
Queues are widely used in programming for tasks like:
- **Task scheduling** (e.g., print queue, process scheduling in operating systems)
- **Handling requests** (e.g., message queues in distributed systems)
- **Breadth-first search algorithms** (e.g., shortest path finding in graphs)
- **Managing resources** (e.g., handling requests in web servers)

---

## 📖 **Key Concepts and Terminology**

1. **Enqueue** – Adding an element to the end of the queue.
2. **Dequeue** – Removing an element from the front of the queue.
3. **Front (Head)** – The element at the beginning of the queue.
4. **Rear (Tail)** – The element at the end of the queue.
5. **FIFO (First In, First Out)** – The order in which elements are processed.
6. **Types of Queues** – Simple Queue, Circular Queue, Priority Queue, Double-ended Queue (Deque).
---

## 📝 **Types of Queue in Java**

### 1️⃣ **Simple Queue (FIFO Queue)**
A standard queue that follows the **First-In-First-Out** order.

### 2️⃣ **PriorityQueue**
A queue where elements are processed based on their **priority**, not FIFO.

### 3️⃣ **Deque (Double-Ended Queue)**
Allows insertion and deletion from **both ends** (Front & Rear).

### 4️⃣ **Circular Queue**
A queue where the **last position** is connected to the **first position**, making it circular.

---

## 🔧 **Core Methods of Queue Interface**
| Method | Description |
|--------|------------|
| `add(E e)` | Inserts an element at the rear (throws exception if full) |
| `offer(E e)` | Inserts an element (returns false if full) |
| `remove()` | Removes and returns the front element (throws exception if empty) |
| `poll()` | Removes and returns the front element (returns null if empty) |
| `element()` | Retrieves the front element without removing it (throws exception if empty) |
| `peek()` | Retrieves the front element without removing it (returns null if empty) |

---

## 🎲 **How to Use a Queue in Java?**

### 🛠 **Basic Queue Example**
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Retrieving elements
        System.out.println("Front: " + queue.peek());  // 10

        // Removing elements
        queue.poll();  // Removes 10
        System.out.println("After removing: " + queue);
    }
}
```
📅 **Output:**
```
Front: 10
After removing: [20, 30]
```

---

### 📈 **PriorityQueue Example**
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(40);
        pq.add(10);
        pq.add(30);

        System.out.println("Priority Queue: " + pq);
        System.out.println("Smallest Element: " + pq.poll()); // Removes 10 (smallest)
    }
}
```
📅 **Output:**
```
Priority Queue: [10, 40, 30]
Smallest Element: 10
```

---

## 🔍 **Comparison of Queue Implementations**
| Implementation | Ordered? | Allows Null? | Thread-Safe? |
|---------------|---------|-------------|-------------|
| `LinkedList` | Yes | Yes | No |
| `PriorityQueue` | Sorted | No | No |
| `ArrayDeque` | Yes | No | No |

---

## 📊 **Performance Analysis**
| Operation | `LinkedList` | `PriorityQueue` | `ArrayDeque` |
|-----------|------------|---------------|------------|
| `offer()` (Add) | O(1) | O(log n) | O(1) |
| `poll()` (Remove) | O(1) | O(log n) | O(1) |
| `peek()` (Front Element) | O(1) | O(1) | O(1) |

---

## 🔍 **When to Use Which Queue?**
- Use **`LinkedList`** when you need a simple **FIFO Queue**.
- Use **`PriorityQueue`** when you need a **priority-based ordering**.
- Use **`ArrayDeque`** when you need a **fast, resizable queue**.

---
## 🔥 **Real-World Analogy**
Imagine a customer service center where people take tickets and wait in line. The first person who took a ticket will be served first (FIFO). New customers always join at the end of the line, just like elements being added to a queue!

---

## 📌 **Advanced Queue Implementations in Java**
We will explore different Queue implementations in the **subfolders** of this project, covering:

- **PriorityQueue** (Elements are processed based on priority, not FIFO)
- **ArrayDeque** (Efficient implementation of both Queue and Stack operations)
- **LinkedList as a Queue**
- **BlockingQueue** (Useful for multi-threading applications)
- **ConcurrentLinkedQueue** (Thread-safe queue for concurrent applications)

Each subfolder will contain a **detailed explanation**, **Java code examples**, and **hands-on practice files**. 🚀

---
## 🔎 **Further Reading**
- [Java Queue (Oracle Docs)](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
- [Java PriorityQueue Docs](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)

---

## 🚀 **Final Thoughts**
The **Queue** is a fundamental **data structure** used in scheduling, buffering, and real-world applications like **printer queues, task scheduling, and breadth-first search (BFS)**. Mastering its variations like **PriorityQueue** and **Deque** will help in **real-world coding challenges**!

🌟 **Next Steps?** Move on to **Deque (Double-Ended Queue)**! 🚀

