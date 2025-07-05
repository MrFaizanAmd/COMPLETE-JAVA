# **Understanding the `var` Keyword in Java** 🚀  

## **Introduction**  

Java 10 introduced the `var` keyword as a way to enable **local variable type inference**. This means that instead of explicitly specifying a variable's type, the compiler **infers** the type based on the assigned value.  

✅ **Reduces boilerplate** code  
✅ **Improves readability**  
✅ **Does NOT make Java dynamically typed** (Java is still statically typed)  

---

## **1. How Does `var` Work?**  

When you declare a variable using `var`, the compiler **infers** the type based on the assigned value.  

```java
public class VarExample {
    public static void main(String[] args) {
        var message = "Hello, Java!"; // Compiler infers String
        var number = 42;              // Compiler infers int
        var pi = 3.14;                // Compiler infers double

        System.out.println(message); // Output: Hello, Java!
        System.out.println(number);  // Output: 42
        System.out.println(pi);      // Output: 3.14
    }
}
```

### **Key Points**  
✅ The type of `var` is determined **at compile-time**, not at runtime.  
✅ Once assigned, the inferred type **cannot change**.  

```java
var name = "John"; 
// name = 42; // ❌ Compilation error (String cannot be reassigned to an int)
```

---

## **2. Where Can `var` Be Used?**  

### **✅ Allowed Usage**  

`var` can be used for **local variables**, including:  
✔ Inside methods  
✔ Inside loops  
✔ With local scope  

#### **Example: Inside Methods**  

```java
public class VarInsideMethod {
    public static void main(String[] args) {
        var text = "Java"; // Compiler infers String
        System.out.println(text.toUpperCase()); // Output: JAVA
    }
}
```

#### **Example: Inside Loops**  

```java
import java.util.List;

public class VarInLoops {
    public static void main(String[] args) {
        var names = List.of("Alice", "Bob", "Charlie");

        for (var name : names) {
            System.out.println(name);
        }
    }
}
```

---

## **3. Where `var` CANNOT Be Used** 🚫  

🚨 **1. Instance Variables** (Fields in a Class)  

```java
class Test {
    var name = "John"; // ❌ Compilation error (Cannot use var for class fields)
}
```

🚨 **2. Method Parameters**  

```java
public void print(var message) { // ❌ Compilation error (Cannot use var for parameters)
    System.out.println(message);
}
```

🚨 **3. Return Type in Method Declarations**  

```java
public var getNumber() { // ❌ Compilation error (Cannot use var for return types)
    return 10;
}
```

🚨 **4. Without Initialization**  

```java
var x; // ❌ Compilation error (Compiler cannot infer type without an initial value)
```

🚨 **5. Lambda Parameters (Before Java 11)**  

```java
(var a, var b) -> a + b; // ❌ Compilation error in Java 10
```

(Note: Java 11+ allows `var` in lambda parameters.)

---

## **4. Understanding Type Inference**  

The type of `var` **depends on the assigned value**:  

```java
var str = "Hello";     // Compiler infers String
var num = 100;         // Compiler infers int
var list = List.of(1, 2, 3); // Compiler infers List<Integer>
```

🔹 **Type is Fixed:** After inference, the type **cannot be changed**.  

```java
var num = 10;
// num = "Hello"; // ❌ Compilation error (num is inferred as int)
```

🔹 **Type Cannot Be Ambiguous:**  

```java
var ambiguous = null; // ❌ Compilation error (Cannot infer type from null)
```

---

## **5. `var` with Collections and Generics**  

The `var` keyword makes working with **generics** easier by reducing redundant syntax.  

### **Without `var`**  

```java
Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
```

### **With `var`**  

```java
var map = new HashMap<String, List<Integer>>(); // Compiler infers type
```

---

## **6. `var` in Streams and Functional Programming**  

`var` simplifies functional programming in Java, especially when dealing with Streams.  

```java
import java.util.List;

public class VarWithStreams {
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5);

        var doubledNumbers = numbers.stream()
                                    .map(n -> n * 2)
                                    .toList();

        System.out.println(doubledNumbers); // Output: [2, 4, 6, 8, 10]
    }
}
```

---

## **7. Comparison: `var` vs Explicit Types**  

| **Feature**       | **Explicit Type (`int x = 10;`)** | **Using `var` (`var x = 10;`)** |
|------------------|---------------------------------|-------------------------------|
| Readability      | Clearer for beginners          | More concise |
| Type Safety      | Explicit type ensures safety   | Compiler infers type (still type-safe) |
| Code Length      | Longer                         | Shorter |
| Works with Generics | ✅ Yes | ✅ Yes (but cannot specify generic types explicitly) |

**When to Use `var`?**  
✔ When the type is **clear from context**  
✔ When working with **complex generics**  
✔ When reducing boilerplate  

**When to Avoid `var`?**  
❌ When the inferred type is not immediately obvious  
❌ When working with primitive types (explicit typing improves readability)  

---

## **8. FAQs About `var`**  

### **Q1: Is Java now dynamically typed because of `var`?**  
No. Java **remains statically typed**. The compiler determines the type at compile-time, and type safety is preserved.  

### **Q2: Can `var` be `null`?**  
No, because the compiler **cannot infer the type of null**.  

```java
var x = null; // ❌ Compilation error
```

### **Q3: Can I mix `var` and explicit types?**  
Yes, but it's best to **stay consistent**. Avoid mixing `var` and explicit types in the same block unless necessary.  

### **Q4: Does `var` impact performance?**  
No. `var` **does not introduce runtime overhead**—it's only syntactic sugar for type inference at compile-time.  

---

## **9. Conclusion**  

🔹 `var` is a powerful **type inference feature** introduced in Java 10.  
🔹 It **reduces boilerplate** while keeping Java **statically typed**.  
🔹 Use `var` **where it improves readability**, but avoid overuse.  
🔹 Java **is not dynamically typed**—types are still checked at compile-time.  

By mastering `var`, you can **write cleaner, more concise Java code** while maintaining type safety! 🚀  

---

## **Hands-On Practice**  

📂 **[Click here](./var-practice)** to access coding exercises for `var` in Java.  

---

### **Further Reading**  

📖 [Official Java 10 `var` Documentation](https://docs.oracle.com/javase/10/docs/specs/man/var.html)  
📚 [Baeldung - Guide to Java `var`](https://www.baeldung.com/java-10-var-type)  