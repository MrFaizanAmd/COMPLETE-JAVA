import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producing item: Task-1");
                queue.put("Task-1"); // Will block until taken
                System.out.println("Task-1 handed over to consumer");

                System.out.println("Producing item: Task-2");
                queue.put("Task-2"); // Will block until taken
                System.out.println("Task-2 handed over to consumer");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(1000);
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}