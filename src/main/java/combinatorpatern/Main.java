package combinatorpatern;

import java.time.LocalDate;

import static combinatorpatern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+099999",
                LocalDate.of(2000, 1, 1)
        );

        // Check if the customer is valid via the normal way
        System.out.println(new CustomerValidatorService().isValid(customer));

        // Check if the customer is valid with the Combinator Pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        // Throw the exception with the ValidationResult name
        // Take the @ sign away with the customer above to initiate this exception
        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
