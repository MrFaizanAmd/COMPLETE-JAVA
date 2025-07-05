// Encapsulation Example in Java with Method Overriding
// Encapsulation means restricting direct access to data by using private variables
// and providing public getter and setter methods to access and modify the data.

class Person {
    // Private fields (data hiding)
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public getter method to access the name
    public String getName() {
        return name;
    }

    // Public setter method to modify the name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter method to access the age
    public int getAge() {
        return age;
    }

    // Public setter method to modify the age
    public void setAge(int age) {
        if (age > 0) { // Validating the age before setting
            this.age = age;
        } else {
            System.out.println("Age must be a positive number.");
        }
    }
    
    // Method to display details (to be overridden in subclass)
    public void displayInfo() {
        System.out.println("Person Name: " + name);
        System.out.println("Person Age: " + age);
    }
}

// Subclass of Person
class Employee extends Person {
    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calling parent method
        System.out.println("Job Title: " + jobTitle);
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        // Creating an object of Person class
        Person person = new Person("John", 25);
        
        // Accessing private variables using getters
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        
        // Modifying private variables using setters
        person.setName("Alice");
        person.setAge(30);
        
        System.out.println("Updated Name: " + person.getName());
        System.out.println("Updated Age: " + person.getAge());
        
        // Trying to set an invalid age
        person.setAge(-5); // Will print validation message

        // Demonstrating method overriding
        Employee emp = new Employee("David", 40, "Software Engineer");
        emp.displayInfo();
    }
}
