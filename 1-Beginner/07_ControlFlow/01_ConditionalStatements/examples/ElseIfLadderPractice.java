public class ElseIfLadderPractice {
    public static void main(String[] args) {
        // Question 1: Determine grade based on marks
        int marks = 85;
        if (marks >= 90) {
            System.out.println("Grade: A+");
        } else if (marks >= 75) {
            System.out.println("Grade: A");
        } else if (marks >= 50) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: F");
        }

        // Question 2: Check the range of a number
        int number1 = 42;
        if (number1 < 10) {
            System.out.println("The number is less than 10.");
        } else if (number1 <= 50) {
            System.out.println("The number is between 10 and 50.");
        } else {
            System.out.println("The number is greater than 50.");
        }

        // Question 3: Assign performance level based on a score
        int score = 70;
        if (score >= 80) {
            System.out.println("Performance: Excellent");
        } else if (score >= 60) {
            System.out.println("Performance: Good");
        } else if (score >= 40) {
            System.out.println("Performance: Average");
        } else {
            System.out.println("Performance: Poor");
        }

        // Question 4: Check if a person can ride a roller coaster (height)
        int height = 140;
        if (height < 120) {
            System.out.println("Too short to ride.");
        } else if (height <= 200) {
            System.out.println("Can ride safely.");
        } else {
            System.out.println("Too tall to ride.");
        }

        
    }
}
