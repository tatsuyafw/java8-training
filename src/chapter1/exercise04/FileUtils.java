package chapter1.exercise04;

import java.io.File;
import java.util.Arrays;

public class FileUtils {
    public static File[] sortWithDirPreceded(File[] files) {
        Arrays.sort(files, (first, second) -> {
            if (first.isDirectory() && second.isDirectory()) {
                return first.getPath().compareTo(second.getPath());
            } else if (first.isDirectory() && second.isFile()) {
                return -1;
            } else if (first.isFile() && second.isDirectory()) {
                return 1;
            } else {
                return first.getPath().compareTo(second.getPath());
            }
        });
        return files;
    }
}
