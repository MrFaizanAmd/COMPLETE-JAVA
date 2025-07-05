

# **AbstractQueue in Java** 🚀  

## **1️⃣ Introduction**  
The **AbstractQueue** class in Java is an **abstract implementation of the Queue interface**. It provides a foundation for creating custom queue implementations by handling some of the common queue behaviors.  

📌 **Key Features:**  
✔ **Base class for queue implementations** – simplifies queue creation.  
✔ **Implements standard queue operations** like `add()`, `offer()`, `remove()`, `poll()`, and `peek()`.  
✔ **Cannot be instantiated directly** – meant to be **extended**.  
✔ **Provides partial implementations** of `Queue<E>`, leaving methods like `size()` and `iterator()` for subclasses to define.  

📌 **Why is AbstractQueue Important?**  
- Helps **reduce boilerplate code** when implementing a custom queue.  
- Provides **default implementations** for many queue operations.  
- Used as the **base class** for queue implementations like `PriorityQueue`, `ConcurrentLinkedQueue`, and `LinkedBlockingQueue`.  

---

## **2️⃣ Hierarchy of AbstractQueue**  
`AbstractQueue<E>` sits between `Queue<E>` and various queue implementations:  

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── AbstractQueue (Abstract Class) ✅ (Our Focus!)
│   │   │   ├── PriorityQueue (Class)  
│   │   │   ├── ConcurrentLinkedQueue (Class)  
│   │   │   ├── LinkedBlockingQueue (Class)  
```

✔ **Extends**: `AbstractCollection<E>`  
✔ **Implements**: `Queue<E>`  

---

## **3️⃣ Difference Between AbstractQueue, Queue, and Other Implementations**  

| Feature                | **AbstractQueue** ✅ | **Queue (Interface)** | **PriorityQueue** | **LinkedBlockingQueue** |
|-----------------------|----------------|----------------|----------------|----------------|
| **Type**            | Abstract Class | Interface | Class | Class |
| **Can Be Instantiated?** | ❌ No (must extend) | ❌ No | ✅ Yes | ✅ Yes |
| **Implements Queue Methods?** | ✅ Partially | ❌ No | ✅ Fully | ✅ Fully |
| **Thread-Safe?** | ❌ No | ❌ No | ❌ No | ✅ Yes (locks) |
| **Common Use** | Base for queues | Contract for queues | Priority-based queue | Producer-consumer model |

✔ **Use `AbstractQueue` when:**  
- You **want to implement a custom queue** but don't want to start from scratch.  
- You need **partial queue functionality** with some flexibility.  
- You are **designing a non-blocking or priority-based queue**.  

---

## **4️⃣ Real-World Analogy** 🚗  

### **Think of AbstractQueue like a Blueprint for Making Queues**  
- 🏗️ **AbstractQueue** is like a **template for creating new queue types**.  
- 🔧 It provides some **basic functionality** (like inserting/removing elements).  
- 📜 But you need to **define additional behaviors** yourself (like ordering or capacity restrictions).  

---

## **5️⃣ When to Use AbstractQueue?**  

✔ **When creating a new type of queue** – e.g., a time-sensitive queue.  
✔ **When extending queue behavior** – modifying ordering or access rules.  
✔ **When working with priority-based, unbounded, or lock-free queues.**  

---

## **6️⃣ AbstractQueue Methods with Examples**  

### **1️⃣ add(E e)**
📌 **Adds an element to the queue. Throws an exception if the queue is full.**  

```java
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Iterator;

class CustomQueue<E> extends AbstractQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public boolean offer(E e) {
        return list.add(e); // Adds element to the end
    }

    public E poll() {
        return list.isEmpty() ? null : list.removeFirst();
    }

    public E peek() {
        return list.isEmpty() ? null : list.getFirst();
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }

    public int size() {
        return list.size();
    }
}

public class AbstractQueueExample {
    public static void main(String[] args) {
        AbstractQueue<String> queue = new CustomQueue<>();
        queue.add("Alice");
        queue.add("Bob");
        System.out.println(queue.poll()); // Output: Alice
    }
}
```

---

### **2️⃣ offer(E e)**
📌 **Adds an element to the queue without throwing an exception. Returns `true` if successful.**  

```java
queue.offer("Charlie");
System.out.println(queue); // Output: [Bob, Charlie]
```

---

### **3️⃣ poll()**
📌 **Removes & returns the first element, or `null` if empty.**  

```java
System.out.println(queue.poll()); // Output: Bob
System.out.println(queue); // Output: [Charlie]
```

---

### **4️⃣ peek()**
📌 **Returns the first element without removing it.**  

```java
System.out.println(queue.peek()); // Output: Charlie
```

---

### **5️⃣ isEmpty()**
📌 **Checks if the queue is empty.**  

```java
System.out.println("Is Queue Empty? " + queue.isEmpty()); // Output: false
```

---

### **6️⃣ size()**
📌 **Returns the number of elements in the queue.**  

```java
System.out.println("Queue Size: " + queue.size()); // Output: 1
```

---

## **7️⃣ FAQs (Frequently Asked Questions) 🤔**  

### **Q1: How is AbstractQueue different from Queue Interface?**  
✅ `Queue` is **just an interface** (contract) → No method implementations.  
✅ `AbstractQueue` is a **partially implemented class** that **provides default behaviors**.  

### **Q2: Can I create an instance of AbstractQueue?**  
❌ **No**, because it's an abstract class. You must **extend** it.  

### **Q3: When should I use AbstractQueue?**  
✅ When building **custom queue implementations** like priority or time-based queues.  

---

## **8️⃣ More Resources** 📚  
🔗 [Official Java Docs on AbstractQueue](https://docs.oracle.com/javase/8/docs/api/java/util/AbstractQueue.html)  
🔗 [Java Queue Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)  

---

## **9️⃣ Hands-on Practice** 🎯  
Check out the **[Practice Problems Folder](./practice/abstractqueue/)** in this repository for exercises to test your understanding.

---

🚀 **Now you're ready to extend AbstractQueue and create custom queue implementations!** 🎯 Let me know if you have any questions. Happy coding! 👨‍💻🔥