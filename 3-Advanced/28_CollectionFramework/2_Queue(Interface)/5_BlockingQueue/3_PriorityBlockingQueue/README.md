

# **PriorityBlockingQueue in Java 📌**  

## **Introduction**  

### **What is PriorityBlockingQueue?**  
`PriorityBlockingQueue` is a **concurrent, unbounded priority queue** that is used in **multi-threaded** applications where elements must be processed in a **priority order** rather than FIFO (First In, First Out).  

It is part of Java’s **concurrent package** and ensures **thread-safety**, allowing multiple threads to **add and remove elements safely** without explicit synchronization.  

### **Why is it Important?**  
In multi-threaded environments, we often need to:  
✔ **Process tasks based on priority** rather than order of insertion.  
✔ **Ensure safe concurrent access** to a queue without locks.  
✔ **Achieve higher performance** compared to traditional synchronized priority queues.  

Example Use Cases:
- **Task Scheduling**: Process urgent tasks first.  
- **Event Handling Systems**: Prioritize critical events.  
- **Pathfinding Algorithms**: Used in **Dijkstra’s Algorithm** for shortest path calculation.  

---

## **Hierarchy of PriorityBlockingQueue**  

```
Iterable  
│  
├── Collection (Interface)  
│   ├── Queue (Interface)  
│   │   ├── BlockingQueue (Interface)  
│   │   │   ├── PriorityBlockingQueue ✅ (Our Focus!)
```

It extends `AbstractQueue<E>` and implements **BlockingQueue**, making it both a priority queue and a blocking queue.

---

## **Key Features of PriorityBlockingQueue 🚀**  

✅ **Thread-safe** – Allows multiple threads to operate without explicit synchronization.  
✅ **Unbounded** – No fixed size; grows dynamically as needed.  
✅ **Priority-based Ordering** – Elements are retrieved based on **natural ordering** or a **custom comparator**.  
✅ **Does Not Block Put Operations** – Always allows insertion (unlike `ArrayBlockingQueue`).  
✅ **Efficient in Multi-threading** – Uses `compareTo()` or `Comparator` to maintain priority order.  

---

## **How PriorityBlockingQueue Works Internally? 🛠️**  

### **1. Uses a Heap Data Structure (Min-Heap by Default)**  
- It internally **maintains a heap** (`PriorityQueue<E>`) where the **smallest** (or highest priority) element is always at the front.  
- If no comparator is provided, it **uses natural ordering** (`Comparable`).  

```java
class Task implements Comparable<Task> {
    private int priority;
    private String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
```

### **2. Does Not Block Put Operations**  
Unlike `LinkedBlockingQueue`, `PriorityBlockingQueue` **never blocks producers** since it is unbounded. However, consumers **may block** while waiting for elements.  

### **3. Uses CompareTo() for Prioritization**  
Elements are sorted using `compareTo()` (for natural ordering) or `Comparator` (for custom ordering).  

---

## **Creating a PriorityBlockingQueue in Java**  

### **Example 1: Basic PriorityBlockingQueue Usage**  

```java
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // Create a PriorityBlockingQueue
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        // Add elements
        queue.add(5);
        queue.add(1);
        queue.add(3);

        // Retrieve elements in priority order
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 3
        System.out.println(queue.poll()); // 5
    }
}
```

### **Output:**
```
1
3
5
```
📌 **Notice:** Elements are retrieved in **ascending order** (natural ordering).

---

## **Example 2: Custom Comparator for PriorityBlockingQueue**  

```java
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Comparator;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class CustomPriorityQueue {
    public static void main(String[] args) {
        // Define custom comparator (Higher priority first)
        Comparator<Task> taskComparator = (t1, t2) -> Integer.compare(t2.priority, t1.priority);

        // Create PriorityBlockingQueue with custom comparator
        PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>(10, taskComparator);

        // Add tasks
        taskQueue.add(new Task("Low Priority Task", 1));
        taskQueue.add(new Task("High Priority Task", 3));
        taskQueue.add(new Task("Medium Priority Task", 2));

        // Process tasks
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}
```

### **Output:**
```
High Priority Task (Priority: 3)
Medium Priority Task (Priority: 2)
Low Priority Task (Priority: 1)
```
📌 **Notice:** The elements are now retrieved **in descending order** (higher priority first).  

---

## **Producer-Consumer Example using PriorityBlockingQueue**  

```java
import java.util.concurrent.PriorityBlockingQueue;

class Producer implements Runnable {
    private PriorityBlockingQueue<Integer> queue;

    public Producer(PriorityBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put(3);
            queue.put(1);
            queue.put(2);
            System.out.println("Produced elements: 3, 1, 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private PriorityBlockingQueue<Integer> queue;

    public Consumer(PriorityBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (!queue.isEmpty()) {
                System.out.println("Consumed: " + queue.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
```

### **Output:**
```
Produced elements: 3, 1, 2
Consumed: 1
Consumed: 2
Consumed: 3
```

---

## **Common Methods in PriorityBlockingQueue**  

| Method | Description |
|--------|------------|
| `put(E e)` | Inserts an element without blocking. |
| `take()` | Retrieves and removes the head, blocks if empty. |
| `poll()` | Retrieves and removes head, returns null if empty. |
| `offer(E e)` | Inserts an element without blocking. |
| `size()` | Returns the number of elements in the queue. |
| `peek()` | Retrieves but does not remove the head. |

---

## **PriorityBlockingQueue vs LinkedBlockingQueue**  

| Feature | PriorityBlockingQueue | LinkedBlockingQueue |
|---------|----------------------|----------------------|
| **Ordering** | Based on priority | FIFO (First In, First Out) |
| **Blocking Behavior** | Never blocks on put() | Blocks if full |
| **Use Case** | Priority-based task processing | General producer-consumer |

---


## **When to Use PriorityBlockingQueue? 🤔**  

You should use `PriorityBlockingQueue` in scenarios where:  

### **✅ 1. Tasks Need to Be Processed Based on Priority**  
- If your system has multiple tasks and **some are more urgent than others**, a `PriorityBlockingQueue` ensures that **higher-priority tasks get processed first**.  
- **Example:**  
  - Task scheduling systems (e.g., executing high-priority jobs before low-priority ones).  
  - Hospital emergency queue (critical patients treated first).  

---

### **✅ 2. You Need a Thread-Safe Priority Queue**  
- If multiple threads are inserting and removing elements **without explicit synchronization**, `PriorityBlockingQueue` is a great choice.  
- Unlike a regular `PriorityQueue`, which is **not thread-safe**, this one allows safe **multi-threaded** access.  
- **Example:**  
  - A **background processing system** where tasks are assigned based on importance.  

---

### **✅ 3. You Need Non-Blocking Insertions**  
- Unlike `LinkedBlockingQueue`, which **blocks when full**, `PriorityBlockingQueue` is **unbounded** and does not block on `put()` operations.  
- **Example:**  
  - A **logging system** where log messages are prioritized and written based on severity (`ERROR > WARN > INFO`).  

---

### **✅ 4. You Want a Custom Sorting Order**  
- If you need elements **sorted dynamically based on a condition**, `PriorityBlockingQueue` allows custom comparators to **define order**.  
- **Example:**  
  - Stock market trading system where **higher-value transactions** are processed before smaller ones.  

---

## **When NOT to Use PriorityBlockingQueue? ❌**  

| **Scenario** | **Better Alternative** |
|-------------|------------------------|
| Need strict FIFO ordering | `LinkedBlockingQueue` |
| Need bounded queue (fixed size) | `ArrayBlockingQueue` |
| Need thread safety with ordering | `ConcurrentLinkedQueue` |
| Need delay-based processing | `DelayQueue` |

---



## **Frequently Asked Questions (FAQs) 🙋‍♂️**  

### **Q1: Can PriorityBlockingQueue contain null values?**  
**Answer:** No, it **does not allow null values** to avoid `NullPointerException` in comparison operations.  

### **Q2: Is PriorityBlockingQueue always sorted?**  
**Answer:** **No**, only when elements are added/removed. It does **not** maintain strict order when viewed.  

### **Q3: Is PriorityBlockingQueue thread-safe?**  
**Answer:** Yes, it is **thread-safe** but does not use locks like `LinkedBlockingQueue`.  

---

## **Hands-on Practice** 🔗  
Check out the [PriorityBlockingQueue Practice Files](./priority-blocking-queue) in this repository for more hands-on coding exercises! 🚀  

---

Let me know if you need **further refinements** or **more explanations!** 😊🔥