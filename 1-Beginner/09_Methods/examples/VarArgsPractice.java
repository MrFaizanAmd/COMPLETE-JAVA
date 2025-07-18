// File: VarArgsPractice.java

public class VarArgsPractice {

    // Method to demonstrate varargs
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    // Method to demonstrate mixing varargs with other parameters
    public static void displayDetails(String message, int... numbers) {
        System.out.println("Message: " + message);
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Calling the sum method with different numbers of arguments
        System.out.println("Sum of 1, 2, 3: " + sum(1, 2, 3)); // Output: 6
        System.out.println("Sum of 5, 10, 15, 20: " + sum(5, 10, 15, 20)); // Output: 50
        System.out.println("Sum of no arguments: " + sum()); // Output: 0

        // Calling the displayDetails method
        displayDetails("List of numbers:", 7, 14, 21, 28); 
        displayDetails("Empty list:");
    }
}
