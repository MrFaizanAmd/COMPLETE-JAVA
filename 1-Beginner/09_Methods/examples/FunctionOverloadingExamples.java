// File 3: FunctionOverloadingExamples.java

public class FunctionOverloadingExamples {

    // Overloaded method for adding two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method for adding two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method for adding three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        FunctionOverloadingExamples examples = new FunctionOverloadingExamples();

        // Using overloaded add methods
        System.out.println("Add two integers: " + examples.add(5, 10)); // Outputs 15
        System.out.println("Add two doubles: " + examples.add(2.5, 3.5)); // Outputs 6.0
        System.out.println("Add three integers: " + examples.add(1, 2, 3)); // Outputs 6
    }
}
