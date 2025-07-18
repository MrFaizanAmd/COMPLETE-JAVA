public class LogicalOperators {
    public static void main(String[] args) {
        // Question 1: AND Operator (&&)
        boolean a = true;
        boolean b = false;
        System.out.println("Question 1 - AND Operator (a && b): " + (a && b));

        // Question 2: OR Operator (||)
        a = true;
        b = false;
        System.out.println("Question 2 - OR Operator (a || b): " + (a || b));

        // Question 3: NOT Operator (!)
        a = true;
        System.out.println("Question 3 - NOT Operator (!a): " + !a);

        // Question 4: Combining AND and OR Operators
        a = true;
        b = false;
        boolean c = true;
        System.out.println("Question 4 - (a && b) || c: " + ((a && b) || c));

        // Question 5: Using Logical Operators with Conditions
        int x = 10, y = 20;
        System.out.println("Question 5 - (x > 5 && y < 25): " + (x > 5 && y < 25));
        System.out.println("Question 5 - (x > 15 || y < 25): " + (x > 15 || y < 25));

        // Question 6: Nested Logical Operators
        a = true;
        b = false;
        System.out.println("Question 6 - (a && (b || true)): " + (a && (b || true)));

        // Question 7: Logical AND with multiple conditions
        x = 15;
        y = 25;
        System.out.println("Question 7 - (x > 10 && y > 20): " + (x > 10 && y > 20));

        // Question 8: Logical OR with multiple conditions
        x = 5;
        y = 15;
        System.out.println("Question 8 - (x < 10 || y > 20): " + (x < 10 || y > 20));

        // Question 9: Using NOT with other logical operators
        a = true;
        b = false;
        System.out.println("Question 9 - !(a || b): " + !(a || b));

        // Question 10: Combining Logical Operators for a Complex Expression
        x = 5;
        y = 10;
        int z = 15;
        boolean result = (x < y && y < z) || !(x > z);
        System.out.println("Question 10 - Complex Logical Expression: " + result);
    }
}
