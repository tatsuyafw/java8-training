package chapter1.exercise03;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if ( args.length != 2 ) {
            System.err.println("Input a directory and an extname");
            System.err.println("$ java Main dirname extname");
            System.exit(1);
        }

        File targetDir = new File(args[0]);
        String extname = args[1];

        System.out.println(Arrays.asList(FileUtils.listWithExt(targetDir, extname)));
    }
}
