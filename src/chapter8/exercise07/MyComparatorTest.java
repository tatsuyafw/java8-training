package chapter8.exercise07;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyComparatorTest {
    private Comparator<String> usedReversedComparator;
    private Comparator<String> myReverseComparator;
    private List<Person> people;

    @Before
    public void setup() {
        usedReversedComparator = Comparator.nullsFirst(Comparator.<String>naturalOrder()).reversed();
        myReverseComparator = Comparator.nullsLast(Comparator.reverseOrder());
        people = new ArrayList<>();
        Person personA = new Person("foo", null, "bar");
        Person personB = new Person("foo", "middleB", "bar");
        Person personC = new Person("foo", "middleC", "bar");
        Person personD = new Person("foo", null, "bar");

        people.add(personC);
        people.add(personA);
        people.add(personD);
        people.add(personB);
    }

    @Test
    public void testComparator() {
        List<Person> clonedPeople = new ArrayList<>(people);

        people.sort( Comparator.comparing(Person::getMiddleName, usedReversedComparator) );
        clonedPeople.sort( Comparator.comparing(Person::getMiddleName, myReverseComparator) );

        Person[] soretedPeople = people.toArray(new Person[people.size()]);
        Person[] clonedSortedPeople = clonedPeople.toArray(new Person[clonedPeople.size()]);

        assertArrayEquals(soretedPeople, clonedSortedPeople);
    }

}

/**
 * テスト用クラス
 */
class Person {
    private String firstName, middleName, lastName;

    Person(String firstName, String middleName, String lastName) {
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
