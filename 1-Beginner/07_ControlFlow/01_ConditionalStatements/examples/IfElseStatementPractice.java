public class IfElseStatementPractice {
    public static void main(String[] args) {
        // Question 1: Check if a number is odd or even
        int number1 = 7;
        if (number1 % 2 == 0) {
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }

        // Question 2: Check if a person is eligible to vote (age >= 18)
        int age = 16;
        if (age >= 18) {
            System.out.println("Eligible to vote.");
        } else {
            System.out.println("Not eligible to vote.");
        }

        // Question 3: Check if a temperature is hot (>30), cold (<15), or normal
        int temp = 25;
        if (temp > 30) {
            System.out.println("It's hot.");
        } else if (temp < 15) {
            System.out.println("It's cold.");
        } else {
            System.out.println("It's normal.");
        }

        // Question 4: Check if a number is divisible by both 3 and 5
        int number2 = 15;
        if (number2 % 3 == 0 && number2 % 5 == 0) {
            System.out.println("Divisible by 3 and 5.");
        } else {
            System.out.println("Not divisible by 3 and 5.");
        }

        
    }
}
