// RecordExample1.java - Basic Record Usage
record Person(String name, int age) {}

public class RecordExample1 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
    }
}