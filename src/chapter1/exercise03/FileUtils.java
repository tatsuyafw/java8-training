package chapter1.exercise03;

import java.io.File;

public class FileUtils {
    public static String[] listWithExt(File targetDir, String extname) {
        if ( !targetDir.exists()) {
            throw new IllegalArgumentException("No such a file or directory");
        }
        if ( !targetDir.isDirectory() ) {
            throw new IllegalArgumentException(targetDir.getPath() + " is not a directory");
        }
        
        return targetDir.list((dir, name) -> name.endsWith("." + extname));
    }
}