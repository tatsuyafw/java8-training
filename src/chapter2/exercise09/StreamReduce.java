package chapter2.exercise09;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduce {
    public static void main(String[] args) {
        
    }
    
    public static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>> newList = stream.reduce((a, b) -> {
            a.addAll(b);
            return a;
        });
        return newList.orElse(new ArrayList<T>());
    }
    
    public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
        ArrayList<T> newList = stream.reduce(new ArrayList<T>(), (a, b) -> {
            a.addAll(b);
            return a;
        });        
        return newList;
    }
    
    public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
        ArrayList<T> newList = stream.reduce(new ArrayList<T>(), 
                (total, list) -> { total.addAll(list); return total; },
                (list1, list2) -> { list1.addAll(list2); return list1; }
                );
        
        return newList;
    }

}
