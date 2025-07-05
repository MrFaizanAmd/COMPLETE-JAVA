import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueuePractice {
    public static void main(String[] args) {
        // Creating a ConcurrentLinkedQueue
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // Adding elements to the queue
        queue.add("Task 1");
        queue.add("Task 2");
        queue.add("Task 3");
        System.out.println("Initial Queue: " + queue);

        // Polling elements (retrieves and removes the head of the queue)
        System.out.println("Processing: " + queue.poll()); // Removes "Task 1"
        System.out.println("Queue after poll: " + queue);

        // Checking the head element without removing it
        System.out.println("Peek (Next Task): " + queue.peek()); // Returns "Task 2" without removing it

        // Adding more elements concurrently
        queue.offer("Task 4");
        queue.offer("Task 5");
        System.out.println("Queue after adding Task 4 and Task 5: " + queue);
        
        // Iterating over queue elements
        System.out.println("Iterating over queue:");
        for (String task : queue) {
            System.out.println(task);
        }

        // Removing a specific element
        queue.remove("Task 3");
        System.out.println("Queue after removing Task 3: " + queue);

        // Checking if the queue contains an element
        System.out.println("Contains Task 4? " + queue.contains("Task 4"));

        // Use case example: processing tasks in a multi-threaded environment
        Runnable worker = () -> {
            while (!queue.isEmpty()) {
                String task = queue.poll(); // Retrieves and removes tasks
                if (task != null) {
                    System.out.println(Thread.currentThread().getName() + " processing " + task);
                }
            }
        };

        // Creating and starting multiple threads to process tasks
        Thread t1 = new Thread(worker, "Worker-1");
        Thread t2 = new Thread(worker, "Worker-2");

        t1.start();
        t2.start();
    }
}
