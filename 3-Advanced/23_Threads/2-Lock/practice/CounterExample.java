import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock(true);  // Fair lock

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        } finally {
            lock.unlock();
        }
    }
}

class CounterTask extends Thread {
    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            counter.increment();
        }
    }
}

public class CounterExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new CounterTask(counter);
        Thread t2 = new CounterTask(counter);

        t1.start();
        t2.start();
    }
}
