// File: MethodsExamples.java
public class MethodsExamples {

    // Method to print a greeting message
    public static void greetUser() {
        System.out.println("Hello, welcome to learning Java methods!");
    }

    // Method to add two numbers and return the result
    public static int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    // Method to check if a number is even or odd
    public static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    // Method to find the factorial of a number
    public static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Main method to test other methods
    public static void main(String[] args) {
        greetUser(); // Calling the greetUser method
        
        int sum = addNumbers(10, 20); // Calling addNumbers method
        System.out.println("The sum of 10 and 20 is: " + sum);
        
        checkEvenOdd(15); // Calling checkEvenOdd method
        
        int fact = factorial(5); // Calling factorial method
        System.out.println("The factorial of 5 is: " + fact);
    }
}
