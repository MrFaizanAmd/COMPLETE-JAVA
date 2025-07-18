// InheritancePractice.java

// Example 1: Single-Level Inheritance
class Vehicle {
    String brand = "Generic Vehicle";

    void start() {
        System.out.println(brand + " is starting...");
    }
}

class Car extends Vehicle {
    String model = "Sedan";

    void drive() {
        System.out.println("Driving a " + model + " car.");
    }
}

// Example 2: Multilevel Inheritance
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Mammal extends Animal {
    void walk() {
        System.out.println("This mammal walks on land.");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("The dog barks: Woof Woof!");
    }
}

// Example 3: Why Multiple Inheritance is Not Allowed
class ParentA {
    void greet() {
        System.out.println("Hello from ParentA!");
    }
}

class ParentB {
    void greet() {
        System.out.println("Hello from ParentB!");
    }
}

// Uncommenting this code will cause an error because Java doesn't support multiple inheritance.
// class Child extends ParentA, ParentB {
//     // Compilation error: Cannot inherit from two classes
// }

// Example 4: Using Interfaces to Simulate Multiple Inheritance

public class InheritancePractice {
    public static void main(String[] args) {
        // Example 1: Single-Level Inheritance
        Car car = new Car();
        car.start(); // Calls method from Vehicle class
        car.drive(); // Calls method from Car class

        System.out.println();

        // Example 2: Multilevel Inheritance
        Dog dog = new Dog();
        dog.eat(); // From Animal class
        dog.walk(); // From Mammal class
        dog.bark(); // From Dog class

        System.out.println();

        // Example 3: Why Multiple Inheritance is Not Allowed
        // Uncommenting the Child class will cause a compilation error
        // because of ambiguity in the `greet` method.

    }
}
