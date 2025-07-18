import java.util.LinkedList;
import java.util.Queue;

class Restaurant {
    private final Queue<String> orders = new LinkedList<>();

    public synchronized void placeOrder(String order) throws InterruptedException {
        orders.add(order);
        System.out.println("Order Placed: " + order);
        notifyAll(); // Notify all waiting chefs
    }

    public synchronized void prepareOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            System.out.println("No orders! Chef is waiting...");
            wait();
        }
        String order = orders.poll();
        System.out.println("Chef is preparing: " + order);
    }
}

public class RestaurantExample {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Thread waiter = new Thread(() -> {
            try {
                restaurant.placeOrder("Pizza");
                Thread.sleep(500);
                restaurant.placeOrder("Burger");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread chef1 = new Thread(() -> {
            try {
                restaurant.prepareOrder();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread chef2 = new Thread(() -> {
            try {
                restaurant.prepareOrder();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waiter.start();
        chef1.start();
        chef2.start();
    }
}
