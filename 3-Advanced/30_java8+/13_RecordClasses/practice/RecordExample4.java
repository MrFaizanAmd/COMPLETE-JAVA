// RecordExample4.java - Record with Static Fields and Methods
record Circle(double radius) {
    static final double PI = 3.14159;
    
    public double circumference() {
        return 2 * PI * radius;
    }
}

public class RecordExample4 {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        System.out.println("Circle Circumference: " + circle.circumference());
    }
}
