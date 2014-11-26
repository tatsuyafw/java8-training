package chapter3.exercise16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AsyncUtil {
    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second, Consumer<Throwable> handlerForSecond) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable e) {
                    try {
                        second.accept(null, e);
                    } catch(Throwable secondError) {
                        handlerForSecond.accept(secondError);
                    }
                }
            }
        };
        t.start();
    }
}
