import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Printer {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isFirstThreadTurn = true;

    public void printNumbers(int n, boolean isFirstThread) {
        lock.lock();
        try {
            while (isFirstThread != isFirstThreadTurn) {
                condition.await();  // Wait for the signal
            }
            for (int i = 1; i <= n; i++) {
                System.out.println(Thread.currentThread().getName() + " prints: " + i);
            }
            isFirstThreadTurn = !isFirstThreadTurn;
            condition.signalAll();  // Notify waiting threads
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class NumberThread extends Thread {
    private Printer printer;
    private int n;
    private boolean isFirstThread;

    public NumberThread(Printer printer, int n, boolean isFirstThread) {
        this.printer = printer;
        this.n = n;
        this.isFirstThread = isFirstThread;
    }

    @Override
    public void run() {
        printer.printNumbers(n, isFirstThread);
    }
}

public class PrintExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new NumberThread(printer, 5, true);
        Thread t2 = new NumberThread(printer, 5, false);

        t1.start();
        t2.start();
    }
}
