class SharedResource {
    static volatile boolean running = true; // Volatile ensures visibility
}

public class VolatileExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (SharedResource.running) {
                // Simulate work
            }
            System.out.println("Worker thread stopped.");
        });

        worker.start();

        try {
            Thread.sleep(2000); // Simulating some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SharedResource.running = false; // Change is immediately visible to the worker thread
        System.out.println("Main thread updated running to false.");
    }
}
