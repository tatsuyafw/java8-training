package chapter2.exercise05;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidParam() {
        StreamUtils.linearCongruentialGenerator(1, 1, 0, 1);
    }

    @Test
    public void testLCGWithValidParams1() {
        Long[] expectedValues = {10L, 2L, 3L, 1L, 0L};
        Stream<Long> stream = StreamUtils.linearCongruentialGenerator(3, 2, 5, 10);
        int maxSize = 5;
        Long[] actualValues = stream.limit(maxSize).toArray(Long[]::new);

        assertEquals(expectedValues.length, actualValues.length);
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void testLCGWithValidParams2() {
        Long[] expectedValues = {
                10L, 252149039181L, 87443922374356L, 97442988689487L, 46639511274414L,
                186231735346465L, 230663807087896L, 75856735677251L, 19312254590354L, 232116663927605L
            };
        Long m = BigInteger.valueOf(2L).pow(48).longValue();
        Stream<Long> stream = StreamUtils.linearCongruentialGenerator(25214903917L, 11, m, 10);
        int maxSize = 10;
        Long[] actualValues = stream.limit(maxSize).toArray(Long[]::new);

        assertEquals(expectedValues.length, actualValues.length);
        assertArrayEquals(expectedValues, actualValues);
    }

}
