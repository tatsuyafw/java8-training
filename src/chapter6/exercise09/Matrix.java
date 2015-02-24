package chapter6.exercise09;

import java.util.Objects;

/*
 * TODO: Write test codes.
 */
public class Matrix {
    private int[][] values;

    public Matrix(int[][] values) {
        Objects.requireNonNull(values, "values must not be null");
        if (values[0].length == 0) {
            throw new IllegalArgumentException("values must have at least one value");
        }
        this.values = values;
    }

    public Matrix multiply(Matrix other) {
        // 行と列の長さが合わないものの行列の積は計算できない
        if ( (this.getColumnSize() != other.getRowSize())
                || this.getRowSize() != other.getColumnSize() ) {
            throw new IllegalArgumentException("Cloud not multipy: "
                + "(" + this.getRowSize()  + ", " + this.getColumnSize() +  ")"
                + "(" + other.getRowSize() + ", " + other.getColumnSize() + ")" );
        }

        // 配列の初期化
        int[][] newValues = new int[values.length][];
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = new int[values[i].length];
        }

        Matrix transposedMatrix = other.transpose();
        int[][] otherValues = transposedMatrix.getValues();

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                newValues[i][j] = productArrayAndSum(values[i], otherValues[j]);
            }
        }

        return new Matrix(newValues);
    }

    public int[][] getValues() {
        return this.values;
    }

    private int getRowSize() {
        return values.length;
    }

    private int getColumnSize() {
        return values[0].length;
    }

    /*
     *  転置行列を返す
     */
    private Matrix transpose() {
        int[][] newValues = new int[values[0].length][];

        // 配列の初期化
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = new int[values.length];
        }

        // 転置
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                newValues[j][i] = values[i][j];
            }
        }
        return new Matrix(newValues);
    }

    /*
     * ２つの配列の積を取る
     * int の範囲を超えたものについては考慮しない
     */
    private static int productArrayAndSum(int[] array, int[] other) {
        if (array.length != other.length) {
            throw new IllegalArgumentException("array.length must equal other.length");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] * other[i];
        }
        return sum;
    }
}
