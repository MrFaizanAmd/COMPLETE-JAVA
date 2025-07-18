# Bitwise Operators in Java: A Complete Guide 🚀

Welcome to the **Java Learning Repository!** In this guide, we'll explore **Bitwise Operators** in Java, a fundamental yet powerful concept often overlooked by beginners. By the end of this guide, you'll understand how bitwise operations work, when to use them, and how they optimize performance in Java programming.

---

## **1. Introduction to Bitwise Operators** 🎯

### **What are Bitwise Operators?**
Bitwise operators work directly on **bits** (0s and 1s). Unlike arithmetic operators that manipulate whole numbers, bitwise operators manipulate individual bits within an integer.

### **Why are Bitwise Operators Important?**
✅ **Fast execution**: Directly manipulates memory bits, making operations efficient.
✅ **Used in low-level programming**: Essential in embedded systems, cryptography, and networking.
✅ **Optimized conditional operations**: Useful for flag-based logic, permission handling, and performance optimizations.

Imagine a **light switch panel** where each switch represents a bit (on = 1, off = 0). Bitwise operations allow us to manipulate these switches efficiently. 🏠💡

---

## **2. Types of Bitwise Operators in Java** 🛠️

| Operator | Symbol | Description |
|----------|--------|-------------|
| AND | `&` | Returns 1 if both bits are 1 |
| OR | `|` | Returns 1 if at least one bit is 1 |
| XOR | `^` | Returns 1 if only one bit is 1 (exclusive OR) |
| NOT | `~` | Inverts the bits (flips 0 to 1 and 1 to 0) |
| Left Shift | `<<` | Shifts bits to the left, multiplying the number by 2 per shift |
| Right Shift | `>>` | Shifts bits to the right, dividing the number by 2 per shift |
| Unsigned Right Shift | `>>>` | Shifts bits to the right without sign extension |

---

## **3. Understanding Bitwise Operations with Examples** 🧑‍💻

### **A. Bitwise AND (`&`)**
Returns `1` if both corresponding bits are `1`, else `0`.

```java
public class BitwiseAND {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        System.out.println(a & b); // Output: 1 (0001)
    }
}
```

### **B. Bitwise OR (`|`)**
Returns `1` if at least one bit is `1`.

```java
public class BitwiseOR {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        System.out.println(a | b); // Output: 7 (0111)
    }
}
```

### **C. Bitwise XOR (`^`)**
Returns `1` if the bits are different, `0` if the same.

```java
public class BitwiseXOR {
    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011
        System.out.println(a ^ b); // Output: 6 (0110)
    }
}
```

### **D. Bitwise NOT (`~`)**
Flips all bits (1 → 0, 0 → 1). Note: In Java, integers are 32-bit signed.

```java
public class BitwiseNOT {
    public static void main(String[] args) {
        int a = 5;  // 00000000 00000000 00000000 00000101
        System.out.println(~a); // Output: -6 (in 2's complement form)
    }
}
```

### **E. Left Shift (`<<`)**
Shifts bits left, effectively multiplying by `2^n`.

```java
public class LeftShift {
    public static void main(String[] args) {
        int a = 5;  // 0101
        System.out.println(a << 1); // Output: 10 (1010)
    }
}
```

### **F. Right Shift (`>>`)**
Shifts bits right, effectively dividing by `2^n`.

```java
public class RightShift {
    public static void main(String[] args) {
        int a = 8;  // 1000
        System.out.println(a >> 2); // Output: 2 (0010)
    }
}
```

### **G. Unsigned Right Shift (`>>>`)**
Similar to `>>` but fills with `0s` instead of copying the sign bit.

```java
public class UnsignedRightShift {
    public static void main(String[] args) {
        int a = -8;
        System.out.println(a >>> 2); // Large positive number
    }
}
```

---

## **4. Real-World Applications of Bitwise Operators 🌍**

- **Cryptography**: Efficient encryption and hashing algorithms.
- **Networking**: Masking IP addresses and subnet calculations.
- **Graphics Processing**: Manipulating color codes and pixels.
- **Permissions & Flags**: Checking and setting user permissions efficiently.

---

## **5. Frequently Asked Questions (FAQs)❓**

### **Q1: What is the difference between `>>` and `>>>`?**
- `>>` keeps the sign bit (negative numbers remain negative).
- `>>>` does not preserve the sign bit, treating the number as unsigned.

### **Q2: Can I use bitwise operators on floating-point numbers?**
No, bitwise operators work only on integers (`byte`, `short`, `int`, `long`).

### **Q3: Why do we use bitwise XOR (`^`) for swapping numbers?**
Bitwise XOR swaps two numbers without using a temporary variable.

```java
int a = 5, b = 7;
a = a ^ b;
b = a ^ b;
a = a ^ b;
System.out.println(a + " " + b); // Output: 7 5
```

---


Happy Coding! 🚀

