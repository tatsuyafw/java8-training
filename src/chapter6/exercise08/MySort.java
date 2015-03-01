package chapter6.exercise08;

import static utils.BenchMark.benchmark;
import static utils.MyRandom.createIntRandomValues;

import java.time.Duration;
import java.util.Arrays;

public class MySort {
    private final static int ARRAY_SIZES[] = { 100, 1_000, 10_000, 100_000, 1_000_000 };
    private final static int VALUE_LIMIT = 1_000_000;

    public static void main(String[] args) {
        for (int i = 0; i < ARRAY_SIZES.length; i++) {
            int[] valuesForSort = createIntRandomValues(VALUE_LIMIT, ARRAY_SIZES[i]);
            int[] valuesForParallelSort = Arrays.copyOf(valuesForSort, valuesForSort.length);

            // Arrays.sort
            Duration elapsedArraysSort = benchmark(() -> {
                Arrays.sort(valuesForSort);
            });
            // Arrays.parallelSort
            Duration elapsedArraysParallelSort = benchmark(() -> {
                Arrays.parallelSort(valuesForParallelSort);
            });

            System.out.println("Array size: " + ARRAY_SIZES[i]);
            System.out.println("Arrays.sort elapsed:         " + elapsedArraysSort.toNanos());
            System.out.println("Arrays.parallelSort elapsed: " + elapsedArraysParallelSort.toNanos());
            System.out.println();
        }
    }
}
