package Revision;

import java.util.Arrays;

public class MinimumFallingPathSum {
    int[][] dp;
    public int helper(int[][] grid, int row, int col){
        if(row >= grid.length){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        //left diagonal
        int r1 = Integer.MAX_VALUE;
        if(col > 0){
            r1 = grid[row][col] + helper(grid, row + 1, col - 1);
        }

        //directly down
        int r2 = grid[row][col] + helper(grid, row + 1, col);

        //right diagonal
        int r3 = Integer.MAX_VALUE;
        if(col < grid[0].length - 1){
            r3 = grid[row][col] + helper(grid, row + 1, col + 1);
        }


        return dp[row][col] = Math.min(r1, Math.min(r2, r3));
    }
    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            res = Math.min(res, helper(matrix, 0, i));
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
