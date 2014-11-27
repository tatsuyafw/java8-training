package chapter3.exercise21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FunctionUtil {
    public static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
        Future<U> mappedFuture = new Future<U>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return future.cancel(mayInterruptIfRunning);
            }
            @Override
            public U get() throws InterruptedException, ExecutionException {
                try {
                   return function.apply(future.get());
                } catch (ExecutionException|InterruptedException e) {
                    throw e;
                }
            }
            @Override
            public U get(long timeout, TimeUnit unit) {
                return null;
            }
            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }
            @Override
            public boolean isDone() {
                return future.isDone();
            }
        };
        return mappedFuture;
    }
}
