package Algorithms.DynamicProgramming;

public class CountSquaresOfAll1s {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //if first row or column, default value same as matrix
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    if(matrix[i][j] == 0){
                        dp[i][j] = 0;
                    }
                    else{
                        //if current cell is 1, only then use below formula, it is min of its neighbours + 1
                        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    }
                }
                res += dp[i][j];
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
