# **Java Record Classes – A Complete Guide** 🚀  

## **1. Introduction to Record Classes**  

### **What Are Record Classes?**  

Record classes, introduced in **Java 14 (as a preview) and officially in Java 16**, are a special type of **immutable data carrier class**. They provide a **concise way to define classes** whose primary purpose is to store data.  

Before records, Java developers had to **write a lot of boilerplate code** (constructors, getters, `toString()`, `equals()`, and `hashCode()`) just to create simple **data-holding objects**. Record classes **automate** this by generating these methods for you!  

### **Why Are Records Important?**  

✅ **Reduces Boilerplate Code** – No need to manually write constructors, getters, `equals()`, `hashCode()`, and `toString()`.  
✅ **Immutable by Default** – Fields in records are `final`, ensuring data consistency.  
✅ **Better Readability** – Clearer code for defining **data-centric** classes.  
✅ **Built-in `equals()` and `hashCode()`** – Ideal for use in collections (`Set`, `Map`, etc.).  
✅ **Thread-Safe by Default** – Since fields are immutable, record objects are inherently thread-safe.  

---

## **2. Defining a Record Class**  

A **record** is defined using the `record` keyword.  

### **Syntax of a Record**  
```java
public record Person(String name, int age) {}
```
🔹 **This single line replaces 50+ lines of code!**  
🔹 `name` and `age` are **final instance variables** (cannot be modified).  
🔹 Java **automatically generates**:
- A **constructor**: `new Person("John", 25)`
- **Getters**: `person.name()` and `person.age()`
- **toString()**: `"Person[name=John, age=25]"`
- **equals()** and **hashCode()**  

---

## **3. How Does a Record Work Internally?**  

If you write:  
```java
public record Person(String name, int age) {}
```
Java **automatically expands it** to something like:  
```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() { return name; }
    public int age() { return age; }

    @Override
    public boolean equals(Object o) { ... }
    @Override
    public int hashCode() { ... }
    @Override
    public String toString() { return "Person[name=" + name + ", age=" + age + "]"; }
}
```
### **Less Code, Same Functionality!**  

---

## **4. Working with Record Classes**  

### **Creating and Using Records**  
```java
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        System.out.println(person.name()); // Alice
        System.out.println(person.age());  // 30

        System.out.println(person); // Person[name=Alice, age=30]
    }
}
```

### **Immutability of Records**  
```java
person.name = "Bob";  // ❌ Compilation Error! Fields are final.
```
Since fields are `final`, **records cannot be modified after creation**.

---

## **5. Customizing Record Classes**  

### **Adding Custom Methods**  
You can **add extra methods** to a record.  
```java
public record Circle(double radius) {
    public double area() {
        return Math.PI * radius * radius;
    }
}
```
Usage:  
```java
Circle c = new Circle(5);
System.out.println(c.area()); // 78.54
```

### **Adding Custom Constructors**  
You can **validate values** inside a constructor.  
```java
public record Temperature(double value) {
    public Temperature {
        if (value < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero!");
        }
    }
}
```
Usage:  
```java
Temperature t1 = new Temperature(-300); // ❌ Exception: Temperature cannot be below absolute zero!
```

### **Modifying `toString()`, `equals()`, `hashCode()`**  
Although Java **generates these methods automatically**, you can **override them** if needed.
```java
@Override
public String toString() {
    return "User: " + name + ", Age: " + age;
}
```

---

## **6. Records vs Regular Classes vs Lombok**  

| Feature          | Record Class ✅ | Regular Class ❌ | Lombok (@Data) 🏷️ |
|-----------------|-----------------|-----------------|-----------------|
| **Boilerplate Code?** | ❌ No | ✅ Yes | ❌ No |
| **Immutable?** | ✅ Yes | ❌ No (unless manually coded) | ✅ Yes |
| **Auto `equals()`, `hashCode()`?** | ✅ Yes | ❌ No (manual) | ✅ Yes |
| **Thread-Safe?** | ✅ Yes | ❌ No (if mutable) | ✅ Yes |
| **Java Version** | Java 14+ | Any | Java 8+ |

---

## **7. Common Use Cases of Records**  

✅ **DTOs (Data Transfer Objects)**  
✅ **API Responses (Spring Boot, REST APIs)**  
✅ **Immutable Key-Value Pair Holders**  
✅ **Cache Entries (e.g., LRU Cache)**  
✅ **Multi-Value Return Objects**  
✅ **Database Entities (JPA Projection)**  

### **Example: Record as a DTO (Data Transfer Object)**
```java
public record EmployeeDTO(String name, double salary) {}
```
Usage:  
```java
EmployeeDTO e = new EmployeeDTO("John", 50000);
System.out.println(e.name() + " earns $" + e.salary());
```

---

## **8. FAQs (Frequently Asked Questions)**  

### **Q1: Can a Record Extend Another Class?**  
❌ **No**, records **cannot extend classes** because they are `final`.  

### **Q2: Can a Record Implement Interfaces?**  
✅ **Yes!** Records **can implement interfaces**.  
```java
public interface Printable {
    void print();
}
public record Book(String title) implements Printable {
    @Override
    public void print() {
        System.out.println("Title: " + title);
    }
}
```

### **Q3: Can We Have Mutable Fields in a Record?**  
❌ **No, all fields are final** by default. But you can have **mutable fields inside a record** (not recommended):  
```java
public record Container(List<String> items) {}
```
The `List` is mutable, **but the reference to it is final**.

### **Q4: Can We Use `@JsonIgnore` or `@JsonProperty` in Records?**  
✅ **Yes!** In **Spring Boot / Jackson**, you can **annotate records for JSON serialization**.  
```java
public record User(@JsonProperty("username") String name, int age) {}
```

---

## **9. Hands-On Practice**  
📂 **[Click here](./record-classes-practice)** for hands-on coding exercises.  

📖 [Official Java Docs on Records](https://docs.oracle.com/en/java/javase/16/language/records.html)  

---

## **10. Summary**  

🔹 **Records** simplify class creation by automatically generating constructors, getters, `toString()`, `equals()`, and `hashCode()`.  
🔹 They **are immutable by default**, making them **safe, clean, and efficient**.  
🔹 Ideal for **DTOs, API responses, database projections, and data-holding classes**.  
🔹 **No inheritance**, but they can **implement interfaces**.  
🔹 **Less code, better performance, and thread safety**.  

🔥 **Use Records whenever you need an immutable data carrier in Java!** 🚀