# 📌 Java Stack Methods - A Complete Guide

## 🔥 Introduction

The `Stack` class in Java is a **Last-In, First-Out (LIFO) data structure** that extends the `Vector` class. It provides essential methods to push, pop, peek, search, and check if the stack is empty.

In this guide, we will explore **all built-in methods** of `Stack`, their use cases, practical examples, and time complexity. Let's dive in! 🚀

---

## 🏗 Stack Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── List
│   │   ├── AbstractList
│   │   │   ├── Vector
│   │   │   │   ├── Stack
```

- `Stack<E>` extends `Vector<E>`, inheriting its methods but modifying behavior to work as a **LIFO stack**.

---

## **1️⃣ Stack Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `push(E item)` | Pushes an item onto the stack | **O(1)** |
| `E pop()` | Removes and returns the top item | **O(1)** |
| `E peek()` | Returns the top item without removing it | **O(1)** |
| `boolean empty()` | Checks if the stack is empty | **O(1)** |
| `int search(Object o)` | Searches for an item and returns its position | **O(n)** |

---

## **2️⃣ Stack Method Descriptions with Examples**

### 📝 **1. `push(E item)` - Add an Element**

- **Inserts an element at the top of the stack**.
- **Time Complexity:** O(1)

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack); // Output: [10, 20, 30]
    }
}
```

---

### 📝 **2. `pop()` - Remove and Return the Top Element**

- **Removes and returns the top element**.
- **Throws `EmptyStackException` if the stack is empty**.
- **Time Complexity:** O(1)

```java
System.out.println(stack.pop()); // Output: 30
System.out.println(stack); // Output: [10, 20]
```

---

### 📝 **3. `peek()` - Get the Top Element Without Removing**

- **Returns the top element without modifying the stack**.
- **Throws `EmptyStackException` if the stack is empty**.
- **Time Complexity:** O(1)

```java
System.out.println(stack.peek()); // Output: 20
```

---

### 📝 **4. `empty()` - Check if the Stack is Empty**

- **Returns `true` if the stack contains no elements**.
- **Time Complexity:** O(1)

```java
System.out.println(stack.empty()); // Output: false
```

---

### 📝 **5. `search(Object o)` - Find an Element**

- **Returns 1-based index position of an element from the top**.
- **Returns `-1` if the element is not found**.
- **Time Complexity:** O(n)

```java
System.out.println(stack.search(10)); // Output: 2
System.out.println(stack.search(100)); // Output: -1
```

---

## **3️⃣ Use Case Scenarios**

✅ **Undo/Redo Functionality** → Stores previous states for undo/redo operations.

✅ **Back/Forward Navigation** → Used in browsers to track page history.

✅ **Expression Evaluation** → Used for parsing mathematical expressions.

✅ **Call Stack in Recursion** → Manages function calls in recursive algorithms.

---

## **📌 Summary**

1. `push(E item)` → Adds an item at the top.
2. `pop()` → Removes and returns the top item.
3. `peek()` → Retrieves the top item without removal.
4. `empty()` → Checks if the stack is empty.
5. `search(Object o)` → Finds an item’s position from the top.

---

## ❓ FAQs

1️⃣ **How is `Stack` different from `Deque`?**  
   - `Stack` extends `Vector`, while `Deque` (`ArrayDeque`) is preferred due to better performance.

2️⃣ **What happens if I `pop()` from an empty stack?**  
   - An `EmptyStackException` is thrown.

3️⃣ **Is `Stack` synchronized?**  
   - Yes, because it extends `Vector`, but `Deque` is a better non-synchronized alternative.

---

## 📚 Additional Resources
- [Official Java Docs - Stack](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)

🚀 Happy Coding! 🎯

