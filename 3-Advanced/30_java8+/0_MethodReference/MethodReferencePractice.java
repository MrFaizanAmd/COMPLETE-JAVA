import java.util.*;
import java.util.function.*;

class Utility {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    
    public int square(int n) {
        return n * n;
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static void printList(List<String> list) {
        list.forEach(System.out::println);
    }
}

public class MethodReferencePractice {
    public static void main(String[] args) {
        // Reference to a static method
        Consumer<String> messagePrinter = Utility::printMessage;
        messagePrinter.accept("Hello, Method References!");
        
        // Reference to an instance method of a particular object
        Utility util = new Utility();
        Function<Integer, Integer> squareFunction = util::square;
        System.out.println("Square of 5: " + squareFunction.apply(5));
        
        // Reference to an instance method of an arbitrary object of a particular type
        Predicate<Integer> evenChecker = Utility::isEven;
        System.out.println("Is 8 even? " + evenChecker.test(8));
        
        // Reference to a constructor
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> names = listSupplier.get();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        
        // Passing method reference to forEach
        Utility.printList(names);
    }
}
