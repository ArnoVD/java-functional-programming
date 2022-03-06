package finalsection;

import java.util.function.Consumer;

// ? Example of Callback Functions Like Javascript
public class Callbacks {
    public static void main(String[] args) {
        // Using the callback function
        hello("John", null, firstName -> {
            System.out.println("Lastname not provided for " + firstName);
        });

        // Callback function without an argument
        hello2("John", null, () -> {
            System.out.println("Lastname not provided");
        });
    }

    // Example of a callback function
    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    // Example of a simpler callback function without an argument
    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
