public class TernaryAndUnaryOperators {
    public static void main(String[] args) {
        // Ternary Operator Questions
        
        // Question 1: Simple Ternary Operator
        int a = 10, b = 20;
        int result = (a > b) ? a : b;
        System.out.println("Question 1 - Ternary Operator: (a > b) ? a : b = " + result);

        // Question 2: Ternary Operator with String
        String message = (a < b) ? "a is smaller" : "a is greater";
        System.out.println("Question 2 - Ternary Operator with String: " + message);

        // Question 3: Nested Ternary Operator
        int max = (a > b) ? ((a > 15) ? a : 15) : ((b > 15) ? b : 15);
        System.out.println("Question 3 - Nested Ternary Operator: " + max);

        // Unary Operator Questions
        
        // Question 4: Prefix Increment
        int x = 5;
        System.out.println("Question 4 - Prefix Increment: ++x = " + (++x));

        // Question 5: Postfix Increment
        int y = 5;
        System.out.println("Question 5 - Postfix Increment: y++ = " + (y++));
        System.out.println("y after postfix increment: " + y);

        // Question 6: Prefix Decrement
        int z = 10;
        System.out.println("Question 6 - Prefix Decrement: --z = " + (--z));

        // Question 7: Postfix Decrement
        int w = 10;
        System.out.println("Question 7 - Postfix Decrement: w-- = " + (w--));
        System.out.println("w after postfix decrement: " + w);

        // Question 8: Unary Minus and Plus
        int num = -15;
        System.out.println("Question 8 - Unary Minus: " + (-num));
        System.out.println("Question 8 - Unary Plus: " + (+num));

        // Question 9: Logical NOT
        boolean isTrue = false;
        System.out.println("Question 9 - Logical NOT: !isTrue = " + (!isTrue));

        // Question 10: Combining Unary Operators
        int p = 10, q = 5;
        System.out.println("Question 10 - Combining Unary Operators: p++ - --q = " + (p++ - --q));
        System.out.println("p after combining unary operators: " + p);
        System.out.println("q after combining unary operators: " + q);
    }
}
