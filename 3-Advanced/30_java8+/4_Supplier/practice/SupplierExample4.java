// SupplierExample4.java - Supplying an Object
import java.util.function.Supplier;

class Person {
    String name;
    
    Person(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

public class SupplierExample4 {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = () -> new Person("John Doe");
        System.out.println(personSupplier.get());
    }
}
