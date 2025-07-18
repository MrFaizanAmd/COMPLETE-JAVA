# 📌 Java Vector Methods - A Complete Guide

## 🔥 Introduction

The `Vector` class in Java is a part of the Java Collection Framework and implements the **List interface**. It is similar to `ArrayList` but is **synchronized**, making it thread-safe.

In this guide, we will explore **all built-in methods** of `Vector`, their use cases, practical examples, and time complexity. Let's dive in! 🚀

---

## 🏗 Vector Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── List
│   │   ├── AbstractList
│   │   │   ├── Vector
│   │   │   │   ├── Stack
```

- `Vector` implements the **List** interface and extends `AbstractList`.
- `Stack` is a subclass of `Vector`, meaning `Vector` supports stack operations.
- `Vector` maintains an **ordered collection** and allows **duplicate elements**.
- Unlike `ArrayList`, it is **synchronized**, making it suitable for multi-threaded environments.

---

## **1️⃣ Basic Methods (from List Interface)**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `boolean add(E e)` | Adds element at the end | **O(1)** |
| `void add(int index, E element)` | Inserts element at a specific index | **O(n)** |
| `E get(int index)` | Returns the element at the given index | **O(1)** |
| `E set(int index, E element)` | Replaces an element at the given index | **O(1)** |
| `E remove(int index)` | Removes and returns element at the given index | **O(n)** |
| `boolean remove(Object o)` | Removes the first occurrence of the specified element | **O(n)** |
| `boolean contains(Object o)` | Checks if the element exists in the list | **O(n)** |
| `int indexOf(Object o)` | Returns the index of the first occurrence of an element | **O(n)** |
| `int lastIndexOf(Object o)` | Returns the index of the last occurrence of an element | **O(n)** |
| `boolean isEmpty()` | Checks if the list is empty | **O(1)** |
| `int size()` | Returns the number of elements in the list | **O(1)** |
| `void clear()` | Removes all elements from the list | **O(1)** |
| `Object[] toArray()` | Converts the Vector to an array | **O(n)** |

### 📝 **Example**
```java
Vector<String> vector = new Vector<>();
vector.add("A");
vector.add(1, "B");
System.out.println(vector.get(0));  // Output: A
System.out.println(vector.contains("B")); // Output: true
```

---

## **2️⃣ Capacity Management Methods**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `int capacity()` | Returns the current capacity of the vector | **O(1)** |
| `void ensureCapacity(int minCapacity)` | Increases the capacity if needed | **O(n)** |
| `void trimToSize()` | Reduces capacity to the current size | **O(n)** |

### 📝 **Example**
```java
Vector<Integer> vector = new Vector<>(5);
System.out.println(vector.capacity()); // Output: 5
vector.ensureCapacity(10);
System.out.println(vector.capacity()); // Output: 10
vector.trimToSize();
System.out.println(vector.capacity()); // Output: current size of the vector
```

---

## **3️⃣ Thread-Safety & Synchronization Methods**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `synchronized List<T> synchronizedList(List<T> list)` | Returns a synchronized list | **O(1)** |
| `void wait()` | Causes the current thread to wait | **O(1)** |
| `void notify()` | Wakes up a single waiting thread | **O(1)** |
| `void notifyAll()` | Wakes up all waiting threads | **O(1)** |

### 📝 **Example**
```java
List<String> syncList = Collections.synchronizedList(new Vector<>());
syncList.add("Thread-safe");
System.out.println(syncList.get(0));  // Output: Thread-safe
```

---

## **4️⃣ Iteration Methods**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `Iterator<E> iterator()` | Returns an iterator for the list | **O(1)** |
| `ListIterator<E> listIterator()` | Returns a list iterator for traversal | **O(1)** |

### 📝 **Example**
```java
Vector<String> vector = new Vector<>();
vector.add("One");
vector.add("Two");

Iterator<String> it = vector.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```
📌 **Output:**  
```
One  
Two  
```

---

## **📌 Summary of Method Categories**
1. **Basic Operations:** `add()`, `get()`, `set()`, `remove()`, `contains()`, `clear()`
2. **Capacity Management:** `capacity()`, `ensureCapacity()`, `trimToSize()`
3. **Thread-Safety:** `synchronizedList()`, `wait()`, `notify()`, `notifyAll()`
4. **Iteration:** `iterator()`, `listIterator()`

---

## ❓ FAQs

1️⃣ **When should I use `Vector` instead of `ArrayList`?**
   - Use **`Vector`** when thread safety is required.
   - Use **`ArrayList`** when performance is more important than synchronization.

2️⃣ **Why is `Vector` slower than `ArrayList`?**
   - Because all methods in `Vector` are synchronized, causing overhead in performance.

3️⃣ **Is `Vector` obsolete?**
   - While still used, `Vector` is largely replaced by `ArrayList` and `CopyOnWriteArrayList`.

---

## 📚 Additional Resources
- [Official Java Docs - Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)

Happy Coding! 🚀🎯

