import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequePractice {
    public static void main(String[] args) {
        // Creating a ConcurrentLinkedDeque
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();

        // Adding elements at both ends
        deque.addFirst("First"); // Adds at the front
        deque.addLast("Last");   // Adds at the back
        deque.offer("Middle");   // Adds at the end (like addLast)

        System.out.println("Initial Deque: " + deque);

        // Removing elements from both ends
        System.out.println("Removed from front: " + deque.pollFirst()); // Retrieves and removes from front
        System.out.println("Removed from back: " + deque.pollLast());   // Retrieves and removes from back

        System.out.println("Deque after removals: " + deque);

        // Checking elements without removing
        System.out.println("Peek First: " + deque.peekFirst()); // Retrieves but does not remove the first element
        System.out.println("Peek Last: " + deque.peekLast());   // Retrieves but does not remove the last element

        // Iterating over deque elements
        System.out.println("Iterating over deque:");
        for (String item : deque) {
            System.out.println(item);
        }

        // Use case example: Multi-threaded Processing
        ConcurrentLinkedDeque<Integer> taskDeque = new ConcurrentLinkedDeque<>();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                taskDeque.addLast(i); // Simulating task generation
                System.out.println("Produced: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                Integer task = taskDeque.pollFirst(); // Consume task from front
                if (task != null) {
                    System.out.println("Consumed: " + task);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
