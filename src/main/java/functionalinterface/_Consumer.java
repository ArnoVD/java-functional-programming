package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// ? NOTE: In this class we give examples for the Consumer<T> and BiConsumer<T, U>
// * DOCS: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
public class _Consumer {
    public static void main(String[] args) {
        // Customer object
        Customer maria = new Customer("Maria", "99999");

        // Normal Java Function
        greetCustomer(maria);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);

        // BiConsumer Functional interface
        greetCustomerBiConsumer.accept(maria, false);
    }

    // Consumer<T> Function Example
    static Consumer<Customer> greetCustomerConsumer = (customer) -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " + customer.customerPhoneNumber);

    // BiConsumer<T, U> Function Example where we can choose with a boolean if we want to show the phone number
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number " + (showPhoneNumber ? customer.customerPhoneNumber: "*****"));

    // Normal Java Function
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    // Customer object
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
