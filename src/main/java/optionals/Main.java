package optionals;

import java.util.Optional;

// ? NOTE: In the class we give examples of Optionals
// * DOCS: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
public class Main {
    public static void main(String[] args) {
        // * Java Optionals Tutorial - Crash course

        // Optional to check if the optional is present or empty
        Optional<String> empty = Optional.of("");

        // Print results
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

        // If empty is empty than print World
        String orElse = empty.orElse("World");
        System.out.println(orElse);

        // Print hello toUpperCase orElseGet and print world
        Optional<String> hello = Optional.ofNullable("hello");
        String orElseGet = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    // ... extra computation to retrieve the value
                    return "world";
                });

        System.out.println(orElseGet);

        // * Java Functional Programming - Full Course Tutorial

        Object value = Optional.ofNullable("Hello")
                .  orElseGet(() -> "default value");

        System.out.println(value);

        Object value2 = Optional.ofNullable("Hello")
                .  orElseThrow(() -> new IllegalStateException("exception"));

        System.out.println(value2);

        Optional.ofNullable(null)
                .  ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email"));
    }
}
