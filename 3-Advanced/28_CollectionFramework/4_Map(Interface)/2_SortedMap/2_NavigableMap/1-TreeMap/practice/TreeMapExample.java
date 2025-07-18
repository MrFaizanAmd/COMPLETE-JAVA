import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating a TreeMap (Automatically sorts by keys)
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 2️⃣ Adding key-value pairs
        treeMap.put(3, "Banana");
        treeMap.put(1, "Apple");
        treeMap.put(5, "Mango");
        treeMap.put(2, "Orange");

        System.out.println("TreeMap (Sorted by Keys): " + treeMap);

        // 3️⃣ Accessing elements
        System.out.println("Value for key 2: " + treeMap.get(2));

        // 4️⃣ Removing an element
        treeMap.remove(3);
        System.out.println("After removing key 3: " + treeMap);

        // 5️⃣ Checking if a key exists
        System.out.println("Contains key 5? " + treeMap.containsKey(5));

        // 6️⃣ Checking if a value exists
        System.out.println("Contains value 'Apple'? " + treeMap.containsValue("Apple"));

        // 7️⃣ Iterating over TreeMap
        System.out.println("Iterating using for-each:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 8️⃣ Using NavigableMap Methods
        System.out.println("First Entry: " + treeMap.firstEntry());
        System.out.println("Last Entry: " + treeMap.lastEntry());
        System.out.println("Lower Entry (before key 3): " + treeMap.lowerEntry(3));
        System.out.println("Higher Entry (after key 3): " + treeMap.higherEntry(3));

        // 9️⃣ Reverse Order
        System.out.println("Reverse Order Map: " + treeMap.descendingMap());

        System.out.println("----------------------------------------------------");

        // 🔹 Custom Sorting Example
        TreeMap<String, Integer> customSortedMap = new TreeMap<>(Comparator.reverseOrder());
        customSortedMap.put("John", 30);
        customSortedMap.put("Alice", 25);
        customSortedMap.put("Bob", 28);

        System.out.println("TreeMap with Reverse Order: " + customSortedMap);
    }
}
