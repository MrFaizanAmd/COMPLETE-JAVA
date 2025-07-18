# Fork/Join Pool in Java

## Introduction

In Java, the **Fork/Join framework** is a powerful tool for parallel computing, introduced in Java 7 as part of the `java.util.concurrent` package. It is designed to efficiently execute large computational tasks by splitting them into smaller subtasks and executing them concurrently on multiple processor cores.

Imagine you have a large job, like counting the words in a massive document. Instead of one worker reading the entire document, you could split it into sections, have multiple workers count words in their respective sections, and then combine the results. This is precisely how Fork/Join works!

## Why Use Fork/Join Pool?
- Utilizes multiple processor cores efficiently
- Enhances performance for large-scale parallel computations
- Reduces execution time by breaking tasks into smaller chunks
- Optimized for recursive divide-and-conquer algorithms

## Key Concepts

### 1. **ForkJoinPool**
`ForkJoinPool` is a special thread pool used to manage and execute `ForkJoinTask` instances. Unlike regular thread pools, it uses **work-stealing** to maximize CPU utilization, allowing idle threads to "steal" pending tasks from busy threads.

### 2. **ForkJoinTask**
A `ForkJoinTask` represents a task that can be **split** into smaller subtasks. There are two main subclasses:
- `RecursiveAction`: Used when a task does **not** return a result.
- `RecursiveTask<V>`: Used when a task **returns a result**.

### 3. **Work-Stealing Algorithm**
Instead of threads sitting idle, they dynamically "steal" unfinished tasks from other busy threads, ensuring a balanced workload.

## Important Methods with Real-Life Example

### 1. **invoke(Task task)**
This method executes a given task and returns the result. It is synchronous and blocks until the computation is complete.
#### Example:
Imagine you are running a fast-food restaurant and need to process multiple customer orders. Using `invoke()`, you ensure that the entire batch of orders is completed before moving to the next task.
```java
ForkJoinPool pool = new ForkJoinPool();
SumTask task = new SumTask(numbers, 0, numbers.length);
int result = pool.invoke(task);
System.out.println("Total orders processed: " + result);
```

### 2. **fork()**
This method starts asynchronous execution of a subtask.
#### Example:
A delivery company assigns different drivers to different zones. Each driver (`fork()`) picks up orders for their assigned area asynchronously.
```java
SumTask leftTask = new SumTask(numbers, start, mid);
leftTask.fork(); // Assigns delivery to a driver
```

### 3. **join()**
This method waits for the completion of a previously forked task and retrieves the result.
#### Example:
The delivery company waits for all drivers to complete their deliveries before closing operations for the day.
```java
int leftResult = leftTask.join(); // Ensures all deliveries are completed
```

### 4. **compute()**
Defines the task logic and decides whether to perform computation or split the task further.
#### Example:
If a warehouse receives 100 packages, `compute()` determines whether a single worker can process them or if they should be split among multiple workers.
```java
@Override
protected Integer compute() {
    if (end - start <= THRESHOLD) {
        return processOrders(); // Single worker processes small batch
    } else {
        splitAndAssignTasks(); // Divide among multiple workers
    }
}
```

### 5. **invokeAll(Task... tasks)**
Executes multiple tasks in parallel and returns results after all are completed.
#### Example:
A bakery needs to bake multiple cakes at once. `invokeAll()` assigns each cake to a separate oven and waits for all to be ready before serving.
```java
invokeAll(leftTask, rightTask);
```

### 6. **getQueuedTaskCount()**
Returns the number of queued but not yet started tasks.
#### Example:
A bank checks how many customers are waiting in the queue to manage teller allocation.
```java
System.out.println("Pending transactions: " + pool.getQueuedTaskCount());
```

### 7. **getActiveThreadCount()**
Returns the number of currently active threads in the pool.
#### Example:
A hotel manager monitors the number of room cleaning staff currently working.
```java
System.out.println("Active cleaners: " + pool.getActiveThreadCount());
```

## Basic Example: Fork/Join in Action

Let's say we need to **sum an array of numbers** using Fork/Join.

```java
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private int[] numbers;
    private int start, end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);
            
            leftTask.fork(); // Start left task asynchronously
            int rightResult = rightTask.compute(); // Compute right part
            int leftResult = leftTask.join(); // Wait for left task to finish
            
            return leftResult + rightResult;
        }
    }
}
```

## Hands-On Practice
For hands-on practice, check out the examples in this repository:
[👉 ForkJoin Pool Examples](./fork-join-examples/)  

## Additional Resources
- [Official Java Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html)
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html)
- [Brian Goetz's Java Concurrency](https://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601)

---
This guide takes you from **basic concepts** to **advanced optimizations**, making it easy to understand and apply Fork/Join Pool in Java! 🚀 Happy Coding! 🎯

