import java.util.concurrent.locks.ReentrantLock;

class Inventory {
    private int stock = 3; // Only 3 laptops in stock
    private final ReentrantLock lock = new ReentrantLock(); // Lock for synchronizing

    public void purchase(String customer) {
        lock.lock(); // Acquire lock before checking stock
        try {
            if (stock > 0) {
                System.out.println(customer + " purchased a laptop.");
                stock--;
                System.out.println("Remaining stock: " + stock);
            } else {
                System.out.println(customer + " - Sorry, out of stock!");
            }
        } finally {
            lock.unlock(); // Release lock
        }
    }
}

class Customer extends Thread {
    private final Inventory inventory;
    private final String name;

    public Customer(Inventory inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }

    @Override
    public void run() {
        inventory.purchase(name);
    }
}

public class ShoppingExample {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Customers trying to buy the same product
        Thread user1 = new Customer(inventory, "Alice");
        Thread user2 = new Customer(inventory, "Bob");
        Thread user3 = new Customer(inventory, "Charlie");
        Thread user4 = new Customer(inventory, "David");

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
