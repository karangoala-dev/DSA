package Algorithms.DynamicProgramming;

import java.util.*;

public class MinimumPathSum {
    int[][] dp;
    public int helper(int[][] grid, int r, int c){
        int n = grid.length, m = grid[0].length;
        if(r >= n || c >= m){
            return 100001;
        }
        if(r == n - 1 && c == m - 1){
            return grid[r][c];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        //go down
        int res1 = grid[r][c] + helper(grid, r + 1, c);
        //go right
        int res2 = grid[r][c] + helper(grid, r, c + 1);

        return dp[r][c] = Math.min(res1, res2);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(grid, 0, 0);
    }
    public static void main(String[] args) {

    }
}
