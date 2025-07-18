public class AssignmentOperators {
    public static void main(String[] args) {
        // Question 1: Basic Assignment
        int a = 10;
        System.out.println("Question 1 - a = " + a);

        // Question 2: Addition Assignment
        a += 5; // a = a + 5
        System.out.println("Question 2 - a += 5, a = " + a);

        // Question 3: Subtraction Assignment
        a -= 3; // a = a - 3
        System.out.println("Question 3 - a -= 3, a = " + a);

        // Question 4: Multiplication Assignment
        a *= 2; // a = a * 2
        System.out.println("Question 4 - a *= 2, a = " + a);

        // Question 5: Division Assignment
        a /= 4; // a = a / 4
        System.out.println("Question 5 - a /= 4, a = " + a);

        // Question 6: Modulus Assignment
        a %= 3; // a = a % 3
        System.out.println("Question 6 - a %= 3, a = " + a);

        // Question 7: Chained Assignment
        int b = 5, c = 3;
        a = b = c; // a = b = c
        System.out.println("Question 7 - Chained Assignment: a = " + a + ", b = " + b + ", c = " + c);

        // Question 8: Using Assignment Operators with Expressions
        int x = 10, y = 20;
        x += (y -= 5); // First subtract y by 5, then add the result to x
        System.out.println("Question 8 - x += (y -= 5), x = " + x + ", y = " + y);

        // Question 9: Combined Assignment in a Real-World Scenario
        // Assume you're calculating the total amount after applying multiple discounts
        double price = 1000.0;
        price -= 100.0; // Apply first discount
        price *= 0.9;   // Apply second discount (10% off)
        System.out.println("Question 9 - Total after discounts: " + price);

        // Question 10: Compound Assignment with String
        String message = "Hello";
        message += " World"; // Concatenate " World" to message
        System.out.println("Question 10 - message: " + message);
    }
}
