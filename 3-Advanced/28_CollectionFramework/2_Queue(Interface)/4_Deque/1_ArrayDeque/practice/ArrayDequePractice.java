import java.util.ArrayDeque;

public class ArrayDequePractice {
    public static void main(String[] args) {
        // Creating an ArrayDeque (double-ended queue)
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Adding elements to the front and rear
        deque.addFirst("First"); // Adds element at the front
        deque.addLast("Second"); // Adds element at the rear
        deque.offerFirst("Zero"); // Another way to add at the front
        deque.offerLast("Third"); // Another way to add at the rear
        
        System.out.println("Initial Deque: " + deque);

        // Removing elements from the front and rear
        System.out.println("Removed First: " + deque.pollFirst()); // Removes from the front
        System.out.println("Removed Last: " + deque.pollLast()); // Removes from the rear
        
        System.out.println("Deque after removals: " + deque);

        // Checking elements without removal
        System.out.println("Peek First: " + deque.peekFirst()); // Checks front element
        System.out.println("Peek Last: " + deque.peekLast()); // Checks rear element

        // Checking if deque contains an element
        System.out.println("Contains 'Second'? " + deque.contains("Second"));

        // Iterating over deque elements
        System.out.println("Iterating over deque:");
        for (String item : deque) {
            System.out.println(item);
        }

        // Use case example: Browser history navigation
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        browserHistory.push("Page 1"); // User visits Page 1
        browserHistory.push("Page 2"); // User visits Page 2
        browserHistory.push("Page 3"); // User visits Page 3
        
        System.out.println("Current History Stack: " + browserHistory);
        
        // Going back in history
        System.out.println("Going back to: " + browserHistory.pop()); // Returns to Page 2
        System.out.println("Current Page: " + browserHistory.peek()); // Now on Page 2
    }
}
