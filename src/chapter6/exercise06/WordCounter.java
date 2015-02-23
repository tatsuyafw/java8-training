package chapter6.exercise06;

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
                map.computeIfAbsent(word, k -> {
                    // 単語が登録されていなかった場合にのみ HashSet を生成するだけで済む
                    HashSet<File> set = new HashSet<File>();
                    set.add(file);
                    return set;
                }).add(file);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
