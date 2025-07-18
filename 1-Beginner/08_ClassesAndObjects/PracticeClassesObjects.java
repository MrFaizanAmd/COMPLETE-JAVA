// Practice File: Classes and Objects in Java
// This single runnable file contains multiple examples within the main method.

public class PracticeClassesObjects {

    public static void main(String[] args) {

        // Example 1: Basic Class and Object
        Person person = new Person();
        person.name = "Alice";
        person.age = 25;
        person.introduce(); // Outputs: Hi, I am Alice and I am 25 years old.

        // Example 2: Multiple Objects
        Book book1 = new Book();
        book1.title = "Java Programming";
        book1.author = "John Doe";
        book1.displayInfo(); // Outputs: Title: Java Programming, Author: John Doe

        Book book2 = new Book();
        book2.title = "Data Structures";
        book2.author = "Jane Smith";
        book2.displayInfo(); // Outputs: Title: Data Structures, Author: Jane Smith

        // Example 3: Modifying Attributes
        book1.title = "Advanced Java Programming";
        book1.displayInfo(); // Outputs: Title: Advanced Java Programming, Author: John Doe

        // Example 4: Real-world analogy: Zoo
        Animal lion = new Animal();
        lion.species = "Lion";
        lion.age = 5;
        lion.diet = "Carnivore";
        lion.eat(); // Outputs: The Lion is eating.

        Animal elephant = new Animal();
        elephant.species = "Elephant";
        elephant.age = 10;
        elephant.diet = "Herbivore";
        elephant.eat(); // Outputs: The Elephant is eating.

        // Example 5: Using a method to modify attributes
        person.changeName("Bob");
        person.introduce(); // Outputs: Hi, I am Bob and I am 25 years old.
    }
}

// Supporting Classes

class Person {
    String name;
    int age;

    public void introduce() {
        System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
    }

    public void changeName(String newName) {
        name = newName;
    }
}

class Book {
    String title;
    String author;

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Animal {
    String species;
    int age;
    String diet;

    public void eat() {
        System.out.println("The " + species + " is eating.");
    }
}
