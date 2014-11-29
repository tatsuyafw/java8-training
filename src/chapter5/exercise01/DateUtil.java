package chapter5.exercise01;

import java.time.LocalDate;
import java.time.Year;

public class DateUtil {
    public static final int PROGRAMMERS_DAY = 256;

    public static LocalDate programmersDayOf(Year year) {
        return year.atDay(PROGRAMMERS_DAY);
    }

    public static void main(String[] args) {
        Year thisYear = Year.now();
        System.out.println(programmersDayOf(thisYear));
    }
}
