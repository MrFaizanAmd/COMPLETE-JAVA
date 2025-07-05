public class TernaryOperatorPractice {
    public static void main(String[] args) {
        // Question 1: Check if a number is even or odd
        int number = 10;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number is: " + result);

        // Question 2: Find the larger of two numbers
        int a = 15, b = 20;
        int larger = (a > b) ? a : b;
        System.out.println("Larger number is: " + larger);

        // Question 3: Check if a person is an adult (age >= 18)
        int age = 17;
        String adult = (age >= 18) ? "Adult" : "Not an adult";
        System.out.println("Person is: " + adult);

        // Question 4: Determine if a temperature is hot or cold
        int temp = 30;
        String tempStatus = (temp > 25) ? "Hot" : "Cold";
        System.out.println("Temperature is: " + tempStatus);

        // Question 5: Use ternary to assign a default value
        int value = 0;
        int defaultValue = (value != 0) ? value : 100;
        System.out.println("Value is: " + defaultValue);
    }
}
