package chapter6.exercise07;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/*
 * alice.txt の中から最頻出の単語を探す
 */
public class Ex07 {
    private static final String INPUT_FILE_NAME = "alice.txt";

    public static void main(String[] args) {
        Path path = Paths.get(Ex07.class.getResource(INPUT_FILE_NAME).getPath());
        ConcurrentHashMap<String, Long> words = new ConcurrentHashMap<>();
        try (Scanner in = new Scanner(path)) {
            while (in.hasNext()) {
                String word = in.next();
                words.compute(word, (k, v) -> v == null ? 1L : v + 1L);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Map.Entry<String, Long> mostFrequentWord = words.reduceEntries(0L, (wordA, wordB) -> {
            if ( wordA.getValue() >= wordB.getValue() ) {
                return wordA;
            } else {
                return wordB;
            }
        });

        System.out.println("The most frequent word is '" + mostFrequentWord.getKey() + "'"
                + " and the count is " + mostFrequentWord.getValue() + ".");
    }
}
