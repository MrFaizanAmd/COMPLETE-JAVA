

### **Practice 1: Basic CompletableFuture**
**File:** `BasicCompletableFuture.java`
```java
import java.util.concurrent.CompletableFuture;

public class BasicCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Task running asynchronously...");
        });

        future.join(); // Wait for completion
        System.out.println("Main thread finished.");
    }
}
```
---

### **Practice 2: CompletableFuture with `supplyAsync`**
**File:** `CompletableFutureWithSupplyAsync.java`
```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithSupplyAsync {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello from CompletableFuture!";
        });

        System.out.println(future.join()); // Get the result
    }
}
```
---

### **Practice 3: Chaining CompletableFutures**
**File:** `ChainingCompletableFuture.java`
```java
import java.util.concurrent.CompletableFuture;

public class ChainingCompletableFuture {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World")
                .thenApply(result -> result + "!!!");

        System.out.println(future.join());
    }
}
```
---

### **Practice 4: Handling Exceptions**
**File:** `HandlingExceptions.java`
```java
import java.util.concurrent.CompletableFuture;

public class HandlingExceptions {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Success";
        }).exceptionally(ex -> "Recovered from: " + ex.getMessage());

        System.out.println(future.join());
    }
}
```
---

### **Practice 5: Combining Two Futures**
**File:** `CombiningFutures.java`
```java
import java.util.concurrent.CompletableFuture;

public class CombiningFutures {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (f1, f2) -> f1 + " " + f2);

        System.out.println(combinedFuture.join());
    }
}
```
---

### **Practice 6: Running Multiple Futures in Parallel**
**File:** `ParallelFutures.java`
```java
import java.util.concurrent.CompletableFuture;
import java.util.List;

public class ParallelFutures {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Task 1 Completed");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Task 2 Completed");

        List<CompletableFuture<String>> futures = List.of(future1, future2);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join(); // Wait for all tasks to complete

        futures.forEach(f -> System.out.println(f.join()));
    }
}
```
---

### **Practice 7: Using `thenAccept` to Process the Result**
**File:** `ThenAcceptExample.java`
```java
import java.util.concurrent.CompletableFuture;

public class ThenAcceptExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello, CompletableFuture!")
                .thenAccept(System.out::println);
    }
}
```
---

These practice files should give you a solid understanding of `CompletableFuture`.