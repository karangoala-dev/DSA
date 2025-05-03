package Algorithms.DynamicProgramming;

import java.util.*;

public class MinimumFallingPathSum {
    int[][] dp;
    public int helper(int[][] mx, int r, int c){
        int n = mx.length, m = mx[0].length;
        if(r >= n || c >= m || c < 0){
            return 100001;
        }
        if(r == n - 1){
            //means we reached last row
            return mx[r][c];
        }

        if(dp[r][c] != Integer.MIN_VALUE){
            return dp[r][c];
        }

        //directly down
        int r1 = mx[r][c] + helper(mx, r + 1, c);
        //left diagonal
        int r2 = mx[r][c] + helper(mx, r + 1, c - 1);
        //right diagonal
        int r3 = mx[r][c] + helper(mx, r + 1, c + 1);

        return dp[r][c] = Math.min(r1, Math.min(r2, r3));
    }
    public int minFallingPathSum(int[][] mx) {
        int n = mx.length, m = mx[0].length;
        dp = new int[n][m];
        for(int[] curr: dp){
            Arrays.fill(curr, Integer.MIN_VALUE);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            res = Math.min(res, helper(mx, 0, i));
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
