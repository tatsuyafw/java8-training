package chapter1.exercise02;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Input a directory");
            System.exit(1);
        }

        for (String pathname : args) {
            System.out.println("Directory " + pathname + " includes:");
            System.out.println(Arrays.asList(FileUtils.subDirectories(new File(pathname))));
            System.out.println();
        }
    }
}
