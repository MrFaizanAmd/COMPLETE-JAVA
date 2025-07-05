import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        try {
            lock.lockInterruptibly();  // Acquire lock, but allow interruption
            System.out.println(Thread.currentThread().getName() + " is accessing resource.");
            Thread.sleep(2000); // Simulating work
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}

class Worker extends Thread {
    private SharedResource resource;

    public Worker(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.accessResource();
    }
}

public class InterruptibleLockExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Thread t1 = new Worker(resource);
        Thread t2 = new Worker(resource);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        t2.interrupt(); // Interrupt thread 2 while it's waiting for the lock
    }
}
