
// 10. Generic Method Example
class GenericMethodExample {
    public static <T> void display(T value) {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        display(100);
        display("Generics in Java");
        display(10.5);
    }
}
