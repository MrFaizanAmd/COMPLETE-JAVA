import java.util.concurrent.*;
import java.util.*;

class Task implements Comparable<Task> {
    private final int priority;
    private final String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // Higher priority first
    }

    @Override
    public String toString() {
        return "Task{" + "priority=" + priority + ", name='" + name + '\'' + '}';
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                queue.put(new Task(3, "Low Priority Task"));
                System.out.println("Added Low Priority Task");
                Thread.sleep(100);
                queue.put(new Task(10, "High Priority Task"));
                System.out.println("Added High Priority Task");
                Thread.sleep(100);
                queue.put(new Task(5, "Medium Priority Task"));
                System.out.println("Added Medium Priority Task");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Task task = queue.take(); // Blocking call
                    System.out.println("Processing " + task);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        Thread.sleep(500); // Allow consumer to process tasks
        consumer.interrupt(); // Stop consumer thread
    }
}