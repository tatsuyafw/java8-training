package chapter2.exercise04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SeveralStreams {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        
        System.out.println(Stream.of(values).getClass());
        System.out.println(IntStream.of(values).getClass());
        System.out.println(int.class.getCanonicalName());
    }
}
