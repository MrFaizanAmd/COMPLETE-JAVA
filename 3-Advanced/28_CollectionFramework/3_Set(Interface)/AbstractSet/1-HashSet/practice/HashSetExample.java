import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        // 1️⃣ Basic HashSet Operations
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate, will not be added

        System.out.println("HashSet: " + set);

        // 2️⃣ Check if an element exists
        System.out.println("Contains 'Banana'? " + set.contains("Banana"));
        System.out.println("Contains 'Grapes'? " + set.contains("Grapes"));

        // 3️⃣ Remove elements
        set.remove("Cherry");
        System.out.println("After removing 'Cherry': " + set);

        // 4️⃣ Iterating over HashSet
        System.out.println("Iterating over HashSet:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // 5️⃣ Convert HashSet to Array
        String[] array = set.toArray(new String[0]);
        System.out.println("Converted Array: " + Arrays.toString(array));

        // 6️⃣ Convert HashSet to List
        List<String> list = new ArrayList<>(set);
        System.out.println("Converted List: " + list);

        // 7️⃣ Check size of the HashSet
        System.out.println("Size of HashSet: " + set.size());

        // 8️⃣ Check if HashSet is empty
        System.out.println("Is HashSet empty? " + set.isEmpty());

        // 9️⃣ Clear all elements
        set.clear();
        System.out.println("After clearing: " + set);
        
        System.out.println("----------------------------------------------------");

        // 🔹 Advanced Usage

        // 1️⃣ Creating a HashSet with Initial Capacity and Load Factor
        HashSet<Integer> numbers = new HashSet<>(10, 0.75f);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Numbers HashSet: " + numbers);

        // 2️⃣ Union of Two Sets
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set1.addAll(set2);
        System.out.println("Union: " + set1);

        // 3️⃣ Intersection of Two Sets
        set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set1.retainAll(set2);
        System.out.println("Intersection: " + set1);

        // 4️⃣ Difference of Two Sets
        set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set1.removeAll(set2);
        System.out.println("Difference: " + set1);

        // 5️⃣ Checking if one set is a subset of another
        set1 = new HashSet<>(Arrays.asList(1, 2));
        set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Is set1 a subset of set2? " + set2.containsAll(set1));

        // 6️⃣ HashSet with Custom Objects
        Set<Person> people = new HashSet<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Alice", 25)); // Duplicate due to same values

        System.out.println("HashSet with Custom Objects: " + people);
    }
}

// Custom Class with Proper hashCode() and equals() for HashSet
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
