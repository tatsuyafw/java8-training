package chapter2.exercise04;

import static org.junit.Assert.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamOfTest {
    private final int[] values = { 1, 4, 9, 16 };

    /*
     * FIXME Actually, this codes does not check whether the stream is composed of primitive integer.
     */
    @Test    
    public void testCreatePrimitiveTypeIntegerStream() {
        IntStream stream = IntStream.of(values);        
        assertTrue(stream.toArray().getClass().getCanonicalName().equals("int[]"));
    }
    
    @Test
    public void testCreateObjectTypeIntegerStream() {
        Stream<int[]> stream = Stream.of(values);
        assertFalse(stream.toArray().getClass().getCanonicalName().equals("int[]"));       
    }

}
