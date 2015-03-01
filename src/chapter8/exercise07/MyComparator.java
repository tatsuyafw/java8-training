package chapter8.exercise07;


public class MyComparator {
    private MyComparator() {
    }

    /**
     * nullsFirst(naturalOrder()).reversed() と同等の Comparator を返す
     * うまく作れなかったので断念(型が違う)
     */
    /*
    public static <T> Comparator<? super T> nullsFirstComparatorReversed() {
        return Comparator.<T>nullsLast(reverseOrder());
    }
    */
}
