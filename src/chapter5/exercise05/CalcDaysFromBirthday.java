package chapter5.exercise05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcDaysFromBirthday {
    public static void main(String[] args) {
        if (args.length != 3) {
            usage();
            System.exit(1);
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int day = Integer.parseInt(args[2]);
        System.out.println("You've lived " + calcDaysFromToday(year, month, day) + " days from your birthday.");
    }

    private static long calcDaysFromToday(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        long days = birthday.until(today, ChronoUnit.DAYS) + 1;
        if (days <= 0) {
            throw new IllegalArgumentException("The given day must be before today");
        }
        return days;
    }

    private static void usage() {
        System.out.println("Input your birthday as below");
        System.out.println("$ java year month day");
    }
}
