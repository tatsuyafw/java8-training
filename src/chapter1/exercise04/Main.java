package chapter1.exercise04;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Input files and directories");
            System.exit(1);
        }
        
        File[] files = new File[args.length];
        for (int i = 0; i < args.length; i++) {
            files[i] = new File(args[i]);
        }
        
        System.out.println(Arrays.asList(FileUtils.sortWithDirPreceded(files)));
    }
}
