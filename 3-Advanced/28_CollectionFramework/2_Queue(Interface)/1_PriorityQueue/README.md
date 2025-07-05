# 📚 **PriorityQueue in Java - The Efficient Heap-Based Queue!**

## 🔹 **Hierarchy of PriorityQueue**  
Before diving deep into **PriorityQueue**, let's understand where it fits in the **Java Collection Framework**.

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── AbstractQueue (Abstract Class)  
│   │   │   ├── PriorityQueue ✅ (Our Focus!)  
```

### 🤔 **What is a PriorityQueue?**  
A **PriorityQueue** is a special type of queue where **elements are ordered based on their priority**. It is implemented as a **binary heap**, making it efficient for retrieving the highest (or lowest) priority element.

## 🎨 **Visualization**

Imagine a **PriorityQueue** as a **heap-based structure**, where each element has a priority, and elements with higher priority are processed first. By default, Java uses a **min-heap** (smallest element first), but you can customize it using a **Comparator**.

```
       10
      /  \
    20    15
   /  \   /
  40  50 30
```

---

📌 **Key Features of PriorityQueue:**  
✅ **Heap-based Structure** – Uses a **binary heap** for efficient priority-based ordering.  
✅ **Efficient Polling** – Retrieving the highest-priority element is **O(1)**.  
✅ **Logarithmic Insertions** – Insertion and deletion take **O(log n)** time.  
✅ **Unordered Iteration** – The queue does **not** maintain a strict sorted order, only ensures the root has the highest priority.  
✅ **No Null Elements** – Unlike `LinkedList`, it **does not allow `null` values**.  
✅ **Custom Ordering** – Allows **custom Comparator** for max-heap behavior.  

---

## 🔍 **Core Methods in PriorityQueue**  
Since `PriorityQueue` implements `Queue`, it supports all standard queue operations:

### ✨ **Basic Methods:**
- `add(E e)`: Inserts an element **(O(log n))**.  
- `offer(E e)`: Inserts an element **(O(log n))**, similar to `add()`, but returns `false` if insertion fails.  
- `poll()`: Retrieves and removes the highest-priority element **(O(log n))**.  
- `peek()`: Retrieves the highest-priority element without removing it **(O(1))**.  
- `remove(Object o)`: Removes a specific element **(O(n))**.  
- `contains(Object o)`: Checks if the queue contains an element **(O(n))**.  
- `size()`: Returns the number of elements in the queue **(O(1))**.  

---

## 💪 **How is PriorityQueue Implemented Internally?**  
Behind the scenes, `PriorityQueue` **uses a binary heap**, a complete binary tree where:

1️⃣ **Each node** follows the **heap property**:
   - **Min-Heap** (default): Parent is smaller than children.
   - **Max-Heap** (custom): Parent is larger than children.

2️⃣ **Operations follow heap algorithms**:
   - **Insertion**: Adds an element at the last position and **heapifies up**.
   - **Polling**: Removes the root and **heapifies down**.

---

## ✅ **How to Declare and Use a PriorityQueue?**  
Let's start coding! 🚀  

### 👉 **Basic PriorityQueue Usage**  
```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Creating a min-heap (default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements
        pq.add(30);
        pq.add(10);
        pq.add(20);

        // Polling elements
        System.out.println("Removed: " + pq.poll()); // 10 (smallest element first)
        System.out.println("Peek: " + pq.peek());   // 20
    }
}
```
📈 **Output:**  
```
Removed: 10  
Peek: 20  
```
## 📊 **Understanding Min-Heap in PriorityQueue**  
A **Min-Heap** is a **binary heap** where:
- The **smallest element** is always at the root.
- Each parent node is **less than or equal** to its child nodes.
- When an element is inserted, it is placed in the correct position using **heapify-up**.
- When the root (smallest element) is removed, the last element replaces it, and **heapify-down** restores the heap property.

### ⚡ **Example of Min-Heap Operations:**
```java
import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.add(40);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(50);
        minHeap.add(20);

        System.out.println("Smallest Element: " + minHeap.poll()); // 10
        System.out.println("Next Smallest: " + minHeap.peek());   // 20
    }
}
```

📈 **Output:**
```
Smallest Element: 10  
Next Smallest: 20  
```

---
---

## 💥 **Creating a Max-Heap (Custom Comparator)**  
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Creating a max-heap using a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Adding elements
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);

        // Polling elements
        System.out.println("Removed: " + maxHeap.poll()); // 30 (largest element first)
    }
}
```
📈 **Output:**  
```
Removed: 30  
```

---

## 🌟 **All Methods in PriorityQueue with Time Complexity**  

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Inserts an element | **O(log n)** |
| `offer(E e)` | Inserts an element | **O(log n)** |
| `poll()` | Retrieves and removes the highest-priority element | **O(log n)** |
| `peek()` | Retrieves but does not remove the highest-priority element | **O(1)** |
| `remove(Object o)` | Removes a specific element | **O(n)** |
| `contains(Object o)` | Checks if an element exists | **O(n)** |
| `size()` | Returns the total number of elements | **O(1)** |

---

## ❓ **Frequently Asked Questions (FAQs)**  

### ❓ 1. **What is the difference between `PriorityQueue` and `Queue`?**  
| Feature | PriorityQueue | Queue (LinkedList) |
|---------|--------------|-------------------|
| Ordering | Elements ordered by priority | FIFO (First In First Out) |
| Performance | Efficient retrieval of min/max | Best for normal queue operations |
| Use Case | Scheduling, Dijkstra’s Algorithm | Standard queue-based operations |

---

### ❓ 2. **How can I implement a custom priority logic?**  
Use a **Comparator**:
```java
PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.age));
```

---

### 📖 **Further Reading & Official Docs**  
🔗 [Java PriorityQueue (Oracle Docs)](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)  
🔗 [Collections Framework Overview](https://docs.oracle.com/javase/tutorial/collections/intro/index.html)  

---

## 📂 **Where to Find Implementations?**  
All implementations and examples are in the `PriorityQueue` folder inside this repository! 🚀  

---

## 💪 **Final Thoughts**  
`PriorityQueue` is an **essential data structure** for **priority-based processing**. It is widely used in **graph algorithms, task scheduling, and job processing**.  

🔥 **Next Steps?** Try different methods and custom comparators to master it! Happy coding! 🚀  

---

