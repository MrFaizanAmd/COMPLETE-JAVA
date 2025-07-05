// RecordExample2.java - Record with Custom Constructor
record Employee(String name, double salary) {
    public Employee {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }
}

public class RecordExample2 {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 50000);
        System.out.println("Employee: " + emp.name() + ", Salary: " + emp.salary());
    }
}