public class LiteralExamples {
    public static void main(String[] args) {
        // Integer Literals
        int decimal = 25; // Decimal (Base 10)
        int binary = 0b1101; // Binary (Base 2)
        int octal = 0123; // Octal (Base 8)
        int hexadecimal = 0x1A; // Hexadecimal (Base 16)

        System.out.println("Integer Literals:");
        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);

        // Floating-Point Literals
        double pi = 3.14159; // Double by default
        float gravity = 9.8f; // Float (requires 'f' or 'F' suffix)
        double scientificNotation = 6.022E23; // Scientific notation

        System.out.println("\nFloating-Point Literals:");
        System.out.println("Pi: " + pi);
        System.out.println("Gravity: " + gravity);
        System.out.println("Scientific Notation: " + scientificNotation);

        // Character Literals
        char letter = 'A';
        char numberAsChar = '7';
        char specialChar = '@';

        System.out.println("\nCharacter Literals:");
        System.out.println("Letter: " + letter);
        System.out.println("Number as Char: " + numberAsChar);
        System.out.println("Special Character: " + specialChar);

        // String Literals
        String greeting = "Hello, World!";
        String emptyString = "";
        String numberAsString = "1234";

        System.out.println("\nString Literals:");
        System.out.println("Greeting: " + greeting);
        System.out.println("Empty String: " + emptyString);
        System.out.println("Number as String: " + numberAsString);

        // Boolean Literals
        boolean isJavaFun = true;
        boolean isFishTasty = false;

        System.out.println("\nBoolean Literals:");
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Is fish tasty? " + isFishTasty);

        // Null Literal
        String nullString = null;

        System.out.println("\nNull Literal:");
        System.out.println("Null String: " + nullString);

        // Tricky Questions
        System.out.println("\nTricky Questions:");

        // 1. Combining binary and octal literals
        int tricky1 = 0b10 + 012; // Binary 2 + Octal 10 (Decimal equivalent)
        System.out.println("0b10 + 012 = " + tricky1);

        // 2. Using underscores in literals
        int readableNumber = 10_000;
        System.out.println("10_000 = " + readableNumber);

        // 3. Comparing string literals and numbers
        String numberLiteral = "123";
        System.out.println("String '123' equals  123? " + numberLiteral.equals("123"));

        // 4. Mixing integer and floating-point literals
        double mixedLiteral = 10 + 5.5; // Integer 10 is promoted to double
        System.out.println("10 + 5.5 = " + mixedLiteral);

        // 5. Null comparison
        String testNull = null;
        System.out.println("Is null equal to \"\"? " + (testNull == ""));
    }
}
