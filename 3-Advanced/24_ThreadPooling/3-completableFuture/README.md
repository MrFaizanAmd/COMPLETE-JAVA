# CompletableFuture in Java - A Beginner to Advanced Guide

## Introduction

Java's `CompletableFuture` is a powerful tool for handling asynchronous programming. It allows us to run tasks in parallel, wait for their completion, and process results efficiently. Unlike traditional `Future`, `CompletableFuture` provides a rich set of methods to compose, combine, and handle multiple async tasks flexibly.

This guide will take you step-by-step through `CompletableFuture`, its methods, and how to use it with `Supplier`.

---

## Why Use `CompletableFuture`?

- **Non-blocking**: Unlike traditional synchronous operations, it doesn’t block the thread while waiting for results.
- **Efficient resource utilization**: Reduces CPU waiting time by allowing parallel execution.
- **Flexible and composable**: Supports chaining, error handling, and combination of multiple async tasks.

### Real-World Analogy
Think of `CompletableFuture` like an **online food delivery service**:
1. You order food (**asynchronous task starts**).
2. While waiting, you do other tasks (**non-blocking execution**).
3. Once food is ready, you get a notification (**callback execution**).
4. If there is a delay, you handle it (**exception handling**).

---

## Key Methods in `CompletableFuture`

### 1. Creating a `CompletableFuture`
```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello, World!");
        future.thenAccept(System.out::println); // Output: Hello, World!
    }
}
```

### 2. `supplyAsync()` vs `runAsync()`
- **`supplyAsync(Supplier<T>)`**: Returns a value.
- **`runAsync(Runnable)`**: Executes a task without returning a value.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10 + 20);
CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(() -> System.out.println("Task Done"));
```

### 3. `thenApply()`, `thenAccept()`, and `thenRun()`
- **`thenApply(Function<T, R>)`**: Transforms result.
- **`thenAccept(Consumer<T>)`**: Consumes result without returning anything.
- **`thenRun(Runnable)`**: Runs after completion but doesn't use the result.

```java
CompletableFuture.supplyAsync(() -> "Hello")
    .thenApply(str -> str + " World") // Transforms the result
    .thenAccept(System.out::println) // Prints: Hello World
    .thenRun(() -> System.out.println("Task Finished!"));
```

### 4. `thenCombine()` - Combining Two Futures
```java
CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

CompletableFuture<String> result = future1.thenCombine(future2, (f1, f2) -> f1 + " " + f2);
result.thenAccept(System.out::println); // Output: Hello World
```

### 5. `thenCompose()` - Chaining Dependent Futures
```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
    .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " World"));
future.thenAccept(System.out::println); // Output: Hello World
```

### 6. Handling Errors with `exceptionally()`
```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    if (true) throw new RuntimeException("Error occurred");
    return 10;
}).exceptionally(ex -> {
    System.out.println("Handled Exception: " + ex.getMessage());
    return -1;
});

future.thenAccept(System.out::println); // Output: Handled Exception: Error occurred
```

### 7. Combining Multiple Futures with `allOf()` and `anyOf()`
```java
CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Task 1");
CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Task 2");
CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Task 3");

// Wait for all to complete
CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
all.thenRun(() -> System.out.println("All tasks completed!"));

// Wait for any one to complete
CompletableFuture<Object> any = CompletableFuture.anyOf(f1, f2, f3);
any.thenAccept(result -> System.out.println("First completed: " + result));
```

---

## Understanding `Supplier<T>`

A `Supplier<T>` is a functional interface used in `supplyAsync()`. It represents a function that **takes no arguments and returns a value**.

Example:
```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello, Supplier!";
        System.out.println(supplier.get()); // Output: Hello, Supplier!
    }
}
```

In `CompletableFuture`, `Supplier` is used to provide values asynchronously.

```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Async Result");
```

---

## FAQs

### 1. What is the difference between `Future` and `CompletableFuture`?
| Feature | Future | CompletableFuture |
|---------|--------|------------------|
| Blocking | Yes | No |
| Chaining | No | Yes |
| Exception Handling | No | Yes |
| Combining Futures | No | Yes |

### 2. When should I use `CompletableFuture`?
Use it when dealing with **asynchronous tasks**, **parallel processing**, or **improving performance** in Java applications.

### 3. What happens if an exception occurs in `CompletableFuture`?
Use `exceptionally()` or `handle()` to catch and process exceptions.

### 4. How do I cancel a `CompletableFuture`?
You can use `future.cancel(true);` to cancel it if it’s still running.

---

## Hands-On Practice

To practice `CompletableFuture`, check out the hands-on examples in this [repository folder](./CompletableFuture_Examples).

---

## Additional Resources
- [Official Java Documentation](https://docs.oracle.com/en/java/)
- [Baeldung Guide to CompletableFuture](https://www.baeldung.com/java-completablefuture)

---

## Conclusion

`CompletableFuture` makes Java asynchronous programming **powerful, flexible, and easy to manage**. Understanding its methods, chaining, error handling, and combination techniques can help in building **efficient, responsive applications**.

Next, we will learn about **ScheduledExecutorService** for task scheduling. 🚀

