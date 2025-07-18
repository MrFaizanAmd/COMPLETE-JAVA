import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // 2️⃣ Adding key-value pairs
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Mango");
        map.put(5, "Grapes");

        System.out.println("Initial HashMap: " + map);

        // 3️⃣ Accessing a value
        System.out.println("Value for key 3: " + map.get(3));

        // 4️⃣ Checking if a key exists
        System.out.println("Contains key 2? " + map.containsKey(2));

        // 5️⃣ Checking if a value exists
        System.out.println("Contains value 'Mango'? " + map.containsValue("Mango"));

        // 6️⃣ Removing an element
        map.remove(4);
        System.out.println("After removing key 4: " + map);

        // 7️⃣ Iterating over a HashMap
        System.out.println("Iterating using for-each:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("----------------------------------------------------");

        // 🔹 Updating values using `compute`
        map.compute(2, (key, value) -> value + " 🍌");
        System.out.println("After updating key 2: " + map);

        // 🔹 Using `putIfAbsent`
        map.putIfAbsent(6, "Pineapple");
        System.out.println("After putIfAbsent for key 6: " + map);

        System.out.println("----------------------------------------------------");

        // 🔹 Handling Null Keys & Values
        map.put(null, "NullKeyValue");
        map.put(7, null);
        System.out.println("HashMap with null key and value: " + map);

        System.out.println("----------------------------------------------------");

        // 🔹 Real-World Use Case: Counting Word Frequency
        String sentence = "apple banana apple cherry apple banana mango";
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : sentence.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequency Count: " + wordCount);
    }
}
