package chapter10;

public class cci_10_09 {
    
    public static int[] sortedMatrixSearch(int[][] M, int e) {
        if (M.length == 0) return new int[] {-1, -1};
        int col_l = 0, col_r = M[0].length - 1;
        int row_l = 0, row_r = M.length - 1;
        while (row_l <= row_r && col_l <= col_r) {
            int row_m = row_l + (row_r - row_l) / 2;
            int col_i = binarySearch(M[row_m], col_l, col_r, e);
            if (col_i != -1) return new int[] {row_m, col_i};
            if (e < M[row_m][col_l]) {
                row_r = row_m - 1;
            }
            else {
                row_l = row_m + 1;
            }
            int col_m = col_l + (col_r - col_l) / 2;
            int row_i = binarySearch(getColumn(M, col_m), row_l, row_r, e);
            if (row_i != -1) return new int[] {row_i, col_m};
            if (e < M[row_l][col_m]) {
                col_r = col_m - 1;
            }
            else {
                col_l = col_m + 1;
            }
        }
        return new int[] {-1, -1};
    }

    private static int[] getColumn(int[][] A, int j) {
        int[] col = new int[A[0].length];
        for (int i = 0; i < col.length; i++) {
            col[i] = A[i][j];
        } 
        return col;
    }

    private static int binarySearch(int[] A, int l, int r, int e) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] ==  e) {
                return m;
            }
            else if (A[m] < e) {
                l = m + 1;
            }
            else { // A[m] > e
                r = m - 1;
            }
        }
        return -1;
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
        int[][] M = { {0, 1, 5, 6},
                      {2, 7, 8, 9},
                      {9, 10, 20, 22},
                      {11, 42, 50, 63} };
        printMatrix(M);
        System.out.println();
        
        int e = 48;
        int[] result = sortedMatrixSearch(M, e);
        System.out.println(e + " is at (" + result[0] + ", " + result[1] + ")");
        
        e = 1;
        result = sortedMatrixSearch(M, e);
        System.out.println(e + " is at (" + result[0] + ", " + result[1] + ")");
        
        e = 20;
        result = sortedMatrixSearch(M, e);
        System.out.println(e + " is at (" + result[0] + ", " + result[1] + ")");
    }
}
