// File: TypeConversionExamples.java

public class TypeConversionExamples {
    public static void main(String[] args) {
        // Example 1: Widening Conversion
        // Widening Conversion: Automatically converting a smaller type to a larger type
        int intValue = 100;
        long longValue = intValue; // Widening from int to long
        float floatValue = longValue; // Widening from long to float
        double doubleValue = floatValue; // Widening from float to double

        System.out.println("Widening Conversion Examples:");
        System.out.println("Int value: " + intValue);
        System.out.println("Long value: " + longValue);
        System.out.println("Float value: " + floatValue);
        System.out.println("Double value: " + doubleValue);
        System.out.println(); // Blank line for better readability


        
        // Example 2: Narrowing Conversion
        // Narrowing Conversion: Explicitly converting a larger type to a smaller type
        double doubleValueNarrow = 123.456;
        float floatValueNarrow = (float) doubleValueNarrow; // Narrowing from double to float
        long longValueNarrow = (long) floatValueNarrow; // Narrowing from float to long
        int intValueNarrow = (int) longValueNarrow; // Narrowing from long to int

        System.out.println("Narrowing Conversion Examples:");
        System.out.println("Double value: " + doubleValueNarrow);
        System.out.println("Float value: " + floatValueNarrow);
        System.out.println("Long value: " + longValueNarrow);
        System.out.println("Int value: " + intValueNarrow);
        System.out.println(); // Blank line for better readability

        // Example 3: Practice with Widening and Narrowing Conversions
        // Widening Conversion Example
        byte byteValue = 42;
        int intValueWiden = byteValue; // Widening from byte to int
        double doubleValueWiden = intValueWiden; // Widening from int to double

        System.out.println("Practice: Widening Conversion:");
        System.out.println("Byte value: " + byteValue);
        System.out.println("Int value: " + intValueWiden);
        System.out.println("Double value: " + doubleValueWiden);

        // Narrowing Conversion Example
        double doubleNumber = 99.99;
        int intNumber = (int) doubleNumber; // Narrowing from double to int

        System.out.println("\nPractice: Narrowing Conversion:");
        System.out.println("Double number: " + doubleNumber);
        System.out.println("Int number: " + intNumber);

        // Additional Example: Mixing conversions
        char charValue = 'A';
        int charToInt = charValue; // Widening from char to int
        double charToDouble = charToInt; // Widening from int to double
        int doubleToInt = (int) charToDouble; // Narrowing from double to int

        System.out.println("\nMixing Conversions:");
        System.out.println("Char value: " + charValue);
        System.out.println("Char to Int: " + charToInt);
        System.out.println("Char to Double: " + charToDouble);
        System.out.println("Double to Int: " + doubleToInt);
    }
}
