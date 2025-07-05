# Java Learning Repository - Abstraction in Java

## Introduction

Welcome to the Java Learning Repository! In this section, we will dive into **Abstraction in Java**, one of the four fundamental principles of Object-Oriented Programming (OOP). Abstraction allows us to focus on what an object does rather than how it does it. By the end of this guide, you will understand abstraction, abstract classes, the `abstract` keyword, inner classes, anonymous classes, and the combination of abstract and anonymous inner classes.

## What is Abstraction?

**Abstraction** is the process of hiding implementation details and exposing only essential features of an object. This helps in reducing complexity and increasing reusability.

### Why is Abstraction Important?

- **Hides implementation details** and shows only relevant data.
- **Improves code maintainability** by separating what an object does from how it does it.
- **Supports scalability** by allowing flexible design changes.
- **Enhances security** by preventing unintended modifications to implementation details.

## How and When to Use Abstraction

Abstraction is used when:
- We need to define a common interface for a set of related classes but let the implementation vary.
- We want to enforce a certain method structure in subclasses while avoiding code repetition.
- We want to hide complex implementation details from the user.

### Example: Abstraction in a Payment System

Let's say we have different types of payment methods, such as **Credit Card** and **PayPal**. We can use an abstract class to define a common blueprint while letting each subclass implement the specifics.

```java
abstract class Payment {
    abstract void makePayment(double amount);
    
    void printReceipt() {
        System.out.println("Payment successful. Receipt generated.");
    }
}

class CreditCardPayment extends Payment {
    void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment extends Payment {
    void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment();
        payment1.makePayment(100);
        payment1.printReceipt();
        
        Payment payment2 = new PayPalPayment();
        payment2.makePayment(50);
        payment2.printReceipt();
    }
}
```

**Output:**
```
Paid $100 using Credit Card.
Payment successful. Receipt generated.
Paid $50 using PayPal.
Payment successful. Receipt generated.
```

This example shows how abstraction allows us to define a general **Payment** class while letting subclasses implement their own payment logic.

## Abstract Class and `abstract` Keyword

### What is an Abstract Class?
An **abstract class** in Java is a class that cannot be instantiated on its own and is meant to be extended by other classes. It provides a blueprint for subclasses.

### Using the `abstract` Keyword
- The `abstract` keyword is used to declare an abstract class or an abstract method.
- Abstract methods do not have a body and must be implemented by subclasses.

### Example of an Abstract Class

```java
abstract class Animal {
    abstract void makeSound(); // Abstract method (no body)
    
    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Output: Bark!
        myDog.sleep(); // Output: Sleeping...
    }
}
```

## Inner Classes

An **inner class** is a class declared inside another class. It helps in logically grouping classes that are used together.

### Example of an Inner Class
```java
class OuterClass {
    class InnerClass {
        void display() {
            System.out.println("This is an inner class method");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.InnerClass obj = new OuterClass().new InnerClass();
        obj.display();
    }
}
```

## Anonymous Classes

An **anonymous class** is a class that has no name and is instantiated at the same time it is declared.

### Example of an Anonymous Class

```java
abstract class Vehicle {
    abstract void start();
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle() {
            void start() {
                System.out.println("Car is starting...");
            }
        };
        car.start();
    }
}
```

## Abstract and Anonymous Inner Classes Combined

We can also create an **anonymous inner class** that extends an **abstract class**. This allows us to provide implementation on the fly without creating a separate subclass.

### Example of an Anonymous Inner Class Extending an Abstract Class

```java
abstract class Person {
    abstract void speak();
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person() {
            void speak() {
                System.out.println("Hello, I am speaking!");
            }
        };
        p.speak();
    }
}
```

## FAQs (Frequently Asked Questions)

### 1. **Can an abstract class have constructors?**
Yes! An abstract class can have constructors, and they are called when a subclass object is created.

### 2. **Can an abstract class have both abstract and concrete methods?**
Yes! Abstract classes can have both abstract methods (without implementation) and concrete methods (with implementation).

### 3. **Why can’t we instantiate an abstract class?**
Because an abstract class is incomplete on its own and requires a subclass to provide implementations for abstract methods.

### 4. What is the difference between an abstract class and an interface?  
Note: we will learn interface later
| Feature          | Abstract Class | Interface |
|-----------------|---------------|-----------|
| Methods        | Can have both abstract and concrete methods | Only abstract methods (before Java 8) |
| Variables      | Can have instance variables | Only public static final variables |
| Constructor    | Can have constructors | Cannot have constructors |

### 5. **Can an abstract class extend another abstract class?**
Yes! An abstract class can extend another abstract class and inherit its abstract methods.

## Further Learning Resources
- [Oracle Documentation on Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Java Inner Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)


Happy Coding! 🚀

