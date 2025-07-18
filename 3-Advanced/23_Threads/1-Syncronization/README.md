## 🔒 **Understanding `synchronized` in Depth**  

When multiple threads access a shared resource, race conditions can occur, leading to **data inconsistency**. To prevent this, Java provides the `synchronized` keyword, which ensures that only **one thread** can execute a synchronized block/method at a time.

---

### **1️⃣ How `synchronized` Works?**  
When a thread enters a synchronized block, it **acquires a lock** (also called a **monitor**). No other thread can enter **any synchronized block** on the same object until the first thread **releases the lock**.

Java provides **two types of synchronization**:  
1. **Method-level Synchronization** – Lock is applied to the entire method.  
2. **Block-level Synchronization** – Lock is applied to only a specific part of the method.

---

## **2️⃣ Method-Level Synchronization 🔒**  
When we declare a method as `synchronized`, Java automatically **locks the object** so only **one thread** can execute that method at a time.

### **Example – Synchronizing a Method**  
```java
class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) { // 🔒 Entire method is locked
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient balance!");
        }
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> {
            account.withdraw(80);
        };

        Thread t1 = new Thread(task, "User1");
        Thread t2 = new Thread(task, "User2");

        t1.start();
        t2.start();
    }
}
```
### **Explanation**  
- Since `withdraw()` is **synchronized**, only one thread can enter it at a time.  
- If `User1` is withdrawing money, `User2` must **wait** until `User1` completes.  
- **Prevents race condition! ✅**  

---

## **3️⃣ Block-Level Synchronization 🎯**  
Instead of locking the entire method, we can **lock only a specific section**. This is useful when some parts of the method do not need synchronization.

### **Example – Synchronizing a Block**  
```java
class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        synchronized (this) { // 🔒 Locking only this block
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " - Insufficient balance!");
            }
        }
    }
}
```
### **Why Use Block Synchronization?**
- Other **non-critical** parts of the method can still be accessed by other threads.  
- **Improves performance** by locking **only the necessary part** instead of the entire method.

---

## **4️⃣ Static Synchronization 🏛️**  
If a method is `static`, it belongs to the **class, not an object**. In this case, we synchronize on the **class-level lock**.

### **Example – Synchronizing a Static Method**  
```java
class Bank {
    private static int balance = 100;

    public static synchronized void withdraw(int amount) { // 🔒 Locks at the class level
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient balance!");
        }
    }
}
```
### **Key Points**  
- `static synchronized` locks the **class** instead of an instance (`this`).  
- Ensures that only one thread accesses the **static method** at a time.  
- Multiple objects of `Bank` **share the same lock** because it's at the **class level**.

---

## **5️⃣ Locking with Different Objects 🚦**  
If multiple threads **use different objects**, each object has its **own lock**. Synchronization only applies to **the same object**.

### **Example – Synchronization Issue with Different Objects**
```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " Count: " + count);
    }
}

public class SyncIssueExample {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // Different objects
        Counter c2 = new Counter();

        Thread t1 = new Thread(() -> c1.increment(), "Thread1");
        Thread t2 = new Thread(() -> c2.increment(), "Thread2");

        t1.start();
        t2.start();
    }
}
```
### **Problem?**
- `t1` locks `c1`, and `t2` locks `c2`.  
- Since they are **different objects**, both threads run **simultaneously** instead of waiting.  
- **Solution?** Use **static synchronization** or a shared object.

---

## **6️⃣ `synchronized` vs `ReentrantLock` 🛑**  
Java also provides the `ReentrantLock` class for **more control** over synchronization.

| Feature | `synchronized` | `ReentrantLock` |
|---------|---------------|----------------|
| Lock Type | Implicit (Handled by JVM) | Explicit (Manually locked/unlocked) |
| Fairness | No fairness guarantee | Can provide fairness |
| Interruptible | No | Yes (`lockInterruptibly()`) |
| Try Lock | No | Yes (`tryLock()`) |
| Performance | Simple and fast | More powerful but slightly slower |

### **Example – Using `ReentrantLock`**  
```java
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // 🔒 Lock manually
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " Count: " + count);
        } finally {
            lock.unlock(); // 🔓 Unlock manually
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(() -> obj.increment(), "Thread1");
        Thread t2 = new Thread(() -> obj.increment(), "Thread2");

        t1.start();
        t2.start();
    }
}
```
✅ **`ReentrantLock` allows fine-grained control**, including try-lock, fairness settings, and interruptibility.

---

## **7️⃣ Key Takeaways 📝**  
1. **`synchronized` prevents race conditions** by ensuring **one thread at a time** accesses a shared resource.  
2. **Method Synchronization (`synchronized void method()`)** locks the entire method.  
3. **Block Synchronization (`synchronized (this) {}`)** locks only a part of the method.  
4. **Static Synchronization (`synchronized static`)** locks at the **class level**, not object level.  
5. **Different objects have different locks**, so synchronization applies **only to the same object**.  
6. **Use `ReentrantLock` for advanced control** (e.g., fairness, try-lock, interrupts).  

---
