
// FunctionExample2.java - Function Chaining using andThen and compose
import java.util.function.Function;

public class FunctionExample2 {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = num -> num * 2;
        Function<Integer, Integer> squareIt = num -> num * num;
        Function<Integer, Integer> doubleThenSquare = doubleIt.andThen(squareIt);
        Function<Integer, Integer> squareThenDouble = doubleIt.compose(squareIt);
        System.out.println(doubleThenSquare.apply(3)); // 36
        System.out.println(squareThenDouble.apply(3)); // 18
    }
}
