// FunctionExample1.java - Basic Function Usage
import java.util.function.Function;

public class FunctionExample1 {
    public static void main(String[] args) {
        Function<Integer, Integer> square = num -> num * num;
        System.out.println(square.apply(5)); // 25
        System.out.println(square.apply(10)); // 100
    }
}
