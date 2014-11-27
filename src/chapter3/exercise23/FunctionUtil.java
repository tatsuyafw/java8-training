package chapter3.exercise23;

import java.util.function.Function;

public class FunctionUtil {
    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> function) {
        U first  = function.apply(pair.getFirst());
        U second = function.apply(pair.getSecond());
        return new Pair<U>(first, second);
    }
}
