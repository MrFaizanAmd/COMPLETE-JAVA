import java.util.concurrent.*;

// Task that implements Delayed interface
class DelayedTask implements Delayed {
    private final String name;
    private final long startTime;

    public DelayedTask(String name, long delayInSeconds) {
        this.name = name;
        this.startTime = System.currentTimeMillis() + (delayInSeconds * 1000);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.startTime, ((DelayedTask) other).startTime);
    }

    @Override
    public String toString() {
        return "Task[" + name + "]";
    }
}

public class DelayQueueExample {
    public static void main(String[] args) {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        // Adding tasks with different delays
        queue.add(new DelayedTask("Task 1", 3));
        queue.add(new DelayedTask("Task 2", 1));
        queue.add(new DelayedTask("Task 3", 5));

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (!queue.isEmpty()) {
                try {
                    DelayedTask task = queue.take(); // Blocks until a task is ready
                    System.out.println("Executed: " + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }
}
