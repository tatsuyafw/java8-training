package chapter2.exercise06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {
    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).boxed().map(s::charAt);
    }
}
