package functionalinterface;

import java.util.function.Predicate;

// ? NOTE: In this class we give examples for the Predicate<T>
// * DOCS: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
public class _Predicate {
    public static void main(String[] args) {
        // Normal Java function checks
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("070000000"));
        System.out.println(isPhoneNumberValid("09000343500"));

        // Predicate Checks
        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));

        // Combined Predicate Checks with AND()
        System.out.println("Combined predicate with and()");
        System.out.println("Is phone number valid and contains number 3 ? " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("09000343500"));

        // Combined Predicate Checks with OR()
        System.out.println("Combined predicate with or()");
        System.out.println("Is phone number valid or contains number 3 ? " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("09000343500"));
    }

    // Predicate<T> Function
    static Predicate<String> isPhoneNumberValidPredicate = (phoneNumber) ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    // Second Predicate<T> Function
    static Predicate<String> containsNumber3 = (phoneNumber) -> phoneNumber.contains("3");

    // Normal Java Function
     static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
     }
}
