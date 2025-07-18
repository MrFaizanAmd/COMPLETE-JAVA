import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    static AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
        count.incrementAndGet(); // Atomic operation
    }
}

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                AtomicCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                AtomicCounter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + AtomicCounter.count.get()); // Always 2000
    }
}
