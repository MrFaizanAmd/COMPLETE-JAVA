# Java Learning Repository: Mastering Exception & Error Handling

Welcome to the **Java Learning Repository!** In this guide, we will explore **Exception & Error Handling** in Java in detail. Exception handling is a crucial concept that helps in building reliable and bug-free applications. This guide covers everything from basic to advanced concepts, ensuring that you gain a strong foundation in exception handling.

---

## **1. Introduction to Exception & Error Handling**

### **What is Exception Handling?**
Exception handling in Java is a mechanism that allows developers to manage and handle runtime errors in a structured way. Instead of abruptly terminating the program, Java provides tools such as `try-catch`, `throws`, and custom exceptions to handle these errors gracefully.

### **Why is Exception Handling Important?**
- Prevents **abrupt program termination**.
- Helps in **debugging and tracing issues**.
- Enhances **code maintainability and readability**.
- Ensures **smooth user experience** by handling failures gracefully.

---

## **2. Types of Errors in Java**

Errors in Java can be broadly categorized into:

### **A. Compile-time Errors**
These errors occur during compilation and prevent the program from executing. Examples include:
- **Syntax Errors**: Missing semicolons, incorrect keywords, invalid method calls.
- **Type Mismatch Errors**: Assigning an incompatible data type.

### **B. Runtime Errors**
These errors occur during execution and may cause the program to crash. They include:
- **Exceptions**: Recoverable issues like `NullPointerException`, `IOException`.
- **Errors**: Irrecoverable problems like `OutOfMemoryError`, `StackOverflowError`.

---

## **3. Understanding Exceptions in Java**

### **What is an Exception?**
An **exception** is an event that disrupts the normal flow of a program during execution. Java has a built-in exception hierarchy.

### **Hierarchy of Exceptions in Java**
```
Throwable
│
├── Exception (Checked Exceptions)
│   ├── IOException
│   ├── SQLException
│   ├── FileNotFoundException
│
├── RuntimeException (Unchecked Exceptions)
│   ├── NullPointerException
│   ├── ArithmeticException
│   ├── ArrayIndexOutOfBoundsException
│
└── Error (Serious Issues)
    ├── OutOfMemoryError
    ├── StackOverflowError
```

### **Checked vs. Unchecked Exceptions**
- **Checked Exceptions**: Enforced at compile-time. Must be handled using `try-catch` or `throws`. Example: `IOException`.
- **Unchecked Exceptions**: Occur at runtime due to programming mistakes. Example: `NullPointerException`.

---

## **4. Handling Exceptions in Java**

### **A. Using try-catch Blocks**
The `try-catch` block is the most common way to handle exceptions.

#### **Example: Handling Divide by Zero Exception**
```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
```

### **B. Using throw Keyword**
The `throw` keyword is used to explicitly throw an exception.

#### **Example: Using throw**
```java
public class ThrowExample {
    static void checkNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }
    }
    public static void main(String[] args) {
        checkNumber(-5);
    }
}
```

### **C. Using throws Keyword**
The `throws` keyword is used in method signatures to indicate that a method may throw an exception.

#### **Example: Declaring an Exception with throws**
```java
import java.io.*;

public class ThrowsExample {
    static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt");
    }
    
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
```

### **D. Difference Between throw and throws**
| Feature  | throw | throws |
|----------|-------|--------|
| Purpose  | Used to explicitly throw an exception | Used in method declaration to indicate exceptions that may be thrown |
| Usage    | Inside the method | With method signature |
| Followed by | An instance of an exception | An exception class |
| Example  | `throw new IOException();` | `void method() throws IOException {}` |

### **E. Using finally Block**
The `finally` block is executed **regardless of whether an exception occurs**.

#### **Example: Using finally for Cleanup**
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            int num = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("This will always execute!");
        }
    }
}
```

---

## **5. Advanced Exception Handling**

### **A. Creating Custom Exceptions**
Custom exceptions help enforce application-specific rules.

#### **Example: Custom Exception**
```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or older!");
        }
    }
    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### **B. Exception Propagation**
Exceptions can propagate up the call stack if not handled.

#### **Example: Exception Propagation**
```java
public class ExceptionPropagation {
    static void method1() throws ArithmeticException {
        throw new ArithmeticException("Exception in method1");
    }
    static void method2() {
        method1();
    }
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

### **C. Try-with-Resources (Java 7+)**
Introduced to automatically close resources.

#### **Example: Try-with-Resources**
```java
import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
```

---

## **6. Conclusion**
Mastering exception handling is crucial for developing robust applications. By effectively using `try-catch`, `throw`, `throws`, `finally`, and custom exceptions, you can manage errors efficiently.

---

## **7. Hands-on Practice**
🔗 [Access the Exception Handling Practice Folder](./Example/README.md)

Happy Coding! 🚀

