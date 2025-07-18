public class ECommerce {
    public static void main(String[] args) {
        Thread payment = new Thread(() -> {
            try {
                System.out.println("Processing Payment...");
                Thread.sleep(3000);
                System.out.println("Payment Successful!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread order = new Thread(() -> {
            try {
                payment.join(); // Wait until payment completes
                System.out.println("Order Placed Successfully!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        payment.start();
        order.start();
    }
}
