package chapter2.exercise08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MyStream {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> newStreamElements = new ArrayList<>();
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();


        for ( ;; ) {
            if ( ! firstIterator.hasNext() ) {
                break;
            } else {
                newStreamElements.add(firstIterator.next());
            }

            if ( ! secondIterator.hasNext() ) {
                break;
            } else {
                newStreamElements.add(secondIterator.next());
            }
        }

        return newStreamElements.stream();
    }
}
