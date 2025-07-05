// SealedExample2.java - Sealed Class with Non-Sealed Subclass
sealed class Animal permits Dog, Cat {}

final class Dog extends Animal {}
non-sealed class Cat extends Animal {}

class PersianCat extends Cat {}

public class SealedExample2 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new PersianCat();
        System.out.println("Dog and PersianCat instances created.");
    }
}
