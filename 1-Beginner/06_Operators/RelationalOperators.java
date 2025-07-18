public class RelationalOperators {
    public static void main(String[] args) {
        // Question 1: Equal to (==)
        int a = 10, b = 20;
        System.out.println("Question 1 - a == b: " + (a == b));

        // Question 2: Not equal to (!=)
        a = 15;
        b = 15;
        System.out.println("Question 2 - a != b: " + (a != b));

        // Question 3: Greater than (>)
        a = 30;
        b = 20;
        System.out.println("Question 3 - a > b: " + (a > b));

        // Question 4: Less than (<)
        a = 10;
        b = 20;
        System.out.println("Question 4 - a < b: " + (a < b));

        // Question 5: Greater than or equal to (>=)
        a = 25;
        b = 25;
        System.out.println("Question 5 - a >= b: " + (a >= b));

        // Question 6: Less than or equal to (<=)
        a = 15;
        b = 20;
        System.out.println("Question 6 - a <= b: " + (a <= b));

        // Question 7: Comparing with Multiple Conditions
        int x = 5, y = 10, z = 15;
        System.out.println("Question 7 - (x < y && y < z): " + (x < y && y < z));

        // Question 8: Check if a Number is Within a Range
        a = 18;
        System.out.println("Question 8 - Is a between 10 and 20? (a >= 10 && a <= 20): " + (a >= 10 && a <= 20));

        // Question 9: Compare Two Strings Using Relational Operators
        String str1 = "Java";
        String str2 = "Java";
        System.out.println("Question 9 - str1 == str2: " + (str1 == str2));

        // Question 10: Check if One Number is Divisible by Another
        a = 30;
        b = 5;
        System.out.println("Question 10 - Is a divisible by b? (a % b == 0): " + (a % b == 0));
    }
}
