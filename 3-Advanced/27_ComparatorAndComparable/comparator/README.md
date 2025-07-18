# Comparator Interface in Java

## Introduction
The `Comparator` interface in Java is used to define a custom ordering for objects. Unlike the `Comparable` interface, which allows a class to define its natural ordering, `Comparator` provides greater flexibility by allowing sorting based on different criteria without modifying the class itself.

This is particularly useful when sorting objects based on multiple attributes or when the natural ordering is not suitable for a specific scenario.

## Key Concepts and Terminologies

### 1. Comparator Interface
- Belongs to `java.util` package.
- Contains a `compare(T o1, T o2)` method for defining custom sorting logic.
- Supports lambda expressions (Java 8 onwards).
- Used in sorting collections and arrays.

### 2. Difference Between Comparable and Comparator
| Feature | Comparable | Comparator |
|---------|-----------|------------|
| Package | `java.lang` | `java.util` |
| Method | `compareTo(T o)` | `compare(T o1, T o2)` |
| Implementation | Implemented within the class | Implemented externally as a separate class or lambda function |
| Modification | Requires modifying the class | No need to modify the class |
| Sorting Flexibility | Single natural ordering | Multiple sorting criteria supported |

## How the Comparator Interface Works

The `Comparator` interface provides a way to create multiple comparison strategies for objects. You can define custom ordering in multiple ways:

### 1. Implementing the Comparator Interface
```java
import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Charlie"));
        
        Collections.sort(students, new NameComparator());
        
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}
```

### 2. Using Anonymous Class
```java
Collections.sort(students, new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.id, s2.id);
    }
});
```

### 3. Using Lambda Expressions (Java 8+)
```java
Collections.sort(students, (s1, s2) -> s1.name.compareTo(s2.name));
```

### 4. Using `Comparator.comparing` (Java 8+)
```java
students.sort(Comparator.comparing(s -> s.name));
```

### 5. Sorting in Reverse Order
```java
students.sort(Comparator.comparing(Student::getName).reversed());
```

## Frequently Asked Questions (FAQs)

### 1. When should I use `Comparator` instead of `Comparable`?
Use `Comparator` when you need multiple sorting strategies or do not want to modify the class to define sorting behavior.

### 2. Can I use multiple sorting criteria with `Comparator`?
Yes, you can chain comparators using `thenComparing()`.
```java
Comparator<Student> comparator = Comparator.comparing(Student::getName).thenComparing(Student::getId);
students.sort(comparator);
```

### 3. Is `Comparator` thread-safe?
No, but it can be used safely in concurrent environments with synchronization or concurrent data structures.

## Additional Resources
- [Oracle Docs: Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
- [Java Comparator Tutorial](https://www.geeksforgeeks.org/comparator-interface-java/)

## Hands-On Practice
Explore practical examples of `Comparator` in the [Comparator Examples](./ComparatorExamples/) folder.

---
With `Comparator`, you gain full control over how objects are sorted in Java. Mastering it is essential for advanced Java programming and interview preparation! 🚀

