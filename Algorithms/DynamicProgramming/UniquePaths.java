package Algorithms.DynamicProgramming;

import java.util.*;

public class UniquePaths {
    int[][] dp;
    public int helper(int m, int n, int r, int c){
        if(r == m - 1 && c == n - 1){
            return 1;
        }
        if(r >= m || c >= n){
            return 0;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        //go down
        int downDirPaths = helper(m, n, r + 1, c);
        //go left
        int rightDirPaths = helper(m, n, r, c + 1);

        return dp[r][c] = downDirPaths + rightDirPaths;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(m, n, 0, 0);
    }
    public static void main(String[] args) {

    }
}
