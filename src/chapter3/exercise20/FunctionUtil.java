package chapter3.exercise20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionUtil {
    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> mappedList = new ArrayList<U>();
        for (T entry : list) {
            mappedList.add(f.apply(entry));
        }
        return mappedList;
    }
}
