import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        // 1️⃣ Basic TreeSet Operations (Sorted Set)
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(5); // Duplicate, will not be added

        System.out.println("TreeSet (Sorted Order): " + treeSet);

        // 2️⃣ Check if an element exists
        System.out.println("Contains 8? " + treeSet.contains(8));
        System.out.println("Contains 10? " + treeSet.contains(10));

        // 3️⃣ Remove elements
        treeSet.remove(2);
        System.out.println("After removing 2: " + treeSet);

        // 4️⃣ Iterating over TreeSet (Always in Sorted Order)
        System.out.println("Iterating over TreeSet:");
        for (Integer num : treeSet) {
            System.out.println(num);
        }

        // 5️⃣ Retrieve First and Last Elements
        System.out.println("First Element: " + treeSet.first());
        System.out.println("Last Element: " + treeSet.last());

        // 6️⃣ Higher and Lower Methods
        System.out.println("Higher than 3: " + treeSet.higher(3)); // Next higher element
        System.out.println("Lower than 3: " + treeSet.lower(3));   // Previous lower element

        // 7️⃣ HeadSet, TailSet, and SubSet
        System.out.println("HeadSet (Elements less than 5): " + treeSet.headSet(5));
        System.out.println("TailSet (Elements greater than or equal to 5): " + treeSet.tailSet(5));
        System.out.println("SubSet (Between 1 and 8): " + treeSet.subSet(1, 8));

        // 8️⃣ Polling First and Last Elements
        System.out.println("Polling First Element: " + treeSet.pollFirst());
        System.out.println("Polling Last Element: " + treeSet.pollLast());
        System.out.println("After Polling: " + treeSet);

        System.out.println("----------------------------------------------------");

        // 🔹 Advanced Usage

        // 1️⃣ Custom Comparator (Descending Order)
        TreeSet<Integer> descSet = new TreeSet<>(Collections.reverseOrder());
        descSet.addAll(Arrays.asList(10, 20, 5, 15));
        System.out.println("TreeSet with Descending Order: " + descSet);

        // 2️⃣ TreeSet with Custom Objects
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));
        people.add(new Person("Alice", 25)); // Duplicate, won't be added

        System.out.println("TreeSet with Custom Objects: " + people);
    }
}

// Custom Class must implement Comparable for TreeSet to work
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // Sorting by Age
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
