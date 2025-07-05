

# **LinkedTransferQueue in Java** 🚀  

## **1️⃣ Introduction**  
The **LinkedTransferQueue** is a high-performance, unbounded, concurrent queue that implements **TransferQueue**. It allows efficient **direct handoff** between producers and consumers, meaning:  

✔ **Producers can wait until consumers receive the element** (if required).  
✔ **Consumers can take elements immediately** if available.  
✔ **Supports both synchronous and asynchronous operations**.  

📌 **Why is LinkedTransferQueue Important?**  
- **High Performance**: Faster than other blocking queues due to optimized CAS operations.  
- **Supports Wait-Free Retrieval**: Consumers can retrieve elements without blocking.  
- **Scalability**: Handles a high number of threads efficiently.  

---

## **2️⃣ Hierarchy of LinkedTransferQueue**  
`LinkedTransferQueue` is a **class** that implements `TransferQueue`, `BlockingQueue`, and `Queue`:

```
Iterable  
│  
├── Collection  
│   ├── Queue (Interface)  
│   │   ├── BlockingQueue (Interface)  
│   │   │   ├── TransferQueue (Interface)  
│   │   │   │   ├── LinkedTransferQueue (Class) ✅ (Our Focus!)
```

✔ **Extends**: `AbstractQueue<E>`  
✔ **Implements**: `TransferQueue<E>, BlockingQueue<E>, Queue<E>, Collection<E>, Iterable<E>`  

---

## **3️⃣ Key Features of LinkedTransferQueue**  

✅ **Unbounded Queue** → Grows dynamically as needed.  
✅ **Efficient Direct Transfer** → Ensures messages are taken immediately if a consumer is waiting.  
✅ **Non-blocking Retrieval** → Consumers can poll without waiting.  
✅ **CAS-Based Implementation** → Uses Compare-And-Swap for high efficiency.  

---

## **4️⃣ Real-World Analogy** 🏪  

**Think of LinkedTransferQueue like a Delivery Service** 📦  

- If the **customer (consumer) is waiting**, the delivery (message) is handed over instantly.  
- If the **customer is not there**, the package waits in storage until a consumer arrives.  
- Unlike a traditional queue, the delivery **doesn't happen unless the recipient is available** (when using `transfer()`).  

---

## **5️⃣ When to Use LinkedTransferQueue?**  

✔ **Message Passing Systems** → Ensures messages are received before proceeding.  
✔ **Multi-Threaded Task Processing** → Allows immediate processing if a worker is available.  
✔ **Real-Time Data Processing** → Ensures fast data flow between producer and consumer threads.  

---

## **3️ Difference Between LinkedTransferQueue, LinkedBlockingQueue, and ArrayBlockingQueue**  

| Feature               | **LinkedTransferQueue** ✅ | **LinkedBlockingQueue** | **ArrayBlockingQueue** |
|----------------------|----------------------|----------------------|----------------------|
| **Capacity**        | Unbounded            | Bounded (default: Integer.MAX_VALUE) | Bounded (fixed-size) |
| **Blocking Behavior** | Supports blocking & non-blocking operations | Blocks if full/empty | Blocks if full/empty |
| **Transfer Capability** | ✅ Supports `transfer()` | ❌ No `transfer()` | ❌ No `transfer()` |
| **Performance**      | Faster due to CAS-based operations | Slower due to locks | Slower due to array-based structure |
| **Fairness**        | No fairness control | Can be fair (`LinkedBlockingQueue(true)`) | Can be fair (`ArrayBlockingQueue(true)`) |
| **Use Case**        | High-performance messaging systems | Producer-consumer applications | Bounded message processing |
| **Waiting Consumers** | ✅ Can check with `hasWaitingConsumer()` | ❌ Not available | ❌ Not available |

✔ **Use `LinkedTransferQueue` when:**  
- You need **direct handoff** (messages should be taken immediately).  
- **High performance** is needed with low contention.  
- You want both **blocking and non-blocking behavior**.  

---

## **6️⃣ LinkedTransferQueue Methods with Examples**  

### **1️⃣ transfer(E e)**
📌 Transfers an element and **waits until a consumer takes it**.

```java
import java.util.concurrent.*;

public class TransferExample {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        // Consumer Thread
        new Thread(() -> {
            try {
                System.out.println("Consumer waiting...");
                String message = queue.take();
                System.out.println("Consumed: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        Thread.sleep(2000); // Simulate delay

        // Producer
        System.out.println("Producer transferring item...");
        queue.transfer("Hello, World!");
        System.out.println("Item transferred!");
    }
}
```

**🔹 Output:**
```
Producer transferring item...
Consumer waiting...
Consumed: Hello, World!
Item transferred!
```

---

### **2️⃣ tryTransfer(E e)**
📌 Transfers an element **only if a consumer is waiting**.

```java
import java.util.concurrent.LinkedTransferQueue;

public class TryTransferExample {
    public static void main(String[] args) {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

        boolean success = queue.tryTransfer(42);
        System.out.println("Transfer successful? " + success);
    }
}
```

**🔹 Output:**
```
Transfer successful? false
```
🔹 Since no consumer was waiting, the transfer failed.

---

### **3️⃣ tryTransfer(E e, timeout, TimeUnit unit)**
📌 Tries to transfer an element, but **waits for a given time** if no consumer is available.

```java
import java.util.concurrent.*;

public class TimedTransferExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        boolean transferred = queue.tryTransfer("Hello", 2, TimeUnit.SECONDS);
        System.out.println("Transferred? " + transferred);
    }
}
```

---

### **4️⃣ hasWaitingConsumer()**
📌 Checks if **at least one consumer is waiting**.

```java
import java.util.concurrent.LinkedTransferQueue;

public class CheckConsumer {
    public static void main(String[] args) {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

        if (queue.hasWaitingConsumer()) {
            System.out.println("A consumer is waiting!");
        } else {
            System.out.println("No consumer is waiting.");
        }
    }
}
```

**🔹 Output:**  
```
No consumer is waiting.
```

---

### **5️⃣ getWaitingConsumerCount()**
📌 Returns the **number of waiting consumers**.

```java
System.out.println("Waiting consumers: " + queue.getWaitingConsumerCount());
```

---

## **7️⃣ FAQs (Frequently Asked Questions) 🤔**  

### **Q1: How is LinkedTransferQueue different from LinkedBlockingQueue?**  
✅ `LinkedBlockingQueue` allows producers to **always add elements**, while `LinkedTransferQueue` can **wait for consumers** before adding elements.  

### **Q2: When should I use `transfer()` instead of `put()`?**  
✅ Use `transfer()` when you need **immediate consumption**. If you use `put()`, the element can be added even if no consumer is available.  

### **Q3: Can I use LinkedTransferQueue with multiple consumers?**  
✅ Yes, multiple consumers can take elements from the queue. The first available consumer will receive the transferred element.  

### **Q4: Is LinkedTransferQueue thread-safe?**  
✅ Yes! It uses **Compare-And-Swap (CAS) operations** for high concurrency support.  

---

## **8️⃣ More Resources** 📚  
🔗 [Official Java Docs on LinkedTransferQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedTransferQueue.html)  
🔗 [TransferQueue Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TransferQueue.html)  

---

## **9️⃣ Hands-on Practice** 🎯  
Check out the **[Practice Problems Folder](./practice/linkedtransferqueue/)** in this repository for exercises to test your understanding.

---

## **🔹 Summary: Why Use LinkedTransferQueue?**  
✅ **Better Performance** → Faster than other blocking queues.  
✅ **Efficient Direct Transfers** → Reduces unnecessary storage operations.  
✅ **Ideal for Real-Time Systems** → Ensures immediate processing of messages.  

---

🚀 **Now you're ready to use LinkedTransferQueue effectively in Java!** 🎯 Let me know if you have any questions. Happy coding! 👨‍💻🔥
Here's a detailed **README** for **LinkedTransferQueue**, now including a **comparison table** to highlight the differences between `LinkedTransferQueue`, `LinkedBlockingQueue`, and `ArrayBlockingQueue`. 🚀  

---

