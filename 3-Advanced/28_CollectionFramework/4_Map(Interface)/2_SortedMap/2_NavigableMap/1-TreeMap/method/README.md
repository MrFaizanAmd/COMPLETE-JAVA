# 📌 **Java TreeMap – A Complete Reference Guide**  

## 🔥 **Introduction**  
`TreeMap<K, V>` is a **sorted map** implementation in Java based on a **Red-Black Tree**.  
It maintains **natural ordering** of keys (or a custom comparator) and provides **logarithmic time complexity** for key-based operations.

This guide covers **all methods**, **time complexity analysis**, and examples.

---

## 🏗 **Class Hierarchy**
```plaintext
Iterable
│
├── Collection
│   ├── Map
│   │   ├── SortedMap
│   │   │   ├── NavigableMap
│   │   │   │   ├── TreeMap
```
- **Implements `NavigableMap<K, V>`, `SortedMap<K, V>`, and `Map<K, V>`**.
- Uses a **Red-Black Tree** for ordering.
- **Not synchronized** (use `Collections.synchronizedMap()` if needed).
---

## **TreeMap Example Code for Each Method**

### **1. put(K key, V value) – Insert Key-Value Pair**
```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println(map); // Output: {1=One, 2=Two, 3=Three}
    }
}
```

---

### **2. get(Object key) – Retrieve Value**
```java
System.out.println(map.get(2)); // Output: Two
System.out.println(map.get(5)); // Output: null (Key not found)
```

---

### **3. remove(Object key) – Remove a Key-Value Pair**
```java
map.remove(2);
System.out.println(map); // Output: {1=One, 3=Three}
```

---

### **4. containsKey(Object key) – Check if a Key Exists**
```java
System.out.println(map.containsKey(1)); // Output: true
System.out.println(map.containsKey(5)); // Output: false
```

---

### **5. containsValue(Object value) – Check if a Value Exists**
```java
System.out.println(map.containsValue("Three")); // Output: true
System.out.println(map.containsValue("Five")); // Output: false
```

---

### **6. size() – Get Number of Elements**
```java
System.out.println(map.size()); // Output: 2
```

---

### **7. isEmpty() – Check if the Map is Empty**
```java
System.out.println(map.isEmpty()); // Output: false
map.clear();
System.out.println(map.isEmpty()); // Output: true
```

---

### **8. clear() – Remove All Entries**
```java
map.clear();
System.out.println(map); // Output: {}
```

---

### **9. firstKey() – Get First (Smallest) Key**
```java
map.put(5, "Five");
map.put(3, "Three");
System.out.println(map.firstKey()); // Output: 3
```

---

### **10. lastKey() – Get Last (Largest) Key**
```java
System.out.println(map.lastKey()); // Output: 5
```

---

### **11. firstEntry() – Get First Key-Value Pair**
```java
System.out.println(map.firstEntry()); // Output: 3=Three
```

---

### **12. lastEntry() – Get Last Key-Value Pair**
```java
System.out.println(map.lastEntry()); // Output: 5=Five
```

---

### **13. higherKey(K key) – Get Key Greater than Given Key**
```java
System.out.println(map.higherKey(3)); // Output: 5
System.out.println(map.higherKey(5)); // Output: null
```

---

### **14. lowerKey(K key) – Get Key Less than Given Key**
```java
System.out.println(map.lowerKey(5)); // Output: 3
```

---

### **15. ceilingKey(K key) – Get Smallest Key >= Given Key**
```java
System.out.println(map.ceilingKey(4)); // Output: 5
```

---

### **16. floorKey(K key) – Get Largest Key <= Given Key**
```java
System.out.println(map.floorKey(4)); // Output: 3
```

---

### **17. headMap(K toKey) – Get Entries < `toKey`**
```java
System.out.println(map.headMap(5)); // Output: {3=Three}
```

---

### **18. tailMap(K fromKey) – Get Entries >= `fromKey`**
```java
System.out.println(map.tailMap(3)); // Output: {3=Three, 5=Five}
```

---

### **19. subMap(K fromKey, K toKey) – Get Entries Between `fromKey` and `toKey`**
```java
System.out.println(map.subMap(3, 5)); // Output: {3=Three}
```

---

### **20. descendingKeySet() – Get Keys in Descending Order**
```java
System.out.println(map.descendingKeySet()); // Output: [5, 3]
```

---

### **21. descendingMap() – Get Entries in Reverse Order**
```java
System.out.println(map.descendingMap()); // Output: {5=Five, 3=Three}
```

---

### **22. keySet() – Get All Keys**
```java
System.out.println(map.keySet()); // Output: [3, 5]
```

---

### **23. values() – Get All Values**
```java
System.out.println(map.values()); // Output: [Three, Five]
```

---

### **24. entrySet() – Get All Key-Value Pairs**
```java
System.out.println(map.entrySet()); // Output: [3=Three, 5=Five]
```

---

### **25. putIfAbsent(K key, V value) – Insert Only if Key is Absent**
```java
map.putIfAbsent(5, "New Five"); // Won't update
map.putIfAbsent(7, "Seven"); // Will insert
System.out.println(map); // Output: {3=Three, 5=Five, 7=Seven}
```

---

### **26. replace(K key, V value) – Replace Value of a Key**
```java
map.replace(5, "Updated Five");
System.out.println(map); // Output: {3=Three, 5=Updated Five, 7=Seven}
```

---

### **27. replace(K key, V oldValue, V newValue) – Replace Only if Old Value Matches**
```java
map.replace(5, "Wrong Value", "New Five"); // Won't replace
map.replace(5, "Updated Five", "New Five"); // Will replace
System.out.println(map); // Output: {3=Three, 5=New Five, 7=Seven}
```

---

### **28. putAll(Map<? extends K, ? extends V> m) – Copy All Entries from Another Map**
```java
TreeMap<Integer, String> anotherMap = new TreeMap<>();
anotherMap.put(8, "Eight");
map.putAll(anotherMap);
System.out.println(map); // Output: {3=Three, 5=New Five, 7=Seven, 8=Eight}
```

---

### **29. equals(Object o) – Check if Two Maps are Equal**
```java
TreeMap<Integer, String> anotherMap = new TreeMap<>();
anotherMap.put(3, "Three");
anotherMap.put(5, "New Five");
anotherMap.put(7, "Seven");
anotherMap.put(8, "Eight");

System.out.println(map.equals(anotherMap)); // Output: true
```

---

### **30. hashCode() – Get Hash Code of the Map**
```java
System.out.println(map.hashCode()); // Output: Some integer hash code
```

---



## ⭐ **Key Methods With Examples**  

### ✅ **1. put() - Add Elements to TreeMap**
```java
import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();

        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println(map);  // Output: {1=One, 2=Two, 3=Three} (Sorted Order)
    }
}
```
🔹 **TreeMap maintains keys in sorted order.**

---

### ✅ **2. get() - Retrieve Value by Key**
```java
System.out.println(map.get(2)); // Output: Two
```

---

### ✅ **3. remove() - Remove a Key-Value Pair**
```java
map.remove(2);
System.out.println(map); // Output: {1=One, 3=Three}
```

---

### ✅ **4. firstKey() & lastKey() - Get First & Last Keys**
```java
System.out.println(map.firstKey()); // Output: 1
System.out.println(map.lastKey());  // Output: 3
```

---

### ✅ **5. ceilingKey() & floorKey() - Get Closest Keys**
```java
System.out.println(map.ceilingKey(2)); // Output: 3 (Next greater key)
System.out.println(map.floorKey(2));   // Output: 1 (Previous lower key)
```

---

### ✅ **6. headMap(), tailMap(), subMap() - Range Views**
```java
System.out.println(map.headMap(3));  // Output: {1=One, 2=Two} (keys < 3)
System.out.println(map.tailMap(2));  // Output: {2=Two, 3=Three} (keys ≥ 2)
System.out.println(map.subMap(1, 3)); // Output: {1=One, 2=Two} (keys 1 to 2)
```

---

### ✅ **7. descendingMap() - Reverse Order**
```java
System.out.println(map.descendingMap()); // Output: {3=Three, 2=Two, 1=One}
```

---

## 🔥 **Key Differences: TreeMap vs. HashMap**  

| Feature | HashMap | TreeMap |
|---------|--------|--------|
| Ordering | No order | **Sorted order** |
| Search Time | **O(1)** | **O(log n)** |
| Insert/Delete Time | **O(1)** | **O(log n)** |
| Null Keys | ✅ Allowed | ❌ Not allowed |
| Null Values | ✅ Allowed | ✅ Allowed |
| Thread Safety | ❌ Not synchronized | ❌ Not synchronized |

---

## 📌 **Summary**
1. `TreeMap` **maintains keys in sorted order**.
2. **O(log n) performance** for insert, delete, search.
3. **Not synchronized** (use `Collections.synchronizedMap()` if needed).
4. **Does not allow `null` keys**, but allows `null` values.
5. **Useful when you need a sorted collection of key-value pairs**.

---

## ❓ **FAQs**
1️⃣ **When to use TreeMap instead of HashMap?**  
   - When you need **keys in sorted order** (ascending or custom).

2️⃣ **Does TreeMap allow `null` keys?**  
   - **No**, inserting a `null` key throws `NullPointerException`.

3️⃣ **Is TreeMap thread-safe?**  
   - **No**, use `Collections.synchronizedMap(new TreeMap<>())`.

---

🚀 **Happy Coding!** 🎯