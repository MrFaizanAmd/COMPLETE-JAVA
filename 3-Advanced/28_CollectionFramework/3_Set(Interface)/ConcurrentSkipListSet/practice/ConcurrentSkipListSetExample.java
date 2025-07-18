import java.util.concurrent.ConcurrentSkipListSet;
import java.util.Iterator;

public class ConcurrentSkipListSetExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a ConcurrentSkipListSet
        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();

        // 2️⃣ Adding elements
        skipListSet.add(30);
        skipListSet.add(10);
        skipListSet.add(50);
        skipListSet.add(20);
        skipListSet.add(40);

        System.out.println("Initial Set (Sorted Order): " + skipListSet);

        // 3️⃣ Trying to add duplicate element (it won’t be added)
        skipListSet.add(30);
        System.out.println("After adding duplicate (30): " + skipListSet);

        // 4️⃣ Removing an element
        skipListSet.remove(20);
        System.out.println("After removing 20: " + skipListSet);

        // 5️⃣ Iterating over elements (Sorted Order)
        System.out.println("Iterating using for-each loop:");
        for (Integer num : skipListSet) {
            System.out.println(num);
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Concurrent Modification Example
        System.out.println("Concurrent modification test:");
        Iterator<Integer> iterator = skipListSet.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println("Processing: " + num);
            skipListSet.add(60); // No ConcurrentModificationException
        }

        System.out.println("After modification in iteration: " + skipListSet);

        System.out.println("----------------------------------------------------");

        // 🔹 Real-World Use Case Example: Multi-threaded Access
        Runnable task = () -> {
            skipListSet.add((int) (Math.random() * 100));
            System.out.println(Thread.currentThread().getName() + " added an element.");
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Set after multithreading: " + skipListSet);
    }
}
