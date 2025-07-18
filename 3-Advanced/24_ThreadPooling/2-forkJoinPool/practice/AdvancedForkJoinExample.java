
// Advanced Example: Parallel Data Processing
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// A task to process a list of strings in parallel
class DataProcessingTask extends RecursiveTask<List<String>> {
    private static final int THRESHOLD = 5; // Threshold for direct computation
    private List<String> data;

    public DataProcessingTask(List<String> data) {
        this.data = data;
    }

    @Override
    protected List<String> compute() {
        // If list size is within the threshold, process directly
        if (data.size() <= THRESHOLD) {
            List<String> result = new ArrayList<>();
            for (String item : data) {
                result.add(item.toUpperCase()); // Convert each string to uppercase
            }
            return result;
        } else {
            // Split the list into two sub-lists
            int mid = data.size() / 2;
            DataProcessingTask leftTask = new DataProcessingTask(data.subList(0, mid));
            DataProcessingTask rightTask = new DataProcessingTask(data.subList(mid, data.size()));
            
            leftTask.fork(); // Start left task asynchronously
            List<String> rightResult = rightTask.compute(); // Compute right task directly
            List<String> leftResult = leftTask.join(); // Wait for left task to complete
            
            leftResult.addAll(rightResult); // Merge results
            return leftResult;
        }
    }
}

public class AdvancedForkJoinExample {
    public static void main(String[] args) {
        List<String> data = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew");
        
        ForkJoinPool pool = new ForkJoinPool(); // Create ForkJoinPool
        DataProcessingTask task = new DataProcessingTask(new ArrayList<>(data));
        List<String> result = pool.invoke(task); // Execute task and get result
        
        System.out.println("Processed Data: " + result);
    }
}
