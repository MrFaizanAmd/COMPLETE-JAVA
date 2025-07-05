// Basic Implementation: Simple Fork/Join Task
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

// A simple recursive task that calculates the sum of numbers from 1 to n
class BasicTask extends RecursiveTask<Integer> {
    private int number;

    public BasicTask(int number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        // Base case: if number is 1 or less, return the number
        if (number <= 1) return number;
        
        // Create a sub-task for (number - 1)
        BasicTask task1 = new BasicTask(number - 1);
        task1.fork(); // Start the sub-task asynchronously
        
        // Combine result of current number with result of sub-task
        return number + task1.join();
    }
}

public class BasicForkJoinExample {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(); // Create a ForkJoinPool
        BasicTask task = new BasicTask(5); // Create a task to sum numbers up to 5
        int result = pool.invoke(task); // Execute the task and get the result
        System.out.println("Result: " + result);
    }
}
