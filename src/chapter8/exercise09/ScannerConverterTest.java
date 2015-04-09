package chapter8.exercise09;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScannerConverterTest {
    private Path in = Paths.get(ScannerConverterTest.class.getResource("alice.txt").getPath());
    private Stream<String> filesLines;
    private Stream<String> scannerLines;

    @Before
    public void setup() {
        System.out.println("setup");
        try {
            filesLines = Files.lines(in);
            scannerLines = ScannerConverter.lines(new Scanner(in));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (filesLines != null) {
            filesLines.close();
        }
        if (scannerLines != null) {
            scannerLines.close();
        }
    }

    @Test
    public void testLinesComparedWithFilesLines() {
        assertArrayEquals(filesLines.toArray(String[]::new), scannerLines.toArray(String[]::new));
    }

}
