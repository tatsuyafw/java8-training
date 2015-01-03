package chapter9.sandbox;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Sandbox {
    public static void main(String[] args) {
        Path absolute = Paths.get("/", "home");
        Path relative = Paths.get("myprog", "conf", "user.properties");

        System.out.println(absolute);
        System.out.println(relative);
    }
}
