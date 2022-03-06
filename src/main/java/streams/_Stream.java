package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

// ? NOTE: In this class we give examples about streams
// * DOCS: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // Java Stream to collect and print all the genders
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Java Stream print the length of each persons name
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // Java Stream to check if there are only females
        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);

        // Java Stream to check if there is at least one male
        boolean containsAtLeastOneMale = people.stream()
                .anyMatch(person -> MALE.equals(person.gender));
        System.out.println(containsAtLeastOneMale);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
