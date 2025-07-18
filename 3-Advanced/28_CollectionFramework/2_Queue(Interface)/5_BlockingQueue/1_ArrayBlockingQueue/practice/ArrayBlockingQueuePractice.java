import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueuePractice {
    public static void main(String[] args) {
        // Creating an ArrayBlockingQueue with a fixed capacity of 5
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        try {
            // Adding elements to the queue
            queue.put("Task 1");
            queue.put("Task 2");
            queue.put("Task 3");
            queue.put("Task 4");
            queue.put("Task 5");
            
            System.out.println("Queue after adding elements: " + queue);
            
            // Attempting to add another element (will block if queue is full)
            new Thread(() -> {
                try {
                    System.out.println("Trying to add Task 6...");
                    queue.put("Task 6");
                    System.out.println("Task 6 added");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
            
            // Removing elements from the queue
            System.out.println("Removed: " + queue.take()); // Retrieves and removes the head
            System.out.println("Removed: " + queue.take());
            
            System.out.println("Queue after removals: " + queue);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Use Case Example: Producer-Consumer Simulation
        ArrayBlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(3);
        
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("Producer adding: Task " + i);
                    taskQueue.put(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Integer task = taskQueue.take();
                    System.out.println("Consumer processing: Task " + task);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}