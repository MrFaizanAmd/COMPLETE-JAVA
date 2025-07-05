# **Java Sealed Classes – A Complete Guide** 🚀  

## **1. Introduction to Sealed Classes**  

### **What Are Sealed Classes?**  

Sealed classes, introduced in **Java 15 (preview) and finalized in Java 17**, allow developers to **control inheritance** by **restricting which classes can extend or implement them**.  

Unlike regular inheritance, where any class can extend a superclass, **sealed classes define a fixed set of allowed subclasses**. This provides **better security, maintainability, and control** over your class hierarchy.  

### **Why Are Sealed Classes Important?**  

✅ **Restricts Unintended Inheritance** – Prevents unwanted subclasses.  
✅ **Enhances Maintainability** – Developers know exactly which classes are allowed.  
✅ **Optimizes Performance** – JVM can optimize pattern matching more effectively.  
✅ **Ensures Type Safety** – Avoids unpredictable behaviors in large applications.  
✅ **Supports Pattern Matching (Switch Expressions)** – Works well with Java’s newer pattern matching features.  

---

## **2. Defining a Sealed Class**  

### **Basic Syntax of a Sealed Class**  
```java
public sealed class Shape permits Circle, Rectangle, Triangle {}
```
🔹 **`sealed` keyword** restricts inheritance.  
🔹 **`permits` clause** lists the allowed subclasses.  

### **Permitted Subclasses Must Declare One of the Following:**  
- `final` – Cannot be further extended.  
- `sealed` – Can have limited subclasses.  
- `non-sealed` – Allows unrestricted extension.  

---

## **3. Working with Sealed Classes**  

### **Example: Sealed Class with Permitted Subclasses**  
```java
// Sealed Parent Class
public sealed class Shape permits Circle, Rectangle {}

// Final Subclass (Cannot be extended further)
public final class Circle extends Shape {}

// Sealed Subclass (Can have limited subclasses)
public sealed class Rectangle extends Shape permits Square {}

// Non-Sealed Subclass (Can be extended freely)
public non-sealed class Square extends Rectangle {}
```

### **Key Takeaways:**  
✅ `Circle` is `final` → No further subclassing.  
✅ `Rectangle` is `sealed` → Can be extended, but only by `Square`.  
✅ `Square` is `non-sealed` → Can be extended without restrictions.  

---

## **4. How Does Sealed Work Under the Hood?**  

🔹 When a class is marked as `sealed`, the **Java compiler ensures that only the listed subclasses can extend it**.  
🔹 The permitted subclasses **must be in the same package or module**.  
🔹 If a subclass is `sealed`, it must also declare its own permitted subclasses.  

### **JVM Optimization with Sealed Classes**  
- The JVM **knows all possible subclasses** at compile-time.  
- This allows **better performance optimizations** in pattern matching and switch expressions.  

---

## **5. Using Sealed Classes with Pattern Matching**  

Sealed classes **work well with pattern matching in switch expressions**, making the code **cleaner and safer**.  

```java
public sealed class Shape permits Circle, Rectangle {}

public final class Circle extends Shape {}
public final class Rectangle extends Shape {}

public class Main {
    static void printShape(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println("It's a Circle!");
            case Rectangle r -> System.out.println("It's a Rectangle!");
        }
    }

    public static void main(String[] args) {
        printShape(new Circle());  // Output: It's a Circle!
        printShape(new Rectangle()); // Output: It's a Rectangle!
    }
}
```
✅ **No need for `default` case** → Compiler ensures all subclasses are covered.  
✅ **Better type safety** → Reduces risk of unhandled cases.  

---

## **6. Sealed Classes vs Abstract Classes vs Interfaces**  

| Feature            | Sealed Class ✅ | Abstract Class ✅ | Interface ✅ |
|--------------------|---------------|-----------------|-------------|
| **Can Have Methods?** | ✅ Yes | ✅ Yes | ✅ Default Methods |
| **Restricts Inheritance?** | ✅ Yes | ❌ No | ❌ No |
| **Allows Pattern Matching?** | ✅ Yes | ❌ No | ❌ No |
| **Supports Multiple Inheritance?** | ❌ No | ❌ No | ✅ Yes |
| **Encourages Controlled Hierarchy?** | ✅ Yes | ❌ No | ❌ No |

### **When to Use What?**  
✅ **Use `sealed` classes** when you want a fixed set of allowed subclasses.  
✅ **Use `abstract` classes** when you need common behavior but unrestricted inheritance.  
✅ **Use `interfaces`** when you need multiple inheritance and loose coupling.  

---

## **7. Common Use Cases of Sealed Classes**  

✅ **Defining a Restricted Hierarchy** (e.g., Shapes, Payment Methods, UI Components).  
✅ **Pattern Matching in Switch Statements**.  
✅ **Enforcing a Fixed Set of States** (e.g., Workflow states in an application).  
✅ **Limiting Subclassing in Large Projects** to prevent unintended modifications.  

### **Example: Sealed Class for Payment Methods**
```java
public sealed class PaymentMethod permits CreditCard, PayPal, BankTransfer {}

public final class CreditCard extends PaymentMethod {}
public final class PayPal extends PaymentMethod {}
public final class BankTransfer extends PaymentMethod {}
```
✅ No other subclass can be created outside the defined hierarchy.  

---

## **8. FAQs (Frequently Asked Questions)**  

### **Q1: Can a Sealed Class Be Abstract?**  
✅ **Yes!** A sealed class can be **abstract** if it contains abstract methods.  
```java
public abstract sealed class Vehicle permits Car, Bike {}
```

### **Q2: Can a Sealed Class Have Non-Sealed Subclasses?**  
✅ **Yes!** A subclass can be **`non-sealed`**, allowing unrestricted inheritance.  
```java
public non-sealed class SUV extends Car {}
```

### **Q3: Can We Use Sealed Classes in Spring Boot or Hibernate?**  
✅ **Yes!** Sealed classes work well with **DTOs and domain models** but **cannot be directly used as JPA entities** (since JPA requires a no-arg constructor).  

### **Q4: Can Sealed Classes Have Static Methods?**  
✅ **Yes!** They can contain **static methods** like any other class.  

---

## **9. Hands-On Practice**  
📂 **[Click here](./sealed-classes-practice)** for coding exercises.  

📖 [Official Java Docs on Sealed Classes](https://docs.oracle.com/en/java/javase/17/language/sealed-classes-and-interfaces.html)  

---

## **10. Summary**  

🔹 **Sealed classes** restrict inheritance to a fixed set of allowed subclasses.  
🔹 They enhance **security, maintainability, and performance** in Java applications.  
🔹 **Subclasses must be `final`, `sealed`, or `non-sealed`**.  
🔹 Work seamlessly with **pattern matching and switch expressions**.  
🔹 Ideal for **defining restricted hierarchies** like shapes, payment methods, and UI components.  

🔥 **Use Sealed Classes when you need controlled, predictable inheritance in Java!** 🚀