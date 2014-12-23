package chapter5.exercise06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Friday13th {
    public static void main(String[] args) {
        for (LocalDate date : getFridayThe13thDaysOfTwentiethCentury()) {
            System.out.println(date);
        }
    }

    public static LocalDate[] getFridayThe13thDaysOfTwentiethCentury() {
        LocalDate startOfTwentiethCentury = LocalDate.of(1901, 1, 1);
        LocalDate endOfTwentiethCentury = LocalDate.of(2000, 12, 31);

        Stream<LocalDate> stream = dateStream(startOfTwentiethCentury, endOfTwentiethCentury);
        Stream<LocalDate> fridayThe13thDays = stream.filter(d -> {
            if ( d.getDayOfMonth() == 13
                    && d.getDayOfWeek().equals(DayOfWeek.FRIDAY) ) {
                return true;
            } else {
                return false;
            }
        });

        return fridayThe13thDays.toArray(LocalDate[]::new);
    }

    private static Stream<LocalDate> dateStream(LocalDate start, LocalDate end) {
        long days = start.until(end, ChronoUnit.DAYS) + 1;
        Stream<LocalDate> stream = Stream.iterate(start, d -> d.plusDays(1)).limit(days);
        return stream;
    }

}
