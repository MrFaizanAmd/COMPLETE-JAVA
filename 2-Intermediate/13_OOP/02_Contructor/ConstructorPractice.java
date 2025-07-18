// ConstructorPractice.java
public class ConstructorPractice {

    // Example 1: Simple Constructor
    static class Example1 {
        Example1() {
            System.out.println("Example 1: Constructor Called");
        }
    }

    // Example 2: Constructor with Parameters
    static class Example2 {
        String name;

        Example2(String name) {
            this.name = name;
            System.out.println("Example 2: Hello, " + name);
        }
    }

    // Example 3: Constructor Chaining using 'this'
    static class Example3 {
        int x, y;

        Example3() {
            this(10, 20); // Calls the second constructor
            System.out.println("Example 3: Default Constructor Called");
        }

        Example3(int x, int y) {
            this.x = x;
            this.y = y;
            System.out.println("Example 3: Parameterized Constructor Called (x = " + x + ", y = " + y + ")");
        }
    }

    // Example 4: Parent and Child Constructor Ordering using 'super'
    static class Parent {
        Parent() {
            System.out.println("Example 4: Parent Constructor Called");
        }
    }

    static class Child extends Parent {
        Child() {
            super(); // Explicitly calls Parent's constructor
            System.out.println("Example 4: Child Constructor Called");
        }
    }

    // Example 5: Constructor with Default Values
    static class Example5 {
        String message;

        Example5() {
            this("Default Message"); // Calls the parameterized constructor
        }

        Example5(String message) {
            this.message = message;
            System.out.println("Example 5: Message - " + message);
        }
    }

    // Example 6: Predict Constructor Ordering
    static class GrandParent {
        GrandParent() {
            System.out.println("Example 6: GrandParent Constructor Called");
        }
    }

    static class Parent6 extends GrandParent {
        Parent6() {
            System.out.println("Example 6: Parent Constructor Called");
        }
    }

    static class Child6 extends Parent6 {
        Child6() {
            System.out.println("Example 6: Child Constructor Called");
        }
    }

    public static void main(String[] args) {
        System.out.println("Example 1 Output:");
        new Example1();

        System.out.println("\nExample 2 Output:");
        new Example2("Saif");

        System.out.println("\nExample 3 Output:");
        new Example3();

        System.out.println("\nExample 4 Output:");
        new Child();

        System.out.println("\nExample 5 Output:");
        new Example5();

        System.out.println("\nExample 6 Output:");
        new Child6();
    }
}
