// VarExample3.java - Using var with Collections
import java.util.ArrayList;
import java.util.List;

public class VarExample3 {
    public static void main(String[] args) {
        var names = List.of("Alice", "Bob", "Charlie");
        for (var name : names) {
            System.out.println(name);
        }
    }
}