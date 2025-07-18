
// RecordExample5.java - Record Implementing an Interface
interface Describable {
    String describe();
}

record Car(String model, int year) implements Describable {
    public String describe() {
        return "Car model: " + model + ", Year: " + year;
    }
}

public class RecordExample5 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022);
        System.out.println(car.describe());
    }
}
