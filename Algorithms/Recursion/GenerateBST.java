package Algorithms.Recursion;

public class GenerateBST {
    int dp[];
    public int helper(int n){
        if(dp[n] != 0){
            return dp[n];
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += helper(i) * helper(n - i - 1);
        }
        dp[n] = res;
        return res;
    }
    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return helper(n);
    }
    public static void main(String[] args) {

    }
}
