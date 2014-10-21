package chapter2.exercise12;

import static org.junit.Assert.*;

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
        int[] result = counter.countUp();
        IntStream resultStream = Arrays.stream(result);

        assertEquals(maxLength + 1, result.length);
        assertTrue(resultStream.allMatch(i -> (i == 0)));
    }

    @Test
    public void testCountUpWithValidWordList() {
        String[] words = { "C", "C++", "Java", "C#", "JavaScript", "Go", "Ruby", "Haskell", "Perl", "Python", "OCaml" };
        int maxLength = 5;
        ShortWordsCounter counter = new ShortWordsCounter(words, maxLength);
        int[] result = counter.countUp();
        int[] expectedResult = { 0, 1, 2, 1, 3, 1 };

        assertEquals(expectedResult.length, result.length);
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i], result[i]);
        }
    }
}
