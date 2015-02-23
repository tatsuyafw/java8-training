package utils;

import java.util.Random;

public class MyRandom {
    /*
     * [0, limit) の範囲の乱数列を生成
     */
    public static long[] createLongRandomValues(int limit, int size) {
        long[] values = new long[size];
        Random random = new Random();

        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(limit);
        }

        return values;
    }

    /*
     * [0, limit) の範囲の乱数列を生成
     */
    public static int[] createIntRandomValues(int limit, int size) {
        int[] values = new int[size];
        Random random = new Random();

        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(limit);
        }

        return values;
    }
}
