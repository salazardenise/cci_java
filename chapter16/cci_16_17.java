package chapter16;

import java.util.Arrays;

public class cci_16_17 {
   
    // Runtime O(n), Space O(n), Dynamic Programming method
    // M[i] is defined as the max contiguous subarray that includes A[i]
    public static int getMaxContiguousSumVersion1(int[] A) {
        int n = A.length;
        int[] M = new int[n];
        M[0] = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < n; i++) {
            M[i] = (M[i-1] + A[i]  > A[i]) ? M[i-1] + A[i] : A[i];
                if (M[i] > maxSoFar) maxSoFar = M[i];
        }
        return maxSoFar;
    }
 
    // Runtime O(n^2), Space O(1), Brute-force method
    // to obtain sequence with largest sum, save indexes i and j
    public static int getMaxContiguousSumVersion2(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    // Comparing all methods
    public static int getMaxContiguousSum(int[] A) {
        int sum_v1 = getMaxContiguousSumVersion1(A);
        int sum_v2 = getMaxContiguousSumVersion2(A);
        if (sum_v1 == sum_v2) {
            System.out.println(Arrays.toString(A) + " : " + sum_v1);
        } else {
            System.out.println(Arrays.toString(A) + " : " + sum_v1 + " : " + sum_v2);
        }
        return sum_v1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, -8, 3, -2, 4, -10};
        getMaxContiguousSum(arr);
    }
}
