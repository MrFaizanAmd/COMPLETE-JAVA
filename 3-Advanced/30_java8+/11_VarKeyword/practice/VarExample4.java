// VarExample4.java - Using var with Streams
import java.util.List;

public class VarExample4 {
    public static void main(String[] args) {
        var numbers = List.of(10, 20, 30, 40);
        numbers.stream().map((Integer num) -> num * 2).forEach(System.out::println);
    }
}