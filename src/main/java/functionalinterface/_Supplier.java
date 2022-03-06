package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

// ? NOTE: In this class we give examples for the Supplier<T>
// * DOCS: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
public class _Supplier {
    public static void main(String[] args) {
        // Normal Java Function
        System.out.println(getDbConnectingUrl());

        // Supplier Function
        System.out.println(getDbConnectionUrlSupplier.get());

        // Supplier Function returning a list
        System.out.println(getDbConnectionUrlListSupplier.get());
    }

    // Supplier Function
    static Supplier<String> getDbConnectionUrlSupplier = () -> "jdbc://localhost:5432/users";

    // Supplier Function returning a list
    static Supplier<List<String>> getDbConnectionUrlListSupplier = () -> List.of("jdbc://localhost:5432/users");

    // Normal Java Function
    static String getDbConnectingUrl() {
        return "jdbc://localhost:5432/users";
    }
}
