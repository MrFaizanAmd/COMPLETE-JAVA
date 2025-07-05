// Tricky Questions on Type Conversion in Java

public class Practice {

    public static void main(String[] args) {
        // Question 1: Widening with byte, short, and int
        byte b = 50;
        short s = b; // Widening byte to short
        int i = s;   // Widening short to int
        System.out.println("Widening byte -> short -> int: " + i);

        // Question 2: Narrowing with possible data loss
        double d = 123.456;
        int narrowedInt = (int) d; // Narrowing double to int
        System.out.println("Narrowing double -> int (with data loss): " + narrowedInt);

        // Question 3: Overflow during narrowing
        int largeValue = 130;
        byte narrowedByte = (byte) largeValue; // Narrowing int to byte
        System.out.println("Overflow in narrowing int -> byte: " + narrowedByte);

        // Question 4: Adding char values
        char c1 = 'A'; // ASCII value is 65
        char c2 = 'B'; // ASCII value is 66
        int sum = c1 + c2; // Adds ASCII values
        System.out.println("Sum of char 'A' + 'B' (ASCII): " + sum);

        // Question 5: Implicit type promotion in expressions
        byte x = 10;
        byte y = 20;
        // byte z = x + y; // Error: x + y is promoted to int
        int z = x + y;
        System.out.println("Type promotion in byte addition: " + z);

        // Question 6: String to numeric conversion
        String strNumber = "123";
        int parsedInt = Integer.parseInt(strNumber); // String to int
        double parsedDouble = Double.parseDouble(strNumber); // String to double
        System.out.println("String to int: " + parsedInt);
        System.out.println("String to double: " + parsedDouble);

        // Question 7: Numeric to String conversion
        int number = 456;
        String strFromInt = Integer.toString(number);
        System.out.println("Int to String: " + strFromInt);

        // Question 8: Typecasting in division
        int a = 10;
        int bDiv = 4;
        double divisionResult = (double) a / bDiv; // Casting to avoid integer division
        System.out.println("Division with casting: " + divisionResult);

        // Question 9: Unexpected type promotion
        char charValue = 'C'; // ASCII value is 67
        int promotedValue = charValue + 1; // Promoted to int in arithmetic
        System.out.println("Promoted char 'C' + 1: " + promotedValue);

        // Question 10: Mixed type operations
        int intVal = 5;
        float floatVal = 2.5f;
        double result = intVal + floatVal; // Implicit promotion to double
        System.out.println("Mixed type operation (int + float): " + result);

        // Question 11: Long literal without suffix
        long longWithoutSuffix = 123456789;
        System.out.println("Long without suffix: " + longWithoutSuffix);

        // Question 12: Float to int narrowing with rounding
        float floatNum = 9.99f;
        int roundedInt = (int) floatNum;
        System.out.println("Narrowing float -> int (truncation): " + roundedInt);

        // Question 13: Casting large double to int
        double bigDouble = 1e9 + 0.7; // 1 billion + 0.7
        int bigInt = (int) bigDouble; // Truncates fractional part
        System.out.println("Casting large double -> int: " + bigInt);

        // Question 14: Boolean to numeric (not allowed in Java)
        // boolean boolVal = true;
        // int boolToInt = (int) boolVal; // Compilation error: incompatible types
    }
}
