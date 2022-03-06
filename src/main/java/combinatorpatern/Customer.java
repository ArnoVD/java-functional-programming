package combinatorpatern;

import java.time.LocalDate;

// ? NOTE: In the class we give examples of the Combinator Pattern
public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dateOfBirth;

    public Customer(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
