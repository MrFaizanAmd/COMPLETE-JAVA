public class EmailScheduler {
    public static void main(String[] args) {
        Thread emailThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Sending Email Notification...");
                    Thread.sleep(5000); // Wait 5 seconds
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        emailThread.setDaemon(true); // Set as daemon thread (runs in background)
        emailThread.start();

        try {
            Thread.sleep(15000); // Main thread sleeps for 15 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ending...");
    }
}
