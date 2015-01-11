package chapter9.exercise08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointTest {

    @Test
    public void testCompareSameObject() {
        Point a = new Point(0, 0);
        assertEquals(0, a.compareTo(a));
    }

    @Test
    public void testCompareEquals1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        assertEquals(0, a.compareTo(b));
    }

    @Test
    public void testCompareEquals2() {
        Point a = new Point(Integer.MAX_VALUE, 0);
        Point b = new Point(Integer.MAX_VALUE, 0);
        assertEquals(0, a.compareTo(b));
    }

    @Test
    public void testCompareWhenAisGreaterThanBCase1() {
        Point a = new Point(1, 0);
        Point b = new Point(0, 0);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    public void testCompareWhenAisGreaterThanBCase2() {
        Point a = new Point(Integer.MAX_VALUE, 0);
        Point b = new Point(Integer.MIN_VALUE, 0);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    public void testCompareWhenAisGreaterThanBCase3() {
        Point a = new Point(0, Integer.MAX_VALUE);
        Point b = new Point(0, Integer.MIN_VALUE);
        assertTrue(a.compareTo(b) > 0);
    }

    @Test
    public void testCompareWhenAisLessThanBCase1() {
        Point a = new Point(-1, 0);
        Point b = new Point(0, 0);
        assertTrue(a.compareTo(b) < 0);
    }

    @Test
    public void testCompareWhenAisLessThanBCase2() {
        Point a = new Point(Integer.MIN_VALUE, 0);
        Point b = new Point(Integer.MAX_VALUE, 0);
        assertTrue(a.compareTo(b) < 0);
    }

    @Test
    public void testCompareWhenAisLessThanBCase3() {
        Point a = new Point(0, Integer.MIN_VALUE);
        Point b = new Point(0, Integer.MAX_VALUE);
        assertTrue(a.compareTo(b) < 0);
    }


}
