import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueuePractice {
    public static void main(String[] args) {
        // Creating a LinkedBlockingQueue with a capacity of 3
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

        // Example: Handling print jobs in a print queue
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                try {
                    System.out.println("Adding print job: Job " + i);
                    queue.put(i); // Adds job to the queue, blocks if full
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Integer job = queue.take(); // Takes a job from the queue, blocks if empty
                    System.out.println("Processing print job: Job " + job);
                    Thread.sleep(1000); // Simulate print time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        producer.start();
        consumer.start();

        // Allow the threads to run for a while before terminating
        try {
            Thread.sleep(7000);
            producer.interrupt();
            consumer.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
