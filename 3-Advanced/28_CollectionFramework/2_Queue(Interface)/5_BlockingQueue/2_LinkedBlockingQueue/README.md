Here’s the **detailed README** for **LinkedBlockingQueue**, covering its **inner workings, key features, examples, and more!** 🚀  

---

# **LinkedBlockingQueue in Java 📌**  

## **Introduction**  

`LinkedBlockingQueue` is a **thread-safe, optionally bounded FIFO queue** that is backed by a **linked list**. It is part of **Java’s concurrent package** and is commonly used in **multi-threaded applications** where **producers and consumers** operate asynchronously.  

### **How does it work?**  
- If the queue is **empty**, consumers **wait** for elements.  
- If the queue is **full**, producers **wait** before adding elements (only if bounded).  
- Uses **separate locks** for put and take operations, improving **concurrency** compared to `ArrayBlockingQueue`.  

---

## **Hierarchy of LinkedBlockingQueue**  

```
Iterable  
│  
├── Collection (Interface)  
│   ├── Queue (Interface)  
│   │   ├── BlockingQueue (Interface)  
│   │   │   ├── LinkedBlockingQueue ✅ (Our Focus!)
```

---

## **Key Features of LinkedBlockingQueue** 🚀  

✅ **Thread-safe** – Uses separate locks for high concurrency.  
✅ **Optional Bounded Capacity** – Can be **bounded** or **unbounded** (default: `Integer.MAX_VALUE`).  
✅ **FIFO Order** – Maintains strict insertion order.  
✅ **Efficient for Multi-threading** – Uses **two locks** for independent put/take operations.  
✅ **Less Blocking** – Since it uses two locks, producers and consumers do not block each other as much as in `ArrayBlockingQueue`.  

---

## **How LinkedBlockingQueue Works Internally? 🛠️**  

### **1. Internal Storage: Uses a Linked List**  
Unlike `ArrayBlockingQueue`, `LinkedBlockingQueue` is backed by a **linked list** where each node stores an element and points to the next node.  

```java
static class Node<E> {
    E item;  
    Node<E> next;
}
```

### **2. Two Locks for Better Performance**  
- **Put Lock:** Controls producer access.  
- **Take Lock:** Controls consumer access.  

This **reduces contention**, making it **faster in multi-threaded scenarios** than `ArrayBlockingQueue`.

```java
private final ReentrantLock putLock = new ReentrantLock();
private final ReentrantLock takeLock = new ReentrantLock();
```

### **3. Blocking Mechanism**  
If the queue is **empty**, `take()` **blocks** the consumer.  
If the queue is **full**, `put()` **blocks** the producer.  

```java
private final Condition notEmpty = takeLock.newCondition();
private final Condition notFull = putLock.newCondition();
```

- `notEmpty.await()` → Waits if queue is empty.  
- `notFull.await()` → Waits if queue is full.  
- `notEmpty.signal()` → Wakes up a waiting consumer.  
- `notFull.signal()` → Wakes up a waiting producer.  

---

## **Creating a LinkedBlockingQueue in Java**  

```java
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // Create a BlockingQueue with a bounded capacity of 3
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

        try {
            queue.put("Task 1");  // Blocks if full
            queue.put("Task 2");
            queue.put("Task 3");

            System.out.println("Queue: " + queue);

            queue.take(); // Removes element, blocks if empty
            System.out.println("After take(): " + queue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### **Output:**
```
Queue: [Task 1, Task 2, Task 3]
After take(): [Task 2, Task 3]
```

---

## **Producer-Consumer Example using LinkedBlockingQueue**  

```java
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                queue.put(i); // Blocks if full
                System.out.println("Produced: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                int num = queue.take(); // Blocks if empty
                System.out.println("Consumed: " + num);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
```

### **Output:**
```
Produced: 1
Consumed: 1
Produced: 2
Produced: 3
Consumed: 2
Produced: 4
...
```

---

## **Common Methods in LinkedBlockingQueue**  

| Method | Description |
|--------|------------|
| `put(E e)` | Adds an element, blocks if queue is full. |
| `take()` | Removes and returns the head element, blocks if queue is empty. |
| `offer(E e)` | Adds an element if space is available, else returns false. |
| `poll()` | Retrieves and removes head, returns null if queue is empty. |
| `size()` | Returns the number of elements in the queue. |
| `remainingCapacity()` | Returns remaining space in the queue. |

---

## **LinkedBlockingQueue vs ArrayBlockingQueue**  

| Feature | LinkedBlockingQueue | ArrayBlockingQueue |
|---------|--------------------|--------------------|
| **Capacity** | Bounded or Unbounded | Fixed |
| **Performance** | Better in high contention (Two Locks) | Better for fixed-size queue |
| **Memory Usage** | Higher (linked list overhead) | Lower (array-based) |
| **When to Use?** | When dynamic size is needed | When fixed size is required |

---

## **When to Use LinkedBlockingQueue? 🤔**  

| Use Case | Recommended? |
|----------|-------------|
| Need a **dynamic queue** | ✅ Yes |
| Need **fast multi-threading** | ✅ Yes |
| Need **FIFO order** | ✅ Yes |
| Need a **bounded queue** | ✅ Yes (set a limit) |
| Need a **low-memory queue** | ❌ No (Use `ArrayBlockingQueue`) |

---

## **Frequently Asked Questions (FAQs) 🙋‍♂️**  

### **Q1: What happens if I add elements beyond the capacity?**  
**Answer:** If `put()` is used, the thread **blocks** until space is available. If `offer()` is used, it simply **returns false** if the queue is full.  

### **Q2: Is LinkedBlockingQueue thread-safe?**  
**Answer:** Yes, it uses **two separate locks** for producers and consumers, making it highly efficient.  

### **Q3: Can I use null values in LinkedBlockingQueue?**  
**Answer:** No, `null` elements **are not allowed** to avoid ambiguity in `take()` and `poll()`.  

### **Q4: What happens if no capacity is given during creation?**  
**Answer:** It defaults to `Integer.MAX_VALUE`, making it **unbounded** (potential memory risk).  

---

## **Conclusion 🎯**  
- `LinkedBlockingQueue` is an **efficient, thread-safe, optionally bounded** queue.  
- It is **faster than `ArrayBlockingQueue`** in high-contention scenarios due to **two-lock architecture**.  
- Perfect for **multi-threaded producer-consumer problems**.  

### **What’s Next?**  
Explore **PriorityBlockingQueue** and **DelayQueue** for advanced queue management! 🚀  
