public class ArithmeticOperators {
    public static void main(String[] args) {
        // Question 1: Simple Addition
        int a = 10;
        int b = 5;
        int result = a + b;
        System.out.println("Question 1 - Sum: " + result);

        // Question 2: Subtraction
        a = 15;
        b = 7;
        result = a - b;
        System.out.println("Question 2 - Difference: " + result);

        // Question 3: Multiplication
        a = 4;
        b = 6;
        result = a * b;
        System.out.println("Question 3 - Product: " + result);

        // Question 4: Division
        a = 20;
        b = 4;
        result = a / b;
        System.out.println("Question 4 - Quotient: " + result);

        // Question 5: Modulus
        a = 25;
        b = 4;
        result = a % b;
        System.out.println("Question 5 - Remainder: " + result);

        // Question 6: Simple Interest Calculation
        double principal = 1000.0;
        double rate = 5.0;
        double time = 3.0;
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Question 6 - Simple Interest: " + simpleInterest);

        // Question 7: Discount Calculation
        double originalPrice = 100.0;
        double discount = 20.0;
        double discountedPrice = originalPrice - (originalPrice * (discount / 100));
        System.out.println("Question 7 - Discounted Price: " + discountedPrice);

        // Question 8: Average Calculation
        int num1 = 10, num2 = 20, num3 = 30;
        double average = (num1 + num2 + num3) / 3.0;
        System.out.println("Question 8 - Average: " + average);

        // Question 9: Swapping Two Numbers Without a Temporary Variable
        a = 5;
        b = 10;
        a = a + b;  // a becomes 15
        b = a - b;  // b becomes 5
        a = a - b;  // a becomes 10
        System.out.println("Question 9 - Swapped Values: a = " + a + ", b = " + b);

        // Question 10: Percentage Calculation
        double totalMarks = 500;
        double obtainedMarks = 435;
        double percentage = (obtainedMarks / totalMarks) * 100;
        System.out.println("Question 10 - Percentage: " + percentage + "%");
    }
}
