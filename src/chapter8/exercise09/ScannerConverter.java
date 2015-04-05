package chapter8.exercise09;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ScannerConverter {
    public static Stream<String> words(Scanner scanner) {

        return null; // Temporary
    }

    public static Stream<String> lines(Scanner scanner) {
        Iterator<String> iter = new Iterator<String>() {

            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public String next() {
                return scanner.next();
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}
