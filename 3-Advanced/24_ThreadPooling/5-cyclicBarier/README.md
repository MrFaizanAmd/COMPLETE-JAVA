# CyclicBarrier in Java - A Complete Guide

## Introduction

In Java multithreading, there are situations where multiple threads must wait for each other at a common point before proceeding further. **CyclicBarrier** is a synchronization aid that allows a set of threads to wait for each other before continuing execution.

This guide will help you understand:
- What **CyclicBarrier** is and why it is useful
- How it works internally
- Real-world examples and practical code implementations
- Frequently asked questions and common misconceptions

---

## What is CyclicBarrier?

`CyclicBarrier` is a class in Java's `java.util.concurrent` package that enables multiple threads to wait at a **barrier** until all of them reach it. Once all threads have arrived, the barrier is **released**, allowing the threads to proceed together.

### Key Features:
- Ensures that all participating threads reach a common point before continuing.
- The barrier can be **reused** multiple times (hence the name *cyclic*).
- An optional **barrier action** can be specified, which executes once all threads reach the barrier.

### Real-World Analogy:
Imagine a **group of friends waiting at a train station**. The train will not leave until all friends have arrived. Once everyone reaches the station, they board the train together. Similarly, `CyclicBarrier` ensures that all threads reach a common point before proceeding.

---

## How Does CyclicBarrier Work?

### Basic Working Mechanism
1. Threads call `await()` to indicate they have reached the barrier.
2. The barrier keeps track of the number of threads that have arrived.
3. Once all threads reach the barrier, they are released to continue execution.
4. If a **barrier action** is specified, it runs before the threads proceed.

---

## Example: Using CyclicBarrier in Java

### Example 1: Synchronizing Threads with CyclicBarrier
```java
import java.util.concurrent.CyclicBarrier;

class Worker implements Runnable {
    private CyclicBarrier barrier;
    private int id;
    
    public Worker(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Worker " + id + " is preparing...");
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println("Worker " + id + " reached the barrier.");
            
            barrier.await(); // Waiting at the barrier
            
            System.out.println("Worker " + id + " is continuing work.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numWorkers);
        
        for (int i = 1; i <= numWorkers; i++) {
            new Thread(new Worker(barrier, i)).start();
        }
    }
}
```

### Explanation:
- We create a `CyclicBarrier` for **3 workers**.
- Each worker reaches the barrier and **waits**.
- Once all workers reach the barrier, they proceed together.

---

## Example 2: Using a Barrier Action
A **barrier action** is a task that runs once all threads reach the barrier.

```java
import java.util.concurrent.CyclicBarrier;

class Task implements Runnable {
    private CyclicBarrier barrier;
    private int id;
    
    public Task(CyclicBarrier barrier, int id) {
        this.barrier = barrier;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Task " + id + " is executing...");
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println("Task " + id + " reached the barrier.");
            
            barrier.await(); // Waiting at the barrier
            
            System.out.println("Task " + id + " continues execution.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierWithAction {
    public static void main(String[] args) {
        int numTasks = 3;
        CyclicBarrier barrier = new CyclicBarrier(numTasks, () ->
            System.out.println("All tasks reached the barrier. Proceeding...")
        );
        
        for (int i = 1; i <= numTasks; i++) {
            new Thread(new Task(barrier, i)).start();
        }
    }
}
```

### Key Points:
- The **barrier action** prints a message when all threads reach the barrier.
- This ensures that **all tasks wait for each other** before moving forward.

---

## Common Questions and Misconceptions

### 1. How is CyclicBarrier different from CountDownLatch?
| Feature | CyclicBarrier | CountDownLatch |
|---------|-------------|----------------|
| Reusability | Yes, can be reset and used multiple times | No, cannot be reused |
| Synchronization | Threads wait for each other | Threads count down without waiting |
| Barrier Action | Supports an optional barrier action | No barrier action |

### 2. What happens if a thread gets stuck before reaching the barrier?
If a thread **never reaches** the barrier, the other threads will **wait indefinitely** unless a timeout or exception is handled.

### 3. Can CyclicBarrier handle dynamic thread counts?
No, `CyclicBarrier` requires a **fixed** number of threads defined during its creation. It cannot dynamically adjust.

---

## Additional Resources
- [Official Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CyclicBarrier.html)
- [Baeldung Guide on CyclicBarrier](https://www.baeldung.com/java-cyclic-barrier)

---

## Hands-On Practice
You can find the hands-on code files for this topic [here](./cyclic-barrier-examples). Try modifying the examples and experimenting with different parameters.

---

## Summary
- `CyclicBarrier` synchronizes multiple threads by making them wait at a barrier.
- It can be **reused**, unlike `CountDownLatch`.
- Supports **barrier actions** that execute when all threads reach the barrier.
- Used in scenarios requiring **phased execution** of multiple threads.



