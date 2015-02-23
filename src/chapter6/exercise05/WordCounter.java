package chapter6.exercise05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WordCounter implements Runnable {
    private Path path;
    private ConcurrentHashMap<String, Set<File>> map;

    public WordCounter(Path path, ConcurrentHashMap<String, Set<File>> map) {
        this.path= path;
        this.map = map;
    }

    @Override
    public void run() {
        File file = path.toFile();
        try (Scanner in = new Scanner(path)) {
            while (in.hasNext()) {
                String word = in.next();
                HashSet<File> set = new HashSet<>();
                set.add(file);
                map.merge(word, set, (existingSet, newSet) -> {
                    existingSet.addAll(newSet);
                    return existingSet;
                });
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
