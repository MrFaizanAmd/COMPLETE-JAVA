

## **Practice 1: Basic CyclicBarrier Example**
**File:** `BasicCyclicBarrier.java`
```java
import java.util.concurrent.CyclicBarrier;

public class BasicCyclicBarrier {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println("All threads reached the barrier. Proceeding together...");
        });

        Runnable worker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is working...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " reached the barrier.");
                barrier.await(); // Wait at the barrier
                System.out.println(Thread.currentThread().getName() + " continues execution...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i <= numThreads; i++) {
            new Thread(worker, "Worker-" + i).start();
        }
    }
}
```
---

## **Practice 2: CyclicBarrier for Coordinated Start**
**File:** `CoordinatedStart.java`
```java
import java.util.concurrent.CyclicBarrier;

public class CoordinatedStart {
    public static void main(String[] args) {
        int numRunners = 3;
        CyclicBarrier barrier = new CyclicBarrier(numRunners, () -> {
            System.out.println("All runners are ready. Start the race!");
        });

        Runnable runner = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is warming up...");
                Thread.sleep((int) (Math.random() * 3000) + 1000);
                System.out.println(Thread.currentThread().getName() + " is ready.");
                barrier.await(); // Wait at the starting line
                System.out.println(Thread.currentThread().getName() + " started running!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i <= numRunners; i++) {
            new Thread(runner, "Runner-" + i).start();
        }
    }
}
```
---

## **Practice 3: CyclicBarrier with Reset**
**File:** `CyclicBarrierReset.java`
```java
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierReset {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println("All tasks reached the barrier. Resetting barrier...");
        });

        Runnable task = () -> {
            try {
                for (int i = 1; i <= 2; i++) {
                    System.out.println(Thread.currentThread().getName() + " is processing phase " + i);
                    Thread.sleep(1000);
                    barrier.await(); // Wait for other threads
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i <= numThreads; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
```
---

## **Practice 4: CyclicBarrier in a Multi-Stage Task**
**File:** `MultiStageProcessing.java`
```java
import java.util.concurrent.CyclicBarrier;

public class MultiStageProcessing {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println("All threads completed a phase. Moving to next...");
        });

        Runnable worker = () -> {
            try {
                for (int phase = 1; phase <= 3; phase++) {
                    System.out.println(Thread.currentThread().getName() + " is working on phase " + phase);
                    Thread.sleep((int) (Math.random() * 2000) + 1000);
                    System.out.println(Thread.currentThread().getName() + " reached barrier for phase " + phase);
                    barrier.await(); // Wait for all threads to reach the barrier
                }
                System.out.println(Thread.currentThread().getName() + " finished all phases.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i <= numThreads; i++) {
            new Thread(worker, "Worker-" + i).start();
        }
    }
}
```
---

## **Practice 5: CyclicBarrier with Worker Threads and a Final Task**
**File:** `FinalTaskCyclicBarrier.java`
```java
import java.util.concurrent.CyclicBarrier;

public class FinalTaskCyclicBarrier {
    public static void main(String[] args) {
        int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> {
            System.out.println("All workers finished. Final task executing...");
        });

        Runnable worker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is performing work...");
                Thread.sleep((int) (Math.random() * 2000) + 1000);
                System.out.println(Thread.currentThread().getName() + " finished work and waiting at barrier.");
                barrier.await(); // Wait for all threads to finish
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 1; i <= numThreads; i++) {
            new Thread(worker, "Worker-" + i).start();
        }
    }
}
```
---

### **Explanation**
- **Practice 1:** A simple example where multiple threads wait at a `CyclicBarrier` before proceeding.
- **Practice 2:** Simulates a race where all runners must be ready before the race starts.
- **Practice 3:** Demonstrates resetting of the `CyclicBarrier` after all threads reach it.
- **Practice 4:** A multi-stage processing example where threads synchronize at multiple phases.
- **Practice 5:** Shows a final task that executes once all worker threads reach the barrier.

---

These examples will help you **master `CyclicBarrier`** in Java.