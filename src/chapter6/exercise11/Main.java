package chapter6.exercise11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * This code is a sample.
 * DO NOT USE for production.
 */
public class Main {
    private final static String SAMPLE_PASSWORD = "secret";

    public static void main(String[] args) {
        readUserPass();
        checkPassword();
        try {
            ForkJoinPool.commonPool().awaitTermination(10,  TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // WIP
    private static Supplier<PasswordAuthentication> readUserPass() {
        return () -> {
            String username = "", password = "";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line = null;
                // Read a username.
                while ( true ) {
                    System.out.print("Username: ");
                    line = reader.readLine();
                    if ( ! line.isEmpty() ) {
                        username = line;
                        break;
                    }
                }

                // Read a password.
                // TODO: Do not echo back.
                while ( true ) {
                    System.out.print("Password: ");
                    line = reader.readLine();
                    if ( ! line.isEmpty() ) {
                        password = line;
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return new PasswordAuthentication(username, password.toCharArray());
        };
    }

    // WIP
    private static Predicate<PasswordAuthentication> checkPassword() {
        return (passwordAuthentication) -> {
            String password = String.valueOf(passwordAuthentication.getPassword());
            if ( password != SAMPLE_PASSWORD ) {
              return true;
          } else {
              return false;
          }
        };
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
