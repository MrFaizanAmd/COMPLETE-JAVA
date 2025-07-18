import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating an IdentityHashMap
        IdentityHashMap<String, Integer> identityMap = new IdentityHashMap<>();

        // 2️⃣ Adding key-value pairs
        identityMap.put(new String("Apple"), 1);
        identityMap.put(new String("Apple"), 2); // Different Object, So Treated as a New Key
        identityMap.put("Banana", 3);
        identityMap.put("Banana", 4); // Same Reference, So Overwrites Previous Value

        System.out.println("IdentityHashMap: " + identityMap);

        // 3️⃣ Retrieving a value
        System.out.println("Value for 'Banana': " + identityMap.get("Banana"));

        // 4️⃣ Checking if a key exists
        System.out.println("Contains key 'Apple'? " + identityMap.containsKey("Apple"));

        // 5️⃣ Iterating through IdentityHashMap
        System.out.println("Iterating using for-each:");
        for (Map.Entry<String, Integer> entry : identityMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Demonstrating the Key Difference from HashMap
        Map<String, Integer> hashMap = new java.util.HashMap<>();
        String key1 = new String("Orange");
        String key2 = new String("Orange");

        hashMap.put(key1, 10);
        hashMap.put(key2, 20); // Overwrites the previous value (because keys are equal)

        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key1, 10);
        identityHashMap.put(key2, 20); // Treated as a new entry (because keys have different memory references)

        System.out.println("HashMap (uses equals() for keys): " + hashMap);
        System.out.println("IdentityHashMap (uses == for keys): " + identityHashMap);
    }
}
