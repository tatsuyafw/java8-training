package chapter3.exercise09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class MyComparator {
    // This method is not yet working...
    public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (first, second) -> {
            try {
                for (int i = 0; i < fieldNames.length; i++) {
                    Field f1 = first.getClass().getField(fieldNames[i]);
                    Field f2 = second.getClass().getField(fieldNames[i]);

                    if ( f1.equals(f2) ) {
                        continue;
                    } else {
                        //Comparable<?> c1 = (Comparable<?>) f1.get(first);
                        //Comparable<?> c2 = (Comparable<?>) f2.get(second);
                        return 0;
                    }
                }
                return 0;
            } catch (NoSuchFieldException e) {
                return 0;
            }
        };
    }
}
