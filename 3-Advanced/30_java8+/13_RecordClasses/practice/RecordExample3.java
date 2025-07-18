
// RecordExample3.java - Record with Methods
record Rectangle(double width, double height) {
    public double area() {
        return width * height;
    }
}

public class RecordExample3 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + rect.area());
    }
}
