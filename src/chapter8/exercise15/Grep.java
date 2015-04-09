package chapter8.exercise15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grep {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: java Grep pattern file");
            System.exit(1);
        }

        String pattern = args[0];
        Path filePath = Paths.get(args[1]);

        for (String line : grep(filePath, pattern) ) {
            System.out.println(line);
        }
    }

    public static List<String> grep(Path path, String pattern) {
        List<String> matchedLines = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path) ) {
            matchedLines = lines.filter(Pattern.compile(pattern).asPredicate()).collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return matchedLines;
    }
}
