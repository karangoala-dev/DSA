package Revision;

import java.util.Arrays;

public class UniquePaths2 {
    int[][] dp;
    public int dfs(int[][] grid, int r, int c){
        int m = grid.length, n = grid[0].length;
        if(grid[r][c] == 1){
            return 0;
        }
        if(r >= m || c >= n){
            return 0;
        }
        if(r == m - 1 && c == n - 1){
            return 1;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int[] rows = {1, 0};
        int[] cols = {0, 1};
        int res = 0;
        for(int i = 0; i < 2; i++){
            int nR = rows[i] + r;
            int nC = cols[i] + c;
            if(nR < m && nC < n && nR >= 0 && nC >= 0 && grid[nR][nC] != 1){
                res += dfs(grid, nR, nC);
            }
        }
        return dp[r][c] = res;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return dfs(grid, 0, 0);
    }
    public static void main(String[] args) {

    }
}
