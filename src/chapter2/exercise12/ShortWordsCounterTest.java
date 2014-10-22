package chapter2.exercise12;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

public class ShortWordsCounterTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCannotCreateInstanceOverTheLimit() {
        String[] words = { "dummy" };
        new ShortWordsCounter(words, ShortWordsCounter.COUTUP_LENGTH_LIMIT + 1);
    }

    @Test
    public void testCountUpWithEmptyWordList() {
        String[] words = {};
        int maxLength = 10;
        ShortWordsCounter counter = new ShortWordsCounter(words, maxLength);
        int[] actualResult = counter.countUp();
        IntStream resultStream = Arrays.stream(actualResult);

        assertEquals(maxLength + 1, actualResult.length);
        assertTrue(resultStream.allMatch(i -> (i == 0)));
    }

    @Test
    public void testCountUpWithValidWordList() {
        String[] words = { "C", "C++", "Java", "C#", "JavaScript", "Go", "Ruby", "Haskell", "Perl", "Python", "OCaml" };
        int maxLength = 5;
        ShortWordsCounter counter = new ShortWordsCounter(words, maxLength);
        int[] actualResult = counter.countUp();
        int[] expectedResult = { 0, 1, 2, 1, 3, 1 };

        assertEquals(expectedResult.length, actualResult.length);
        assertArrayEquals(expectedResult, actualResult);
    }
}
