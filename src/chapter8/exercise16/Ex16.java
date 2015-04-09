package chapter8.exercise16;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Ex16 {
    private static final String DATA_FILE = "data.txt";
    public static void main(String[] args) {
        String regexp = "(?<city>[\\p{L} ]+),\\s*(?<state>[A-Z]{2}),\\s*(?<zipcode>[0-9]{5,9}|[0-9]{5}-[0-9]{4})";
        try ( Stream<String> lines = Files.lines(Paths.get(Ex16.class.getResource(DATA_FILE).getPath())) ) {
            Pattern pattern = Pattern.compile(regexp);
            lines.forEach((line) -> {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String city = matcher.group("city");
                    String state = matcher.group("state");
                    String zipcode = matcher.group("zipcode");
                    System.out.println("City: " + city + ", State: " + state + ", Zip code: " + zipcode);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
