## ⭕ Understanding `ReentrantLock` in Depth

While `synchronized` provides implicit locking, Java also offers the `ReentrantLock` class, which provides **greater control** over synchronization.

---

## **1️⃣ What is `ReentrantLock`?**
`ReentrantLock` is a class in `java.util.concurrent.locks` package that provides **explicit** locking, allowing us to manually acquire and release locks.

Unlike `synchronized`, it provides:
- **Fairness policy** to ensure first-come-first-served locking.
- **Interruptible locks** so threads can be interrupted while waiting.
- **Try-locking** to attempt acquiring a lock without blocking.
- **Lock timeout** to wait for a certain period before failing.

### **Example – Using `ReentrantLock`**
```java
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // 🔒 Manually acquire lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " Count: " + count);
        } finally {
            lock.unlock(); // 🔓 Release lock manually
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        SharedResource obj = new SharedResource();

        Thread t1 = new Thread(obj::increment, "Thread1");
        Thread t2 = new Thread(obj::increment, "Thread2");

        t1.start();
        t2.start();
    }
}
```
### **Key Points**
- Unlike `synchronized`, you must **explicitly lock and unlock**.
- Always use `try-finally` to **ensure unlocking** even if an exception occurs.
- Supports **reentrancy**: a thread can lock multiple times but must unlock the same number of times.

---

## **2️⃣ `ReentrantLock` Methods Explained**
### **1. `lock()`**
- Acquires the lock **immediately**, blocking if necessary.
- Must be **released manually** using `unlock()`.
- If the same thread calls `lock()` multiple times, it must call `unlock()` the same number of times.

### **2. `tryLock()`**
- Attempts to acquire the lock **without blocking**.
- Returns `true` if lock is acquired, `false` if it's already held by another thread.

#### **Example – Using `tryLock()`**
```java
import java.util.concurrent.locks.ReentrantLock;

class TryLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void attempt() {
        if (lock.tryLock()) { // 🔒 Try to acquire lock without waiting
            try {
                System.out.println(Thread.currentThread().getName() + " acquired the lock!");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not acquire the lock!");
        }
    }
}

public class TryLockDemo {
    public static void main(String[] args) {
        TryLockExample obj = new TryLockExample();
        Thread t1 = new Thread(obj::attempt, "Thread1");
        Thread t2 = new Thread(obj::attempt, "Thread2");

        t1.start();
        t2.start();
    }
}
```
### **3. `tryLock(time, unit)`**
- Tries to acquire the lock **within a given time period**.
- If the lock is **not available**, it waits for the given time before giving up.

#### **Example – Using `tryLock(time, unit)`**
```java
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class TryLockWithTimeout {
    private final ReentrantLock lock = new ReentrantLock();

    public void attempt() {
        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) { // ⏳ Wait up to 2 sec
                try {
                    System.out.println(Thread.currentThread().getName() + " got the lock!");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
### **4. `lockInterruptibly()`**
- Allows a thread to be **interrupted while waiting** for a lock.
- Useful when a thread might be **stuck in a long wait**.

#### **Example – Using `lockInterruptibly()`**
```java
import java.util.concurrent.locks.ReentrantLock;

class LockInterruptibleExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void access() {
        try {
            lock.lockInterruptibly(); // 🔒 Allow interruption
            try {
                System.out.println(Thread.currentThread().getName() + " is executing");
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted!");
        }
    }
}
```

---

## **3️⃣ Deadlocks with `ReentrantLock` ⚠️**
Deadlocks occur when two or more threads **wait indefinitely** for each other's locks.

### **Example – Deadlock Scenario**
```java
import java.util.concurrent.locks.ReentrantLock;

class DeadlockExample {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void method1() {
        lock1.lock();
        System.out.println(Thread.currentThread().getName() + " locked Lock1");
        try {
            Thread.sleep(50);
            lock2.lock(); // 🔒 Waiting for Lock2
            System.out.println(Thread.currentThread().getName() + " locked Lock2");
        } catch (InterruptedException e) { }
        finally {
            lock2.unlock();
            lock1.unlock();
        }
    }
```

---

## **4️⃣ Fairness in `ReentrantLock`**
By default, `ReentrantLock` is **non-fair**, meaning any thread can acquire the lock regardless of waiting time.

### **Fair Lock Example**
```java
ReentrantLock fairLock = new ReentrantLock(true); // Enable fairness
```
- If fairness is `true`, the longest-waiting thread **gets priority**.
- If fairness is `false` (default), threads can acquire the lock in **any order**, improving performance.

✅ Use a **fair lock** when **thread starvation** is a concern, but keep in mind that fair locks can reduce performance.

---

## **5️⃣ Summary**
- `ReentrantLock` provides **better control** than `synchronized`.
- Use `tryLock()` and `tryLock(time, unit)` for **non-blocking** attempts.
- Use `lockInterruptibly()` to **handle thread interruptions**.
- Avoid **deadlocks** by acquiring locks **in a fixed order**.
- Consider **fair locks** if fairness is critical, but be aware of performance trade-offs.

✅ `ReentrantLock` is powerful, but **always unlock** in a `finally` block to prevent issues!

