import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a CopyOnWriteArraySet
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();

        // 2️⃣ Adding elements
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Orange");

        System.out.println("Initial Set: " + set);

        // 3️⃣ Trying to add duplicate element (it won’t be added)
        set.add("Banana"); 
        System.out.println("After adding duplicate: " + set);

        // 4️⃣ Removing an element
        set.remove("Mango");
        System.out.println("After removing 'Mango': " + set);

        // 5️⃣ Iterating over elements
        System.out.println("Iterating using for-each loop:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Concurrent Modification Example
        System.out.println("Concurrent modification test:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Processing: " + fruit);
            set.add("Pineapple"); // No ConcurrentModificationException
        }

        System.out.println("After modification in iteration: " + set);
        
        System.out.println("----------------------------------------------------");
        
        // 🔹 Real-World Use Case Example: Multi-threaded Access
        Runnable task = () -> {
            set.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " added!");
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

        System.out.println("Final Set after multithreading: " + set);
    }
}
