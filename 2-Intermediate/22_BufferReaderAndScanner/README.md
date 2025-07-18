# Java Learning Repository: BufferedReader, Scanner & Try-With-Resources

Welcome to the **Java Learning Repository!** In this guide, we will explore **BufferedReader**, **Scanner**, and **Try-With-Resources** in Java. These tools are essential for handling user input and file reading efficiently. By the end of this guide, you'll understand when and how to use each of them effectively.

---

## **1. Introduction to BufferedReader and Scanner**

### **Why Do We Need BufferedReader and Scanner?**
Java provides multiple ways to read input, including `BufferedReader` and `Scanner`. These classes help read data efficiently from different sources such as user input, files, and streams.

### **Key Differences Between BufferedReader and Scanner**
| Feature         | BufferedReader  | Scanner          |
|---------------|----------------|------------------|
| Performance   | Faster (uses buffering) | Slightly slower (parses input) |
| Input Source  | Reads from streams (e.g., files, console) | Reads from input sources like System.in |
| Data Handling | Reads full lines or characters | Parses input (tokens, numbers, strings) |
| Exception Handling | Requires handling `IOException` | Handles exceptions internally |

---

## **2. Understanding BufferedReader**
### **What is BufferedReader?**
`BufferedReader` is a Java class used for reading text from an input stream, buffering characters to improve efficiency.

### **How to Use BufferedReader?**
#### **Example: Reading Input from Console**
```java
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = br.readLine();
            System.out.println("Hello, " + name);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
```

### **Why Use BufferedReader?**
- Efficient for reading large text data.
- Suitable for file handling.
- Faster than `Scanner` for reading large input.

#### **Example: Reading a File Using BufferedReader**
```java
import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

---

## **3. Understanding Scanner**
### **What is Scanner?**
`Scanner` is a Java utility class used to parse primitive types and strings using regular expressions.

### **How to Use Scanner?**
#### **Example: Reading Input from Console**
```java
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Your age is: " + age);
        scanner.close();
    }
}
```

### **Why Use Scanner?**
- Easy to use with methods like `nextInt()`, `nextLine()`, `nextDouble()`.
- Provides built-in parsing and tokenization.
- Suitable for small-scale user input.

#### **Example: Reading a File Using Scanner**
```java
import java.io.*;
import java.util.Scanner;

public class FileScannerExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

---

## **4. Understanding Try-With-Resources**
### **What is Try-With-Resources?**
`try-with-resources` is a feature introduced in Java 7 that automatically closes resources when they are no longer needed.

### **Why Use Try-With-Resources?**
- Prevents resource leaks (e.g., unclosed file streams).
- Simplifies exception handling.
- Reduces boilerplate code.

#### **Example: Using Try-With-Resources with BufferedReader**
```java
import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

#### **Example: Using Try-With-Resources with Scanner**
```java
import java.util.Scanner;
import java.io.*;

public class TryWithResourcesScanner {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

---

## **5. Conclusion**
- Use **BufferedReader** for efficient reading of large text data.
- Use **Scanner** for easy token parsing and simple user input.
- Use **Try-With-Resources** to handle resources efficiently and prevent leaks.

---


Happy Coding! 🚀

