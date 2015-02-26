package chapter6.exercise10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final String FETCH_SAMPLE_URL = "http://horstmann.com";

    public static void main(String[] args) {
        getURLInput("Input url: ")
          .thenCompose(url -> readPage(url))
          .thenCompose(page -> Parser.getLinks(page))
          .thenAccept(links -> {
              for (String link : links) {
                System.out.println(link);
              }
          });

        try {
            ForkJoinPool.commonPool().awaitTermination(10,  TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static CompletableFuture<URL> getURLInput(String prompt) {
        return CompletableFuture.supplyAsync(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(prompt);

            String urlString = "";
            try {
                urlString = reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            URL url = null;
            try {
                url = new URL(urlString);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

            return url;
        });
    }

    public static CompletableFuture<String> readPage(URL url) {
        return CompletableFuture.supplyAsync(() -> blockingReadPage(url));
    }

    public static String blockingReadPage(URL url) {
        String contents = null;

        try (Scanner scanner = new Scanner(url.openStream())) {
            scanner.useDelimiter("\\Z"); // Use \\Z instead of $
            contents = scanner.next();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return contents;
    }
}
