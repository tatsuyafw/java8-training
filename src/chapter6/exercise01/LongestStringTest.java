package chapter6.exercise01;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class LongestStringTest {
    private static String[] LANGUAGES = { "Java", "JavaScript", "C",
        "C++", "C#", "Perl", "Python", "Ruby", "TypeScript", "Go", "PHP", "ClojureScript" };
    private static int THREAD_NUM = LANGUAGES.length;
    private static String EXPECTED_LONGEST_LANGUAGE;

    static {
        EXPECTED_LONGEST_LANGUAGE = Stream.of(LANGUAGES).reduce((a, b) -> {
            return a.length() >= b.length() ? a : b;
        }).get();
    }

    @Test
    public void testUpdateAndGet() {
        LongestString longestLanguage = new LongestString("");

        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < threads.length; i++) {
            final String language = LANGUAGES[i];
            threads[i] = new Thread() {
                @Override
                public void run() {
                    longestLanguage.update(language);
                }
            };
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        System.out.println(longestLanguage.get());
        assertEquals(EXPECTED_LONGEST_LANGUAGE, longestLanguage.get());
    }

}
