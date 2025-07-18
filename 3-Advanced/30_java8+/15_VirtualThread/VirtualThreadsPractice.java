import java.util.concurrent.*;

public class VirtualThreadsPractice {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Virtual Threads Practice!");
        
        // 1️⃣ Basic Virtual Thread Execution
        Thread.ofVirtual().start(() -> System.out.println("Hello from Virtual Thread!"));
        
        // 2️⃣ Using VirtualThread Executor
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> System.out.println("Task 1 Running in Virtual Thread"));
            executor.submit(() -> System.out.println("Task 2 Running in Virtual Thread"));
        }
        
        // 3️⃣ Checking if Current Thread is Virtual
        Thread vThread = Thread.ofVirtual().start(() -> 
            System.out.println("Is Virtual: " + Thread.currentThread().isVirtual())
        );
        vThread.join();
        
        // 4️⃣ Virtual Threads Sleeping (Non-blocking)
        Thread.ofVirtual().start(() -> {
            try {
                System.out.println("Sleeping...");
                Thread.sleep(1000);
                System.out.println("Awake!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).join();
        
        // 5️⃣ Multiple Virtual Threads Execution
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                int taskId = i;
                executor.submit(() -> System.out.println("Executing Task " + taskId));
            }
        }
        
        // 6️⃣ Virtual Threads Yielding Execution
        Thread.ofVirtual().start(() -> {
            System.out.println("Thread Yielding...");
            Thread.yield();
            System.out.println("Thread Resumed");
        }).join();
        
        // 7️⃣ Running CPU Intensive Tasks (Not Recommended for Virtual Threads)
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                long sum = 0;
                for (int i = 0; i < 1000000; i++) {
                    sum += i;
                }
                System.out.println("CPU Task Completed with Sum: " + sum);
            });
        }
        
        // 8️⃣ I/O Bound Task Simulation (Ideal for Virtual Threads)
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println("Simulated I/O Task Completed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        // 9️⃣ Virtual Thread Deadlock Scenario
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread v1 = Thread.ofVirtual().start(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding Lock 1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired Lock 2");
                }
            }
        });
        
        Thread v2 = Thread.ofVirtual().start(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding Lock 2...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired Lock 1");
                }
            }
        });
        
        v1.join();
        v2.join();
        
        System.out.println("All Virtual Threads Executed Successfully!");
    }
}
