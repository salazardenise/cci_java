package chapter01;

// given an nxm matrix, if an element is 0, then set its entire row and column to zeros as well

public class cci_01_08 {

    public static void zeroMatrix(int[][] M) {
        if (M.length == 0) return;
        int n = M.length, m = M[0].length;
        
        // mark where zeros occur
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 0) {
                    rows[i] = true;
                    cols[i] = true;
                }
            }
        }

        // set rows
        for (int i = 0; i < n; i++) {
            if (rows[i] == true) {
                for (int j = 0; j < m; j++) {
                    M[i][j] = 0;
                }
            }
        }
        // set cols
        for (int j = 0; j < m; j++) {
            if (cols[j] == true) {
                for (int i = 0; i < n; i++) {
                    M[i][j] = 0;
                }
            }
        }
    }

    private static void printMatrix(int[][] M) {
        if (M.length == 0) return;
        for (int i = 0; i < M.length; i++) {
            String line = "";
            for (int j = 0; j < M[0].length; j++) {
                line += M[i][j] + ", ";
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        int[][] M = { {0, 1, 2, 3},
                      {8, 7, 5, 8},
                      {1, 2, 0, 4},
                      {7, 9, 50, 10} };
        System.out.println("original matrix: ");
        printMatrix(M);
        System.out.println("zeroed matrix: ");
        zeroMatrix(M);
        printMatrix(M);
    }
}
