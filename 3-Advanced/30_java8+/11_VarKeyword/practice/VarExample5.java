
// VarExample5.java - Using var with Objects
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

public class VarExample5 {
    public static void main(String[] args) {
        var person = new Person("John Doe");
        System.out.println(person);
    }
}
