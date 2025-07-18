public class StringMethodsPractice {
    public static void main(String[] args) {
        // 1. length()
        System.out.println("1. length() Example:");
        String str1 = "Hello, World!";
        System.out.println("Length of '" + str1 + "': " + str1.length());

        // 2. charAt()
        System.out.println("\n2. charAt() Example:");
        System.out.println("Character at index 7 in '" + str1 + "': " + str1.charAt(7));

        // 3. substring()
        System.out.println("\n3. substring() Example:");
        System.out.println("Substring from index 7 in '" + str1 + "': " + str1.substring(7));
        System.out.println("Substring from index 7 to 12 in '" + str1 + "': " + str1.substring(7, 12));

        // 4. equals() and equalsIgnoreCase()
        System.out.println("\n4. equals() and equalsIgnoreCase() Examples:");
        String str2 = "hello, world!";
        System.out.println("'" + str1 + "' equals '" + str2 + "'?: " + str1.equals(str2));
        System.out.println("'" + str1 + "' equalsIgnoreCase '" + str2 + "'?: " + str1.equalsIgnoreCase(str2));

        // 5. contains()
        System.out.println("\n5. contains() Example:");
        System.out.println("Does '" + str1 + "' contain 'World'?: " + str1.contains("World"));

        // 6. toUpperCase() and toLowerCase()
        System.out.println("\n6. toUpperCase() and toLowerCase() Examples:");
        System.out.println("Uppercase of '" + str2 + "': " + str2.toUpperCase());
        System.out.println("Lowercase of '" + str1 + "': " + str1.toLowerCase());

        // 7. trim()
        System.out.println("\n7. trim() Example:");
        String str3 = "   Java Programming   ";
        System.out.println("Original string: '" + str3 + "'");
        System.out.println("Trimmed string: '" + str3.trim() + "'");

        // 8. replace() and replaceAll()
        System.out.println("\n8. replace() and replaceAll() Examples:");
        String str4 = "I love Java. Java is fun!";
        System.out.println("Original string: '" + str4 + "'");
        System.out.println("replace 'Java' with 'Python': " + str4.replace("Java", "Python"));
        System.out.println("replaceAll 'a' with 'A': " + str4.replaceAll("a", "A"));

        // 9. split()
        System.out.println("\n9. split() Example:");
        String str5 = "apple,banana,cherry";
        String[] fruits = str5.split(",");
        System.out.println("Fruits split by ',' :");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 10. startsWith() and endsWith()
        System.out.println("\n10. startsWith() and endsWith() Examples:");
        System.out.println("Does '" + str1 + "' start with 'Hello'?: " + str1.startsWith("Hello"));
        System.out.println("Does '" + str1 + "' end with 'World!'?: " + str1.endsWith("World!"));

        // 11. concat()
        System.out.println("\n11. concat() Example:");
        String str6 = "Learning ";
        String str7 = "Java";
        System.out.println("Concatenated string: " + str6.concat(str7));

        // 12. isEmpty() and isBlank()
        System.out.println("\n12. isEmpty() and isBlank() Examples:");
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("Is empty string empty?: " + emptyStr.isEmpty());
        System.out.println("Is blank string blank?: " + blankStr.isBlank());

        // 13. intern()
        System.out.println("\n13. intern() Example:");
        String str8 = new String("Java").intern();
        String str9 = "Java";
        System.out.println("Are '" + str8 + "' and '" + str9 + "' the same object?: " + (str8 == str9));

        // 14. valueOf()
        System.out.println("\n14. valueOf() Example:");
        int num = 42;
        String numStr = String.valueOf(num);
        System.out.println("String representation of number 42: " + numStr);
    }
}
