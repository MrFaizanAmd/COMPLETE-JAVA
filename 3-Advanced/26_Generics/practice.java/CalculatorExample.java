
// Comprehensive Generic Calculator with Multiple Operations
class Calculator<T extends Number> {
    private T num1;
    private T num2;

    public Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1.doubleValue() + num2.doubleValue();
    }

    public double subtract() {
        return num1.doubleValue() - num2.doubleValue();
    }

    public double multiply() {
        return num1.doubleValue() * num2.doubleValue();
    }

    public double divide() {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static void main(String[] args) {
        Calculator<Integer> intCalc = new Calculator<>(10, 5);
        System.out.println("Addition: " + intCalc.add());
        System.out.println("Subtraction: " + intCalc.subtract());
        System.out.println("Multiplication: " + intCalc.multiply());
        System.out.println("Division: " + intCalc.divide());

        Calculator<Double> doubleCalc = new Calculator<>(10.5, 2.5);
        System.out.println("Addition: " + doubleCalc.add());
        System.out.println("Subtraction: " + doubleCalc.subtract());
        System.out.println("Multiplication: " + doubleCalc.multiply());
        System.out.println("Division: " + doubleCalc.divide());
    }
}
