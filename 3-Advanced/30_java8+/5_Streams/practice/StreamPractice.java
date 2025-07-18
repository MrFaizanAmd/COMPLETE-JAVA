import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {
        // Sample Data
        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 25, 30, 35, 40);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 2500),
            new Employee("Bob", 3000),
            new Employee("Charlie", 2800),
            new Employee("David", 3200),
            new Employee("Eve", 2700)
        );

        // 1. Print all even numbers
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // 2. Find the sum of all numbers greater than 15
        int sum = numbers.stream().filter(n -> n > 15).mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // 3. Convert all words to uppercase
        words.stream().map(String::toUpperCase).forEach(System.out::println);

        // 4. Find the longest word
        String longestWord = words.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("Longest Word: " + longestWord);

        // 5. Sort numbers in descending order
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 6. Count words starting with 'b'
        long countB = words.stream().filter(w -> w.startsWith("b")).count();
        System.out.println("Words starting with 'b': " + countB);

        // 7. Find the first three elements in the list
        numbers.stream().limit(3).forEach(System.out::println);

        // 8. Skip first two elements and print the rest
        numbers.stream().skip(2).forEach(System.out::println);

        // 9. Check if all numbers are greater than 5
        boolean allGreaterThan5 = numbers.stream().allMatch(n -> n > 5);
        System.out.println("All greater than 5: " + allGreaterThan5);

        // 10. Find any number greater than 25
        numbers.stream().filter(n -> n > 25).findAny().ifPresent(System.out::println);

        // 11. Convert a list of names to a comma-separated string
        String joinedNames = words.stream().collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);

        // 12. Group words by their first letter
        Map<Character, List<String>> groupedWords = words.stream().collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(groupedWords);

        // 13. Find the highest salary employee
        Employee highestSalaryEmployee = employees.stream().max(Comparator.comparingInt(Employee::getSalary)).orElse(null);
        System.out.println("Highest Salary: " + highestSalaryEmployee);

        // 14. Find total salary of all employees
        int totalSalary = employees.stream().mapToInt(Employee::getSalary).sum();
        System.out.println("Total Salary: " + totalSalary);

        // 15. Find distinct numbers in a list
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // 16. Get employees earning more than 2700
        employees.stream().filter(e -> e.getSalary() > 2700).forEach(System.out::println);

        // 17. Partition employees into high and low salary groups (threshold: 2800)
        Map<Boolean, List<Employee>> partitionedEmployees = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 2800));
        System.out.println(partitionedEmployees);

        // 18. Find second highest salary
        int secondHighestSalary = employees.stream().mapToInt(Employee::getSalary).distinct().sorted().skip(employees.size() - 2).findFirst().orElse(0);
        System.out.println("Second Highest Salary: " + secondHighestSalary);

        // 19. Generate a list of squares of numbers
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // 20. Check if any number is a multiple of 5
        boolean anyMultipleOf5 = numbers.stream().anyMatch(n -> n % 5 == 0);
        System.out.println("Any multiple of 5: " + anyMultipleOf5);
    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}
