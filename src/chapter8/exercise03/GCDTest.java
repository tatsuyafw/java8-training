package chapter8.exercise03;

import static chapter8.exercise03.GCD.gcdWithFloorMod;
import static chapter8.exercise03.GCD.gcdWithPercentSymbol;
import static chapter8.exercise03.GCD.gcdWithRem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GCDTest {
    private int a = 24;
    private int b = 16;
    private int expected  = 8;

    @Test
    public void testGcdWithPercentSymbol() {
        assertThat(gcdWithPercentSymbol(a, b), is(expected));
        assertThat(gcdWithPercentSymbol(a, -b), is(expected));
        assertThat(gcdWithPercentSymbol(-a, b), is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGcdWithPercentException() {
        gcdWithPercentSymbol(Integer.MIN_VALUE, 0);
    }

    @Test
    public void testGcdWithFloorMod() {
        assertThat(gcdWithFloorMod(a, b), is(expected));
        assertThat(gcdWithFloorMod(a, -b), is(expected));
        assertThat(gcdWithFloorMod(-a, b), is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGcdWithFloorModException() {
        gcdWithFloorMod(Integer.MIN_VALUE, 0);
    }

    @Test
    public void testGcdWithRem() {
        assertThat(gcdWithRem(a, b), is(expected));
        assertThat(gcdWithRem(a, -b), is(expected));
        assertThat(gcdWithRem(-a, b), is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGcdWithRemException() {
        gcdWithRem(Integer.MIN_VALUE, 0);
    }

}
