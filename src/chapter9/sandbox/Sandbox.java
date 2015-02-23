package chapter9.sandbox;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Sandbox {
    public static void main(String[] args) {
        Path absolute = Paths.get("/", "home");
        Path relative = Paths.get("myprog", "conf", "user.properties");
        Path configPath = absolute.resolve(relative);
        Path workPath = Paths.get("/", "home", "cay", "myprog", "work");
        Path tempPath = workPath.resolveSibling("temp");

        Path relativizedPath = workPath.relativize(Paths.get("/home/fred/myprog"));
        Path normalizedPath = Paths.get("/home/cay/../fred/./myprog").normalize();

        System.out.println(absolute);
        System.out.println(relative);
        System.out.println(configPath);
        System.out.println(workPath);
        System.out.println(tempPath);
        System.out.println(relativizedPath);
        System.out.println(normalizedPath);
        System.out.println(Paths.get("config").toAbsolutePath());
    }
}
