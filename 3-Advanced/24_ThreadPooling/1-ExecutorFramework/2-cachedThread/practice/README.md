

## **Practice 1: Basic Cached Thread Pool Example**
**File:** `BasicCachedThreadPool.java`
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown(); // Shutdown the executor after task execution
    }
}
```
---

## **Practice 2: Real-Life Example – Processing Web Requests**
**File:** `WebRequestProcessing.java`
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebRequestProcessing {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            int requestId = i;
            executor.execute(() -> {
                System.out.println("Processing web request " + requestId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep((int) (Math.random() * 2000) + 1000); // Simulating processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
```
---

## **Practice 3: Cached Thread Pool with Database Queries**
**File:** `DatabaseQueryExecutor.java`
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseQueryExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 7; i++) {
            int queryId = i;
            executor.execute(() -> {
                System.out.println("Executing database query " + queryId + " using " + Thread.currentThread().getName());
                try {
                    Thread.sleep((int) (Math.random() * 3000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
```
---

## **Practice 4: Cached Thread Pool for File Downloads**
**File:** `FileDownloader.java`
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            int fileId = i;
            executor.execute(() -> {
                System.out.println("Downloading file " + fileId + " using " + Thread.currentThread().getName());
                try {
                    Thread.sleep((int) (Math.random() * 5000) + 1000); // Simulate file download time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
```
---

## **Practice 5: Cached Thread Pool for Email Sending System**
**File:** `EmailSender.java`
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailSender {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 8; i++) {
            int emailId = i;
            executor.execute(() -> {
                System.out.println("Sending email " + emailId + " using " + Thread.currentThread().getName());
                try {
                    Thread.sleep((int) (Math.random() * 4000) + 1000); // Simulate email sending time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
```
---

### **Explanation**
- **Practice 1:** A simple example of using a cached thread pool to execute multiple tasks.
- **Practice 2:** Simulates a web server processing multiple incoming requests.
- **Practice 3:** Demonstrates executing database queries concurrently.
- **Practice 4:** Uses a cached thread pool to handle multiple file downloads efficiently.
- **Practice 5:** Simulates an email-sending system that efficiently processes multiple emails.

---

These **real-life examples** will help you master `newCachedThreadPool()`.