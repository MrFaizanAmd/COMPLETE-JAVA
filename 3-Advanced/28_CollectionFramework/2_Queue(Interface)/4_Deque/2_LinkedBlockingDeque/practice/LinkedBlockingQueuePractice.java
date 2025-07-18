import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueuePractice {
    public static void main(String[] args) throws InterruptedException {
        // Creating a LinkedBlockingQueue with capacity 5
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        // Adding elements to the queue
        queue.put("Task 1"); // Puts element in queue, waits if full
        queue.put("Task 2");
        queue.put("Task 3");
        queue.offer("Task 4"); // Returns false if queue is full instead of blocking
        queue.offer("Task 5");
        
        System.out.println("Initial Queue: " + queue);
        
        // Removing elements from the queue
        System.out.println("Removed: " + queue.take()); // Retrieves and removes, waits if empty
        System.out.println("Removed: " + queue.poll()); // Retrieves and removes, returns null if empty
        
        System.out.println("Queue after removals: " + queue);
        
        // Checking elements without removing
        System.out.println("Peek: " + queue.peek()); // Retrieves but does not remove the head
        
        // Iterating over queue elements
        System.out.println("Iterating over queue:");
        for (String task : queue) {
            System.out.println(task);
        }

        // Use case example: Producer-Consumer Pattern
        LinkedBlockingQueue<Integer> taskQueue = new LinkedBlockingQueue<>(10);
        
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    taskQueue.put(i); // Simulate producing a task
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer task = taskQueue.take(); // Consume task
                    System.out.println("Consumed: " + task);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
    }
}
