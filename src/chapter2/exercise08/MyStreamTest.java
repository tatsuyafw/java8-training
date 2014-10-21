package chapter2.exercise08;

import static org.junit.Assert.*;
import java.util.stream.Stream;
import org.junit.Test;

public class MyStreamTest {
    @Test
    public void testZipWithFirstParamEmpty() {
        Stream<Integer> second = Stream.of(2, 4, 6);

        Object[] zippedArray = MyStream.zip(Stream.empty(), second).toArray();
        assertEquals(0, zippedArray.length);
    }

    @Test
    public void testZipWithSecondParamEmpty() {
        Stream<Integer> first = Stream.of(1, 3, 5);

        Object[] zippedArray = MyStream.zip(first, Stream.empty()).toArray();
        assertEquals(1, zippedArray.length);
    }

    @Test
    public void testZipFirstParamLongerThanSecond() {
        Stream<Integer> first = Stream.of(1, 3, 5);
        Stream<Integer> second = Stream.of(2, 4);
        Integer[] expected = { 1, 2, 3, 4, 5 };

        Stream<Integer> zippedStream = MyStream.zip(first, second);
        Integer[] zippedArray = zippedStream.toArray(Integer[]::new);

        assertArrayEquals(expected, zippedArray);
    }

    @Test
    public void testZipFirstParamLengthEqualsSecondParamLength() {
        Stream<Integer> first = Stream.of(1, 3, 5);
        Stream<Integer> second = Stream.of(2, 4, 6);
        Integer[] expected = { 1, 2, 3, 4, 5, 6};

        Stream<Integer> zippedStream = MyStream.zip(first, second);
        Integer[] zippedArray = zippedStream.toArray(Integer[]::new);

        assertArrayEquals(expected, zippedArray);
    }

}
