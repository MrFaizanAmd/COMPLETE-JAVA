# Java Learning Repository: Mastering Multithreading & Concurrency 🚀

Welcome to the **Java Learning Repository!** In this guide, we'll explore **Multithreading & Concurrency**, one of the most powerful and essential topics in Java. Whether you're a beginner or an advanced learner, this guide will help you understand, implement, and master the art of handling multiple threads efficiently.

---

## **1. Introduction to Multithreading & Concurrency** 🎯

### **What is Multithreading?**
Multithreading is the ability of a CPU to execute multiple threads concurrently. In Java, a thread is the smallest unit of execution, and multithreading allows us to run multiple tasks simultaneously, making our programs more efficient.

### **Why is Multithreading Important?**
✅ Enhances performance by utilizing CPU cores effectively.  
✅ Enables smooth multitasking within applications.  
✅ Improves responsiveness in GUI-based applications.  
✅ Allows concurrent execution of independent tasks.  

Imagine you're a chef in a restaurant. Instead of cooking one dish at a time, you prepare multiple dishes simultaneously. This is how multithreading works—it allows tasks to run in parallel, improving efficiency! 🍳💨

---

## **2. Understanding Threads in Java** 🧵

### **What is a Thread?**
A thread is a lightweight process that runs independently. Java provides built-in support for threads via the `Thread` class and `Runnable` interface.

### **Creating a Thread in Java**
There are two primary ways to create a thread:

#### **A. Extending the `Thread` Class**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Starts the thread execution
    }
}
```

#### **B. Implementing the `Runnable` Interface**
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

---

## **3. Runnable vs. Thread** 🤔

### **Understanding `Thread` Class**
- The `Thread` class in Java provides built-in methods for managing threads.
- You can create a thread by extending the `Thread` class and overriding the `run()` method.
- However, since Java doesn’t support multiple inheritance, extending `Thread` prevents you from extending any other class.

### **Understanding `Runnable` Interface**
- The `Runnable` interface represents a task that can be executed by a thread.
- It provides flexibility as a class implementing `Runnable` can still extend another class.
- Recommended for better design in large applications as it supports thread pooling.

### **Key Differences Between `Thread` and `Runnable`**
| Feature | `Thread` Class | `Runnable` Interface |
|---------|---------------|-----------------|
| Inheritance | Extends `Thread` | Implements `Runnable` |
| Flexibility | Cannot extend other classes | Can extend another class |
| Reusability | Less reusable, as each thread creates a new object | More reusable, as it can be shared across multiple threads |
| Best Use Case | When a class is specifically handling threading logic | When tasks need to be executed by multiple threads |

### **Example: Using `Runnable` for Better Design**
```java
class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing...");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        
        t1.start();
        t2.start();
    }
}
```

---

## **4. Thread Lifecycle** 🔄
A thread in Java goes through multiple states during its execution:

1. **New** – Thread is created but not yet started.
2. **Runnable** – Thread is ready to run and waiting for CPU time.
3. **Blocked** – Thread is waiting to access a locked resource.
4. **Waiting** – Thread is waiting indefinitely for another thread to notify it.
5. **Timed Waiting** – Thread waits for a specified period before resuming.
6. **Terminated** – Thread execution is complete.

---
## **5. Race Condition in Threads 🏎️💥**  

### **What is a Race Condition?**  
A **race condition** occurs when multiple threads access and modify shared data simultaneously, leading to unpredictable behavior. This usually happens when one thread reads a value while another thread is modifying it, causing inconsistent results.  

### **Real-World Analogy**  
Imagine two people trying to withdraw money from the same bank account at the same time. If both transactions happen simultaneously without proper synchronization, they might withdraw more money than the account actually has! 💸🏦  

### **Example of a Race Condition in Java**  
```java
class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient balance!");
        }
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable withdrawTask = () -> {
            account.withdraw(80); // Both threads will try to withdraw at the same time
        };

        Thread t1 = new Thread(withdrawTask, "User1");
        Thread t2 = new Thread(withdrawTask, "User2");

        t1.start();
        t2.start();
    }
}
```
### **Expected Issue**
- If both threads check the balance **before** the withdrawal completes, both may withdraw successfully, **even if there isn't enough money** in the account!  
- This leads to an **inconsistent final balance**, which is a classic race condition.

### **How to Prevent a Race Condition?**  
We can use **synchronized methods or blocks** to ensure only one thread accesses the shared resource at a time.  

#### **Fixing the Race Condition using `synchronized`**  
```java
class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount) {
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
✅ Now, only one thread can access the `withdraw` method at a time, **preventing inconsistent balance issues**.  

---

## **6. Thread Methods & Control** 🎮

### **A. Controlling Thread Execution**

#### **Using `sleep()` to Pause a Thread**
```java
class SleepExample extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000); // Sleep for 1 second
                System.out.println(i);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadSleepDemo {
    public static void main(String[] args) {
        SleepExample t1 = new SleepExample();
        t1.start();
    }
}
```

#### **Using `join()` to Wait for a Thread to Finish**
```java
class JoinExample extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
        }
    }
}

public class ThreadJoinDemo {
    public static void main(String[] args) {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();
        t1.start();
        try {
            t1.join(); // Waits for t1 to finish before starting t2
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
    }
}
```

#### **Setting Thread Priority** 🎚️
```java
class PriorityExample extends Thread {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " with priority " + Thread.currentThread().getPriority());
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        PriorityExample t1 = new PriorityExample();
        PriorityExample t2 = new PriorityExample();
        
        t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t2.setPriority(Thread.MAX_PRIORITY); // Priority 10
        
        t1.start();
        t2.start();
    }
}
```
---
### **`interrupt()` – Stopping a Thread Gracefully**  
If you want to **stop a thread** politely, you can use `interrupt()` instead of `stop()` (which is unsafe).  

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            if (Thread.interrupted()) {
                System.out.println("Thread interrupted! Exiting...");
                return;
            }
            System.out.println("Processing: " + i);
        }
    }
}

public class InterruptExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        
        t1.interrupt(); // Interrupt the thread
    }
}
```
🔹 If the thread detects `Thread.interrupted()`, it exits gracefully instead of running indefinitely.

---

### ** `yield()` – Giving Other Threads a Chance**  
The `yield()` method allows the current thread to **pause execution temporarily** so other threads can run.  

```java
class YieldExample extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is executing...");
            Thread.yield(); // Gives chance to other threads
        }
    }
}

public class YieldDemo {
    public static void main(String[] args) {
        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();
        
        t1.start();
        t2.start();
    }
}
```
🔹 **Note**: `yield()` does not guarantee another thread will execute immediately, but it suggests that other threads should run.

---

### ** `setDaemon(true)` – Background (Daemon) Threads**  
A **daemon thread** runs in the background and automatically terminates when all user threads finish execution.  

```java
class DaemonExample extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon thread running...");
        }
    }
}

public class DaemonDemo {
    public static void main(String[] args) {
        DaemonExample daemon = new DaemonExample();
        daemon.setDaemon(true); // Setting as daemon thread
        daemon.start();
        
        System.out.println("Main thread ending...");
    }
}
```
🔹 The **daemon thread stops** when the main thread finishes.


---

## **6. Frequently Asked Questions (FAQs)❓**

### **Q1: What happens if we call `start()` twice on a thread?**
Calling `start()` twice on the same thread results in `IllegalThreadStateException`.

### **Q2: How do I stop a thread in Java?**
You can use flags (`volatile boolean`) or `interrupt()` method.

### **Q3: What is deadlock in Java threads?**
Deadlock occurs when two or more threads are blocked forever, each waiting for the other to release a resource.

---

## **7. Hands-on Practice** 🏆
🔗 [Access the Multithreading Practice Folder](./multithreading-practice)

Happy Coding! 🚀

