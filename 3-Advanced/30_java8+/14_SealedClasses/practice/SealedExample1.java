// SealedExample1.java - Basic Sealed Class
sealed class Vehicle permits Car, Truck {}

final class Car extends Vehicle {}
final class Truck extends Vehicle {}

public class SealedExample1 {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle truck = new Truck();
        System.out.println("Created instances of Car and Truck.");
    }
}