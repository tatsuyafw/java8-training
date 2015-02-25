package chapter6.exercise11;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
    }

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenCompose(result -> {
            if (until.test(result)) {
                return CompletableFuture.<T>supplyAsync(() -> result);
            } else {
                return repeat(action, until);
            }
        });

    }
}
