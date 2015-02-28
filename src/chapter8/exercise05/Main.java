package chapter8.exercise05;

import static utils.BenchMark.benchmark;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String INPUT_FILE_NAME = "alice.txt";
    public static void main(String[] args) {
        Path path = Paths.get(Main.class.getResource( INPUT_FILE_NAME ).getPath());
        List<String> words = readFile(path);

        Duration elapsedRemoveIf = benchmark(() -> {
            words.removeIf(lang -> lang.length() <= 12);
        });
        System.out.println("removeIf elapsed: " + elapsedRemoveIf.toNanos());

        Duration elapsedStream = benchmark(() -> {
            words.stream().filter(w -> w.length() > 12);
        });
        System.out.println("stream elapsed  : " + elapsedStream.toNanos());
    }

    private static List<String> readFile(Path path) {
        List<String> words = new ArrayList<>();
        try (Scanner in = new Scanner(path)) {
            while (in.hasNext()) {
                words.add(in.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return words;
    }
}
