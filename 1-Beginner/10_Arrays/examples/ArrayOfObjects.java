// File: ArrayOfObjects.java
// Practice creating an array of objects
class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class ArrayOfObjects {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = new Student[3];
        students[0] = new Student("Alice", 20);
        students[1] = new Student("Bob", 22);
        students[2] = new Student("Charlie", 19);

        // Print the array of objects
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
