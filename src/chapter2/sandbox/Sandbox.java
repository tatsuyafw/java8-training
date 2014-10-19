package chapter2.sandbox;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sandbox {
    public static void main(String[] args) {
        Stream<String> languages = Stream.of(new String[] { "Java", "JavaScript" });
        
        System.out.println(languages.filter(lang -> lang.length() > 5).count());
        
        Object[] powers = Stream.iterate(1,  p -> p * 2).peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();
        System.out.println(Arrays.asList(powers));
    }
}
