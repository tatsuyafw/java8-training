package chapter6.exercise09;

import java.util.Arrays;

public class Main {
    private static final int FIBONACCI_SIZE = 10;

    public static void main(String[] args) {
        Matrix[] fibonacciMatrixes = new Matrix[FIBONACCI_SIZE];

        // 1, 1
        // 1, 0 で初期化
        Arrays.parallelSetAll(fibonacciMatrixes, i -> {
            int[][] values = { {1, 1}, {1, 0} };
            return new Matrix(values);
        });

        // fibonacci number の計算
        Arrays.parallelPrefix(fibonacciMatrixes, (f1, f2) -> f1.multiply(f2));

        // 行列の左上の数値を出力
        for (int i = 0; i < fibonacciMatrixes.length; i++) {
            System.out.println("f"+ (i+1) + ": " + fibonacciMatrixes[i].getValues()[0][0]);
        }
    }

}
