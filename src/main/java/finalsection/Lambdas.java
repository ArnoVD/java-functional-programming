package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

// ? Example of lambdas
public class Lambdas {
    public static void main(String[] args) {
        // Different ways to write lambda's
        Function<String, String> upperCaseName = name -> name.toUpperCase();

        Function<String, String> upperCaseNameShort = String::toUpperCase;

        Function<String, String> upperCaseNameLong = name -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name is blank");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseNameBiFunction = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name is blank");
            return name.toUpperCase();
        };

        String upperCasedName =  upperCaseNameBiFunction.apply("Alex", 20);
        System.out.println(upperCasedName);
    }
}
