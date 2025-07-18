# Understanding and Using String Methods in Java

The `String` class in Java provides numerous built-in methods that help manipulate, analyze, and process strings effectively. This README covers all major `String` methods, complete with explanations and practical examples.

---

## **String Built-in Methods**

### 1. `length()`
Returns the number of characters in the string.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Java Programming";
        System.out.println("Length: " + str.length()); // Output: 16
    }
}
```

---

### 2. `charAt(int index)`
Returns the character at the specified index.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Character at index 1: " + str.charAt(1)); // Output: e
    }
}
```

---

### 3. `substring(int beginIndex, int endIndex)`
Extracts a portion of the string starting at `beginIndex` and ending before `endIndex`.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Learn Java";
        System.out.println("Substring: " + str.substring(0, 5)); // Output: Learn
    }
}
```

---

### 4. `toUpperCase()` and `toLowerCase()`
Converts all characters in the string to uppercase or lowercase.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Java";
        System.out.println("Uppercase: " + str.toUpperCase()); // Output: JAVA
        System.out.println("Lowercase: " + str.toLowerCase()); // Output: java
    }
}
```

---

### 5. `contains(CharSequence sequence)`
Checks if the string contains the specified sequence of characters.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "I love programming.";
        System.out.println("Contains 'love': " + str.contains("love")); // Output: true
    }
}
```

---

### 6. `equals(String anotherString)` and `equalsIgnoreCase(String anotherString)`
Compares two strings for equality. The `equalsIgnoreCase` method ignores case differences.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println("Equals: " + str1.equals(str2)); // Output: false
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase(str2)); // Output: true
    }
}
```

---

### 7. `replace(CharSequence target, CharSequence replacement)`
Replaces all occurrences of the target with the replacement.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Java is fun!";
        System.out.println("Replaced: " + str.replace("fun", "awesome")); // Output: Java is awesome!
    }
}
```

---

### 8. `split(String regex)`
Splits the string into an array based on the specified delimiter.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String csv = "Apple,Orange,Banana";
        String[] fruits = csv.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit); // Output: Apple Orange Banana
        }
    }
}
```

---

### 9. `trim()`
Removes leading and trailing spaces from the string.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "   Java   ";
        System.out.println("Trimmed: '" + str.trim() + "'"); // Output: 'Java'
    }
}
```

---

### 10. `startsWith(String prefix)` and `endsWith(String suffix)`
Checks if the string starts or ends with the specified prefix or suffix.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String url = "www.example.com";
        System.out.println("Starts with 'www': " + url.startsWith("www")); // Output: true
        System.out.println("Ends with '.com': " + url.endsWith(".com")); // Output: true
    }
}
```

---

### 11. `concat(String str)`
Appends the specified string to the end of the current string.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";
        System.out.println("Full Name: " + firstName.concat(" ").concat(lastName)); // Output: John Doe
    }
}
```

---

### 12. `indexOf(String str)` and `lastIndexOf(String str)`
Finds the index of the first or last occurrence of the specified string.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str = "Programming in Java";
        System.out.println("First 'a': " + str.indexOf('a')); // Output: 12
        System.out.println("Last 'a': " + str.lastIndexOf('a')); // Output: 20
    }
}
```

---

### 13. `isEmpty()` and `isBlank()` (Java 11+)
- `isEmpty()` checks if the string length is 0.
- `isBlank()` checks if the string is empty or contains only whitespace.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("Is Empty: " + emptyStr.isEmpty()); // Output: true
        System.out.println("Is Blank: " + blankStr.isBlank()); // Output: true
    }
}
```

---

### 14. `valueOf()`
Converts various data types into a string.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        int number = 42;
        double price = 99.99;
        System.out.println("String value: " + String.valueOf(number)); // Output: 42
        System.out.println("String value: " + String.valueOf(price)); // Output: 99.99
    }
}
```

---

### 15. `compareTo(String anotherString)` and `compareToIgnoreCase(String anotherString)`
Compares two strings lexicographically. Returns:
- A negative value if the first string comes before the second.
- Zero if both strings are equal.
- A positive value if the first string comes after the second.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "Banana";
        System.out.println("Compare: " + str1.compareTo(str2)); // Output: -1
        System.out.println("Compare Ignore Case: " + str1.compareToIgnoreCase("apple")); // Output: 0
    }
}
```

---

### 16. `join(CharSequence delimiter, CharSequence... elements)`
Joins multiple strings using the specified delimiter.

**Example:**
```java
public class StringMethods {
    public static void main(String[] args) {
        String joinedStr = String.join(", ", "Java", "Python", "C++");
        System.out.println("Joined String: " + joinedStr); // Output: Java, Python, C++
    }
}
```

---

## Practice Files
For hands-on practice, explore the [practice folder](./practice/string-methods) in this repository.

