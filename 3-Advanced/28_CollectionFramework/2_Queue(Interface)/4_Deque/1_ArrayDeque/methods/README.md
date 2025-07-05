# 📌 Java ArrayDeque Methods - A Complete Guide

## 🔥 Introduction

`ArrayDeque` is a **resizable, double-ended queue (Deque)** in Java that allows **fast insertions and removals** from both ends. It is more efficient than `Stack` and `LinkedList` for stack and queue operations.

In this guide, we will explore **all built-in methods** of `ArrayDeque`, their use cases, practical examples, and time complexity. Let's dive in! 🚀

---

## 🏗 ArrayDeque Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Deque
│   │   ├── ArrayDeque
```

- `ArrayDeque<E>` implements `Deque<E>` and allows operations at both ends with **O(1)** performance.

---

## **1️⃣ ArrayDeque Methods and Their Time Complexity**

| Method | Description | Time Complexity |
|--------|------------|----------------|
| `add(E e)` | Adds an element to the end | **O(1)** |
| `addFirst(E e)` | Inserts an element at the front | **O(1)** |
| `addLast(E e)` | Inserts an element at the end | **O(1)** |
| `offer(E e)` | Offers an element at the end | **O(1)** |
| `offerFirst(E e)` | Offers an element at the front | **O(1)** |
| `offerLast(E e)` | Offers an element at the end | **O(1)** |
| `remove()` | Removes and returns the first element | **O(1)** |
| `removeFirst()` | Removes and returns the first element | **O(1)** |
| `removeLast()` | Removes and returns the last element | **O(1)** |
| `poll()` | Retrieves and removes the first element | **O(1)** |
| `pollFirst()` | Retrieves and removes the first element | **O(1)** |
| `pollLast()` | Retrieves and removes the last element | **O(1)** |
| `element()` | Retrieves but does not remove the first element | **O(1)** |
| `peek()` | Retrieves but does not remove the first element | **O(1)** |
| `peekFirst()` | Retrieves but does not remove the first element | **O(1)** |
| `peekLast()` | Retrieves but does not remove the last element | **O(1)** |
| `size()` | Returns the number of elements | **O(1)** |
| `isEmpty()` | Checks if the deque is empty | **O(1)** |
| `clear()` | Removes all elements | **O(n)** |
| `iterator()` | Returns an iterator over elements | **O(1)** |
| `descendingIterator()` | Returns a reverse-order iterator | **O(1)** |

---

## **2️⃣ ArrayDeque Method Descriptions with Examples**

### 📝 **1. `add(E e)` - Add an Element at the End**

```java
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(10);
        deque.add(20);
        deque.add(30);
        System.out.println(deque); // Output: [10, 20, 30]
    }
}
```

---

### 📝 **2. `addFirst(E e)` - Add Element to Front**

```java
deque.addFirst(5);
System.out.println(deque); // Output: [5, 10, 20, 30]
```

---

### 📝 **3. `addLast(E e)` - Add Element to End**

```java
deque.addLast(40);
System.out.println(deque); // Output: [5, 10, 20, 30, 40]
```

---

### 📝 **4. `remove()` - Remove First Element**

```java
System.out.println(deque.remove()); // Output: 5
System.out.println(deque); // Output: [10, 20, 30, 40]
```

---

### 📝 **5. `removeLast()` - Remove Last Element**

```java
System.out.println(deque.removeLast()); // Output: 40
```

---

### 📝 **6. `peek()` - Get First Element Without Removing**

```java
System.out.println(deque.peek()); // Output: 10
```

---

### 📝 **7. `poll()` - Remove and Return First Element**

```java
System.out.println(deque.poll()); // Output: 10
System.out.println(deque); // Output: [20, 30]
```

---

### 📝 **8. `size()` - Get Size of Deque**

```java
System.out.println(deque.size()); // Output: 2
```

---

### 📝 **9. `isEmpty()` - Check If Deque is Empty**

```java
System.out.println(deque.isEmpty()); // Output: false
```

---

### 📝 **10. `clear()` - Remove All Elements**

```java
deque.clear();
System.out.println(deque); // Output: []
```

---

### 📝 **11. `iterator()` - Iterate Over Elements**

```java
for (int num : deque) {
    System.out.print(num + " ");
}
// Output: 20 30
```

---

### 📝 **12. `descendingIterator()` - Reverse Order Iteration**

```java
for (Iterator<Integer> it = deque.descendingIterator(); it.hasNext(); ) {
    System.out.print(it.next() + " ");
}
// Output: 30 20
```

---

## **3️⃣ Use Case Scenarios**

✅ **Undo/Redo Operations** → Stores actions for undoing and redoing changes.

✅ **Task Scheduling** → Used in applications where task execution order matters.

✅ **Sliding Window Problems** → Efficient for managing sliding window operations in algorithms.

✅ **Expression Evaluation** → Used in parsing mathematical expressions.

✅ **Browser History** → Manages back/forward navigation.

---

## **📌 Summary**

1. `addFirst()` / `addLast()` → Adds elements at both ends.
2. `removeFirst()` / `removeLast()` → Removes elements from both ends.
3. `peekFirst()` / `peekLast()` → Retrieves elements without removing them.
4. `iterator()` / `descendingIterator()` → Supports traversal in both directions.
5. `clear()`, `size()`, `isEmpty()` → Utility methods for management.

---

## ❓ FAQs

1️⃣ **How is `ArrayDeque` different from `LinkedList`?**
   - `ArrayDeque` is faster as it does not maintain node references.

2️⃣ **Is `ArrayDeque` synchronized?**
   - No, it is **not thread-safe**.

3️⃣ **What is the initial capacity of `ArrayDeque`?**
   - It starts with **16 elements** and dynamically resizes.

---

## 📚 Additional Resources
- [Official Java Docs - ArrayDeque](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/ArrayDeque.html)

🚀 Happy Coding! 🎯

