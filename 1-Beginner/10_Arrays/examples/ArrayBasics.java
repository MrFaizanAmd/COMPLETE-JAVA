public class ArrayBasics {
    public static void main(String[] args) {
        // Create and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Access elements
        System.out.println("First element: " + numbers[0]);

        // Modify an element
        numbers[2] = 100;
        System.out.println("Modified array: " + java.util.Arrays.toString(numbers));

        // Iterate through the array
        for (int number : numbers) {
            System.out.println("Element: " + number);
        }
    }
}