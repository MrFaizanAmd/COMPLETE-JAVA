
# 🌟 New "Rule Switch" Statement (Java 12+)

The **rule switch** introduced in Java 12 (and finalized in Java 14) is an enhanced version of the traditional `switch` statement. It makes code cleaner, less error-prone, and more expressive by introducing new syntax and capabilities.

---

## 🎯 Key Improvements in the New Switch Statement

1. **Use of the `->` Operator**  
   - Instead of traditional `case` blocks with `:` and `break`, the new syntax uses `->` to specify a single-line or multi-line block of code.  
   - **Eliminates the need for `break` statements**, reducing common errors like unintended fall-through.

2. **Switch as an Expression**  
   - The new switch can **return a value** directly. This makes it more functional and reduces boilerplate code.

3. **Multiple Labels in One Case**  
   - A single `case` can handle multiple values, separated by commas.

4. **Introduction of `yield`**  
   - The `yield` keyword is used to return values from a `case` block when it spans multiple lines. It replaces `return` within `switch` expressions.

5. **Default Fall-Through Prevention**  
   - Fall-through (executing multiple `case` blocks unintentionally) is no longer allowed by default, ensuring safer and more predictable code.

---

## 💡 Syntax of Rule Switch

### Single-line Cases
```java
switch (expression) {
    case value1 -> action1;
    case value2 -> action2;
    default -> defaultAction;
}
```

### Multi-line Cases Using `yield`
```java
switch (expression) {
    case value1 -> {
        // Perform actions
        yield result; // Return a value
    }
    case value2 -> {
        // Perform other actions
        yield anotherResult;
    }
    default -> {
        // Default block actions
        yield defaultResult;
    }
}
```

---

## 📚 Detailed Explanation of Key Features

### 1. **`->` Operator**
The `->` operator simplifies the syntax by separating the case label from the block of code to execute. It eliminates the need for a `:` and makes the code cleaner.

#### Example:
Traditional `switch`:
```java
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

New `switch`:
```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Invalid day");
}
```

---

### 2. **Switch as an Expression**
The new switch can return a value directly. This is useful when you need to assign a result based on a condition.

#### Example:
```java
int day = 3;
String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Invalid day";
};
System.out.println("Day name is: " + dayName);
```

---

### 3. **Using Multiple Labels in One Case**
You can now group multiple values in a single case, separated by commas.

#### Example:
```java
int month = 2;
int daysInMonth = switch (month) {
    case 1, 3, 5, 7, 8, 10, 12 -> 31;
    case 4, 6, 9, 11 -> 30;
    case 2 -> 28; // Non-leap year
    default -> throw new IllegalArgumentException("Invalid month");
};
System.out.println("Days in the month: " + daysInMonth);
```

---

### 4. **`yield` Keyword**
When a `case` block contains multiple lines, you need to use the `yield` keyword to return a value from the `switch` expression.

#### Why `yield`?  
- `yield` provides more clarity and safety in multi-line cases.  
- Unlike `break`, which terminates a switch statement, `yield` explicitly returns a value.

#### Example:
```java
int score = 85;
String grade = switch (score / 10) {
    case 10, 9 -> "A";
    case 8 -> "B";
    case 7 -> "C";
    case 6 -> "D";
    default -> {
        System.out.println("Score too low");
        yield "F"; // Return value
    }
};
System.out.println("Grade: " + grade);
```

---

## 🚀 What’s New in Rule Switch?

1. **No Fall-Through**  
   In traditional `switch`, forgetting a `break` leads to fall-through, where all subsequent cases execute unintentionally. In rule switch, this is **disallowed** by design.

   - Traditional `switch` (fall-through example):  
     ```java
     switch (day) {
         case 1:
             System.out.println("Monday");
         case 2:
             System.out.println("Tuesday"); // Fall-through happens here
     }
     ```
   - Rule switch:
     ```java
     switch (day) {
         case 1 -> System.out.println("Monday");
         case 2 -> System.out.println("Tuesday");
     }
     ```

2. **Concise Syntax**  
   The `->` operator reduces boilerplate code and makes switches easier to read and write.

3. **Expressions, Not Just Statements**  
   Rule switch supports expressions, allowing you to assign values directly to variables.

4. **`yield` for Explicit Value Return**  
   `yield` improves clarity and supports multi-line cases in expressions.

---

## 🖊️ Example Code Structure
Check out these example files for practical implementations:

1. [New switch Example](SwitchRuleExample.java)

---
## 🛠️ Summary of Benefits
- Cleaner and more concise syntax (`->` operator).
- Eliminates the need for `break`.
- Prevents unintended fall-through.
- Allows returning values using expressions.
- Multi-line cases use `yield` for clarity.
- Supports multiple values per case.

---

## 📚 Additional Resources
- [Java Switch Documentation](https://docs.oracle.com/en/java/javase/17/language/switch-expressions.html)
- [JEP 325: Switch Expressions](https://openjdk.org/jeps/325)
- [JEP 361: Switch Expressions (Standard)](https://openjdk.org/jeps/361)

---

The new rule switch in Java is a game-changer for simplifying conditional logic and making code more readable and efficient. Practice with the examples above and integrate this style into your Java projects! 🚀