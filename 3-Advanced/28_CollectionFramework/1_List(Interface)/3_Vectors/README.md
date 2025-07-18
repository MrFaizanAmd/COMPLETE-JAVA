

# 📚 **Vector in Java - The Legacy Synchronized List!**  

## 🔹 **Hierarchy of Vector**  
Before we dive into `Vector`, let's see where it fits in the **Java Collection Framework**.  

```
Iterable  
│  
├── Collection  
│   ├── List (Interface)  
│   │   ├── AbstractList (Abstract Class)  
│   │   │   ├── Vector ✅ (Our Focus!)  
```

### 🧐 **What is a Vector?**  
A **Vector** is a **resizable, synchronized list** in Java. It is similar to `ArrayList`, but with one major difference—it is **thread-safe** because all its methods are **synchronized**.  

📌 **Key Features of Vector:**  
✅ **Thread-Safe** – Synchronized methods ensure safety in multi-threaded environments.  
✅ **Dynamic Sizing** – It grows **automatically** when elements are added.  
✅ **Allows Duplicates** – Just like `ArrayList`, duplicates are permitted.  
✅ **Maintains Insertion Order** – Elements remain in the order they were added.  
✅ **Slower than ArrayList** – Due to synchronization overhead.  

---

## 🔍 **Core Interface: List**  
Since `Vector` implements the **List** interface, it inherits many useful methods for handling ordered collections.  

### ✨ **What does Vector inherit from List?**  
- `add(E e)`: Adds an element to the list.  
- `get(int index)`: Retrieves an element at a specific position.  
- `remove(int index)`: Removes an element at the given index.  
- `size()`: Returns the number of elements in the list.  
- `contains(Object o)`: Checks if the list contains a specific element.  
- `indexOf(Object o)`: Finds the index of the first occurrence of an element.  

💡 **Think of `List` as a contract that defines the rules** for different types of lists, and `Vector` is one way to implement those rules.

---

## 🛠 **How is Vector Implemented Internally?**  
Internally, `Vector` is implemented using an **array** that grows dynamically **when needed**.  

1️⃣ The initial capacity of `Vector` can be set during initialization (default: 10).  
2️⃣ When the capacity is exceeded, **Vector doubles its size (2x growth policy)**, unlike `ArrayList`, which grows by **1.5x**.  
3️⃣ The old elements are copied to a new, larger array.  

### 🏗 **Internal Array Expansion Mechanism**  
```java
public synchronized boolean add(E e) {
    ensureCapacityHelper(elementCount + 1);
    elementData[elementCount++] = e;
    return true;
}
```
🔹 **ensureCapacityHelper()** checks if expansion is needed. If yes, it creates a **larger array** and copies existing elements.

---

## ✍ **How to Declare and Use a Vector?**  
Let's start coding! 🚀  

### ✅ **Basic Vector Usage**
```java
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        // Creating a Vector
        Vector<String> fruits = new Vector<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Accessing elements
        System.out.println("First fruit: " + fruits.get(0));

        // Removing an element
        fruits.remove("Banana");

        // Iterating over elements
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```
📌 **Output:**  
```
First fruit: Apple  
Apple  
Cherry  
```

---

## 🔥 **Advanced Operations on Vector**
### 📌 **Sorting a Vector**
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>(Arrays.asList(5, 2, 9, 1, 3));
        
        // Sorting in ascending order
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        // Sorting in descending order
        numbers.sort(Collections.reverseOrder());
        System.out.println("Reverse Sorted: " + numbers);
    }
}
```
📌 **Output:**  
```
Sorted: [1, 2, 3, 5, 9]  
Reverse Sorted: [9, 5, 3, 2, 1]  
```

---

## ⚡ **Commonly Used Methods in Vector**
| Method | Description |
|--------|------------|
| `add(E e)` | Adds an element to the list |
| `add(int index, E element)` | Inserts an element at a specific index |
| `get(int index)` | Retrieves an element by index |
| `remove(int index)` | Removes an element at a given index |
| `size()` | Returns the total number of elements |
| `set(int index, E element)` | Replaces an element at a specified index |
| `contains(Object o)` | Checks if an element exists |
| `indexOf(Object o)` | Returns the index of the first occurrence |
| `clear()` | Removes all elements from the list |
| `firstElement()` | Returns the first element |
| `lastElement()` | Returns the last element |
| `capacity()` | Returns the current capacity of the vector |
| `trimToSize()` | Reduces capacity to the current size |

---

## ❓ **Frequently Asked Questions (FAQs)**  

### ❓ 1. **What is the difference between `Vector` and `ArrayList`?**  
| Feature | Vector | ArrayList |
|---------|--------|----------|
| Synchronization | **Yes** (Thread-safe) | **No** (Not thread-safe) |
| Performance | Slower (due to synchronization) | Faster (no synchronization overhead) |
| Growth Rate | **Doubles (2x)** when resized | **1.5x** when resized |
| Use Case | Multi-threaded applications | Single-threaded applications |

---

### ❓ 2. **Can a Vector store `null` values?**  
Yes! `Vector` allows storing `null` values.  
```java
Vector<String> list = new Vector<>();
list.add(null);
System.out.println(list.get(0));  // Output: null
```

---

### ❓ 3. **How to convert a Vector to an array?**  
You can use the `.toArray()` method.  
```java
String[] array = fruits.toArray(new String[0]);
```

---

### 📚 **Further Reading & Official Docs**  
🔗 [Java Vector (Oracle Docs)](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)  
🔗 [Collections Framework Overview](https://docs.oracle.com/javase/tutorial/collections/intro/index.html)  

---

## 📂 **Where to Find Implementations?**  
You can find all implementations and examples in the `Vector` folder inside this repository! 🚀  

---

## 🎯 **Final Thoughts**  
`Vector` is an important part of **Java Collections**, especially in **multi-threaded environments** where **synchronization** is necessary. However, due to its slower performance, `ArrayList` is preferred in most modern applications unless thread safety is required.  

🔥 **Next Steps?** Practice with real-world scenarios and try different methods to become a pro! 🚀 Happy coding! 🎯  

---
