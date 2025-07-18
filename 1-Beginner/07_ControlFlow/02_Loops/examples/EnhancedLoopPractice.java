// File: EnhancedLoopPractice.java
public class EnhancedLoopPractice {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1. Print all elements in an array
        for (int num : numbers) {
            System.out.println(num);
        }

        // 2. Print only odd elements in an array
        for (int num : numbers) {
            if (num % 2 == 0) continue;
            System.out.println(num);
        }

        // 3. Stop when element equals 5
        for (int num : numbers) {
            if (num == 5) break;
            System.out.println(num);
        }

        // 4. Print squares of elements
        for (int num : numbers) {
            System.out.println("Square of " + num + " is " + (num * num));
        }

        // 5. Sum elements of the array
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum);
    }
}