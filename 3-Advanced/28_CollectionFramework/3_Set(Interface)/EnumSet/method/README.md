# 📌 **EnumSet Methods - A Complete Guide**  

## 🔥 **Introduction**  

`EnumSet<E extends Enum<E>>` is a specialized `Set` implementation designed **exclusively for enum types**. Unlike general-purpose `Set` implementations such as `HashSet` or `TreeSet`, `EnumSet` is:  

✅ **Highly optimized** → Uses a bit-vector for storage instead of hashing  
✅ **Ordered** → Maintains elements in their natural order (enum declaration order)  
✅ **Memory efficient** → Stores elements compactly using bitwise operations  
✅ **Null-safe** → Does **not** allow `null` elements  

This guide covers **all built-in methods**, explanations, practical examples, real-life use cases, and performance considerations.  

---

## 🏗 **Class Hierarchy**  

```plaintext
Iterable
│
├── Collection
│   ├── Set
│   │   ├── AbstractSet
│   │   │   ├── EnumSet
```

- `EnumSet<E>` extends `AbstractSet<E>` and is optimized for **enum types only**.  
- It provides a more efficient alternative to `HashSet<E>` when working with enums.  

---

## ⭐ **Methods and Their Descriptions**  

| Method | Description |
|--------|------------|
| `allOf(Class<E> elementType)` | Creates an `EnumSet` containing all elements of the given enum type. |
| `noneOf(Class<E> elementType)` | Creates an empty `EnumSet` of the specified enum type. |
| `of(E first, E... rest)` | Creates an `EnumSet` with the given elements. |
| `range(E from, E to)` | Creates an `EnumSet` containing all elements in the specified range. |
| `copyOf(EnumSet<E> s)` | Creates a copy of the given `EnumSet`. |
| `copyOf(Collection<E> c)` | Creates an `EnumSet` from another collection. |
| `add(E e)` | Adds the specified element. |
| `addAll(Collection<? extends E> c)` | Adds all elements from the given collection. |
| `remove(E e)` | Removes the specified element. |
| `removeAll(Collection<?> c)` | Removes all elements found in the given collection. |
| `retainAll(Collection<?> c)` | Retains only elements that are present in the given collection. |
| `clear()` | Removes all elements. |
| `size()` | Returns the number of elements in the set. |
| `isEmpty()` | Checks if the set is empty. |
| `contains(E e)` | Checks if an element exists in the set. |
| `iterator()` | Returns an iterator for traversing the elements. |
| `toArray()` | Converts the `EnumSet` to an array. |

---

## ✅ **1. allOf(Class<E> elementType) - Create an EnumSet with All Elements**  
```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

EnumSet<Day> allDays = EnumSet.allOf(Day.class);
System.out.println(allDays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
```

---

## ✅ **2. noneOf(Class<E> elementType) - Create an Empty EnumSet**  
```java
EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
System.out.println(emptySet.isEmpty()); // Output: true
```

---

## ✅ **3. of(E first, E... rest) - Create an EnumSet with Specific Elements**  
```java
EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
System.out.println(weekend); // Output: [SATURDAY, SUNDAY]
```

---

## ✅ **4. range(E from, E to) - Create an EnumSet Within a Range**  
```java
EnumSet<Day> midWeek = EnumSet.range(Day.TUESDAY, Day.THURSDAY);
System.out.println(midWeek); // Output: [TUESDAY, WEDNESDAY, THURSDAY]
```

---

## ✅ **5. copyOf(EnumSet<E> s) - Copy an EnumSet**  
```java
EnumSet<Day> workingDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
EnumSet<Day> copySet = EnumSet.copyOf(workingDays);
System.out.println(copySet); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
```

---

## ✅ **6. copyOf(Collection<E> c) - Convert a Collection to an EnumSet**  
```java
List<Day> daysList = Arrays.asList(Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY);
EnumSet<Day> daySet = EnumSet.copyOf(daysList);
System.out.println(daySet); // Output: [MONDAY, WEDNESDAY, FRIDAY]
```

---

## ✅ **7. add(E e) - Add an Element**  
```java
EnumSet<Day> set = EnumSet.noneOf(Day.class);
set.add(Day.MONDAY);
System.out.println(set); // Output: [MONDAY]
```

---

## ✅ **8. addAll(Collection<? extends E> c) - Add Multiple Elements**  
```java
EnumSet<Day> set = EnumSet.noneOf(Day.class);
set.addAll(EnumSet.of(Day.TUESDAY, Day.THURSDAY));
System.out.println(set); // Output: [TUESDAY, THURSDAY]
```

---

## ✅ **9. remove(E e) - Remove an Element**  
```java
EnumSet<Day> set = EnumSet.allOf(Day.class);
set.remove(Day.SUNDAY);
System.out.println(set); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY]
```

---

## ✅ **10. removeAll(Collection<?> c) - Remove Multiple Elements**  
```java
EnumSet<Day> set = EnumSet.allOf(Day.class);
set.removeAll(EnumSet.of(Day.SATURDAY, Day.SUNDAY));
System.out.println(set); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
```

---

## ✅ **11. retainAll(Collection<?> c) - Retain Only Matching Elements**  
```java
EnumSet<Day> set = EnumSet.allOf(Day.class);
set.retainAll(EnumSet.of(Day.SATURDAY, Day.SUNDAY));
System.out.println(set); // Output: [SATURDAY, SUNDAY]
```

---

## ✅ **12. clear() - Remove All Elements**  
```java
EnumSet<Day> set = EnumSet.allOf(Day.class);
set.clear();
System.out.println(set.isEmpty()); // Output: true
```

---

## ✅ **13. contains(E e) - Check if an Element Exists**  
```java
EnumSet<Day> set = EnumSet.of(Day.MONDAY, Day.WEDNESDAY);
System.out.println(set.contains(Day.MONDAY)); // Output: true
System.out.println(set.contains(Day.SUNDAY)); // Output: false
```

---

## **3️⃣ Use Case Scenarios**  

✅ **Handling days of the week** → Efficiently storing selected days  
✅ **Managing state machines** → Keeping track of finite states  
✅ **Feature flags** → Using enums to toggle features  
✅ **Permission management** → Storing user roles and permissions  

---

## 📌 **Summary**  

1. `EnumSet` is a high-performance `Set` implementation **designed for enum types**.  
2. It provides methods like `allOf()`, `noneOf()`, `of()`, and `range()` for easy initialization.  
3. Unlike `HashSet`, it uses a **bit-vector representation** instead of hashing.  
4. Best suited for **enum-based operations** due to **fast iteration and memory efficiency**.  

---

## ❓ **FAQs**  

1️⃣ **Why use `EnumSet` instead of `HashSet`?**  
   - `EnumSet` is **faster** and **more memory-efficient** because it uses **bitwise operations** instead of hashing.  

2️⃣ **Can `EnumSet` store `null` values?**  
   - **No**, `EnumSet` **does not support `null`** elements.  

3️⃣ **Is `EnumSet` thread-safe?**  
   - No, `EnumSet` is **not synchronized** and must be wrapped using `Collections.synchronizedSet()` for thread safety.  

---

## 📚 **Additional Resources**  
- [Official Java Docs - EnumSet](https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html)  

🚀 **Happy Coding!** 🎯