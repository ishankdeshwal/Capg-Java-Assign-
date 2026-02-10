package Capgg;
class TransposeMatrix{
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int r = A.length; 
        int c = A[0].length;
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
