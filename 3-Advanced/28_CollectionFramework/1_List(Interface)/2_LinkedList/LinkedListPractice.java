import java.util.*;

public class LinkedListPractice {
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> list = new LinkedList<>();
        
        // 1. add(E e) - Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        System.out.println("LinkedList: " + list);
        
        // 2. add(int index, E element) - Insert at index
        list.add(1, "Orange");
        System.out.println("After adding at index 1: " + list);
        
        // 3. get(int index) - Retrieve an element
        System.out.println("Element at index 2: " + list.get(2));
        
        // 4. set(int index, E element) - Update an element
        list.set(1, "Grapes");
        System.out.println("After update: " + list);
        
        // 5. remove(int index) - Remove by index
        list.remove(2);
        System.out.println("After removal by index: " + list);
        
        // 6. remove(Object o) - Remove by value
        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);
        
        // 7. size() - Get size
        System.out.println("Size of LinkedList: " + list.size());
        
        // 8. clear() - Remove all elements
        list.clear();
        System.out.println("After clearing: " + list);
        
        // 9. contains(Object o) - Check if element exists
        list.add("Kiwi");
        System.out.println("Contains 'Kiwi': " + list.contains("Kiwi"));
        
        // 10. peekFirst() / peekLast() - Get first/last without removal
        list.add("Papaya");
        System.out.println("First Element: " + list.peekFirst());
        System.out.println("Last Element: " + list.peekLast());
        
        // 11. pollFirst() / pollLast() - Get and remove first/last
        System.out.println("Removed First: " + list.pollFirst());
        System.out.println("After pollFirst: " + list);
        
        // 12. isEmpty() - Check if empty
        System.out.println("Is empty: " + list.isEmpty());
        
        // 13. toArray() - Convert to array
        list.add("Strawberry");
        list.add("Blueberry");
        Object[] arr = list.toArray();
        System.out.println("Array: " + Arrays.toString(arr));
        
        // 14. descendingIterator() - Iterate in reverse
        list.add("Cherry");
        System.out.println("Reverse iteration:");
        Iterator<String> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
