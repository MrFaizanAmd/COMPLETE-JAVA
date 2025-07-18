# 📌 Java AbstractSet Methods - A Complete Guide

## 🔥 Introduction

`AbstractSet<E>` is a skeletal implementation of the `Set` interface, designed to minimize the effort required to implement a set. It provides default implementations for several methods while leaving abstract methods for customization.

This guide covers **all built-in methods**, explanations, practical examples, real-life use cases, and performance considerations.

---

## 🏗 Class Hierarchy

```plaintext
Iterable
│
├── Collection
│   ├── Set
│   │   ├── AbstractSet
```

- `AbstractSet<E>` extends `AbstractCollection<E>` and implements `Set<E>`.

---

## ⭐ Methods and Their Descriptions

### ✅ **1. size() - Get Number of Elements**
```java
@Override
public abstract int size();
```
- Returns the number of elements in the set.

**Example:**
```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
System.out.println(set.size()); // Output: 2
```

---
### ✅ **2. isEmpty() - Check if Set is Empty**
```java
@Override
public boolean isEmpty() {
    return size() == 0;
}
```
- Returns `true` if the set is empty, `false` otherwise.

**Example:**
```java
Set<Integer> set = new HashSet<>();
System.out.println(set.isEmpty()); // Output: true
set.add(5);
System.out.println(set.isEmpty()); // Output: false
```

---
### ✅ **3. contains(Object o) - Check if Element Exists**
```java
@Override
public abstract boolean contains(Object o);
```
- Checks if the set contains the specified element.

**Example:**
```java
Set<String> set = new HashSet<>();
set.add("Java");
System.out.println(set.contains("Java")); // Output: true
System.out.println(set.contains("Python")); // Output: false
```

---
### ✅ **4. iterator() - Iterate Over Elements**
```java
@Override
public abstract Iterator<E> iterator();
```
- Returns an iterator to traverse the elements in the set.

**Example:**
```java
Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
Iterator<Integer> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---
### ✅ **5. toArray() - Convert Set to Array**
```java
@Override
public Object[] toArray() {
    Object[] array = new Object[size()];
    int index = 0;
    for (E e : this) {
        array[index++] = e;
    }
    return array;
}
```
- Converts the set into an array.

**Example:**
```java
Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
Object[] arr = set.toArray();
System.out.println(Arrays.toString(arr)); // Output: [A, B, C]
```

---
### ✅ **6. addAll(Collection<? extends E> c) - Add All Elements**
```java
@Override
public boolean addAll(Collection<? extends E> c) {
    boolean modified = false;
    for (E e : c) {
        if (add(e)) {
            modified = true;
        }
    }
    return modified;
}
```
- Adds all elements from a collection to the set.

**Example:**
```java
Set<Integer> set = new HashSet<>();
set.addAll(Arrays.asList(1, 2, 3));
System.out.println(set); // Output: [1, 2, 3]
```

---
### ✅ **7. remove(Object o) - Remove an Element**
```java
@Override
public abstract boolean remove(Object o);
```
- Removes the specified element from the set.

**Example:**
```java
Set<String> set = new HashSet<>(Arrays.asList("A", "B"));
set.remove("A");
System.out.println(set); // Output: [B]
```

---
### ✅ **8. removeAll(Collection<?> c) - Remove Multiple Elements**
```java
@Override
public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    for (Object e : c) {
        if (remove(e)) {
            modified = true;
        }
    }
    return modified;
}
```
- Removes all elements in the specified collection.

**Example:**
```java
Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
set.removeAll(Arrays.asList(2, 3));
System.out.println(set); // Output: [1, 4]
```

---
### ✅ **9. retainAll(Collection<?> c) - Retain Only Matching Elements**
```java
@Override
public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    Iterator<E> it = iterator();
    while (it.hasNext()) {
        if (!c.contains(it.next())) {
            it.remove();
            modified = true;
        }
    }
    return modified;
}
```
- Keeps only elements that are in the specified collection.

**Example:**
```java
Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
set.retainAll(Arrays.asList(2, 3));
System.out.println(set); // Output: [2, 3]
```

---
### ✅ **10. clear() - Remove All Elements**
```java
@Override
public void clear() {
    iterator().forEachRemaining(this::remove);
}
```
- Removes all elements from the set.

**Example:**
```java
Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C"));
set.clear();
System.out.println(set.isEmpty()); // Output: true
```



## **3️⃣ Use Case Scenarios**

✅ **Unique Element Storage** → Ensures only distinct elements are stored.

✅ **Efficient Lookup Operations** → Quick element presence checks.

✅ **Mathematical Set Operations** → Supports union, intersection, and difference.

✅ **Parallel Processing** → Utilizes `Spliterator` for parallel iteration.

---

## **📌 Summary**

1. `add()`, `remove()`, `contains()` → Core set operations.
2. `iterator()`, `spliterator()` → Efficient element iteration.
3. `size()`, `clear()` → Manage set elements.
4. `hashCode()`, `equals()` → Hash-based comparisons.

---

## ❓ FAQs

1️⃣ **What is the main purpose of `AbstractSet`?**
   - It provides a skeletal implementation of `Set` to simplify custom set creation.

2️⃣ **How does `AbstractSet` differ from `AbstractCollection`?**
   - `AbstractSet` overrides `equals()` and `hashCode()` to enforce set semantics.

3️⃣ **Can we instantiate `AbstractSet` directly?**
   - No, it must be subclassed.

---

## 📚 Additional Resources
- [Official Java Docs - AbstractSet](https://docs.oracle.com/en/java/javase/8/docs/api/java/util/AbstractSet.html)

🚀 Happy Coding! 🎯


