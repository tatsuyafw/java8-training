package chapter5.exercise02;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateSandbox {
    public static void main(String[] args) {
        LocalDate leapDay = LocalDate.of(2000, 2, 29);
        System.out.println("Leap Day: " + leapDay);

        System.out.print("Add a year to leapDay: ");
        System.out.println(leapDay.plus(Period.ofYears(1)));

        System.out.print("Add four years to leapDay: ");
        System.out.println(leapDay.plus(Period.ofYears(4)));

        int count = 4;
        System.out.print("Add a year leapDay for times: ");
        LocalDate newDate = leapDay;
        for (int i = 0; i < count; i++) {
            newDate = newDate.plus(Period.ofYears(1));
        }
        System.out.println(newDate);
    }
}
