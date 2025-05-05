package Algorithms.DynamicProgramming;

import java.util.*;

public class OptimalBST_InefficientMemory {
//    Here, we have level inside memoization key, so it is necessary to use in the dp also, else:
//
//    helper(i, j, level = 1) and
//
//    helper(i, j, level = 2)
//
//    will incorrectly reuse the same dp[i][j] result, even though the cost depends on level. This causes incorrect answers.

    static int[][][] dp;
    static int helper(int[] keys, int[] freq, int i, int j, int level){
        if(i > j){
            return 0;
        }

        if(dp[i][j][level] != -1){
            return dp[i][j][level];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int curr = level * freq[k] + helper(keys, freq, i, k - 1, level + 1) + helper(keys, freq, k + 1, j, level + 1);
            min = Math.min(min, curr);
        }

        return dp[i][j][level] = min;
    }
    static int optimalSearchTree(int keys[], int freq[], int n) {
        // code here
        dp = new int[n][n][n + 1];
        for(int[][] curr2D: dp){
            for(int[] curr: curr2D){
                Arrays.fill(curr, -1);
            }
        }
        return helper(keys, freq, 0, keys.length - 1, 1);
    }
    public static void main(String[] args) {

    }
}
