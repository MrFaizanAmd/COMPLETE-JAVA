import java.util.function.*;
import java.util.*;

public class BiFunctionPractice {
    public static void main(String[] args) {
        // 1. BiFunction: Concatenate first and last names
        BiFunction<String, String, String> fullNameFunction = (first, last) -> first + " " + last;
        System.out.println("Full Name: " + fullNameFunction.apply("John", "Doe"));
        
        // 2. BiFunction: Calculate area of a rectangle
        BiFunction<Integer, Integer, Integer> areaFunction = (length, width) -> length * width;
        System.out.println("Area of 5x10 rectangle: " + areaFunction.apply(5, 10));
        
        // 3. BiFunction: Find the maximum of two numbers
        BiFunction<Integer, Integer, Integer> maxFunction = Integer::max;
        System.out.println("Max of 8 and 12: " + maxFunction.apply(8, 12));
        
        // 4. BiFunction: Merge two lists into a new list
        BiFunction<List<Integer>, List<Integer>, List<Integer>> mergeLists = (list1, list2) -> {
            List<Integer> merged = new ArrayList<>(list1);
            merged.addAll(list2);
            return merged;
        };
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        System.out.println("Merged List: " + mergeLists.apply(list1, list2));
        
        // 5. BiFunction: Convert two integers into a formatted string
        BiFunction<Integer, Integer, String> formattedString = (a, b) -> "Sum of " + a + " and " + b + " is " + (a + b);
        System.out.println(formattedString.apply(7, 9));
        
        // 6. BiFunction: Compute total salary with base salary and bonus
        BiFunction<Double, Double, Double> totalSalary = (base, bonus) -> base + bonus;
        System.out.println("Total Salary: " + totalSalary.apply(50000.0, 5000.0));
        
        // 7. BiFunction with andThen(): Convert area to a formatted string
        BiFunction<Integer, Integer, Integer> areaFunc = (l, w) -> l * w;
        Function<Integer, String> areaToString = area -> "The area is: " + area + " square units";
        System.out.println(areaFunc.andThen(areaToString).apply(6, 8));
        
        // 8. BiFunction with andThen(): Calculate product and then double it
        BiFunction<Integer, Integer, Integer> productFunction = (a, b) -> a * b;
        Function<Integer, Integer> doubleFunction = result -> result * 2;
        System.out.println("Double the product: " + productFunction.andThen(doubleFunction).apply(3, 4));
    }
}
