package chapter6.exercise05;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        // 以下のファイルから読み込む
        String[] fileNames = { "alice.txt", "services", "words" };
        Path[] paths = new Path[fileNames.length];
        for (int i = 0; i < fileNames.length; i++) {
            paths[i] = Paths.get(Main.class.getResource( fileNames[i] ).getPath());
        }

        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();

        int threadNum = fileNames.length;
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            WordCounter counter = new WordCounter(paths[i], map);
            threads[i] = new Thread(counter);
            threads[i].start();
        }

        for (int i = 0; i < threadNum; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(map.get("Alice"));
        System.out.println(map.get("a"));
        System.out.println(map.get("System"));
    }
}
