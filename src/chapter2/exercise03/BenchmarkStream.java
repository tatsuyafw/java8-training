package chapter2.exercise03;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class BenchmarkStream {
    public static void main(String[] args) {
        int wordsSize = 100_000;
        int maxWordLength = 100;
        Random generator = new Random();
        String[] words = new String[wordsSize];
        for (int i = 0; i < wordsSize; i++) {
            words[i] = stringGenarator('*', generator.nextInt(maxWordLength));
        }

        System.out.println("=== Normal Stream ===");
        Stream<String> wordStream = Arrays.stream(words);
        long startedTime = System.nanoTime();
        wordStream.filter(s -> (s.length() > 50)).count();
        long finishedTime = System.nanoTime();
        System.out.println("Time: " + (finishedTime - startedTime));

        System.out.println("=== Parallel Stream ===");
        wordStream = Arrays.asList(words).parallelStream();
        startedTime = System.nanoTime();
        wordStream.filter(s -> (s.length() > 50)).count();
        finishedTime = System.nanoTime();
        System.out.println("Time: " + (finishedTime - startedTime));
    }

    private static String stringGenarator(char c, int maxLength) {
        StringBuilder builder = new StringBuilder(maxLength);
        for (int i = 0; i < maxLength; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
