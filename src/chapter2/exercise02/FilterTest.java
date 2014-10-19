package chapter2.exercise02;

import static org.junit.Assert.*;
import java.util.stream.Stream;
import org.junit.Test;

public class FilterTest {

    @Test
    public void testFilterCalledFive() {
        Stream<String> words = Stream.iterate("", str -> str + "a");
        Counter counter = new Counter(0);
        int expectedCalledCount = 5;

        words.filter(word -> {
            if (word.length() > 1)
                counter.countUp();
            return word.length() > 1;
        }).limit(expectedCalledCount).toArray();

        assertEquals(expectedCalledCount, counter.getCount());
    }

    @Test
    public void testFileterNotCalledWithoutTermination() {
        Stream<String> words = Stream.iterate("", str -> str + "a");
        Counter counter = new Counter(0);
        int expectedCalledCount = 0;

        words.filter(word -> {
            if (word.length() > 1)
                counter.countUp();
            return word.length() > 1;
        }).limit(1000);

        assertEquals(expectedCalledCount, counter.getCount());
    }

    private class Counter {
        private int counter;

        Counter(int init) {
            this.counter = init;
        }

        public void countUp() {
            counter++;
        }

        public int getCount() {
            return counter;
        }
    }
}
