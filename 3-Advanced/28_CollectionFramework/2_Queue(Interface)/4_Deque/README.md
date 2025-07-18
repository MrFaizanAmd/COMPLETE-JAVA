# Deque in Java - A Comprehensive Guide

## Introduction

Welcome to the **Deque (Double-Ended Queue) in Java**! 🎉
Here’s the hierarchy for **Deque in Java**, structured similarly to your previous requests:  

```
Iterable  
│  
├── Collection (Interface)  
│   ├── Queue (Interface)  
│   │   ├── Deque (Interface) ✅ (Our Focus!)  
│   │   │   ├── ArrayDeque ✅ (Common Implementation)  
│   │   │   ├── LinkedList ✅ (Common Implementation)  
│  
├── AbstractCollection (Abstract Class)  
│   ├── AbstractQueue (Abstract Class)  
│   │   ├── AbstractSequentialList (Abstract Class)  
│   │   │   ├── LinkedList ✅ (Implements Deque)  
│  
```

### **Explanation**:
1. **Deque (Interface)** – Extends `Queue` and allows elements to be added or removed from both ends.  
2. **ArrayDeque (Class)** – A resizable array implementation of `Deque`, efficient for stack and queue operations.  
3. **LinkedList (Class)** – Implements `Deque`, providing a doubly-linked list structure for efficient element insertion and deletion at both ends.  

Would you like me to add this hierarchy inside your **README** as well? 😊
A **Deque (pronounced "deck")** is a special type of queue that allows **insertion and deletion from both ends** (front and rear). Unlike a traditional queue (FIFO - First In, First Out) or a stack (LIFO - Last In, First Out), a deque provides greater flexibility in handling elements efficiently.

Deque is particularly useful in scenarios where we need **quick access** to both ends of a collection, such as:
- Implementing **undo/redo** functionality
- Managing **sliding window problems**
- **Palindrome checking**
- **Task scheduling algorithms**

Java provides `Deque` as part of the **Java Collections Framework (JCF)** under the `java.util` package.

---

## 1️⃣ Understanding Deque - Key Features

### ✅ Allows Insertion and Deletion from Both Ends
Unlike a standard queue that only allows operations at one end, a deque can:
- **Add elements at the front** (`addFirst(e)`, `offerFirst(e)`)
- **Add elements at the rear** (`addLast(e)`, `offerLast(e)`)
- **Remove elements from the front** (`removeFirst()`, `pollFirst()`)
- **Remove elements from the rear** (`removeLast()`, `pollLast()`)

### ✅ Can Be Used as Both Queue and Stack
- Using **only rear operations**, a deque behaves like a **queue** (FIFO behavior)
- Using **only front operations**, a deque behaves like a **stack** (LIFO behavior)

### ✅ Supports Null-Free Implementations
- `ArrayDeque` does **not allow null values**
- `LinkedList` allows **null values**

### ✅ Provides Efficient Performance
- **ArrayDeque** is **faster** than `Stack` and `LinkedList` for most cases
- **Constant time** complexity `O(1)` for inserting and deleting at both ends

---

## 2️⃣ Types of Deques in Java

Java provides two primary implementations of `Deque`:

| Implementation  | Description |
|----------------|-------------|
| `ArrayDeque<E>` | A **resizable array** implementation of a deque (faster than LinkedList) |
| `LinkedList<E>` | A **doubly linked list** implementation of a deque |

---

## 3️⃣ Creating a Deque in Java

We can create a `Deque` using **ArrayDeque** or **LinkedList**:

```java
import java.util.Deque;
import java.util.ArrayDeque;

public class DequeExample {
    public static void main(String[] args) {
        // Creating a Deque using ArrayDeque
        Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements
        deque.addFirst(10); // [10]
        deque.addLast(20);  // [10, 20]
        deque.addFirst(5);  // [5, 10, 20]
        
        System.out.println("Deque: " + deque);
    }
}
```

### 🛠 Output:
```
Deque: [5, 10, 20]
```

---

## 4️⃣ Important Methods in Deque

### 🔹 Adding Elements
| Method | Description |
|--------|-------------|
| `addFirst(e)` | Adds element at the front, throws exception if full |
| `addLast(e)` | Adds element at the rear, throws exception if full |
| `offerFirst(e)` | Adds element at the front, returns `false` if full |
| `offerLast(e)` | Adds element at the rear, returns `false` if full |

### 🔹 Removing Elements
| Method | Description |
|--------|-------------|
| `removeFirst()` | Removes the first element, throws exception if empty |
| `removeLast()` | Removes the last element, throws exception if empty |
| `pollFirst()` | Removes the first element, returns `null` if empty |
| `pollLast()` | Removes the last element, returns `null` if empty |

### 🔹 Accessing Elements
| Method | Description |
|--------|-------------|
| `getFirst()` | Retrieves first element, throws exception if empty |
| `getLast()` | Retrieves last element, throws exception if empty |
| `peekFirst()` | Retrieves first element, returns `null` if empty |
| `peekLast()` | Retrieves last element, returns `null` if empty |

---

## 5️⃣ Real-World Example: Browser Back and Forward Navigation

A **Deque** can be used to implement browser **back and forward** functionality:

```java
import java.util.Deque;
import java.util.ArrayDeque;

public class BrowserNavigation {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();

        // Visiting pages
        history.addLast("Google");
        history.addLast("YouTube");
        history.addLast("GitHub");
        
        System.out.println("Current Page: " + history.peekLast());

        // Going back
        history.removeLast();
        System.out.println("After Going Back: " + history.peekLast());
    }
}
```

### 🛠 Output:
```
Current Page: GitHub
After Going Back: YouTube
```

---

## 6️⃣ FAQs

### ❓ How is `ArrayDeque` different from `LinkedList`?
- `ArrayDeque` is faster and does **not allow null values**
- `LinkedList` supports null values but has **higher memory overhead**

### ❓ When should I use a Deque?
- When you need **fast insertions/removals at both ends**
- Implementing **undo/redo, backtracking, or navigation systems**

### ❓ How is Deque different from Stack and Queue?
| Data Structure | Operations | Behavior |
|---------------|------------|-----------|
| **Queue** | `enqueue()`, `dequeue()` | FIFO |
| **Stack** | `push()`, `pop()` | LIFO |
| **Deque** | `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()` | Both FIFO & LIFO |

---

## 📂 Hands-on Practice Files

For coding exercises related to **Deque**, visit the folder:
[🔗 Deque Practice Files](./Deque/)

---

## 🔗 Additional Resources
- [Java Official Documentation - Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
- [GeeksforGeeks - Deque in Java](https://www.geeksforgeeks.org/deque-interface-java/)
- [JavaTpoint - Deque](https://www.javatpoint.com/deque-in-java)

---

### 🎯 Summary
- **Deque (Double-Ended Queue)** allows insertion/deletion from both ends.
- Java provides **ArrayDeque** (recommended) and **LinkedList** implementations.
- It supports **FIFO & LIFO** behaviors.
- Used in **navigation systems, undo/redo, and sliding window problems**.
- Faster than `Stack` and `LinkedList` for most operations.

🎯 **Keep practicing and experimenting with Deques in Java! 🚀**

