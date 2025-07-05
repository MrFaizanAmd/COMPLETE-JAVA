import java.util.Scanner;

public class DataTypeInput {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt and input for each data type
        System.out.print("Enter a byte value: ");
        byte userByte = scanner.nextByte();

        System.out.print("Enter a short value: ");
        short userShort = scanner.nextShort();

        System.out.print("Enter an int value: ");
        int userInt = scanner.nextInt();

        System.out.print("Enter a long value: ");
        long userLong = scanner.nextLong();

        System.out.print("Enter a float value: ");
        float userFloat = scanner.nextFloat();

        System.out.print("Enter a double value: ");
        double userDouble = scanner.nextDouble();

        System.out.print("Enter a char value: ");
        char userChar = scanner.next().charAt(0);

        System.out.print("Enter a boolean value (true/false): ");
        boolean userBoolean = scanner.nextBoolean();

        // Print each variable entered by the user
        System.out.println("\nYou entered:");
        System.out.println("Byte value: " + userByte);
        System.out.println("Short value: " + userShort);
        System.out.println("Int value: " + userInt);
        System.out.println("Long value: " + userLong);
        System.out.println("Float value: " + userFloat);
        System.out.println("Double value: " + userDouble);
        System.out.println("Char value: " + userChar);
        System.out.println("Boolean value: " + userBoolean);

        // Close the scanner
        scanner.close();
    }
}
