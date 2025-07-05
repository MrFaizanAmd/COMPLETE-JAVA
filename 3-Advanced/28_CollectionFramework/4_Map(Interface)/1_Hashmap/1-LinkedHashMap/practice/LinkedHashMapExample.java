import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a LinkedHashMap (Maintains Insertion Order)
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();

        // 2️⃣ Adding key-value pairs
        linkedMap.put(1, "Apple");
        linkedMap.put(2, "Banana");
        linkedMap.put(3, "Cherry");
        linkedMap.put(4, "Mango");
        linkedMap.put(5, "Grapes");

        System.out.println("Initial LinkedHashMap: " + linkedMap);

        // 3️⃣ Accessing a value
        System.out.println("Value for key 3: " + linkedMap.get(3));

        // 4️⃣ Checking if a key exists
        System.out.println("Contains key 2? " + linkedMap.containsKey(2));

        // 5️⃣ Checking if a value exists
        System.out.println("Contains value 'Mango'? " + linkedMap.containsValue("Mango"));

        // 6️⃣ Removing an element
        linkedMap.remove(4);
        System.out.println("After removing key 4: " + linkedMap);

        // 7️⃣ Iterating over a LinkedHashMap (Insertion Order Maintained)
        System.out.println("Iterating using for-each:");
        for (Map.Entry<Integer, String> entry : linkedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Using `putIfAbsent`
        linkedMap.putIfAbsent(6, "Pineapple");
        System.out.println("After putIfAbsent for key 6: " + linkedMap);

        // 🔹 Handling Null Keys & Values
        linkedMap.put(null, "NullKeyValue");
        linkedMap.put(7, null);
        System.out.println("LinkedHashMap with null key and value: " + linkedMap);

        System.out.println("----------------------------------------------------");

        // 🔹 Least Recently Used (LRU) Example using Access Order
        LinkedHashMap<Integer, String> lruCache = new LinkedHashMap<>(5, 0.75f, true);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        lruCache.put(4, "D");
        lruCache.put(5, "E");

        System.out.println("Before accessing any element: " + lruCache);

        // Accessing some elements
        lruCache.get(3);
        lruCache.get(1);

        System.out.println("After accessing keys 3 and 1: " + lruCache);
    }
}
