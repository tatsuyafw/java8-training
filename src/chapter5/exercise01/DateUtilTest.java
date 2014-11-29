package chapter5.exercise01;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Year;

import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testNotLeapYear1() {
        int year = 2014;
        LocalDate expectedProgrammersDay = LocalDate.of(year, 9, 13);
        LocalDate actualProgrammersDay = DateUtil.programmersDayOf(Year.of(year));
        assertEquals(expectedProgrammersDay, actualProgrammersDay);
    }

    @Test
    public void testNotLeapYear2() {
        int year = 1900;
        LocalDate expectedProgrammersDay = LocalDate.of(year, 9, 13);
        LocalDate actualProgrammersDay = DateUtil.programmersDayOf(Year.of(year));
        assertEquals(expectedProgrammersDay, actualProgrammersDay);
    }

    @Test
    public void testLeapYear1() {
        int leapYear = 2012;
        LocalDate expectedProgrammersDay = LocalDate.of(leapYear, 9, 12);
        LocalDate actualProgrammesDay = DateUtil.programmersDayOf(Year.of(leapYear));
        assertEquals(expectedProgrammersDay, actualProgrammesDay);
    }

    @Test
    public void testLeapYear2() {
        int leapYear = 2000;
        LocalDate expectedProgrammersDay = LocalDate.of(leapYear, 9, 12);
        LocalDate actualProgrammersDay = DateUtil.programmersDayOf(Year.of(leapYear));
        assertEquals(expectedProgrammersDay, actualProgrammersDay);
    }

}
