# 📚 **Stack in Java - The LIFO Data Structure!**

## 🔹 **Hierarchy of Stack in Java Collection Framework**
Before we deep dive into Stacks, let's understand its place in the **Java Collection Framework**.

```
Iterable  
│  
├── Collection  
│   ├── List (Interface)  
│   │   ├── Vector (Class)  
│   │   │   ├── Stack ✅ (Our Focus!)  
```

### 🤔 **What is a Stack?**  
A **Stack** is a **Last-In-First-Out (LIFO)** data structure where elements are added and removed from the **same end** (called the **top**). Java provides a built-in `Stack` class that extends `Vector`, making it part of the **List hierarchy**.

## **Visualization of a Stack**  

Imagine a stack of plates 🍽️ - the last plate placed is the first one removed!

```
   [ 40 ]  <- Top (Last In, First Out)
   [ 30 ]
   [ 20 ]
   [ 10 ]  <- Bottom (First In, Last Out)
```

---

## 📌 **Key Features of Stack:**
✅ **LIFO (Last In, First Out)** – The last element added is the first to be removed.
✅ **Push & Pop Operations** – Insert elements using `push()`, remove using `pop()`.
✅ **Efficient Access to Top Element** – `peek()` allows checking the top element without removal.
✅ **Extends Vector** – Stack is a subclass of `Vector`, inheriting its methods.
✅ **Used in Many Algorithms** – Example: Expression evaluation, recursion, undo/redo features.

---

## 🛠 **How to Declare and Use a Stack?**  
Let's start coding! 🚀  

### ✅ **Basic Stack Usage**
```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Creating a Stack
        Stack<String> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");

        // Checking the top element
        System.out.println("Top Element: " + stack.peek());

        // Popping an element
        System.out.println("Popped: " + stack.pop());

        // Checking if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
```

📌 **Output:**  
```
Top Element: C++
Popped: C++
Is stack empty? false
```

---

## 🔍 **Stack Methods with Time Complexity & Examples**  

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `push(E e)` | Adds an element to the top of the stack | **O(1)** |
| `pop()` | Removes and returns the top element | **O(1)** |
| `peek()` | Returns the top element without removing it | **O(1)** |
| `isEmpty()` | Checks if the stack is empty | **O(1)** |
| `search(Object o)` | Returns the position of the element (1-based index) | **O(n)** |

---

## 🔎 **Advanced Operations on Stack**

### 📈 **Reversing a String using Stack**
```java
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        Stack<Character> stack = new Stack<>();
        
        // Push characters onto stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop characters to reverse the string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        System.out.println("Reversed String: " + reversed);
    }
}
```

📌 **Output:**  
```
Reversed String: olleh
```

---

## 🚀 **Stack vs Other List Implementations**
| Feature | Stack | ArrayList | LinkedList |
|---------|-------|-----------|------------|
| Order | LIFO (Last In, First Out) | Indexed Access | Doubly Linked List |
| Insert/Delete | `push()` & `pop()` | `add()` & `remove()` | `addFirst() & removeFirst()` |
| Random Access | Slow | Fast | Slow |
| Use Case | Function calls, undo/redo | Fast lookups | Fast insert/delete |

---

## ❓ **FAQs (Frequently Asked Questions)**  

### ❓ 1. **Why use Stack instead of ArrayList or LinkedList?**
- Stack is optimized for **LIFO operations** (`push()` and `pop()` are **O(1)**).
- `ArrayList` is better when **random access** is needed.
- `LinkedList` is useful for **fast insertions/deletions at both ends**.

### ❓ 2. **Can a Stack store `null` values?**
Yes, a `Stack` allows `null` values.
```java
Stack<String> stack = new Stack<>();
stack.push(null);
System.out.println(stack.peek());  // Output: null
```

### ❓ 3. **What is the difference between `peek()` and `pop()`?**
- `peek()` returns the **top element without removing it**.
- `pop()` returns and **removes the top element**.

---

## 📚 **Further Reading & Official Docs**  
🔗 [Java Stack (Oracle Docs)](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)  
🔗 [Collections Framework Overview](https://docs.oracle.com/javase/tutorial/collections/intro/index.html)  

---

## 🌟 **Final Thoughts**  
`Stack` is a **powerful data structure** used in recursion, expression evaluation, undo/redo mechanisms, and much more. Since it extends `Vector`, it inherits methods like `size()` and `contains()`, making it more flexible.

🔄 **Next Steps?** Keep practicing by implementing stacks in real-world scenarios! 🚀 Happy coding! 🎯  

