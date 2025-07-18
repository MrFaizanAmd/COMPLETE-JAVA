
// 5. Wildcard Example
import java.util.List;
import java.util.Arrays;

class WildcardExample {
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        printNumbers(numbers);
    }
}
