public class OperatorPrecedence {
    public static void main(String[] args) {
        // Question 1: Precedence of Arithmetic Operators
        int a = 10, b = 20, c = 5;
        int result1 = a + b * c;
        System.out.println("Question 1 - a + b * c: " + result1); // Expected: 10 + (20 * 5) = 10 + 100 = 110

        // Question 2: Parentheses change precedence
        int result2 = (a + b) * c;
        System.out.println("Question 2 - (a + b) * c: " + result2); // Expected: (10 + 20) * 5 = 30 * 5 = 150

        // Question 3: Mixed Operators (Arithmetic and Relational)
        boolean result3 = a + b > c * 2;
        System.out.println("Question 3 - a + b > c * 2: " + result3); // Expected: (10 + 20) > (5 * 2) => 30 > 10 => true

        // Question 4: Mixing Assignment and Arithmetic Operators
        int x = 5;
        x += 3 * 2; // x = x + (3 * 2)
        System.out.println("Question 4 - x += 3 * 2: " + x); // Expected: x = 5 + 6 = 11

        // Question 5: Operator Precedence with Multiple Parentheses
        int result4 = (a + b) * (c - a) / b;
        System.out.println("Question 5 - (a + b) * (c - a) / b: " + result4); // Expected: (10 + 20) * (5 - 10) / 20 => 30 * (-5) / 20 => -150 / 20 = -7

        // Question 6: Logical and Relational Operators
        boolean result5 = a + b * c > 50 && b - c < 10;
        System.out.println("Question 6 - a + b * c > 50 && b - c < 10: " + result5); // Expected: (10 + 20 * 5 > 50) && (20 - 5 < 10) => (10 + 100 > 50) && (15 < 10) => true && false => false

        // Question 7: Mixing Logical, Arithmetic, and Relational Operators
        boolean result6 = (a + b > c * 2) || (a * b < c + 10);
        System.out.println("Question 7 - (a + b > c * 2) || (a * b < c + 10): " + result6); // Expected: (10 + 20 > 5 * 2) || (10 * 20 < 5 + 10) => (30 > 10) || (200 < 15) => true || false => true

        // Question 8: Combining Increment/Decrement with Arithmetic Operators
        int result7 = ++a * b - --c;
        System.out.println("Question 8 - ++a * b - --c: " + result7); // Expected: (++10 * 20) - --5 => 11 * 20 - 4 => 220 - 4 = 216

        // Question 9: Using Multiple Operators in a Single Expression
        int result8 = (a * b + c) / (b - a) * c;
        System.out.println("Question 9 - (a * b + c) / (b - a) * c: " + result8); // Expected: (10 * 20 + 5) / (20 - 10) * 5 => (200 + 5) / 10 * 5 => 205 / 10 * 5 = 205 * 0.5 = 102 (integer division)

        // Question 10: Long Expression Combining Different Operators
        int result9 = a + b * c - (a - b) * (c / 2) + b;
        System.out.println("Question 10 - a + b * c - (a - b) * (c / 2) + b: " + result9); // Expected: 10 + 20 * 5 - (10 - 20) * (5 / 2) + 20 => 10 + 100 - (-10) * 2 + 20 => 10 + 100 + 20 + 20 = 150
    }
}
