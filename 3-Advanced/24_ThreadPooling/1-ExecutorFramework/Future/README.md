# Java Executor Framework: Understanding Future

## Introduction

Welcome to this in-depth exploration of **Future** in Java's **Executor Framework**! If you've already learned about **Service Executors**, you’re now ready to dive deeper into the power of asynchronous programming. 

In modern applications, performing tasks asynchronously is essential for improving performance and responsiveness. **Future** helps us handle the results of asynchronous tasks efficiently.

In this guide, you will:
- Understand what **Future** is and why it is important.
- Learn how to use **Future** with the **Executor Framework**.
- Explore real-world examples and best practices.
- Address common misconceptions and FAQs.

Let's get started!

---

## What is `Future` in Java?

`Future` is an interface in Java that represents the **result of an asynchronous computation**. When a task is submitted to an `ExecutorService`, it returns a `Future` object, which acts as a **placeholder** for the task’s result.

### Key Features of `Future`:
- It **allows checking if a task is completed**.
- It **retrieves the result** of a computation once it's done.
- It **cancels the execution** of a task if needed.
- It **handles timeouts**, ensuring tasks don’t block indefinitely.

### Why Do We Need `Future`?
Imagine you order food at a restaurant. Instead of waiting at the counter, you receive a **token number** (like a `Future`), which you can use later to collect your food once it’s ready. Similarly, `Future` lets you submit tasks and check results later, improving efficiency.

---

## Methods of `Future` Interface

The `Future` interface provides several useful methods:

### 1. `isDone()`: Checks if Task is Completed
This method returns `true` if the task has completed execution, otherwise `false`.

#### Example:
```java
if (future.isDone()) {
    System.out.println("Task is completed.");
} else {
    System.out.println("Task is still running.");
}
```
#### Use Case:
- Useful for polling when waiting for task completion.

---

### 2. `get()`: Retrieves the Computation Result
This method blocks and waits for the task to complete before returning the result.

#### Example:
```java
Integer result = future.get();
System.out.println("Result: " + result);
```
#### Use Case:
- Use when the result is necessary before proceeding further.

---

### 3. `get(long timeout, TimeUnit unit)`: Retrieves Result with Timeout
This version of `get()` waits only for the specified time before throwing a `TimeoutException`.

#### Example:
```java
try {
    Integer result = future.get(1, TimeUnit.SECONDS);
    System.out.println("Result: " + result);
} catch (TimeoutException e) {
    System.out.println("Task took too long! Cancelling...");
    future.cancel(true);
}
```
#### Use Case:
- Prevents indefinite blocking in cases where tasks may take too long.

---

### 4. `cancel(boolean mayInterruptIfRunning)`: Cancels Execution
Attempts to cancel execution of the task.

#### Example:
```java
boolean cancelled = future.cancel(true);
if (cancelled) {
    System.out.println("Task was cancelled!");
} else {
    System.out.println("Task already completed!");
}
```
#### Use Case:
- Use when a task is no longer required or taking too long.

---

### 5. `isCancelled()`: Checks if Task was Cancelled
This method returns `true` if the task was cancelled before completion.

#### Example:
```java
if (future.isCancelled()) {
    System.out.println("Task was cancelled before completion.");
}
```
#### Use Case:
- Helpful in handling conditions where a task might be cancelled mid-execution.

---

## `Future` vs `CompletableFuture`
While `Future` is useful, it has **limitations**:
- It blocks on `get()`.
- It doesn’t support chaining multiple tasks.

Java introduced **`CompletableFuture`** in Java 8, which overcomes these limitations by enabling **non-blocking asynchronous computation**. If you're interested in this advanced topic, explore `CompletableFuture` for more flexibility.

---

## FAQs

### 1. What happens if I call `get()` on an unfinished task?
It **blocks** the thread until the task completes, which might cause performance issues.

### 2. Can I reuse a `Future` object for multiple tasks?
No. Each `Future` corresponds to **a single task**. You must submit new tasks to get new `Future` objects.

### 3. Is `Future` thread-safe?
Yes, but **modifying shared objects inside the task requires synchronization**.

### 4. When should I use `Future` over `CompletableFuture`?
Use `Future` when you need **simple task execution and result retrieval**. Use `CompletableFuture` for **advanced chaining and non-blocking workflows**.

---


## Additional Resources
- [Official Java Documentation: Future](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Future.html)
- [Oracle Java Executor Framework Guide](https://docs.oracle.com/javase/tutorial/essential/concurrency/executors.html)
- [Baeldung Guide on Future](https://www.baeldung.com/java-future)

---

## Conclusion
`Future` is a powerful tool for handling asynchronous tasks in Java. Understanding how to use it effectively will help you write efficient, responsive applications. Keep experimenting, try different timeout settings, and explore `CompletableFuture` for even more advanced features!

Happy coding! 🚀

