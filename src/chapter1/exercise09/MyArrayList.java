package chapter1.exercise09;

import java.util.ArrayList;

public class MyArrayList<T> extends ArrayList<T> implements Collection2<T> {
    private static final long serialVersionUID = 6686019967651072845L;

    public static void main(String[] args) {
        String[] languages = { "JavaScript", "Ruby", "Go", "Perl", "Haskell", "C", "Java" };
        Collection2<String> list = new MyArrayList<>();
        for (String lang : languages) {
            list.add(lang);
        }
        list.forEachIf(System.out::println, lang -> lang.startsWith("J"));
    }
}
