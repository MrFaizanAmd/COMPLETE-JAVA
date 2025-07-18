import java.util.*;

public class VectorMethodsDemo {
    public static void main(String[] args) {
        // Creating a Vector
        Vector<String> vector = new Vector<>();
        
        // 1. add(E e) - Adds an element at the end
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        System.out.println("Vector after add: " + vector);
        
        // 2. add(int index, E element) - Inserts an element at a specific index
        vector.add(1, "Mango");
        System.out.println("After adding at index 1: " + vector);
        
        // 3. get(int index) - Retrieves an element at a given index
        System.out.println("Element at index 2: " + vector.get(2));
        
        // 4. set(int index, E element) - Updates an element at a specific index
        vector.set(2, "Orange");
        System.out.println("After setting index 2: " + vector);
        
        // 5. remove(int index) - Removes element at given index
        vector.remove(3);
        System.out.println("After removing index 3: " + vector);
        
        // 6. remove(Object o) - Removes first occurrence of a specific element
        vector.remove("Mango");
        System.out.println("After removing 'Mango': " + vector);
        
        // 7. contains(Object o) - Checks if element exists
        System.out.println("Contains 'Apple'? " + vector.contains("Apple"));
        
        // 8. indexOf(Object o) - Returns the index of the first occurrence
        System.out.println("Index of 'Apple': " + vector.indexOf("Apple"));
        
        // 9. isEmpty() - Checks if the vector is empty
        System.out.println("Is vector empty? " + vector.isEmpty());
        
        // 10. size() - Returns number of elements
        System.out.println("Size of vector: " + vector.size());
        
        // 11. toArray() - Converts Vector to Array
        Object[] arr = vector.toArray();
        System.out.println("Array: " + Arrays.toString(arr));
        
        // 12. firstElement() & lastElement() - Get first and last elements
        System.out.println("First Element: " + vector.firstElement());
        System.out.println("Last Element: " + vector.lastElement());
        
        // 13. ensureCapacity(int minCapacity) - Increases capacity if needed
        vector.ensureCapacity(10);
        System.out.println("Capacity ensured for 10 elements.");
        
        // 14. trimToSize() - Trims the capacity to match current size
        vector.trimToSize();
        System.out.println("Vector size after trim: " + vector.size());
        
        // 15. clone() - Creates a shallow copy
        Vector<String> clonedVector = (Vector<String>) vector.clone();
        System.out.println("Cloned Vector: " + clonedVector);
        
        // 16. clear() - Removes all elements
        vector.clear();
        System.out.println("After clear(): " + vector);
    }
}
