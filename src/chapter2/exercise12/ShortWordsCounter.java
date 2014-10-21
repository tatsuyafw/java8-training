package chapter2.exercise12;

import java.util.Arrays;
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
        AtomicInteger[] shortWords = new AtomicInteger[this.maxLength + 1];
        for (int i = 0; i < shortWords.length; i++) {
            shortWords[i] = new AtomicInteger(0);
        }

        wordStream.parallel().forEach(s -> {
            if(s.length() <= this.maxLength) {
                shortWords[s.length()].incrementAndGet();
            }
        });
        
        int[] result = new int[this.maxLength + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = shortWords[i].get();
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
