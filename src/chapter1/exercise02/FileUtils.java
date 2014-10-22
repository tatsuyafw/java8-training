package chapter1.exercise02;

import java.io.File;

public class FileUtils {
    public static File[] subDirectories(File targetDir) {
        if ( !targetDir.exists() ) {
            throw new IllegalArgumentException("No such a file or directory: " + targetDir.getPath());
        }
        if ( !targetDir.isDirectory() ) {
            throw new IllegalArgumentException(targetDir.getPath() + " is not a directory");
        }

        //return targetDir.listFiles(pathname -> pathname.isDirectory()); // Lambda expression
        return targetDir.listFiles(File::isDirectory);  // Method reference
    }
}
