# SortedMap Interface in Java

## Introduction
The `SortedMap` interface in Java is a specialized `Map` that maintains its keys in a sorted order. It extends the `Map` interface and ensures that keys are stored in their natural order (ascending) or based on a specified comparator.

`SortedMap` is part of the `java.util` package and is commonly implemented by `TreeMap`. It is particularly useful when an ordered collection of key-value pairs is required.

## Hierarchy of SortedMap
```
Map [Interface]
│
├── SortedMap [Interface]
│   ├── NavigableMap [Interface]
│   │   ├── TreeMap [Class] ✅ (Most common implementation)
│   │   ├── ConcurrentSkipListMap [Class]
```

## Key Characteristics of SortedMap
- **Ordered Keys**: Maintains the keys in sorted order.
- **No Duplicate Keys**: Like all `Map` implementations, it does not allow duplicate keys.
- **Efficient Lookup**: Provides fast retrieval of the first, last, or a subset of keys.
- **Natural or Custom Sorting**: Uses natural ordering of keys (`Comparable<T>`) or a custom comparator (`Comparator<T>`).

## Commonly Used Methods

| Method | Description |
|--------|-------------|
| `Comparator<? super K> comparator()` | Returns the comparator used for sorting keys, or `null` if natural ordering is used. |
| `K firstKey()` | Retrieves the first (lowest) key in the map. |
| `K lastKey()` | Retrieves the last (highest) key in the map. |
| `SortedMap<K, V> headMap(K toKey)` | Returns a view of the portion of this map whose keys are strictly less than `toKey`. |
| `SortedMap<K, V> tailMap(K fromKey)` | Returns a view of the portion of this map whose keys are greater than or equal to `fromKey`. |
| `SortedMap<K, V> subMap(K fromKey, K toKey)` | Returns a view of the portion of this map whose keys range from `fromKey` (inclusive) to `toKey` (exclusive). |

## Implementation Example: TreeMap
```java
import java.util.*;

public class SortedMapExample {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(3, "Apple");
        sortedMap.put(1, "Banana");
        sortedMap.put(2, "Cherry");
        sortedMap.put(5, "Date");
        sortedMap.put(4, "Elderberry");

        System.out.println("Sorted Map: " + sortedMap);
        System.out.println("First Key: " + sortedMap.firstKey());
        System.out.println("Last Key: " + sortedMap.lastKey());
        System.out.println("Head Map (Keys < 3): " + sortedMap.headMap(3));
        System.out.println("Tail Map (Keys >= 3): " + sortedMap.tailMap(3));
    }
}
```
### Output:
```
Sorted Map: {1=Banana, 2=Cherry, 3=Apple, 4=Elderberry, 5=Date}
First Key: 1
Last Key: 5
Head Map (Keys < 3): {1=Banana, 2=Cherry}
Tail Map (Keys >= 3): {3=Apple, 4=Elderberry, 5=Date}
```

## When to Use SortedMap?
- When you need **sorted key-value storage**.
- When **range queries** are required (e.g., headMap, tailMap, subMap).
- When performing **sorted iteration** over keys.
- When ordering of elements must be preserved for predictable behavior.

## Differences Between SortedMap and HashMap
| Feature | SortedMap | HashMap |
|---------|----------|---------|
| Ordering | Keys are sorted | No ordering guarantee |
| Performance | O(log n) for put/get/remove (TreeMap) | O(1) for put/get/remove (HashMap) |
| Implementations | TreeMap, ConcurrentSkipListMap | HashMap, LinkedHashMap, WeakHashMap |
| Use Case | Ordered key storage & range queries | Fast lookups with no order |

## FAQs
### 1. How does `SortedMap` maintain ordering?
It maintains ordering by using a **self-balancing binary search tree (TreeMap)** or **skip lists (ConcurrentSkipListMap)**.

### 2. Can we use `null` keys in `SortedMap`?
- `TreeMap` does **not** allow `null` keys if it uses natural ordering.
- It allows `null` keys only if a custom comparator is used that supports `null` values.
- `ConcurrentSkipListMap` does **not** allow `null` keys.

### 3. Which is faster, `HashMap` or `SortedMap`?
- `HashMap` is faster (O(1) for operations).
- `SortedMap` (TreeMap) has O(log n) time complexity due to its tree structure.

### 4. Can I use a custom comparator in `SortedMap`?
Yes, you can pass a `Comparator` while creating a `TreeMap`.
```java
SortedMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
```

## Further Reading
- [Java Documentation: SortedMap](https://docs.oracle.com/javase/8/docs/api/java/util/SortedMap.html)
- [TreeMap in Java](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)

## Hands-On Practice
Check out the [SortedMap Practice Folder](./sortedmap-examples) for more code examples and exercises.

---
This guide should help you understand and effectively use `SortedMap` in Java! 🚀

