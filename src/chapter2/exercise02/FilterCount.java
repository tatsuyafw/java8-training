package chapter2.exercise02;

import java.util.stream.Stream;

public class FilterCount {
    public static void main(String[] args) {
        Stream<String> words = Stream.iterate("", str -> str + "a");
        words.filter(word -> {
            if (word.length() > 1)
                System.out.println("Fitered: " + word);
            return word.length() > 1;
        }).limit(5).toArray();

    }
}
