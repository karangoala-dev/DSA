package Revision;

import java.util.Arrays;

public class UniquePaths {
    int[][] dp;
    public int dfs(int m, int n, int r, int c){
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
            if(nR < m && nC < n && nR >= 0 && nC >= 0){
                res += dfs(m, n, nR, nC);
            }
        }
        return dp[r][c] = res;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return dfs(m, n, 0, 0);
    }
    public static void main(String[] args) {

    }
}
