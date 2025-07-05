public class SwitchStatementPractice {
    public static void main(String[] args) {
        // Question 1: Print day of the week
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day.");
        }

        // Question 2: Determine grade with switch
        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good job!");
                break;
            case 'C':
                System.out.println("Average.");
                break;
            case 'D':
                System.out.println("Below average.");
                break;
            case 'F':
                System.out.println("Fail.");
                break;
            default:
                System.out.println("Invalid grade.");
        }

        // Question 3: Perform operations based on operator
        char operator = '+';
        int a = 10, b = 20;
        switch (operator) {
            case '+':
                System.out.println("Addition: " + (a + b));
                break;
            case '-':
                System.out.println("Subtraction: " + (a - b));
                break;
            case '*':
                System.out.println("Multiplication: " + (a * b));
                break;
            case '/':
                System.out.println("Division: " + (a / b));
                break;
            default:
                System.out.println("Invalid operator.");
        }

        // Question 4: Determine the type of shape based on sides
        int sides = 4;
        switch (sides) {
            case 3:
                System.out.println("Triangle");
                break;
            case 4:
                System.out.println("Quadrilateral");
                break;
            case 5:
                System.out.println("Pentagon");
                break;
            default:
                System.out.println("Shape not defined.");
        }

       
    }
}
