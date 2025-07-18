

### **Practice 1: Basic CountDownLatch**
**File:** `BasicCountDownLatch.java`
```java
import java.util.concurrent.CountDownLatch;

public class BasicCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " is working...");
            latch.countDown(); // Decrease the latch count
        };

        new Thread(worker, "Worker-1").start();
        new Thread(worker, "Worker-2").start();
        new Thread(worker, "Worker-3").start();

        latch.await(); // Wait for all workers to finish
        System.out.println("All workers finished. Main thread continues...");
    }
}
```
---

### **Practice 2: Using CountDownLatch for Thread Coordination**
**File:** `ThreadCoordination.java`
```java
import java.util.concurrent.CountDownLatch;

public class ThreadCoordination {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                latch.await(); // Wait for the signal
                System.out.println(Thread.currentThread().getName() + " starts running!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();

        Thread.sleep(2000); // Simulate some preparation work
        System.out.println("Main thread is done preparing. Releasing threads...");
        latch.countDown(); // Signal all waiting threads to proceed
    }
}
```
---

### **Practice 3: CountDownLatch with Multiple Phases**
**File:** `MultiPhaseCountDownLatch.java`
```java
import java.util.concurrent.CountDownLatch;

public class MultiPhaseCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch phase1 = new CountDownLatch(3);
        CountDownLatch phase2 = new CountDownLatch(2);

        Runnable worker1 = () -> {
            System.out.println(Thread.currentThread().getName() + " completed phase 1");
            phase1.countDown();
        };

        Runnable worker2 = () -> {
            System.out.println(Thread.currentThread().getName() + " completed phase 2");
            phase2.countDown();
        };

        new Thread(worker1, "Worker-1").start();
        new Thread(worker1, "Worker-2").start();
        new Thread(worker1, "Worker-3").start();

        phase1.await(); // Wait for phase 1 to complete
        System.out.println("Phase 1 complete. Starting Phase 2...");

        new Thread(worker2, "Worker-4").start();
        new Thread(worker2, "Worker-5").start();

        phase2.await(); // Wait for phase 2 to complete
        System.out.println("All phases complete. Main thread finishes.");
    }
}
```
---

### **Practice 4: CountDownLatch in a Real-World Example**
**File:** `DatabaseMigration.java`
```java
import java.util.concurrent.CountDownLatch;

public class DatabaseMigration {
    public static void main(String[] args) throws InterruptedException {
        int totalMigrations = 3;
        CountDownLatch latch = new CountDownLatch(totalMigrations);

        Runnable migrationTask = () -> {
            System.out.println(Thread.currentThread().getName() + " is performing database migration...");
            try {
                Thread.sleep(2000); // Simulate migration time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " migration completed.");
        };

        for (int i = 1; i <= totalMigrations; i++) {
            new Thread(migrationTask, "Migration-Thread-" + i).start();
        }

        latch.await(); // Wait for all migrations to finish
        System.out.println("All database migrations completed. System ready!");
    }
}
```
---

### **Practice 5: CountDownLatch with a Race Simulation**
**File:** `RaceSimulation.java`
```java
import java.util.concurrent.CountDownLatch;

public class RaceSimulation {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch readySignal = new CountDownLatch(3);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(3);

        Runnable racer = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is getting ready...");
                readySignal.countDown();
                startSignal.await(); // Wait for the race to start
                System.out.println(Thread.currentThread().getName() + " started running!");
                Thread.sleep((int) (Math.random() * 3000) + 1000); // Simulate race time
                System.out.println(Thread.currentThread().getName() + " finished the race!");
                finishSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(racer, "Runner-1").start();
        new Thread(racer, "Runner-2").start();
        new Thread(racer, "Runner-3").start();

        readySignal.await(); // Wait for all runners to be ready
        System.out.println("All runners are ready. Race starts now!");
        startSignal.countDown(); // Start the race

        finishSignal.await(); // Wait for all runners to finish
        System.out.println("Race completed. Announcing results!");
    }
}
```
---

These practice files will give you hands-on experience with `CountDownLatch`.