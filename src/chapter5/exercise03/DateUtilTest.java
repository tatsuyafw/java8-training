package chapter5.exercise03;

import static chapter5.exercise03.DateUtil.next;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testWeekdayOnFriday() {
        LocalDate friday = LocalDate.of(2014, 11, 7);
        LocalDate expectedWeekday = friday.plusDays(3);
        LocalDate actualWeekday = friday.with(next(w -> w.getDayOfWeek().getValue() < 6));

        assertEquals(expectedWeekday, actualWeekday);
    }

    @Test
    public void testWeekdayOnMonday() {
        LocalDate monday = LocalDate.of(2014, 11, 10);
        LocalDate expectedWeekday= monday.plusDays(1);
        LocalDate actualWeekday = monday.with(next(w -> w.getDayOfWeek().getValue() < 6));

        assertEquals(expectedWeekday, actualWeekday);
    }

}
