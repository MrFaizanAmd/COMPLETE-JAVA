# 📌 Java LinkedList Methods - A Complete Guide

## 🔥 Introduction

The `LinkedList` class in Java is a **doubly linked list implementation** of the `List` and `Deque` interfaces. Unlike `ArrayList`, where elements are stored in a **dynamic array**, `LinkedList` stores elements in **nodes** containing data and references to the previous and next elements.

In this guide, we will explore **all built-in methods** of `LinkedList`, their use cases, practical examples, and time complexity. Let's dive in! 🚀

---

## 🏗 LinkedList Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── List
│   │   ├── AbstractSequentialList
│   │   │   ├── LinkedList
│   ├── Queue
│   │   ├── Deque
│   │   │   ├── LinkedList
```

- `LinkedList` implements both `List` and `Deque`, making it usable as a **list, queue, or stack**.
- It provides **efficient insertions and deletions** but **slower random access** compared to `ArrayList`.



---

## **1️⃣ Basic Methods (from List Interface)**  
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `boolean add(E e)` | Adds element at the end | **O(1)** |
| `void add(int index, E element)` | Inserts element at a specific index | **O(n)** |
| `E get(int index)` | Returns the element at the given index | **O(n)** |
| `E set(int index, E element)` | Replaces an element at the given index | **O(n)** |
| `E remove(int index)` | Removes and returns element at the given index | **O(n)** |
| `boolean remove(Object o)` | Removes the first occurrence of the specified element | **O(n)** |
| `boolean contains(Object o)` | Checks if the element exists in the list | **O(n)** |
| `int indexOf(Object o)` | Returns the index of the first occurrence of an element | **O(n)** |
| `int lastIndexOf(Object o)` | Returns the index of the last occurrence of an element | **O(n)** |
| `boolean isEmpty()` | Checks if the list is empty | **O(1)** |
| `int size()` | Returns the number of elements in the list | **O(1)** |
| `void clear()` | Removes all elements from the list | **O(1)** |
| `Object[] toArray()` | Converts the LinkedList to an array | **O(n)** |
| `<T> T[] toArray(T[] a)` | Returns an array containing elements in proper order | **O(n)** |

### 📝 **Example**
```java
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.add(1, "B");
System.out.println(list.get(0));  // Output: A
System.out.println(list.contains("B")); // Output: true
```

---

## **2️⃣ Methods from Deque (Double-ended Queue) Interface**  
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `void addFirst(E e)` | Adds element at the beginning | **O(1)** |
| `void addLast(E e)` | Adds element at the end | **O(1)** |
| `E getFirst()` | Returns the first element without removing it | **O(1)** |
| `E getLast()` | Returns the last element without removing it | **O(1)** |
| `E removeFirst()` | Removes and returns the first element | **O(1)** |
| `E removeLast()` | Removes and returns the last element | **O(1)** |
| `E peekFirst()` | Returns the first element without removal | **O(1)** |
| `E peekLast()` | Returns the last element without removal | **O(1)** |
| `boolean offerFirst(E e)` | Inserts element at the front | **O(1)** |
| `boolean offerLast(E e)` | Inserts element at the end | **O(1)** |
| `E pollFirst()` | Retrieves and removes the first element | **O(1)** |
| `E pollLast()` | Retrieves and removes the last element | **O(1)** |

### 📝 **Example**
```java
LinkedList<Integer> list = new LinkedList<>();
list.addFirst(1);
list.addLast(2);
System.out.println(list.getFirst()); // Output: 1
System.out.println(list.getLast());  // Output: 2
```

---

## **3️⃣ Queue Methods (FIFO Operations)**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `boolean offer(E e)` | Inserts the element at the end of the queue | **O(1)** |
| `E poll()` | Retrieves and removes the first element | **O(1)** |
| `E peek()` | Retrieves but does not remove the first element | **O(1)** |

### 📝 **Example**
```java
LinkedList<String> queue = new LinkedList<>();
queue.offer("Apple");
queue.offer("Banana");
System.out.println(queue.poll()); // Output: Apple
System.out.println(queue.peek()); // Output: Banana
```

---

## **4️⃣ Stack Methods (LIFO Operations)**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `void push(E e)` | Adds an element at the beginning (like stack `push()`) | **O(1)** |
| `E pop()` | Removes and returns the first element (like stack `pop()`) | **O(1)** |

### 📝 **Example**
```java
LinkedList<Integer> stack = new LinkedList<>();
stack.push(100);
stack.push(200);
System.out.println(stack.pop());  // Output: 200
System.out.println(stack.peek()); // Output: 100
```

---

## **5️⃣ Iteration Methods**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `Iterator<E> iterator()` | Returns an iterator for the list | **O(1)** |
| `ListIterator<E> listIterator()` | Returns a list iterator for traversal | **O(1)** |
| `ListIterator<E> listIterator(int index)` | Returns an iterator starting from a given index | **O(1)** |
| `DescendingIterator<E> descendingIterator()` | Returns an iterator that traverses in reverse order | **O(1)** |

### 📝 **Example**
```java
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.add("B");
list.add("C");

Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```
📌 **Output:**  
```
A  
B  
C  
```

---

## **6️⃣ Additional Methods**
| Method | Description | Time Complexity |
|--------|------------|----------------|
| `boolean retainAll(Collection<?> c)` | Retains only elements in the given collection | **O(n)** |
| `boolean removeAll(Collection<?> c)` | Removes all elements from the given collection | **O(n)** |
| `boolean containsAll(Collection<?> c)` | Checks if all elements exist in the list | **O(n)** |
| `LinkedList<E> clone()` | Returns a shallow copy of the list | **O(n)** |

### 📝 **Example**
```java
LinkedList<String> list1 = new LinkedList<>();
list1.add("X");
list1.add("Y");

LinkedList<String> list2 = (LinkedList<String>) list1.clone();
System.out.println(list2);  // Output: [X, Y]
```

---

## **📌 Summary of Method Categories**
1. **Basic Operations:** `add()`, `get()`, `set()`, `remove()`, `contains()`, `clear()`
2. **Deque (Double-ended Queue):** `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()`
3. **Queue Operations:** `offer()`, `poll()`, `peek()`
4. **Stack Operations:** `push()`, `pop()`
5. **Iteration:** `iterator()`, `listIterator()`, `descendingIterator()`
6. **Bulk Operations:** `removeAll()`, `retainAll()`, `clone()`

---



## 🛠 Commonly Used LinkedList Methods

### 1️⃣ **add(E e)** – Add an element to the end

- **Appends an element at the end of the list**.
- **Time Complexity:** O(1)

```java
LinkedList<String> list = new LinkedList<>();
list.add("Apple");
list.add("Banana");
System.out.println(list); // Output: [Apple, Banana]
```

### 2️⃣ **add(int index, E element)** – Insert at a specific index

- **Inserts an element at the specified index**.
- **Time Complexity:** O(n) (traversal required)

```java
list.add(1, "Mango");
System.out.println(list); // Output: [Apple, Mango, Banana]
```

### 3️⃣ **get(int index)** – Retrieve an element

- **Gets the element at the specified index**.
- **Time Complexity:** O(n)

```java
String fruit = list.get(1);
System.out.println(fruit); // Output: Mango
```

### 4️⃣ **set(int index, E element)** – Update an element

- **Modifies an existing element at the given index**.
- **Time Complexity:** O(n)

```java
list.set(1, "Orange");
System.out.println(list); // Output: [Apple, Orange, Banana]
```

### 5️⃣ **remove(int index)** – Remove an element by index

- **Deletes an element at the specified index**.
- **Time Complexity:** O(n)

```java
list.remove(2);
System.out.println(list); // Output: [Apple, Orange]
```

### 6️⃣ **remove(Object o)** – Remove by value

- **Removes the first occurrence of the specified element**.
- **Time Complexity:** O(n)

```java
list.remove("Orange");
System.out.println(list); // Output: [Apple]
```

### 7️⃣ **size()** – Get the number of elements

- **Returns the total number of elements in the list**.
- **Time Complexity:** O(1)

```java
System.out.println(list.size()); // Output: 1
```

### 8️⃣ **clear()** – Remove all elements

- **Clears all elements in the list**.
- **Time Complexity:** O(1)

```java
list.clear();
System.out.println(list); // Output: []
```

### 9️⃣ **contains(Object o)** – Check if an element exists

- **Returns `true` if the element exists, otherwise `false`**.
- **Time Complexity:** O(n)

```java
System.out.println(list.contains("Apple")); // Output: false
```

### 🔟 **peekFirst() / peekLast()** – Retrieve first/last element without removal

- **Returns the first or last element without removing it**.
- **Time Complexity:** O(1)

```java
System.out.println(list.peekFirst());
System.out.println(list.peekLast());
```

### 1️⃣1️⃣ **pollFirst() / pollLast()** – Retrieve and remove first/last element

- **Removes and returns the first or last element**.
- **Time Complexity:** O(1)

```java
System.out.println(list.pollFirst());
System.out.println(list.pollLast());
```

### 1️⃣2️⃣ **isEmpty()** – Check if the list is empty

- **Returns `true` if the list contains no elements**.
- **Time Complexity:** O(1)

```java
System.out.println(list.isEmpty()); // Output: false
```

### 1️⃣3️⃣ **toArray()** – Convert to array

- **Converts `LinkedList` to an array**.
- **Time Complexity:** O(n)

```java
Object[] arr = list.toArray();
System.out.println(Arrays.toString(arr));
```

### 1️⃣4️⃣ **descendingIterator()** – Iterate in reverse order

- **Returns an iterator that iterates in reverse order**.
- **Time Complexity:** O(n)

```java
Iterator<String> iterator = list.descendingIterator();
while(iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

## ❓ FAQs

1️⃣ **When should I use `LinkedList` instead of `ArrayList`?**
   - Use **`LinkedList`** when frequent **insertions and deletions** are needed.
   - Use **`ArrayList`** when **fast random access** is required.

2️⃣ **Why is `LinkedList` slower for random access?**
   - Because elements are stored as nodes, and traversal is required to access an index.

3️⃣ **Is `LinkedList` thread-safe?**
   - No, it is **not synchronized**. Use `Collections.synchronizedList()` for thread safety.

---

## 📚 Additional Resources
- [Official Java Docs - LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)

Happy Coding! 🚀🎯

