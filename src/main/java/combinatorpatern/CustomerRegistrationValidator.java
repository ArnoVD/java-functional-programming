package combinatorpatern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

// ? Example of the implementation of the Combinator Pattern
public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    // Validations of the customer fields
    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().contains("+0") ?
                SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() > 18 ?
                SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    // This is where the magic happens
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
