import java.util.ArrayList;

public class ArrayListMethodsExample {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        
        // 1. add() - Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After adding elements: " + fruits);

        // 2. add(index, element) - Adding at a specific index
        fruits.add(1, "Blueberry");
        System.out.println("After adding Blueberry at index 1: " + fruits);

        // 3. get() - Retrieving an element
        System.out.println("Element at index 2: " + fruits.get(2));

        // 4. set() - Modifying an element
        fruits.set(1, "Blackberry");
        System.out.println("After modifying index 1: " + fruits);

        // 5. remove(index) - Removing by index
        fruits.remove(2);
        System.out.println("After removing element at index 2: " + fruits);

        // 6. remove(object) - Removing by value
        fruits.remove("Apple");
        System.out.println("After removing Apple: " + fruits);

        // 7. contains() - Checking if an element exists
        System.out.println("Contains Banana? " + fruits.contains("Banana"));

        // 8. size() - Getting the size of the ArrayList
        System.out.println("Size of list: " + fruits.size());

        // 9. isEmpty() - Checking if list is empty
        System.out.println("Is list empty? " + fruits.isEmpty());
       
        // 10. clear() - Removing all elements
        fruits.clear();
        System.out.println("After clearing: " + fruits);

        // 11. ensureCapacity() - Increasing capacity (not commonly used)
        fruits.ensureCapacity(10);
        
        // 12. trimToSize() - Trimming unused capacity
        fruits.trimToSize();

    }
}
