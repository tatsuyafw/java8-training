package chapter1.exercise09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        for (T element : this) {
            if (filter.test(element)) {
                action.accept(element);
            }
        }
    }
}
