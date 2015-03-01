package chapter8.sandbox;

import static java.util.Comparator.nullsFirst;
import static java.util.Comparator.nullsLast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Sandbox {
    public static void main(String[] args) {
        sandbox1();
    }

    public static void sandbox1() {
        Person personA = new Person("foo", null, "bar");
        Person personB = new Person("foo", "middleB", "bar");
        Person personC = new Person("foo", "middleC", "bar");
        Person personD = new Person("foo", "middleD", "bar");

        List<Person> people = new ArrayList<>();
        people.add(personC);
        people.add(personA);
        people.add(personD);
        people.add(personB);

        people.stream().forEach(p -> System.out.println(p.getMiddleName()));
        System.out.println();

        List<Person> preSortedPeople = new ArrayList<>(people);


        //Comparator<String> comp = nullsLast(Comparator.<String>naturalOrder().reversed());
        Comparator<String> compFirst = nullsFirst(Comparator.<String>naturalOrder()).reversed();
        //Comparator<String> compLast = nullsLast(Comparator.<String>naturalOrder()).reversed();
        Comparator<String> compReverse = nullsLast(Comparator.<String>reverseOrder());

        people.sort( Comparator.comparing(Person::getMiddleName, compFirst) );
        people.stream().forEach(p -> System.out.println(p.getMiddleName()));
        System.out.println();

        preSortedPeople.sort( Comparator.comparing(Person::getMiddleName, compReverse));
        preSortedPeople.forEach(p -> System.out.println(p.getMiddleName()));
        System.out.println();

        System.out.println(compFirst.equals(compReverse));
    }
}

class Person {
    private String firstName, middleName, lastName;

    Person(String firstName, String middleName, String lastName) {
        Objects.requireNonNull(firstName, "firstName must not be null");
        Objects.requireNonNull(lastName, "lastName must not be null");
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
}
