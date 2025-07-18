# **Factory Methods for Collections in Java (Java 9+)** 🚀  

Java 9 introduced **factory methods** for creating immutable collections using `List.of()`, `Set.of()`, and `Map.of()`. These methods simplify collection creation, enhance performance, and reduce unnecessary memory usage.  

---

## **1. What Are Factory Methods?**  

Factory methods provide **a concise way to create immutable collections** without using `new ArrayList<>`, `new HashSet<>`, or `new HashMap<>`. Instead of manually adding elements, you can initialize collections **in a single line**.

### **Why Use Them?**  

✅ **Immutable** – Collections cannot be modified after creation.  
✅ **Concise Syntax** – Eliminates boilerplate code.  
✅ **Memory Efficient** – Uses optimized internal storage instead of `ArrayList`, `HashSet`, or `HashMap`.  
✅ **Thread-Safe** – Since the collections are immutable, no external synchronization is needed.  
❌ **No `null` values allowed** – Adding `null` will throw a `NullPointerException`.  

---

## **2. How to Create Immutable Collections?**  

### **Immutable List**
```java
List<String> fruits = List.of("Apple", "Banana", "Cherry");
System.out.println(fruits); // [Apple, Banana, Cherry]
```
🚨 `fruits.add("Mango");` → ❌ Throws `UnsupportedOperationException`  

### **Immutable Set**
```java
Set<String> colors = Set.of("Red", "Green", "Blue");
System.out.println(colors); // [Red, Green, Blue]
```
🚨 `Set.of("A", "A");` → ❌ Throws `IllegalArgumentException` (No Duplicates)  

### **Immutable Map**
```java
Map<Integer, String> numbers = Map.of(1, "One", 2, "Two", 3, "Three");
System.out.println(numbers); // {1=One, 2=Two, 3=Three}
```
🚨 `numbers.put(4, "Four");` → ❌ Throws `UnsupportedOperationException`  

For **more than 10 key-value pairs**, use `Map.ofEntries()`:
```java
Map<Integer, String> bigMap = Map.ofEntries(
    Map.entry(1, "One"), Map.entry(2, "Two"), Map.entry(3, "Three"),
    Map.entry(4, "Four"), Map.entry(5, "Five"), Map.entry(6, "Six")
);
System.out.println(bigMap);
```

---

## **3. How Do Factory Methods Work Internally?**  

When calling `List.of()`, `Set.of()`, or `Map.of()`, Java **does not return an `ArrayList`, `HashSet`, or `HashMap`**. Instead, it returns **a special immutable internal implementation**.

### **Example: What Does `List.of()` Return?**
```java
List<Integer> list = List.of(1, 2, 3);
System.out.println(list.getClass());
```
### **Output:**
```plaintext
class java.util.ImmutableCollections$ListN
```
🔹 **Java returns an optimized internal immutable list** (`ImmutableCollections$ListN`), not an `ArrayList`.  

### **Implementation in Java’s Source Code**  
If we check Java's internal implementation, `List.of()` **switches between different immutable classes based on size**:
```java
public static <E> List<E> of(E... elements) {
    switch (elements.length) {
        case 0: return ImmutableCollections.EMPTY_LIST;
        case 1: return new ImmutableCollections.List1<>(elements[0]);
        case 2: return new ImmutableCollections.List2<>(elements[0], elements[1]);
        default: return new ImmutableCollections.ListN<>(elements);
    }
}
```
- If **0 elements**, returns a **pre-existing empty immutable list**.  
- If **1-2 elements**, returns a **small immutable list**.  
- If **3+ elements**, returns a **general immutable list** (`ListN`).  

### **How `Set.of()` Works**
The `Set.of()` method works similarly but **prevents duplicate elements**.
```java
public static <E> Set<E> of(E... elements) {
    switch (elements.length) {
        case 0: return ImmutableCollections.EMPTY_SET;
        case 1: return new ImmutableCollections.Set1<>(elements[0]);
        case 2: return new ImmutableCollections.Set2<>(elements[0], elements[1]);
        default: return new ImmutableCollections.SetN<>(elements);
    }
}
```
- Uses **different implementations** based on the number of elements.  
- **Checks for duplicate values** and throws `IllegalArgumentException` if duplicates exist.  

### **How `Map.of()` Works**
`Map.of()` also returns an **immutable internal implementation**:
```java
public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
    return new ImmutableCollections.Map2<>(k1, v1, k2, v2);
}
```
- If many key-value pairs exist, `Map.ofEntries()` is used:
```java
public static <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
    return new ImmutableCollections.MapN<>(entries);
}
```
- **Prevents duplicate keys** – Throws an `IllegalArgumentException` if the same key is used multiple times.  

---

## **4. Performance & Memory Optimization**  

🚀 **1. More Memory Efficient**  
- Traditional collections like `ArrayList` and `HashSet` allocate extra memory for resizing and load factors.  
- Factory methods return **compact, immutable structures** optimized for small collections.  

🚀 **2. Faster Read Access**  
- Immutable collections **do not track modifications**, making them **faster for read operations**.  
- They **use less memory** and **avoid synchronization overhead**.  

🚀 **3. Optimized for Small Collections**  
- Java **switches implementations dynamically** depending on size, making it **efficient for different use cases**.  

---

## **5. Comparison: Factory Methods vs Traditional Collections**  

| Feature | Factory Methods (`List.of()`, `Set.of()`, `Map.of()`) | Traditional Collections (`ArrayList<>`, `HashSet<>`, `HashMap<>`) |
|---------|---------------------------------|--------------------------------|
| **Immutable?** | ✅ Yes | ❌ No (modifiable) |
| **Null Allowed?** | ❌ No | ✅ Yes |
| **Memory Efficient?** | ✅ Yes | ❌ No (extra capacity allocated) |
| **Optimized for Small Collections?** | ✅ Yes | ❌ No |
| **Fast Read Access?** | ✅ Yes | ❌ No (extra synchronization in some cases) |
| **Allows Modification?** | ❌ No | ✅ Yes |

---

## **6. When to Use Factory Methods?**  

✔ **Use Factory Methods When:**  
- You need **immutable, read-only collections**.  
- You want **concise and cleaner syntax**.  
- You want **better memory efficiency and performance**.  
- You want **thread-safe collections without extra synchronization**.  

❌ **Avoid Factory Methods When:**  
- You need to **modify (add/remove) elements** after creation.  
- You need **null elements** (factory methods **do not allow `null`**).  
- You need **a large, dynamically growing collection** (use `ArrayList`, `HashSet`, `HashMap`).  

---

## **7. Summary**  

🔹 **Factory methods (`List.of()`, `Set.of()`, `Map.of()`) simplify collection creation.**  
🔹 They **return optimized immutable collections** instead of `ArrayList`, `HashSet`, or `HashMap`.  
🔹 **Cannot be modified**, **do not allow nulls**, and **use less memory**.  
🔹 **Great for small collections that don’t change**!  

📂 **[Click here](./factory-methods-practice)** for hands-on coding practice.  

📖 [Official Java Docs](https://docs.oracle.com/en/java/javase/9/docs/api/java/util/List.html#of-E...-)