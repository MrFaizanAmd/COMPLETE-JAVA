

# **List Interface in Java**  

## **Introduction**  

### **What is `List` in Java?**  
`List<E>` is an **ordered collection** (also known as a **sequence**) that allows **duplicate elements**. It is a part of the `java.util` package and extends the `Collection<E>` interface.  

✔ **Maintains insertion order**  
✔ **Allows duplicate elements**  
✔ **Provides indexed access (via `get(int index)`)**  
✔ **Supports random access for efficient retrieval**  

📌 **Common Use Cases:**  
- **Storing ordered elements** where duplicates are allowed.  
- **Index-based data retrieval** (e.g., accessing elements by position).  
- **Dynamic arrays (alternative to arrays with fixed size).**  

---

## **Hierarchy of `List` Interface**  

```
java.lang.Iterable (Interface)
│
├── java.util.Collection (Interface)
│   ├── java.util.List<E> (Interface) ✅ (Our Focus!)
│       ├── java.util.ArrayList<E> (Class) 
│       ├── java.util.LinkedList<E> (Class) 
│       ├── java.util.Vector<E> (Class)
│       ├── java.util.Stack<E> (Class)
```

📌 **Key Takeaways:**  
- `List<E>` extends `Collection<E>`.  
- **Multiple implementations exist:** `ArrayList`, `LinkedList`, `Vector`, `Stack`.  
- Provides methods to **insert, update, delete, and search elements** efficiently.  

---

## **Creating and Using `List`**  

### **1. Using `ArrayList` (Most Common Implementation)**
```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // Duplicates allowed
        
        System.out.println("List: " + list);
    }
}
```
**Output:**  
```
List: [Java, Python, C++, Java]
```
✅ **Preserves insertion order and allows duplicates**  

---

### **2. Using `LinkedList` (Doubly-Linked List Implementation)**
```java
List<Integer> linkedList = new LinkedList<>();
linkedList.add(10);
linkedList.add(20);
linkedList.add(30);
```
🔹 **Better for frequent insertions/deletions** (compared to `ArrayList`).  

---

### **3. Using `Vector` (Thread-Safe)**
```java
List<String> vector = new Vector<>();
vector.add("Thread-safe List");
```
🔹 **Slower than `ArrayList` due to synchronized methods**.  

---

## **Common Methods in `List` Interface**  

| Method | Description |
|--------|------------|
| `add(E e)` | Adds an element to the list. |
| `add(int index, E e)` | Inserts an element at a specific index. |
| `remove(int index)` | Removes an element at the specified index. |
| `remove(Object o)` | Removes the first occurrence of the element. |
| `get(int index)` | Retrieves an element at a given index. |
| `set(int index, E e)` | Updates an element at a specific index. |
| `size()` | Returns the number of elements in the list. |
| `indexOf(Object o)` | Returns the index of the first occurrence of the element. |
| `contains(Object o)` | Checks if the list contains an element. |
| `toArray()` | Converts the list to an array. |
| `subList(int fromIndex, int toIndex)` | Returns a portion of the list. |

---

## **Internal Working of `List` Implementations**  

### **1. `ArrayList` (Dynamic Array)**
- **Stores elements in a dynamic array** (resizable).  
- Provides **fast random access** (`O(1)`).  
- Adding/removing in the **middle is slow** (`O(n)`).  

### **2. `LinkedList` (Doubly Linked List)**
- Elements are **linked via nodes** (`O(1)` insert/delete at head/tail).  
- **Slower random access** (`O(n)`) due to traversal requirement.  
- **Efficient for frequent insertions/deletions**.  

### **3. `Vector` (Thread-Safe ArrayList)**
- Works like `ArrayList` but **synchronized**.  
- **Slower due to synchronization overhead**.  

### **4. `Stack` (LIFO – Last In, First Out)**
- **Extends `Vector`** and provides stack operations (`push`, `pop`).  
- Used for **backtracking problems, undo operations**.  

---

## **Performance Comparison**  

| Feature | `ArrayList` | `LinkedList` | `Vector` |
|---------|------------|-------------|---------|
| Data Structure | Dynamic Array | Doubly Linked List | Dynamic Array |
| Access Time | `O(1)` (Fast) | `O(n)` (Slow) | `O(1)` (Fast) |
| Insert/Delete at End | `O(1)` | `O(1)` | `O(1)` |
| Insert/Delete in Middle | `O(n)` | `O(1)` | `O(n)` |
| Thread-Safe? | ❌ No | ❌ No | ✅ Yes (Synchronized) |

🔹 **Use `ArrayList`** for fast access & minimal modifications.  
🔹 **Use `LinkedList`** for frequent insertions/deletions.  
🔹 **Use `Vector`** if thread safety is required.  

---

## **Comparison with Other Java Collections**  

| Feature | `List` | `Set` | `Queue` |
|---------|-------|------|-------|
| Allows Duplicates | ✅ Yes | ❌ No | ✅ Yes (Except PriorityQueue) |
| Maintains Order | ✅ Yes | ❌ No (Except LinkedHashSet) | ✅ Yes (FIFO) |
| Provides Index-Based Access | ✅ Yes | ❌ No | ❌ No |
| Thread-Safe Variants | `Vector` | `CopyOnWriteArraySet` | `ConcurrentLinkedQueue` |

---

## **FAQ (Frequently Asked Questions)**  

### **Q1: When should I use `ArrayList` vs `LinkedList`?**  
- Use `ArrayList` when **fast random access** (`O(1)`) is needed.  
- Use `LinkedList` when **frequent insertions/deletions** (`O(1)`) are required.  

### **Q2: Is `List` thread-safe?**  
- **No, `List` itself is not thread-safe**.  
- Use **`Vector` (synchronized)** or **`Collections.synchronizedList()`** for thread safety.  

### **Q3: What is the default capacity of `ArrayList`?**  
- The **default capacity of `ArrayList` is 10** (when created without specifying capacity).  

### **Q4: How to convert a `List` to an `Array`?**  
```java
List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
String[] array = list.toArray(new String[0]);
```
✅ **Uses `toArray()` method to convert a `List` to an array.**  

---

## **Summary** 🎯  
✔ **`List<E>` is an ordered collection that allows duplicates.**  
✔ **Common implementations:** `ArrayList`, `LinkedList`, `Vector`, `Stack`.  
✔ **Best choice depends on use case** (`ArrayList` for fast access, `LinkedList` for modifications).  
✔ **Provides powerful methods for indexed access, searching, and iteration.**  
✔ **Not thread-safe** by default; use `Vector` or synchronization for concurrency.  

---
