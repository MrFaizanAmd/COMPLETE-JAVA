# Understanding Thread Communication in Java - A Comprehensive Guide

## Introduction

In Java, **multithreading** is a powerful feature that enables concurrent execution of two or more parts of a program to maximize CPU utilization. However, when multiple threads work together on shared resources, **thread communication** becomes essential to ensure proper coordination and avoid race conditions, deadlocks, or inconsistent states.

This guide covers:
- **Thread communication methods** (wait, notify, notifyAll)
- **Threads using lambda expressions**
- **Callable vs. Runnable**
- **Thread safety and synchronization**

Let's break it down step by step.

---

## Thread Communication in Java

### Why is Thread Communication Needed?
Imagine a **production line** where one worker (thread) **produces** an item, and another worker (thread) **consumes** it. If both workers operate independently, they may cause problems:
- The consumer may try to take an item that hasn't been produced yet.
- The producer may keep producing without the consumer picking up items, causing overflow.

To prevent such issues, **thread communication** allows threads to signal each other and coordinate their actions.

### Key Methods for Thread Communication
Java provides three main methods to facilitate communication between threads, all of which belong to the `Object` class:

#### 1. `wait()`
- A thread calls `wait()` to pause execution until another thread signals it.
- It releases the lock on the object and enters a **waiting state**.

#### 2. `notify()`
- A thread calls `notify()` to wake up one waiting thread.
- The notified thread must wait until it regains the lock before proceeding.

#### 3. `notifyAll()`
- It wakes up all threads waiting on the object's monitor.

### Example: Producer-Consumer Problem using `wait()` and `notify()`
```java
class SharedResource {
    private int data;
    private boolean hasData = false;
    
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // Wait until the consumer consumes
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait(); // Wait until there is data
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // Notify the producer
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.consume();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

### Expected Output
```
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
```

Here, the **producer** produces data and notifies the **consumer**, while the **consumer** waits until data is available.

---

## Using Threads with Lambda Expressions

Java 8 introduced **lambda expressions**, allowing us to write cleaner, more concise thread code. Instead of creating an anonymous `Runnable` class, we can use lambdas.

### Example: Creating a Thread with Lambda
```java
public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread running: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
```

### Benefits of Using Lambda with Threads
- **Less boilerplate code**
- **Easier to read and maintain**
- **No need to define separate classes for Runnable**

---

## Callable vs. Runnable

Java provides two interfaces for executing tasks in threads:

| Feature        | Runnable  | Callable  |
|---------------|----------|----------|
| Return Value  | No       | Yes (via Future) |
| Exception Handling | Cannot throw checked exceptions | Can throw checked exceptions |
| Functional Interface | Yes (used in lambda expressions) | Yes |

### Example: Using Callable
```java
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("Result: " + future.get());
        executor.shutdown();
    }
}
```

### Key Differences
- `Runnable` is used when a task **does not return a result**.
- `Callable` is used when a task **needs to return a result**.

---

## Thread Safety and Synchronization

### What is Thread Safety?
A program is **thread-safe** if it functions correctly even when multiple threads execute it simultaneously.

### How to Ensure Thread Safety?
1. **Synchronization (`synchronized` keyword)**
2. **Locks (`ReentrantLock`)**
3. **Atomic Variables (`AtomicInteger`)**
4. **Thread-safe Collections (`ConcurrentHashMap`)**

### Example: Using `synchronized`
```java
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
```

### Example: Using `ReentrantLock`
```java
import java.util.concurrent.locks.ReentrantLock;

class SafeCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public int getCount() {
        return count;
    }
}
```

---

## Summary
- **Thread communication** ensures proper coordination using `wait()`, `notify()`, and `notifyAll()`.
- **Lambda expressions** simplify thread creation.
- **Callable vs. Runnable**: Callable returns a result, Runnable does not.
- **Thread safety** is crucial for preventing race conditions.

🔗 **Next:** [Continue to Advanced Thread Synchronization](./ThreadSyncExamples/)

---

