public class SwitchRuleExample {
    public static void main(String[] args) {
        
        // Question 1: Write a rule switch expression to determine the day of the week.
        int day = 3;
        String dayOfWeek = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println("Day of the week: " + dayOfWeek);
        
        // Question 2: Given a score (0-100), use rule switch to determine the grade.
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> {
                System.out.println("Score too low, assigning F...");
                yield "F";
            }
        };
        System.out.println("Grade: " + grade);

        // Question 3: Write a switch expression for determining the number of days in a month.
        int month = 2;
        int daysInMonth = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28; // Non-leap year
            default -> throw new IllegalArgumentException("Invalid month");
        };
        System.out.println("Days in the month: " + daysInMonth);

        // Question 4: Write a switch expression to assign a category based on the age group.
        int age = 25;
        String category = switch (age) {
            case 0, 1, 2, 3, 4, 5 -> "Toddler";
            case 6, 7, 8, 9, 10, 11, 12 -> "Child";
            case 13, 14, 15, 16, 17, 18, 19 -> "Teenager";
            case 20, 21, 22, 23, 24, 25 -> "Young Adult";
            default -> "Adult";
        };
        System.out.println("Category: " + category);

        // Question 5: Use rule switch to calculate the total price based on the quantity purchased.
        int quantity = 5;
        double pricePerItem = switch (quantity) {
            case 1 -> 10.0;
            case 2, 3 -> 9.5;
            case 4, 5 -> 9.0;
            default -> {
                System.out.println("Bulk purchase, applying discount...");
                yield 8.0;
            }
        };
        System.out.println("Price per item: $" + pricePerItem);
    }
}
