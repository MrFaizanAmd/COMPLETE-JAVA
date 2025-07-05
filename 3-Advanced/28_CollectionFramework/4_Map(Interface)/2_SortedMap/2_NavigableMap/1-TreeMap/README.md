# TreeMap in Java

## Overview
`TreeMap` is a part of Java's `java.util` package and implements the `NavigableMap` and `SortedMap` interfaces. It is a map implementation that maintains key-value pairs in sorted order based on the natural ordering of keys or a custom comparator.

## Key Features
- **Sorted Order**: Maintains ascending key order by default.
- **Self-Balancing**: Uses a Red-Black tree structure to maintain order.
- **Logarithmic Time Complexity**: Basic operations like `put()`, `get()`, `remove()` have O(log n) time complexity.
- **Allows Null Values**: But does not allow `null` keys.
- **Not Synchronized**: Needs external synchronization for thread safety.

---

## TreeMap Hierarchy
```
Map [Interface]
│
├── SortedMap [Interface]
│   └── NavigableMap [Interface]
│       └── TreeMap
```

---

## Declaration
```java
TreeMap<K, V> map = new TreeMap<>();
```

---
### **How `TreeMap` Works Internally**  

`TreeMap` in Java is implemented using a **Red-Black Tree**, a self-balancing binary search tree. Here’s a step-by-step breakdown of how it works internally:  

#### **1. Data Structure Used**  
- `TreeMap` is based on **Red-Black Tree**, which ensures that all operations (insertion, deletion, and search) take **O(log N) time complexity**.
- It maintains **key-value pairs in sorted order** according to the natural ordering of keys or a custom comparator.

#### **2. Nodes in `TreeMap`**
Each entry in `TreeMap` is stored as a node in the Red-Black tree. The nodes contain:  
- **Key**
- **Value**
- **Pointers to left and right children**
- **Color (Red or Black) for balancing the tree**

#### **3. Insertion Process**
- When inserting a key-value pair, `TreeMap` first performs a **binary search** to find the correct position.
- The key is inserted as a new node.
- The Red-Black Tree properties are checked and maintained, ensuring the tree remains balanced.

#### **4. Searching in `TreeMap`**
- The search operation is performed using **binary search**, starting from the root.
- If the key matches, the corresponding value is returned.
- Otherwise, it navigates left or right depending on whether the key is smaller or greater than the current node.

#### **5. Deletion Process**
- The node with the key to be deleted is first found.
- Depending on the node’s children, deletion is performed:
  - If the node has **no children**, it is simply removed.
  - If the node has **one child**, it is replaced by the child.
  - If the node has **two children**, the **in-order successor** (smallest key in the right subtree) is found and swapped with the node.
- The Red-Black Tree properties are then maintained to ensure balance.

#### **6. Tree Balancing & Recoloring**
After insertion or deletion, the Red-Black Tree may become unbalanced. To restore balance, `TreeMap` performs:  
1. **Recoloring:** Changing the color of nodes to maintain properties.  
2. **Rotations (Left/Right):** Swapping nodes to maintain balance.  

#### **7. Sorting Mechanism**
- `TreeMap` always maintains elements in **sorted order** based on:
  - **Natural ordering** (`Comparable` interface)
  - **Custom ordering** (if a `Comparator` is provided in the constructor)

---

## Constructor Variants
| Constructor | Description |
|------------|-------------|
| `TreeMap()` | Creates an empty `TreeMap` that sorts based on natural ordering of keys. |
| `TreeMap(Comparator<? super K> comparator)` | Creates a `TreeMap` with a custom comparator for key ordering. |
| `TreeMap(Map<? extends K, ? extends V> m)` | Initializes a `TreeMap` with the mappings from another `Map`. |
| `TreeMap(SortedMap<K, ? extends V> m)` | Initializes a `TreeMap` with the mappings from another `SortedMap`. |

---

## Commonly Used Methods
| Method | Description | Time Complexity |
|--------|-------------|----------------|
| `put(K key, V value)` | Adds a key-value pair to the map. | O(log n) |
| `get(Object key)` | Retrieves the value associated with the given key. | O(log n) |
| `remove(Object key)` | Removes the mapping for the specified key. | O(log n) |
| `containsKey(Object key)` | Checks if the map contains the given key. | O(log n) |
| `containsValue(Object value)` | Checks if the map contains the given value. | O(n) |
| `firstKey()` | Returns the first (lowest) key in the map. | O(log n) |
| `lastKey()` | Returns the last (highest) key in the map. | O(log n) |
| `higherKey(K key)` | Returns the least key strictly greater than the given key. | O(log n) |
| `lowerKey(K key)` | Returns the greatest key strictly less than the given key. | O(log n) |
| `pollFirstEntry()` | Removes and returns the first entry. | O(log n) |
| `pollLastEntry()` | Removes and returns the last entry. | O(log n) |

---

## Code Examples
### 1. Basic TreeMap Example
```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(5, "Five");
        
        System.out.println("TreeMap: " + treeMap); // {1=One, 2=Two, 3=Three, 5=Five}
    }
}
```

### 2. Custom Comparator Example
```java
import java.util.*;

public class CustomComparatorTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> reverseOrderMap = new TreeMap<>(Collections.reverseOrder());
        
        reverseOrderMap.put(1, "One");
        reverseOrderMap.put(3, "Three");
        reverseOrderMap.put(2, "Two");
        
        System.out.println("Reverse Order TreeMap: " + reverseOrderMap);
    }
}
```

---

## Differences: `TreeMap` vs `HashMap` vs `LinkedHashMap`
| Feature | TreeMap | HashMap | LinkedHashMap |
|---------|--------|---------|--------------|
| Ordering | Sorted (Ascending) | No Order | Insertion Order |
| Implementation | Red-Black Tree | Hash Table | Hash Table + Linked List |
| Performance (Put/Get) | O(log n) | O(1) | O(1) |
| Allows `null` keys | ❌ No | ✅ Yes | ✅ Yes |
| Thread-Safe | ❌ No | ❌ No | ❌ No |

---

## When to Use `TreeMap`?
- When **sorted order** of keys is required.
- When **range-based operations** are needed (`subMap()`, `headMap()`, `tailMap()`).
- When **navigation methods** (`higherKey()`, `lowerKey()`) are useful.

---

## Frequently Asked Questions (FAQs)
### 1. Why is `TreeMap` slower than `HashMap`?
`TreeMap` uses a Red-Black tree, requiring O(log n) operations compared to `HashMap`'s O(1) average-case complexity.

### 2. Can `TreeMap` store `null` keys?
No, `TreeMap` does **not** allow `null` keys but allows multiple `null` values.

### 3. Is `TreeMap` thread-safe?
No, `TreeMap` is **not** synchronized. Use `Collections.synchronizedSortedMap(new TreeMap<>())` for thread safety.

### 4. How does `TreeMap` compare keys for sorting?
By default, `TreeMap` uses `Comparable` (natural ordering). A `Comparator` can be provided for custom ordering.

---

## Additional Resources
- [Java Official Docs: TreeMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/TreeMap.html)
- [Baeldung Guide on TreeMap](https://www.baeldung.com/java-treemap)

---

## Hands-on Practice
🔗 [Practice Files in this Repository](./practice/treemap/)

---

## Conclusion
`TreeMap` is a powerful implementation of `NavigableMap` that maintains sorted key order and allows efficient range queries. While it is slower than `HashMap`, it is useful when sorting is essential. Consider using `TreeMap` when you need a **sorted, self-balancing, and navigable** map structure in Java.

