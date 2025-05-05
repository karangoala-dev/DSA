package Algorithms.DynamicProgramming;

import java.util.*;

public class OptimalBST_Efficient {
    static int[][] dp;
    static int[] prefixSum;

    static int sum(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    static int helper(int[] freq, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = sum(i, j) + helper(freq, i, k - 1) + helper(freq, k + 1, j);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    static int optimalSearchTree(int keys[], int freq[], int n) {
        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        // compute prefix sum for O(1) frequency range sum
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + freq[i];
        }

        return helper(freq, 0, n - 1);
    }
    public static void main(String[] args) {

    }
}
