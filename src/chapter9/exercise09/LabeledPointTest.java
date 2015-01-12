package chapter9.exercise09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LabeledPointTest {

    @Test
    public void testEqualsReflexivity() {
        LabeledPoint a = new LabeledPoint("a", 0, 0);
        assertTrue(a.equals(a));
    }

    @Test
    public void testEqualsSimmetry() {
        LabeledPoint a = new LabeledPoint("point", 0, 0);
        LabeledPoint b = new LabeledPoint("point", 0, 0);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

    @Test
    public void testEqualsTransivity() {
        LabeledPoint a = new LabeledPoint("point", 0, 0);
        LabeledPoint b = new LabeledPoint("point", 0, 0);
        LabeledPoint c = new LabeledPoint("point", 0, 0);
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(c.equals(a));
    }

    @Test
    public void testEqualsConsistency() {
        LabeledPoint a = new LabeledPoint("point", 0, 0);
        LabeledPoint b = new LabeledPoint("point", 0, 0);
        assertTrue(a.equals(b));
        a.getX(); a.getY();
        assertTrue(a.equals(b));
    }

    @Test
    public void testHashCode1() {
        LabeledPoint a = new LabeledPoint("point", 100, 100);
        LabeledPoint b = new LabeledPoint("point", 100, 100);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testHashCode2() {
        LabeledPoint a = new LabeledPoint(null, 100, 100);
        LabeledPoint b = new LabeledPoint(null, 100, 100);
        assertEquals(a.hashCode(), b.hashCode());
    }

}
