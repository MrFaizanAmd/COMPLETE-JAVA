# NavigableMap Interface in Java

## Table of Contents
- [Introduction](#introduction)
- [Hierarchy](#hierarchy)
- [Key Features](#key-features)
- [Methods and Complexity](#methods-and-complexity)
- [Implementation Classes](#implementation-classes)
- [Example Usage](#example-usage)
- [Common Interview Questions](#common-interview-questions)
- [FAQs](#faqs)
- [References](#references)

## Introduction
`NavigableMap` is an extension of the `SortedMap` interface that provides navigation methods for searching, retrieving, and iterating over a sorted map. It allows finding key-value pairs closest to a given key in terms of ordering.

**Key Characteristics:**
- Maintains keys in a sorted order (natural or custom comparator).
- Provides methods to find lower, higher, floor, and ceiling keys efficiently.
- Supports bidirectional navigation.
- Allows sub-maps within a given range.

## Hierarchy
```
Map [Interface]
│
├── SortedMap [Interface]
│   ├── NavigableMap [Interface]
│   │   ├── TreeMap ✅ (Most Common Implementation)
│   │   ├── ConcurrentSkipListMap (Thread-Safe Implementation)
│   │   └── ConcurrentNavigableMap [Interface]
```

## Key Features
- **Navigation Methods:** Retrieve keys lower, higher, ceiling, or floor relative to a given key.
- **Descending Order Views:** Allows descending iteration over key-value pairs.
- **Submaps:** Supports headMap, tailMap, and subMap with flexible inclusions.
- **Thread Safety:** `ConcurrentSkipListMap` provides a concurrent implementation.

## Methods and Complexity

| Method | Description | Time Complexity |
|--------|-------------|----------------|
| `lowerKey(K key)` | Returns greatest key < given key | O(log N) |
| `floorKey(K key)` | Returns greatest key ≤ given key | O(log N) |
| `ceilingKey(K key)` | Returns least key ≥ given key | O(log N) |
| `higherKey(K key)` | Returns least key > given key | O(log N) |
| `pollFirstEntry()` | Removes and returns first entry | O(log N) |
| `pollLastEntry()` | Removes and returns last entry | O(log N) |
| `descendingMap()` | Returns a reversed-order view | O(1) |
| `subMap(K fromKey, K toKey)` | Returns a sub-map view | O(1) |

## Implementation Classes

### 1. **TreeMap**
- Implements `NavigableMap` with a Red-Black Tree.
- Keys are sorted based on natural ordering or a custom comparator.
- **Not thread-safe** but can be synchronized externally.

### 2. **ConcurrentSkipListMap**
- Implements `NavigableMap` in a thread-safe manner using Skip Lists.
- Ideal for concurrent applications requiring sorted maps.
- Provides scalable concurrent access.

## Example Usage
```java
import java.util.*;

public class NavigableMapExample {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Apple");
        map.put(20, "Banana");
        map.put(30, "Cherry");
        map.put(40, "Date");

        System.out.println("Ceiling Key (25): " + map.ceilingKey(25)); // Output: 30
        System.out.println("Floor Key (25): " + map.floorKey(25)); // Output: 20
        System.out.println("Descending Map: " + map.descendingMap());
    }
}
```

## Common Interview Questions
1. **What is the difference between `SortedMap` and `NavigableMap`?**
   - `SortedMap` only guarantees sorted keys, while `NavigableMap` provides additional navigation methods like `ceilingKey()` and `floorKey()`.
2. **How does `TreeMap` maintain its sorting order?**
   - It uses a Red-Black tree, ensuring O(log N) time complexity for operations.
3. **Which `NavigableMap` implementation is thread-safe?**
   - `ConcurrentSkipListMap` is thread-safe, unlike `TreeMap`.

## FAQs
**Q: Can I use `NavigableMap` with custom objects?**
Yes, but you need to implement `Comparable<T>` or provide a custom `Comparator<T>`.

**Q: How do I iterate over a `NavigableMap` in descending order?**
Use `descendingMap()` or `descendingKeySet()`.

## References
- [Oracle Java Docs - NavigableMap](https://docs.oracle.com/javase/8/docs/api/java/util/NavigableMap.html)
- [TreeMap Source Code](https://hg.openjdk.org/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/TreeMap.java)

---

### 📂 [Practice Files](./practice/NavigableMap/)
Contains hands-on Java programs for `NavigableMap` concepts.

---

