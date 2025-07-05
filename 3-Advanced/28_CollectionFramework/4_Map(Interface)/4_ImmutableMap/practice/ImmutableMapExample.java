import java.util.*;

public class ImmutableMapExample {
    public static void main(String[] args) {
        // 1️⃣ Creating an Immutable Map using Map.of()
        Map<String, Integer> immutableMap1 = Map.of(
                "A", 1,
                "B", 2,
                "C", 3
        );

        System.out.println("Immutable Map 1: " + immutableMap1);

        // 2️⃣ Creating an Immutable Map using Map.ofEntries()
        Map<String, Integer> immutableMap2 = Map.ofEntries(
                Map.entry("X", 10),
                Map.entry("Y", 20),
                Map.entry("Z", 30)
        );

        System.out.println("Immutable Map 2: " + immutableMap2);

        // 3️⃣ Creating an Immutable Map using Collections.unmodifiableMap()
        Map<String, Integer> mutableMap = new HashMap<>();
        mutableMap.put("P", 100);
        mutableMap.put("Q", 200);
        Map<String, Integer> immutableMap3 = Collections.unmodifiableMap(mutableMap);

        System.out.println("Immutable Map 3: " + immutableMap3);

        // 4️⃣ Demonstrating Immutability - These will throw UnsupportedOperationException
        try {
            immutableMap1.put("D", 4); // ❌ Throws Exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutableMap1!");
        }

        try {
            immutableMap2.remove("X"); // ❌ Throws Exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot remove from immutableMap2!");
        }

        try {
            immutableMap3.put("R", 300); // ❌ Throws Exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutableMap3!");
        }
    }
}
