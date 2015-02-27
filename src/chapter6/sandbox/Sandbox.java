package chapter6.sandbox;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Sandbox {
    public static void main(String[] args) {
        sandbox2();
    }

    public static void sandbox2() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            return "CF";
        });

        cf.thenAccept(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sandbox1() {
        String[] words = { "abc", "abc", "bdc", "a", "x", "y", "z", "z", "y", "abc" };
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            wordCounter.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }

        for (Map.Entry<String, Integer> e : wordCounter.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

    }
}
