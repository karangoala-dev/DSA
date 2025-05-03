package Algorithms.DynamicProgramming;

import java.util.*;

public class UniquePaths2 {
    int[][] dp;
    public int helper(int[][] grid, int r, int c){
        int n = grid.length, m = grid[0].length;

        if(r >= n || c >= m){
            //if out of bounds, return 0
            return 0;
        }
        if(r == n - 1 && c == m - 1 && grid[r][c] == 0){
            //if we reached destination then return 1
            return 1;
        }
        if(grid[r][c] == 1){
            //if obstacle present, return 0
            return 0;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        //down
        int res1 = helper(grid, r + 1, c);

        //right
        int res2 = helper(grid, r, c + 1);

        return dp[r][c] = res1 + res2;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
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
