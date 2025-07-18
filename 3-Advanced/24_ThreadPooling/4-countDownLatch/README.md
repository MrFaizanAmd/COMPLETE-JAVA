# Countdown Latch in Java - A Beginner to Advanced Guide

## Introduction

In multi-threaded programming, ensuring proper synchronization and coordination between threads is essential. Java provides several synchronization mechanisms, and **CountDownLatch** is one of the most useful tools for managing thread dependencies. 

Imagine a scenario where a race official will not start the race until all runners are ready. The official waits until all participants confirm their readiness, and then the race begins. This is precisely what **CountDownLatch** helps achieve in Java programs—it ensures that a thread waits until a specified number of other threads complete their tasks.

---

## What is CountDownLatch?

**CountDownLatch** is a synchronization aid provided by `java.util.concurrent` that allows one or more threads to wait until a given number of operations (performed in other threads) complete.

### Key Characteristics:
- It is initialized with a **count** representing the number of events it must wait for before continuing.
- Threads **decrease the count** by calling `.countDown()`.
- The waiting thread **blocks execution** by calling `.await()` until the count reaches **zero**.
- Once the count reaches zero, all waiting threads proceed.
- It **cannot be reused** after the count reaches zero.

### Real-World Analogy

Think of a **CountDownLatch** like a movie premiere. The movie will not start until all the key people (director, lead actors, cameraman, and sound crew) arrive. Each person checking in (calling `.countDown()`) reduces the waiting count. Once all required people have checked in (count reaches zero), the movie starts (threads proceed).

---

## How Does CountDownLatch Work?

### Step-by-Step Explanation:
1. **Create a CountDownLatch instance** with an initial count (e.g., `CountDownLatch latch = new CountDownLatch(3);`).
2. **Multiple threads perform tasks** and call `latch.countDown();` upon completion.
3. **A main thread waits** by calling `latch.await();` until the count reaches zero.
4. **Once the count reaches zero**, the main thread resumes execution.

---

## Code Example: Basic Usage

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread worker1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Worker 1 completed task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        Thread worker2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Worker 2 completed task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        Thread worker3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Worker 3 completed task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        worker1.start();
        worker2.start();
        worker3.start();

        // Main thread waits for workers to complete
        latch.await();
        System.out.println("All workers finished. Main thread continues execution.");
    }
}
```

### Output:
```
Worker 1 completed task.
Worker 2 completed task.
Worker 3 completed task.
All workers finished. Main thread continues execution.
```

---

## Advanced Use Case: Multiple Waiting Threads

In some cases, multiple threads may need to wait for a certain event to occur before proceeding.

```java
import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private CountDownLatch latch;

    public Worker(String name, CountDownLatch latch) {
        super(name);
        this.latch = latch;
    }

    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
            System.out.println(Thread.currentThread().getName() + " completed task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}

public class MultipleThreadsWaiting {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread t1 = new Worker("Worker-1", latch);
        Thread t2 = new Worker("Worker-2", latch);
        Thread t3 = new Worker("Worker-3", latch);

        t1.start();
        t2.start();
        t3.start();

        // Multiple threads waiting for latch to reach zero
        Thread waiter1 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Waiter-1 proceeding after latch count reached zero.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread waiter2 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Waiter-2 proceeding after latch count reached zero.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waiter1.start();
        waiter2.start();
    }
}
```

---

## Frequently Asked Questions (FAQs)

### 1. Can a `CountDownLatch` be reset?
No, a `CountDownLatch` cannot be reset once it reaches zero. If you need a reusable synchronization mechanism, consider using `CyclicBarrier` instead.

### 2. What happens if `countDown()` is called more times than the initial count?
If `countDown()` is called more than the initial count, it has no additional effect once the count reaches zero.

### 3. What if `await()` is called when the count is already zero?
If `await()` is called when the count is already zero, it does not block and proceeds immediately.

### 4. How is `CountDownLatch` different from `CyclicBarrier`?
| Feature | CountDownLatch | CyclicBarrier |
|---------|---------------|--------------|
| Reusable? | No | Yes |
| Waiting Behavior | One or multiple threads wait | All threads must reach the barrier |
| Use Case | One-time event synchronization | Repeated synchronization |

---

## Hands-on Practice
You can find additional hands-on practice files for this topic in the [CountDownLatch Practice Folder](./practice/countdown_latch/).

---

## Additional Resources
- [Official Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CountDownLatch.html)
- [Java Concurrency in Practice - Brian Goetz](https://www.oreilly.com/library/view/java-concurrency-in/0321349601/)

Happy Coding! 🚀