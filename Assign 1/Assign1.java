import java.util.*;
public class main {

    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        System.out.println("Matrix Multiplication (A * B) ");
        multiply(matrixA, matrixB);

        System.out.println("Transpose of A ");
        transpose(matrixA);

        System.out.println("Horizontal Flip of A ");
        flipHorizontal(matrixA);

        System.out.println("90 Degree Clockwise Rotation of A ");
        rotate90(matrixA);
    }

    // Matrix Multiplication
    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Matrix Transpose 
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Matrix Flip
    public static int[][] flipHorizontal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][cols - 1 - j] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] rotate90(int[][] matrix) {
        return flipHorizontal(transpose(matrix));
    }
}