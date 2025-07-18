
## **1. ArithmeticException**
### **What is it?**
This exception occurs when an illegal arithmetic operation is performed, such as **division by zero**.

### **Example**
```java
public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
    }
}
```
### **Output**
```
Error: Cannot divide by zero!
```

---

## **2. NullPointerException**
### **What is it?**
Occurs when you try to **access a method or field of an object that is null**.

### **Example**
```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length()); // Attempting to access length of null
        } catch (NullPointerException e) {
            System.out.println("Error: Attempted to access a null object!");
        }
    }
}
```
### **Output**
```
Error: Attempted to access a null object!
```

---

## **3. ArrayIndexOutOfBoundsException**
### **What is it?**
Occurs when you try to **access an array element beyond its valid index range**.

### **Example**
```java
public class ArrayIndexOutOfBoundsExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // Invalid index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");
        }
    }
}
```
### **Output**
```
Error: Array index is out of bounds!
```

---

## **4. NumberFormatException**
### **What is it?**
Occurs when a string cannot be converted to a valid number format.

### **Example**
```java
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        String invalidNumber = "abc123";
        try {
            int num = Integer.parseInt(invalidNumber); // Invalid conversion
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        }
    }
}
```
### **Output**
```
Error: Invalid number format!
```

---

## **5. FileNotFoundException**
### **What is it?**
Occurs when attempting to access a file that **does not exist**.

### **Example**
```java
import java.io.*;

public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }
}
```
### **Output**
```
Error: File not found!
```

---

## **6. IOException**
### **What is it?**
Occurs when there is an **input/output failure**, like reading from a closed file.

### **Example**
```java
import java.io.*;

public class IOExceptionExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            reader.close();
            reader.readLine(); // Trying to read after closing
        } catch (IOException e) {
            System.out.println("Error: IO operation failed!");
        }
    }
}
```
### **Output**
```
Error: IO operation failed!
```

---

## **7. IllegalArgumentException**
### **What is it?**
Thrown when a method receives an **argument that is inappropriate or illegal**.

### **Example**
```java
public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        try {
            setAge(-5); // Invalid age
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid age provided!");
        }
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
    }
}
```
### **Output**
```
Error: Invalid age provided!
```

---

## **8. ClassNotFoundException**
### **What is it?**
Occurs when **Java is unable to find a class at runtime**.

### **Example**
```java
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.unknown.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found!");
        }
    }
}
```
### **Output**
```
Error: Class not found!
```

---

## **9. InterruptedException**
### **What is it?**
Occurs when a **thread is interrupted while sleeping or waiting**.

### **Example**
```java
public class InterruptedExceptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });

        thread.start();
        thread.interrupt();
    }
}
```
### **Output**
```
Thread was interrupted!
```

---

## **10. StackOverflowError**
### **What is it?**
Occurs when **infinite recursion leads to stack memory exhaustion**.

### **Example**
```java
public class StackOverflowErrorExample {
    public static void recursiveMethod() {
        recursiveMethod(); // Infinite recursion
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}
```
### **Output**
```
Exception in thread "main" java.lang.StackOverflowError
```

---

These are some of the most common exceptions in Java.