package chapter01;

// rotate an nxn matrix by 90 degrees

public class cci_01_07 {
    
    public static int[][] rotateMatrix(int[][] M) {
        int n = M.length, m = M[0].length;
        if (n == 0 || n != m) return null;
        int[][] rotated = new int[n][n];
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][k] = M[i][j];
            }
            k--;
        }
        return rotated;
    }

    private static void printMatrix(int[][] M) {
        if (M.length == 0) return;
        for (int i = 0; i < M.length; i++) {
            String row = "";
            for (int j = 0; j < M[0].length; j++) {
                 row += M[i][j] + ", ";
            }
            System.out.println(row);
        }
    }    

    public static void main(String[] args) {
        int[][] M = new int[][] { {1, 2, 3},
                                  {10, 20, 30},
                                  {8, 9, 10} };
        int[][] rotated = rotateMatrix(M);
        System.out.println("original matrix: ");
        printMatrix(M);
        System.out.println("rotated matrix: ");
        printMatrix(rotated);
    }
}
