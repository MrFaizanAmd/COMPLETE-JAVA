
# 📚 **LinkedList in Java - The Powerful Doubly Linked List!**  

## 🔹 **Hierarchy of LinkedList**  
Before diving deep into LinkedList, let's understand where it fits in the **Java Collection Framework**.  

```
Iterable  
│  
├── Collection  
│   ├── List (Interface)  
│   │   ├── AbstractSequentialList (Abstract Class)  
│   │   │   ├── LinkedList ✅ (Our Focus!)  
│   ├── Queue (Interface)  
│   │   ├── Deque (Interface)  
│   │   │   ├── LinkedList ✅ (Our Focus!)  
```

### 🧐 **What is a LinkedList?**  
A **LinkedList** is a **doubly linked list** in Java that implements both the `List` and `Deque` interfaces. Unlike `ArrayList`, where elements are stored in a **dynamic array**, `LinkedList` stores elements in **nodes**, which contain data and references to previous and next elements.  
## *Visualisation*

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6IAPFb1O5fe5IHWF5WRYyFo0EwPm0-Pex3w&s" alt="Telephone Keypad">


---


📌 **Key Features of LinkedList:**  
✅ **Doubly Linked List** – Each node has references to both the previous and next node.  
✅ **Efficient Insertions/Deletions** – Adding/removing elements is **O(1)** at the start or end.  
✅ **No Resizing Issues** – Unlike `ArrayList`, it doesn't require resizing operations.  
✅ **Implements List & Queue** – Can be used as a list (`List`) or a queue (`Deque`).  
✅ **Sequential Access** – Slower than `ArrayList` for **random access** (O(n) lookup).  

---

## 🔍 **Core Interfaces: List & Deque**  
`LinkedList` implements **both `List` and `Deque`**, so it supports operations from both:  

### ✨ **What does LinkedList inherit from List?**  
Since `LinkedList` implements `List`, it supports:  

- `add(E e)`: Adds an element to the list.  
- `get(int index)`: Retrieves an element at a specific position.  
- `remove(int index)`: Removes an element at the given index.  
- `size()`: Returns the number of elements in the list.  
- `contains(Object o)`: Checks if the list contains a specific element.  

### ✨ **What does LinkedList inherit from Deque?**  
Since `LinkedList` also implements `Deque`, it supports queue-like operations:  

- `addFirst(E e)`, `addLast(E e)`: Add elements at the beginning or end.  
- `removeFirst()`, `removeLast()`: Remove elements from the beginning or end.  
- `peekFirst()`, `peekLast()`: Retrieve elements without removing them.  

---

## 🛠 **How is LinkedList Implemented Internally?**  
Behind the scenes, `LinkedList` **uses a doubly linked list** structure.  

1️⃣ Each **node** contains:  
   - `data`: The value of the element.  
   - `next`: A reference to the next node.  
   - `prev`: A reference to the previous node.  

2️⃣ The `LinkedList` maintains:  
   - A reference to the **head** (first node).  
   - A reference to the **tail** (last node).  

### 🏗 **Internal Node Structure**  
```java
class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;
}
```
🔹 This allows **efficient insertion and deletion** at both ends but makes **random access slower** than `ArrayList`.  

---

## ✍ **How to Declare and Use a LinkedList?**  
Let's start coding! 🚀  

### ✅ **Basic LinkedList Usage**
```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> names = new LinkedList<>();

        // Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Accessing elements
        System.out.println("First element: " + names.get(0));

        // Removing an element
        names.remove("Bob");

        // Iterating over elements
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```
📌 **Output:**  
```
First element: Alice  
Alice  
Charlie  
```

---

## 🔥 **Advanced Operations on LinkedList**
### 📌 **Using LinkedList as a Queue**
```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();

        // Enqueue elements
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);

        // Dequeue elements
        System.out.println("Removed: " + queue.removeFirst());
        System.out.println("Front: " + queue.peekFirst());
    }
}
```
📌 **Output:**  
```
Removed: 10  
Front: 20  
```

---

### 📌 **Using LinkedList as a Stack**
```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();

        // Push elements
        stack.addFirst("HTML");
        stack.addFirst("CSS");
        stack.addFirst("JavaScript");

        // Pop elements
        System.out.println("Popped: " + stack.removeFirst());
        System.out.println("Top: " + stack.peekFirst());
    }
}
```
📌 **Output:**  
```
Popped: JavaScript  
Top: CSS  
```

---

## ⚡ **All Methods in LinkedList with Time Complexity & Examples**  

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Adds an element at the end | **O(1)** |
| `add(int index, E element)` | Adds an element at a specific index | **O(n)** |
| `get(int index)` | Retrieves an element by index | **O(n)** |
| `set(int index, E element)` | Replaces an element at an index | **O(n)** |
| `remove(int index)` | Removes an element at a specific index | **O(n)** |
| `remove(Object o)` | Removes the first occurrence of the element | **O(n)** |
| `contains(Object o)` | Checks if an element exists | **O(n)** |
| `indexOf(Object o)` | Returns the index of the first occurrence | **O(n)** |
| `clear()` | Removes all elements | **O(1)** |
| `size()` | Returns the total number of elements | **O(1)** |
| `addFirst(E e)` | Adds an element at the beginning | **O(1)** |
| `addLast(E e)` | Adds an element at the end | **O(1)** |
| `removeFirst()` | Removes the first element | **O(1)** |
| `removeLast()` | Removes the last element | **O(1)** |
| `peekFirst()` | Returns the first element without removing | **O(1)** |
| `peekLast()` | Returns the last element without removing | **O(1)** |
| `offer(E e)` | Adds an element at the end (for queues) | **O(1)** |
| `poll()` | Removes and returns the first element (for queues) | **O(1)** |
| `push(E e)` | Adds an element at the start (for stacks) | **O(1)** |
| `pop()` | Removes and returns the first element (for stacks) | **O(1)** |

---

## ❓ **Frequently Asked Questions (FAQs)**  

### ❓ 1. **What is the difference between `ArrayList` and `LinkedList`?**  
| Feature | ArrayList | LinkedList |
|---------|----------|------------|
| Data Structure | Uses a **dynamic array** | Uses a **doubly linked list** |
| Access Time | **O(1)** (Fast, indexed access) | **O(n)** (Slow, traversal required) |
| Insert/Delete | **O(n)** (Shifting required) | **O(1)** (Pointer update) |
| Memory | Less memory (stores only values) | More memory (stores values + pointers) |

---

### ❓ 2. **When should I use `LinkedList` instead of `ArrayList`?**  
- Use **`LinkedList`** when frequent **insertions and deletions** are needed.  
- Use **`ArrayList`** when **fast random access** is required.  

---

### ❓ 3. **Can a LinkedList store `null` values?**  
Yes! `LinkedList` allows storing `null` values.  
```java
LinkedList<String> list = new LinkedList<>();
list.add(null);
System.out.println(list.get(0));  // Output: null
```

---

### 📚 **Further Reading & Official Docs**  
🔗 [Java LinkedList (Oracle Docs)](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)  
🔗 [Collections Framework Overview](https://docs.oracle.com/javase/tutorial/collections/intro/index.html)  

---

## 📂 **Where to Find Implementations?**  
You can find all implementations and examples in the `LinkedList` folder inside this repository! 🚀  

---

## 🎯 **Final Thoughts**  
`LinkedList` is a **powerful** data structure that offers **fast insertions and deletions** at both ends. However, **random access is slower** compared to `ArrayList`.  

🔥 **Next Steps?** Practice with real-world scenarios and try different methods to become a pro! 🚀 Happy coding! 🎯  

---
