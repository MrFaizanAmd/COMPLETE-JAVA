import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount) {
        lock.lock();  // Acquire lock
        try {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient funds for " + Thread.currentThread().getName());
            }
        } finally {
            lock.unlock();  // Release lock
        }
    }
}

class Customer extends Thread {
    private final BankAccount account;
    private int amount;

    public Customer(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }
}

public class BankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread t1 = new Customer(account, 500);
        Thread t2 = new Customer(account, 700);

        t1.start();
        t2.start();
    }
}
