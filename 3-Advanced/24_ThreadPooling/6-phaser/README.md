# Java Phaser - A Step-by-Step Guide

## Introduction

In multi-threaded programming, **synchronization** plays a crucial role in coordinating multiple threads. Java provides various synchronization tools like **CountDownLatch** and **CyclicBarrier**, but sometimes we need a more **flexible and reusable synchronization mechanism**. This is where **Phaser** comes into play.

**Phaser** is a synchronization barrier introduced in Java 7 under `java.util.concurrent`. It is used to **synchronize multiple threads in phases**, meaning it allows threads to perform a set of operations in steps and wait for others before proceeding to the next step.

### Why is Phaser Important?
- **More flexible** than `CountDownLatch` and `CyclicBarrier`.
- **Dynamic thread registration**, allowing new parties (threads) to join at runtime.
- **Multiple phases support**, unlike `CountDownLatch`, which supports only one countdown.
- **Reusable**, unlike `CyclicBarrier`, which cannot be reset dynamically.

---

## Understanding Phaser with a Real-World Analogy

Imagine you are organizing a **relay race**. Runners start at different points and need to wait for their teammates to finish before moving to the next stage. Some runners may join the race late, and some might leave early. **Phaser** works similarly, managing multiple threads (runners) in a coordinated manner.

---

## Key Concepts and Terminologies

1. **Phases**: Each synchronization step is a phase (e.g., round 1, round 2, etc.).
2. **Parties**: The number of threads (participants) registered to the Phaser.
3. **Registering Parties**: Threads can join (`register()`) dynamically.
4. **Arriving and Waiting**: Threads signal arrival (`arriveAndAwaitAdvance()`) and wait for others.
5. **Termination**: When all parties are done, Phaser terminates.

---

## Basic Usage of Phaser

Let's see how Phaser can be used with **three threads synchronizing across three phases**.

### Example 1: Basic Phaser Usage

```java
import java.util.concurrent.Phaser;

class Worker extends Thread {
    private Phaser phaser;
    private String name;

    public Worker(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " completed Phase " + i);
            phaser.arriveAndAwaitAdvance(); // Wait for all parties
        }
    }
}

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // 3 threads registered

        new Worker(phaser, "Worker 1").start();
        new Worker(phaser, "Worker 2").start();
        new Worker(phaser, "Worker 3").start();
    }
}
```

### Explanation:
- Three threads (`Worker`) complete three phases.
- `arriveAndAwaitAdvance()` ensures all threads wait at each phase before moving forward.
- The program ensures synchronization across multiple steps.

---

## Advanced Features of Phaser

### 1. **Registering and Deregistering Threads Dynamically**
```java
phaser.register();   // Register a new thread dynamically
phaser.arriveAndDeregister();  // Deregister a thread
```

### 2. **Checking Phaser Status**
```java
if (phaser.isTerminated()) {
    System.out.println("Phaser has finished execution.");
}
```

### 3. **Customizing Phaser Behavior**
Phaser can be extended to override behavior when advancing phases.

```java
class CustomPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " completed!");
        return registeredParties == 0; // Terminate when no threads remain
    }
}
```

---

## Frequently Asked Questions (FAQs)

### 1. **How is Phaser different from CountDownLatch and CyclicBarrier?**
| Feature         | Phaser | CountDownLatch | CyclicBarrier |
|----------------|--------|---------------|--------------|
| Reusable       | Yes    | No            | Yes          |
| Dynamic Threads | Yes    | No            | No           |
| Supports Multiple Phases | Yes | No | No |

### 2. **When should I use Phaser?**
Use **Phaser** when:
- You need to synchronize multiple phases.
- Threads may join or leave dynamically.
- You require more flexibility than `CountDownLatch` or `CyclicBarrier`.

---

## Additional Resources
- [Official Java Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/Phaser.html)
- [Phaser Guide on Baeldung](https://www.baeldung.com/java-phaser)

---

## Hands-on Practice
Find the hands-on practice files in the [Phaser Examples Folder](./phaser-examples/).

---

## Conclusion
Phaser is a **powerful synchronization tool** that offers **flexibility and reusability** in multi-threaded Java applications. Mastering Phaser helps in handling **complex thread coordination** efficiently.

Stay tuned for more Java concurrency topics! 🚀

