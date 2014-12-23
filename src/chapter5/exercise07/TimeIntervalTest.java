package chapter5.exercise07;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class TimeIntervalTest {
    private TimeInterval interval1; // |----|
    private TimeInterval interval2; //      |----|
    private TimeInterval interval3; //  |----|
    private TimeInterval interval4; //  |-|

    @Before
    public void setup() {
        LocalDate date = LocalDate.of(2014, 10, 31);
        interval1 = createTimeIntervalHelper(date, 9, 0, 10, 0);
        interval2 = createTimeIntervalHelper(date, 10, 0, 11, 0);
        interval3 = createTimeIntervalHelper(date, 9, 15, 10, 15);
        interval4 = createTimeIntervalHelper(date, 9, 15, 9, 30);
    }

    @Test
    public void testNoOverlappedSchedule1() {
        assertFalse(interval1.isOverlapped(interval2));
        assertFalse(interval2.isOverlapped(interval1));
    }

    @Test
    public void testNoOverlappedSchedule2() {
        assertFalse(interval4.isOverlapped(interval2));
        assertFalse(interval2.isOverlapped(interval4));
    }

    @Test
    public void testOverlappedSchedule1() {
        assertTrue(interval1.isOverlapped(interval3));
        assertTrue(interval3.isOverlapped(interval1));
    }

    @Test
    public void testOverlappedSchedule2() {
        assertTrue(interval1.isOverlapped(interval4));
        assertTrue(interval4.isOverlapped(interval1));
    }

    @Test
    public void testOverlappedSchedule3() {
        assertTrue(interval3.isOverlapped(interval4));
        assertTrue(interval4.isOverlapped(interval3));
    }

    @Test
    public void testOverlappedSchedule4() {
        assertTrue(interval1.isOverlapped(interval1));
    }

    private TimeInterval createTimeIntervalHelper(LocalDate date, int startHour, int startMinute, int endHour, int endMinute) {
        return new TimeInterval(
                LocalDateTime.of(date, LocalTime.of(startHour, startMinute)),
                LocalDateTime.of(date, LocalTime.of(endHour, endMinute))
                );
    }

}
