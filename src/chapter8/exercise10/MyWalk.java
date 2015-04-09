package chapter8.exercise10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyWalk {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Needs a root directory");
            System.exit(1);
        }
        Path pathToRoot = Paths.get(args[0]);
        String[] reservedWords = { "transient", "volatile" };
        List<Path> files = filesContainGivenWord(pathToRoot, reservedWords);
        files.stream().forEach(System.out::println);
        System.out.println(files.size());
    }

    public static List<Path> filesContainGivenWord(Path pathToRoot, String[] words) {
        List<Path> list = new ArrayList<>();

        try (Stream<Path> entries = Files.walk(pathToRoot)) {
            entries.filter(path -> {
                return Files.isRegularFile(path);
            }).forEach((path) -> {
                try (Stream<String> lines = Files.lines(path)) {
                    Predicate<String> p = (line) -> { // 行に指定された単語のいづれかが含まれているかの述語
                        for (String word : words) {
                            if (line.contains(word)) {
                                return true;
                            }
                        }
                        return false;
                    };
                    if (lines.anyMatch(p)) {
                        list.add(path);
                    }
                } catch (IOException ex) { // Files.lines
                    ex.printStackTrace();
                    System.exit(1);
                }
            });
        } catch (IOException ex) { // Files.walk
            ex.printStackTrace();
            System.exit(1);
        }

        return list;
    }
}
