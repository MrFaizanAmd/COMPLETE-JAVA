# ✨ Virtual Threads in Java - Complete Method Reference

## 🔍 Introduction
Java introduced **Virtual Threads** in JDK 19 (preview) and stabilized in JDK 21. Virtual Threads are lightweight threads that significantly improve concurrency by reducing OS thread overhead. They enable high-throughput concurrent programming without requiring complex thread pooling mechanisms.

This guide provides an in-depth explanation of **all key methods** related to Virtual Threads, complete with **detailed descriptions and examples**.


---

## 📊 Methods and Explanations

### 1. `Thread.ofVirtual()`
#### **Description:**
Creates a new **unstarted** virtual thread.

#### **Example:**
```java
Thread vThread = Thread.ofVirtual().unstarted(() -> {
    System.out.println("Virtual thread running!");
});
vThread.start();
```
#### **Deep Dive:**
- Unlike `new Thread()`, this does not bind to an OS thread.
- Must explicitly start the thread using `.start()`.

---

### 2. `Thread.ofVirtual().start()`
#### **Description:**
Creates and **starts** a new virtual thread immediately.

#### **Example:**
```java
Thread vThread = Thread.ofVirtual().start(() -> {
    System.out.println("Hello from a Virtual Thread!");
});
```
#### **Deep Dive:**
- Avoids manual `.start()` call, unlike `.unstarted()`.
- Ideal for fire-and-forget tasks.

---

### 3. `Executors.newVirtualThreadPerTaskExecutor()`
#### **Description:**
Creates an `ExecutorService` that assigns a **new virtual thread** to each submitted task.

#### **Example:**
```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> System.out.println("Task 1"));
    executor.submit(() -> System.out.println("Task 2"));
}
```
#### **Deep Dive:**
- Automatically handles virtual thread lifecycle.
- Eliminates need for manual thread management.
- Closes automatically using try-with-resources.

---

### 4. `Thread.currentThread().isVirtual()`
#### **Description:**
Checks whether the current thread is a virtual thread.

#### **Example:**
```java
Thread vThread = Thread.ofVirtual().start(() -> {
    System.out.println("Is Virtual: " + Thread.currentThread().isVirtual());
});
```
#### **Deep Dive:**
- Returns `true` for virtual threads, `false` for platform threads.
- Useful for debugging thread behavior.

---

### 5. `Thread.sleep()` (Optimized for Virtual Threads)
#### **Description:**
Pauses execution of the virtual thread **without blocking OS threads**.

#### **Example:**
```java
Thread.ofVirtual().start(() -> {
    try {
        System.out.println("Sleeping...");
        Thread.sleep(1000);
        System.out.println("Awake!");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});
```
#### **Deep Dive:**
- Unlike platform threads, virtual threads **do not block** underlying OS threads when sleeping.
- Makes high-concurrency applications more efficient.

---

### 6. `Thread.join()`
#### **Description:**
Waits for a virtual thread to complete execution.

#### **Example:**
```java
Thread vThread = Thread.ofVirtual().start(() -> {
    try {
        Thread.sleep(500);
        System.out.println("Virtual Thread Finished");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
});

try {
    vThread.join();
    System.out.println("Main Thread Resumes");
} catch (InterruptedException e) {
    e.printStackTrace();
}
```
#### **Deep Dive:**
- Allows the main thread to **wait** for a virtual thread's completion.
- Avoids premature termination of the application.

---

### 7. `Thread.yield()`
#### **Description:**
Hints that the current virtual thread can **pause** and allow others to execute.

#### **Example:**
```java
Thread.ofVirtual().start(() -> {
    System.out.println("Yielding thread...");
    Thread.yield();
    System.out.println("Resuming thread");
});
```
#### **Deep Dive:**
- No guarantee of execution order.
- Virtual threads reschedule faster than platform threads.

---

## 🔄 Performance Considerations
### ✅ **Best Practices**
- Use **virtual threads** for **I/O-bound** tasks (e.g., HTTP requests, database queries).
- Avoid virtual threads for **CPU-heavy** tasks (use platform threads for parallel computations).
- Utilize `Executors.newVirtualThreadPerTaskExecutor()` for large-scale concurrency.

### ⚠️ **Limitations**
- Cannot change thread priority.
- Cannot perform `Thread.stop()`.
- Uses **Java's own scheduler**, not OS scheduler.

---

## 🔮 Summary
| Method | Description |
|--------|------------|
| `Thread.ofVirtual().unstarted()` | Creates an unstarted virtual thread. |
| `Thread.ofVirtual().start()` | Creates and starts a virtual thread. |
| `Executors.newVirtualThreadPerTaskExecutor()` | Creates an executor for virtual threads. |
| `Thread.currentThread().isVirtual()` | Checks if the current thread is virtual. |
| `Thread.sleep()` | Non-blocking sleep for virtual threads. |
| `Thread.join()` | Waits for a virtual thread to finish. |
| `Thread.yield()` | Yields execution to another thread. |

---

🚀 **Virtual Threads unlock high-performance concurrency!** Happy coding! 💻

