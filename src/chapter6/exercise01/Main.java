package chapter6.exercise01;


public class Main {
    private static String[] LANGUAGES = { "Java", "JavaScript", "C",
        "C++", "C#", "Perl", "Python", "Ruby", "TypeScript", "Go", "PHP", "ClojureScript" };
    private static int THREAD_NUM = LANGUAGES.length;

    public static void main(String[] args) {
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

        System.out.println("Longest language is " + longestLanguage.get());

    }
}
