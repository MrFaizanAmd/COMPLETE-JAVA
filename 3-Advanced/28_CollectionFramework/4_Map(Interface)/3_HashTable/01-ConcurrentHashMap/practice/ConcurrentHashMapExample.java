import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 2️⃣ Adding key-value pairs
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println("Initial Map: " + map);

        // 3️⃣ Fetching values
        System.out.println("Value of A: " + map.get("A"));

        // 4️⃣ Updating values safely
        map.putIfAbsent("D", 4); // Adds if not present
        map.computeIfPresent("B", (k, v) -> v + 10); // Updates if present
        System.out.println("Updated Map: " + map);

        // 5️⃣ Iterating safely over ConcurrentHashMap
        System.out.println("Iterating over map:");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));

        // 6️⃣ Removing elements safely
        map.remove("C", 3); // Removes only if key=C and value=3
        System.out.println("After Removal: " + map);

        // 7️⃣ Using parallel operations
        map.forEach(2, (key, value) -> System.out.println("Processing: " + key + " -> " + value));

        // 8️⃣ Running Concurrent Modifications
        Runnable task1 = () -> {
            for (int i = 5; i <= 10; i++) {
                map.put("Key" + i, i);
                System.out.println("Thread 1 added: Key" + i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 10; i++) {
                map.computeIfPresent("Key" + i, (k, v) -> v * 2);
                System.out.println("Thread 2 updated: Key" + i);
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Map: " + map);
    }
}
