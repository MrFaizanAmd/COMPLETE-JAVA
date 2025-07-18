
// Intermediate Example: Parallel Array Sum
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// A task to compute the sum of an array using Fork/Join
class ArraySumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10; // Threshold to determine sequential vs parallel execution
    private int[] array;
    private int start, end;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // If the range is small enough, compute directly
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task into two sub-tasks
            int mid = (start + end) / 2;
            ArraySumTask leftTask = new ArraySumTask(array, start, mid);
            ArraySumTask rightTask = new ArraySumTask(array, mid, end);
            
            leftTask.fork(); // Start left task asynchronously
            int rightResult = rightTask.compute(); // Compute right task directly
            int leftResult = leftTask.join(); // Wait for left task to complete
            
            return leftResult + rightResult; // Combine results
        }
    }
}

public class IntermediateForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Populate array with numbers 1 to 100
        }
        
        ForkJoinPool pool = new ForkJoinPool(); // Create ForkJoinPool
        ArraySumTask task = new ArraySumTask(numbers, 0, numbers.length);
        int result = pool.invoke(task); // Execute task and get result
        
        System.out.println("Array Sum: " + result);
    }
}