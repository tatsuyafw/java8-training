package chapter6.exercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    // see: http://hack.aipo.com/archives/3118/
    public static final Pattern urlPatern =
            Pattern.compile("((https?)\\:([\\w|\\:\\!\\#\\$\\%\\=\\&\\-\\^\\`\\\\|\\@\\~\\[\\{\\]\\}\\;\\+\\*\\,\\.\\?\\/]+))",
                    Pattern.CASE_INSENSITIVE);

    public static CompletableFuture<List<String>> getLinks(String page) {
        return CompletableFuture.supplyAsync(() -> {
            List<String> links = new ArrayList<>();

            Matcher matcher = urlPatern.matcher(page);
            while (matcher.find()) {
                String link = matcher.group(1);
                links.add(link);
            }

            return links;
        });
    }
}
