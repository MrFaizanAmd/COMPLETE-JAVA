
// Comprehensive Example of Comparable and Comparator

import java.util.*;

// 1. Implementing Comparable to sort Employees by age
class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Salary: " + salary + ")";
    }
}

// 2. Implementing Comparator to sort Employees by Salary
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

// 3. Implementing Comparator to sort Employees by Name
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

public class ComparableComparatorExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 70000));
        employees.add(new Employee("David", 28, 55000));

        // Sorting using Comparable (by Age)
        Collections.sort(employees);
        System.out.println("Sorted by Age (Comparable): " + employees);

        // Sorting using Comparator (by Salary)
        Collections.sort(employees, new SalaryComparator());
        System.out.println("Sorted by Salary (Comparator): " + employees);

        // Sorting using Comparator (by Name)
        Collections.sort(employees, new NameComparator());
        System.out.println("Sorted by Name (Comparator): " + employees);

        // Sorting using Anonymous Comparator (Descending Salary)
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("Sorted by Salary Descending (Lambda Comparator): " + employees);
    }
}
