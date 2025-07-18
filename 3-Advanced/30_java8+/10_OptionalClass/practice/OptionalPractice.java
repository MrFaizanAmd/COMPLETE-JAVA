import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        // 1. Creating Optional instances
        Optional<String> nonEmpty = Optional.of("Hello, Optional!");
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nullableOpt = Optional.ofNullable(null);

        // 2. Checking if value is present
        System.out.println("Is nonEmpty present? " + nonEmpty.isPresent());
        System.out.println("Is emptyOpt present? " + emptyOpt.isPresent());
        
        // 3. Using ifPresent()
        nonEmpty.ifPresent(value -> System.out.println("Value: " + value));
        emptyOpt.ifPresent(value -> System.out.println("Will not print"));

        // 4. Using orElse() and orElseGet()
        System.out.println("orElse Example: " + emptyOpt.orElse("Default Value"));
        System.out.println("orElseGet Example: " + emptyOpt.orElseGet(() -> "Computed Default"));

        // 5. Using orElseThrow()
        try {
            emptyOpt.orElseThrow(() -> new IllegalArgumentException("No value present!"));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 6. Transforming values with map()
        Optional<Integer> lengthOpt = nonEmpty.map(String::length);
        System.out.println("Length of string: " + lengthOpt.orElse(-1));

        // 7. Using flatMap() (Useful for nested Optionals)
        Optional<Optional<String>> nestedOpt = Optional.of(Optional.of("Nested"));
        Optional<String> flattenedOpt = nestedOpt.flatMap(opt -> opt);
        System.out.println("Flattened Value: " + flattenedOpt.orElse("Not Found"));

        // 8. Filtering values
        Optional<String> filteredOpt = nonEmpty.filter(val -> val.startsWith("H"));
        System.out.println("Filtered Value: " + filteredOpt.orElse("Does not start with H"));

        // 9. Chaining Optionals
        Optional<String> result = nonEmpty
            .filter(val -> val.length() > 5)
            .map(String::toUpperCase);
        System.out.println("Chained Result: " + result.orElse("No valid result"));
    }
}
