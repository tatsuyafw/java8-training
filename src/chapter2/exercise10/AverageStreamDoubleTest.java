package chapter2.exercise10;
import static org.junit.Assert.*;
import static chapter2.exercise10.AverageStreamDouble.*;
import java.util.stream.Stream;

import org.junit.Test;

public class AverageStreamDoubleTest {
    private Stream<Double> doubleStream = Stream.of(1.0, 2.0, 3.0);
    private Double expectedAverage = (1.0 + 2.0 + 3.0) / 3;

    @Test
    public void testEmptyDoubleStream() {
        assertTrue(AverageStreamDouble.doubleAverage(Stream.empty()).equals(0.0));
    }
    
    @Test
    public void testDoubleAverageWorkCorrectly() {
        assertEquals(expectedAverage, doubleAverage(doubleStream), 0.0001);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testDoubleAverageIllegalState() {
        doubleAverageIllegalState(doubleStream);
    }

}
