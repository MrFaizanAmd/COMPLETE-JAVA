// ConsumerExample3.java - Consumer to update an object property
import java.util.function.Consumer;

class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
}

public class ConsumerExample3 {
    public static void main(String[] args) {
        Consumer<Person> changeName = person -> person.name = "Updated Name";
        Person p = new Person("Original Name");
        System.out.println("Before: " + p.name);
        changeName.accept(p);
        System.out.println("After: " + p.name);
    }
}