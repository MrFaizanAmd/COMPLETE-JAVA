import java.util.*;

public class PriorityQueuePractice {
    public static void main(String[] args) {
        // Min-Heap (Default Behavior - Smallest element has highest priority)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);

        System.out.println("Min-Heap Order:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Retrieves and removes elements in ascending order
        }

        // Max-Heap (Using Reverse Order Comparator - Largest element has highest priority)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(15);

        System.out.println("\nMax-Heap Order:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // Retrieves and removes elements in descending order
        }

        // PriorityQueue with Custom Objects (Students sorted by rank)
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(Comparator.comparingInt(s -> s.rank));
        studentQueue.add(new Student("Alice", 2));
        studentQueue.add(new Student("Bob", 3));
        studentQueue.add(new Student("Charlie", 1));

        System.out.println("\nStudents Priority Queue (Ascending Rank):");
        while (!studentQueue.isEmpty()) {
            System.out.println(studentQueue.poll()); // Retrieves and removes students based on rank
        }

        // PriorityQueue with Tasks (Simulating a Task Scheduler with priority-based execution)
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));
        taskQueue.add(new Task("Write Report", 2));
        taskQueue.add(new Task("Fix Bug", 1));
        taskQueue.add(new Task("Attend Meeting", 3));

        System.out.println("\nTask Execution Order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll()); // Retrieves and removes tasks based on priority
        }
    }
}

// Student class with name and rank, used in PriorityQueue
class Student {
    String name;
    int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', rank=" + rank + "}";
    }
}

// Task class with description and priority, used in PriorityQueue
class Task {
    String description;
    int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{description='" + description + "', priority=" + priority + "}";
    }
}
