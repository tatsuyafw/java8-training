package chapter2.exercise13;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ShortWordsCounter {
    public static final int COUTUP_LENGTH_LIMIT = 30;
    private int maxLength;
    private String[] words;

    public ShortWordsCounter(String[] words, int maxLength) {
        if (maxLength > COUTUP_LENGTH_LIMIT) {
            throw new IllegalArgumentException("Max length is " + COUTUP_LENGTH_LIMIT);
        }
        this.maxLength = maxLength;
        this.words = words;
    }

    public int[] countUp() {
        Stream<String> wordStream = Arrays.stream(words);
        
        Map<Integer, Long> shortWords = wordStream.collect(
                groupingBy(s -> {
                    if (s.length() <= this.maxLength) {
                        return s.length();
                    } else {
                        //  If a word's length is shorter than maxLength, returns -1 not to count up this word. 
                        return -1; 
                    }
                }, counting())
                );

        int[] result = new int[this.maxLength + 1];
        for (Map.Entry<Integer, Long> e : shortWords.entrySet()) {
            if ( ! e.getKey().equals(-1) ) {
                result[e.getKey()] = e.getValue().intValue();
            }
         }

        return result;
    }

    public static void main(String[] args) {
        String[] words = { "JavaScript", "Java", "Ruby", "Perl", "Python", "Haskell", "Go", "C", "Ada", "C++" };
        int maxLenght = 8;
        ShortWordsCounter counter = new ShortWordsCounter(words, maxLenght);

        System.out.println(Arrays.toString(counter.countUp()));
    }
}
