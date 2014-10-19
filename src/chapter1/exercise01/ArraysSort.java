package chapter1.exercise01;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        String[] languages = {"Java", "Ruby", "JavaScript", "Haskell", "Perl", "C", "C++", "Perl", "Go"};

        System.out.println("[Main thread] Thread ID: " + Thread.currentThread().getId());
        Comparator<String> comp = (first, second) -> {
            System.out.println("[In Comparator] Thread ID: " + Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length());
        };
        
        System.out.println(Arrays.asList(languages));
        Arrays.sort(languages, comp);
        System.out.println(Arrays.asList(languages));
    }
}
