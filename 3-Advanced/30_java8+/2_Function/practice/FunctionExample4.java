// FunctionExample4.java - Function to convert Celsius to Fahrenheit
import java.util.function.Function;

public class FunctionExample4 {
    public static void main(String[] args) {
        Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9/5) + 32;
        System.out.println(celsiusToFahrenheit.apply(0.0)); // 32.0
        System.out.println(celsiusToFahrenheit.apply(100.0)); // 212.0
    }
}
