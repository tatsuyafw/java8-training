package chapter6.exercise11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * This code is a sample.
 * DO NOT USE for production.
 */
public class Main {
    private final static String SAMPLE_PASSWORD = "secret";

    public static void main(String[] args) {
        CompletableFuture<PasswordAuthentication> passwordAuthenticationFuture = repeat(readUserPass(), checkPassword());

        try {
            PasswordAuthentication pass = passwordAuthenticationFuture.get();
            System.out.println("Hi, " + pass.getUserName() + "!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static Supplier<PasswordAuthentication> readUserPass() {
        return () -> {
            String username = "", password = "";

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
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
                System.exit(1);
            } finally {
            }

            return new PasswordAuthentication(username, password.toCharArray());
        };
    }

    private static Predicate<PasswordAuthentication> checkPassword() {
        return (passwordAuthentication) -> {
            // Simulate an authentication delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.exit(1);
            }

            String password = String.valueOf(passwordAuthentication.getPassword());
            if ( password.equals(SAMPLE_PASSWORD) ) {
                return true;
            } else {
                System.out.println("Sorry, try again");
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
