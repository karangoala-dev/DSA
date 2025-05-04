package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int[][] dp;

    // Helper function to recursively compute minimum multiplication cost from i to j
    static int helper(int[] arr, int i, int j){
        if(i + 1 == j){
            //means only one matrix, so operations needed = 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        // Try placing the split at every position between i and j
        for(int k = i + 1; k < j; k++){
            int curr = helper(arr, i, k) +  //cost of multiplying left matrices, resultant matrix dimension will be [i x k]
                    helper(arr, k, j) + //cost of multiplying right matrices, resultant matrix dimension will be [k x j]
                    arr[i] * arr[k] * arr[j]; // when above 2 matrices are multiplied, we get a matrix of size [i x j] and cost = arr[i]*arr[k]*arr[j]

            min = Math.min(min, curr);
        }

        return dp[i][j] = min;
    }
    static int matrixMultiplication(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }

        //Call helper for full range
        return helper(arr, 0, n - 1);
    }
    public static void main(String[] args) {

    }
}
