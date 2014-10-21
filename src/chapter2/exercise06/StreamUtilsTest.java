package chapter2.exercise06;

import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.*;

public class StreamUtilsTest {

    @Test
    public void testZeroLengthString() {
        Stream<Character> charStream = StreamUtils.characterStream("");
        int expectedCount = 0;

        assertEquals(expectedCount, charStream.count());
    }
    
    @Test
    public void testValidString() {
        Stream<Character> charStream = StreamUtils.characterStream("abcdefg");
        Character[] expectedChars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
        
        Character[] actualChars = charStream.toArray(Character[]::new);
        
        assertEquals(expectedChars.length, actualChars.length);
        for (int i = 0; i < expectedChars.length; i++) {
            assertEquals(expectedChars[i], actualChars[i]);
        }
    }

}
