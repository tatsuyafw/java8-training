package chapter9.exercise02;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        code();
    }

    public static void code() throws IOException {
        Scanner in = null;
        PrintWriter out = null;
        IOException thrownIOException = null;

        try {
            in = new Scanner(Paths.get("/usr/share/dict/words"));
            out = new PrintWriter("/tmp/out.txt");
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException ex) {
            thrownIOException = ex;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IllegalStateException ex) {
                    if (thrownIOException != null) {
                        thrownIOException.addSuppressed(ex);
                    }
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IllegalStateException ex) {
                    if (thrownIOException != null) {
                        thrownIOException.addSuppressed(ex);
                    }
                }
            }
            if (thrownIOException != null) {
                throw thrownIOException;
            }
        }

    }
}
