
// 8. Generic Constructor Example
class GenericConstructor {
    private double value;

    <T extends Number> GenericConstructor(T num) {
        value = num.doubleValue();
    }

    void showValue() {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        GenericConstructor gc = new GenericConstructor(10);
        gc.showValue();
    }
}
