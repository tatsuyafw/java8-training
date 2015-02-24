package chapter6.exercise09;

public class Main {

    public static void main(String[] args) {
        int[][] valueA = { {2, 1}, {1, 2} };
        int[][] valueB = { {1, 0}, {0, 1} };

        Matrix matrixA = new Matrix(valueA);
        Matrix matrixB = new Matrix(valueB);
        Matrix newMatrix = matrixA.multiply(matrixB);
        showMatrix(newMatrix);
    }

    protected static void showMatrix(Matrix matrix) {
        int[][] values = matrix.getValues();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j] + " " );
            }
            System.out.println();
        }
    }
}
