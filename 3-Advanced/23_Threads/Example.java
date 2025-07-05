import java.util.concurrent.locks.ReentrantLock;

// 1️⃣ Creating threads using Thread class & Runnable interface
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running: " + Thread.currentThread().getName());
    }
}

// 2️⃣ Synchronization - Preventing Race Condition
class SharedResource {
    private int counter = 0;

    public synchronized void increment() { // Method-level synchronization
        counter++;
        System.out.println(Thread.currentThread().getName() + " Count: " + counter);
    }
}

// 3️⃣ Deadlock Example
class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock1...");
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (lock2) {
                System.out.println("Thread 1: Holding lock1 & lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock2...");
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock2 & lock1");
            }
        }
    }
}

// 4️⃣ Using ReentrantLock for manual locking
class ReentrantExample {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " Count: " + count);
        } finally {
            lock.unlock();
        }
    }
}

// 5️⃣ Inter-thread Communication using wait() & notify()
class Message {
    private String msg;

    public synchronized void writeMessage(String message) {
        msg = message;
        notify(); // Notify waiting thread
    }

    public synchronized void readMessage() {
        try { wait(); } catch (InterruptedException e) {}
        System.out.println("Received: " + msg);
    }
}

public class Example {
    public static void main(String[] args) {
        // 1️⃣ Creating threads
        MyThread t1 = new MyThread();
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();

        // 2️⃣ Synchronization Example
        SharedResource resource = new SharedResource();
        Thread t3 = new Thread(() -> resource.increment(), "Thread A");
        Thread t4 = new Thread(() -> resource.increment(), "Thread B");
        t3.start();
        t4.start();

        // 3️⃣ Deadlock Example (Run carefully, may freeze!)
        DeadlockExample deadlock = new DeadlockExample();
        Thread t5 = new Thread(deadlock::method1, "Thread C");
        Thread t6 = new Thread(deadlock::method2, "Thread D");
        t5.start();
        t6.start();

        // 4️⃣ ReentrantLock Example
        ReentrantExample re = new ReentrantExample();
        Thread t7 = new Thread(re::increment, "Thread E");
        Thread t8 = new Thread(re::increment, "Thread F");
        t7.start();
        t8.start();

        // 5️⃣ Inter-thread Communication
        Message msg = new Message();
        new Thread(msg::readMessage).start();
        new Thread(() -> msg.writeMessage("Hello from Thread G"), "Thread G").start();
    }
}
