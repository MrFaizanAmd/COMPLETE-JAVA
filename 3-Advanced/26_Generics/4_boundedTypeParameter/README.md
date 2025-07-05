# Java Generics: Bounded Type Parameters

## Introduction

Generics in Java allow us to write flexible and reusable code by using type parameters. However, sometimes we want to restrict the types that can be used as arguments for a type parameter. This is where **bounded type parameters** come in. They enable us to limit the types that can be passed to a generic class, method, or interface to a specific type or its subclasses (or interfaces it implements). 

### Why are Bounded Type Parameters Important?

- They provide **type safety** while maintaining flexibility.
- They help enforce constraints, ensuring that only suitable types are used.
- They enable writing **more powerful and reusable** generic methods and classes.
- They reduce runtime errors by enforcing compile-time checks.
- They improve code readability and maintainability by clarifying type constraints.

## Key Concepts and Terminologies

### What is a Bounded Type Parameter?
A **bounded type parameter** is a generic type that is constrained to be a subtype of a specific class or interface.

#### Syntax:
```java
class ClassName<T extends SomeClass> {
    // Class body
}
```
Here, `T` is the generic type parameter, and `SomeClass` is the upper bound.

### Upper Bound
The upper bound restricts the generic type to a specific class or interface and its subclasses. 

```java
class NumericBox<T extends Number> {
    private T value;
    
    public NumericBox(T value) {
        this.value = value;
    }
    
    public double getDoubleValue() {
        return value.doubleValue();
    }
}
```
In this example:
- `T extends Number` means `T` can only be `Number` or its subclasses (`Integer`, `Double`, `Float`, etc.).
- The method `getDoubleValue()` works because `Number` provides `doubleValue()`.

## Real-World Analogy
Imagine a **pet hotel** where only `Dogs` and `Cats` are allowed, but not other animals. Using bounded type parameters, we can enforce this rule in a `PetHotel<T>` class.

```java
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

class PetHotel<T extends Animal> {
    private T pet;

    public PetHotel(T pet) {
        this.pet = pet;
    }

    public void showPet() {
        System.out.println("This pet is a " + pet.getClass().getSimpleName());
    }
}

public class Main {
    public static void main(String[] args) {
        PetHotel<Dog> dogHotel = new PetHotel<>(new Dog());
        dogHotel.showPet();
        
        PetHotel<Cat> catHotel = new PetHotel<>(new Cat());
        catHotel.showPet();

        // PetHotel<String> stringHotel = new PetHotel<>("Not an Animal"); // ERROR!
    }
}
```
This prevents invalid types (like `String`) from being used.

## Wildcards with Bounds
Bounded type parameters can also be used with wildcards (`? extends Type`). 

Example: Method that accepts any subclass of `Number`:
```java
public static void printNumbers(List<? extends Number> numbers) {
    for (Number num : numbers) {
        System.out.println(num);
    }
}
```
This method allows `List<Integer>`, `List<Double>`, etc., but not `List<String>`.

## Lower Bounded Wildcards
Sometimes, we need to specify a lower bound for a generic type parameter using `? super Type`. This is useful when we want to allow any superclass of a given type.

Example:
```java
public static void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```
This method allows `List<Integer>`, `List<Number>`, or `List<Object>` but not `List<Double>`.

## Multiple Bounds
Java allows multiple bounds using `&`.

```java
class MultiBound<T extends Number & Comparable<T>> {
    private T value;
    
    public MultiBound(T value) {
        this.value = value;
    }
    
    public boolean isGreaterThan(T other) {
        return value.compareTo(other) > 0;
    }
}
```
- `T` must extend `Number` **and** implement `Comparable<T>`.

## Common Use Cases
1. **Creating Generic Utility Methods**:
   ```java
   public static <T extends Comparable<T>> T findMax(T a, T b) {
       return a.compareTo(b) > 0 ? a : b;
   }
   ```
   - Ensures `T` can be compared using `compareTo`.

2. **Defining Generic Collections with Constraints**:
   ```java
   class Repository<T extends Serializable> {
       private List<T> items = new ArrayList<>();
   }
   ```
   - Ensures `T` implements `Serializable`.

## Frequently Asked Questions (FAQs)

### 1. Can I have multiple bounds?
Yes! Java allows multiple **interfaces** but only a **single class** to be extended.

### 2. Why can't I use `T extends MultipleClasses`?
Java allows multiple **interfaces** but only a **single class** because it does not support multiple inheritance for classes.

### 3. How do bounded types improve performance?
By restricting types, the compiler can optimize method calls and avoid unnecessary type checks at runtime.

### 4. When should I use wildcards vs bounded type parameters?
Use **wildcards (`? extends Type` or `? super Type`)** when you want to allow a broader range of inputs. Use **bounded type parameters (`T extends Type`)** when defining a **specific type constraint**.

### 5. Can I use primitives as bounded type parameters?
No, Java does not allow primitive types (`int`, `double`, etc.) as generic type arguments. Use their wrapper classes (`Integer`, `Double`, etc.) instead.

## Further Reading
- [Official Java Documentation on Generics](https://docs.oracle.com/javase/tutorial/java/generics/)
- [Java Language Specification - Generics](https://docs.oracle.com/javase/specs/jls/se17/html/jls-4.html)

## Hands-On Practice
Check out the [practice folder](./practice/bounded-type-parameters) in this repository for hands-on coding exercises!

---
This guide takes you from **basics to advanced** concepts of bounded type parameters, ensuring you understand their real-world applications. Keep practicing, and happy coding! 🚀

