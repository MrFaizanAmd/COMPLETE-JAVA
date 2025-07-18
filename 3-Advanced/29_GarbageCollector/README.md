# Garbage Collection in Java

## Introduction

Memory management is a crucial aspect of programming, and Java provides an automated system to handle it efficiently: **Garbage Collection (GC)**. Garbage Collection is the process by which Java reclaims memory occupied by objects that are no longer reachable or needed, preventing memory leaks and optimizing application performance.

Unlike languages like C or C++, where developers must manually allocate and free memory, Java’s garbage collector handles this automatically, making memory management easier and reducing the chances of memory-related errors.

---

## Why is Garbage Collection Important?

1. **Automatic Memory Management** - Developers don’t need to manually free memory, reducing errors like memory leaks and dangling pointers.
2. **Improves Performance** - Frees up unused memory, ensuring efficient use of system resources.
3. **Prevents Memory Leaks** - Objects no longer needed are automatically removed, preventing excessive memory consumption.
4. **Simplifies Code** - Without manual memory management, code is cleaner and less prone to bugs.

---

## Key Concepts & Terminologies

### 1. Heap Memory & JVM Memory Structure
Java manages memory in different areas:
- **Heap Memory**: The runtime memory where objects are stored.
- **Stack Memory**: Stores method calls and local variables.
- **Metaspace**: Stores class metadata.

The **Garbage Collector** primarily operates in the **heap memory**, reclaiming space from objects that are no longer reachable.

### 2. Reachability
An object is considered **reachable** if it can still be accessed by a live thread. Java defines different levels of reachability:
- **Strongly reachable**: Directly referenced by active code.
- **Softly reachable**: Referenced via `SoftReference`, eligible for GC when memory is low.
- **Weakly reachable**: Referenced via `WeakReference`, collected when GC runs.
- **Phantom reachable**: Referenced via `PhantomReference`, available for final cleanup.

### 3. Generational Garbage Collection
Java heap is divided into three main sections for optimization:
- **Young Generation**: Where new objects are allocated.
  - **Eden Space**: Where new objects are created.
  - **Survivor Spaces (S0 & S1)**: Holds objects that survive initial GC cycles.
- **Old (Tenured) Generation**: Stores long-lived objects.
- **Permanent Generation (Metaspace in Java 8+)**: Stores class metadata and static content.

Garbage Collection mostly targets **young generation objects**, as they tend to be short-lived.

---

## How Does Java’s Garbage Collector Work?

### 1. **Mark & Sweep Algorithm**
Java’s garbage collector works in two main phases:
1. **Mark**: Identifies objects that are still in use (reachable).
2. **Sweep**: Removes unreferenced objects, reclaiming memory.

### 2. **Types of Garbage Collectors in Java**
Java provides multiple garbage collectors, each optimized for different scenarios:
- **Serial GC**: A simple, stop-the-world GC, best for small applications.
- **Parallel GC**: Uses multiple threads to speed up garbage collection.
- **G1 (Garbage First) GC**: Efficiently manages memory using regions, best for large applications.
- **ZGC & Shenandoah GC**: Low-latency GCs for real-time applications.

**Example:** Setting a specific GC in JVM:
```sh
java -XX:+UseG1GC MyApplication
```

---

## Code Example: Observing Garbage Collection
Let’s create a simple Java program that demonstrates how objects are garbage-collected.

```java
public class GarbageCollectionDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collected: " + this);
    }

    public static void main(String[] args) {
        GarbageCollectionDemo obj1 = new GarbageCollectionDemo();
        GarbageCollectionDemo obj2 = new GarbageCollectionDemo();

        obj1 = null;  // Eligible for garbage collection
        obj2 = null;  // Eligible for garbage collection

        System.gc(); // Requesting JVM to run GC
    }
}
```
**Output (may vary):**
```
Garbage collected: GarbageCollectionDemo@5e91993f
Garbage collected: GarbageCollectionDemo@1b6d3586
```
*Note: Calling `System.gc()` does not guarantee immediate execution, as garbage collection runs at JVM’s discretion.*

---

## Frequently Asked Questions (FAQs)

### 1. **Can we force garbage collection in Java?**
No, calling `System.gc()` only requests garbage collection. The JVM decides when to execute it.

### 2. **What happens if there’s not enough memory?**
If Java runs out of heap space and cannot free enough memory, it throws an `OutOfMemoryError`.

### 3. **Does Java collect static objects?**
No, static objects are linked to the class and exist until the JVM shuts down.

### 4. **How does WeakReference help in memory management?**
`WeakReference` objects allow garbage collection when memory is needed, useful for caching mechanisms.

---

## Additional Resources
- [Official Java Garbage Collection Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/index.html)
- [Java Memory Management Guide](https://www.baeldung.com/java-memory-management)

---

## Hands-On Practice
Explore practical exercises in the [Garbage Collection Practice Folder](./garbage-collection-practice/) in this repository.

---

By understanding garbage collection, you can optimize Java applications, avoid memory leaks, and ensure smooth performance. Keep experimenting and happy coding! 🚀