
// 13. Bounded Wildcard Example
import java.util.ArrayList;
import java.util.List;

class BoundedWildcardExample {
    public static void sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        sumNumbers(intList);
    }
}
