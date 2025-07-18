# 📌 **Mastering Java Streams – Tricky & Interesting Problems**

Java Streams provide a powerful functional approach to processing collections of data. Below are **10 tricky and interesting problems** solved using Streams, along with explanations and examples.

---

## 🔥 **1. Find the First Non-Repeating Character in a String**
### **Explanation:**
- Convert the string into a character stream using `.chars()`.
- Use `Collectors.groupingBy()` to count occurrences.
- Filter entries with count `1` and return the first.

### **Code Example:**
```java
String str = "swiss";
Optional<Character> firstNonRepeating = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
        .entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst();
System.out.println("First non-repeating character: " + firstNonRepeating.orElse('N'));
```

---

## 🔥 **2. Find the Second-Highest Number in a List**
### **Explanation:**
- Remove duplicates using `.distinct()`.
- Sort in descending order and use `.skip(1)` to get the second-highest.

### **Code Example:**
```java
List<Integer> numbers = Arrays.asList(4, 2, 7, 1, 9, 7, 9, 4);
Optional<Integer> secondHighest = numbers.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst();
System.out.println("Second highest number: " + secondHighest.orElse(-1));
```

---

## 🔥 **3. Find Duplicate Elements in a List**
### **Explanation:**
- Use `Collectors.groupingBy()` to count occurrences.
- Filter elements appearing more than once.

### **Code Example:**
```java
List<Integer> duplicates = numbers.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
System.out.println("Duplicate elements: " + duplicates);
```

---

## 🔥 **4. Find the Longest Word in a Sentence**
### **Explanation:**
- Convert the sentence into words using `.split()`.
- Find the maximum length word using `.max(Comparator.comparingInt())`.

### **Code Example:**
```java
String sentence = "Java Streams make functional programming easier";
String longestWord = Arrays.stream(sentence.split(" "))
        .max(Comparator.comparingInt(String::length))
        .orElse("");
System.out.println("Longest word: " + longestWord);
```

---

## 🔥 **5. Count Occurrences of Each Word in a List**
### **Explanation:**
- Use `Collectors.groupingBy()` to count occurrences.

### **Code Example:**
```java
List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
Map<String, Long> wordCount = words.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println("Word occurrences: " + wordCount);
```

---

## 🔥 **6. Check If a Number is Prime Using Streams**
### **Explanation:**
- Check divisibility up to `sqrt(n)` using `.noneMatch()`.

### **Code Example:**
```java
int num = 29;
boolean isPrime = num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num))
        .noneMatch(n -> num % n == 0);
System.out.println(num + " is prime? " + isPrime);
```

---

## 🔥 **7. Convert a List of Strings to a Single Comma-Separated String**
### **Explanation:**
- Use `Collectors.joining(", ")` to concatenate elements.

### **Code Example:**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
String joinedNames = names.stream()
        .collect(Collectors.joining(", "));
System.out.println("Comma-separated names: " + joinedNames);
```

---

## 🔥 **8. Reverse Each Word in a Sentence Using Streams**
### **Explanation:**
- Convert the sentence into words, reverse each word, and join them.

### **Code Example:**
```java
String reversedWords = Arrays.stream(sentence.split(" "))
        .map(word -> new StringBuilder(word).reverse().toString())
        .collect(Collectors.joining(" "));
System.out.println("Reversed words: " + reversedWords);
```

---

## 🔥 **9. Find the Sum of Digits in a Number Using Streams**
### **Explanation:**
- Convert number to `String`, extract digits, and sum them.

### **Code Example:**
```java
int number = 12345;
int sumOfDigits = String.valueOf(number).chars()
        .map(Character::getNumericValue)
        .sum();
System.out.println("Sum of digits: " + sumOfDigits);
```

---

## 🔥 **10. Find the Most Frequent Element in a List**
### **Explanation:**
- Use `Collectors.groupingBy()` to count occurrences.
- Find the maximum entry using `.max(Map.Entry.comparingByValue())`.

### **Code Example:**
```java
Optional<Integer> mostFrequent = numbers.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey);
System.out.println("Most frequent element: " + mostFrequent.orElse(-1));
```

---

## 🌟 **Conclusion**
- Java Streams provide a **functional** and **efficient** way to process data.
- Using **grouping, mapping, filtering, and sorting**, complex problems can be solved elegantly.
- Understanding **lazy evaluation, parallel streams, and optimized operations** can further enhance performance.

🚀 **Happy Coding!** 🎯

