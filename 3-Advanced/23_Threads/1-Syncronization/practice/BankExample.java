// 1. Bank Account Withdrawal (Synchronized Method)
class BankAccount {
    private int balance = 1000;
    
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds for " + Thread.currentThread().getName());
        }
    }
}
class Customer extends Thread {
    private BankAccount account;
    private int amount;
    
    public Customer(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
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
