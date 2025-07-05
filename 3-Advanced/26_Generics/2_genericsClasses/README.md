# Java Generics – Understanding Generic Classes (Beginner to Advanced)

## 📌 Introduction to Generic Classes
A **Generic Class** in Java allows you to define a class with type parameters, enabling you to write more flexible, reusable, and type-safe code. Think of it as creating a **blueprint** that can adapt to different data types without needing to rewrite the entire class.

### 💡 Why Use Generic Classes?
- **Type Safety:** Prevents runtime errors by catching type issues at compile time.
- **Code Reusability:** Create a single class that can work with different data types.
- **Eliminates Type Casting:** Reduces the need for explicit type conversions.

### 📘 Real-World Analogy:
Imagine a **storage box** designed to hold any type of item. You can label it to hold only books or only toys. Similarly, a generic class is like a box that can store objects of any type, but with the added safety of specifying the type upfront.

---

## 🗝️ Key Concepts & Terminologies
### **1. Defining a Generic Class**
A generic class is defined using **angle brackets (`<>`)** and a type parameter (often `T`).
```java
class Box<T> { // 'T' is a type parameter
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
```
- `T` stands for "Type" and acts as a placeholder.
- You can use any identifier like `E`, `K`, `V`, but `T` is standard.

### **2. Creating Objects from a Generic Class**
```java
public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Generics!");
        System.out.println(stringBox.getItem()); // Outputs: Hello Generics!

        Box<Integer> intBox = new Box<>();
        intBox.setItem(42);
        System.out.println(intBox.getItem()); // Outputs: 42
    }
}
```
**Benefit:** No need for type casting and prevents adding wrong data types.

### **3. Multiple Type Parameters**
A generic class can have more than one type parameter.
```java
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
```
Usage:
```java
Pair<String, Integer> agePair = new Pair<>("Alice", 30);
System.out.println(agePair.getKey() + " is " + agePair.getValue() + " years old.");
```

### **4. Generic Classes with Bounded Types**
You can restrict the type parameter to a specific superclass using `extends`.
```java
class NumberBox<T extends Number> {
    private T number;

    public NumberBox(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}
```
Usage:
```java
NumberBox<Integer> intBox = new NumberBox<>(100);
System.out.println(intBox.doubleValue()); // Outputs: 100.0

// NumberBox<String> strBox = new NumberBox<>("Hello"); // Error: String not allowed
```

### **5. Generic Constructors**
A constructor can also use type parameters.
```java
class Printer {
    public <T> Printer(T item) {
        System.out.println(item);
    }
}
```
Usage:
```java
new Printer("Generic Constructor Example");
new Printer(123);
```

---

## 🤔 FAQs & Common Misconceptions
### **Q1: Can a generic class accept multiple types?**
Yes, by using multiple type parameters (e.g., `Pair<K, V>`).

### **Q2: Can generics work with primitive types?**
No, but they work with wrapper classes (`int` → `Integer`, `double` → `Double`).

### **Q3: What is type erasure?**
Generics are a compile-time feature. The type information is removed during runtime, which is known as **type erasure**.

### **Q4: How are generic classes different from Object classes?**
Generic classes enforce type safety at compile time, whereas `Object` classes require casting and are error-prone.

---

## 🔗 Additional Resources
- [Official Java Generics Guide](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- *Effective Java* by Joshua Bloch (Highly recommended for best practices)
- [Java Generics – Baeldung Guide](https://www.baeldung.com/java-generics)

---

## 🧩 Hands-on Practice
🔗 Check out the [Generic Classes Practice Folder](./generic-classes/) for hands-on exercises and practical projects.

---

## 🎯 Conclusion
Generic classes are a cornerstone of Java programming, promoting type safety, reusability, and clean coding practices. Mastering them will make your Java programs more robust and efficient. Continue exploring the next topics to deepen your understanding of Java Generics.

