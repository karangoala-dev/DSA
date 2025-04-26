package Algorithms.RecursionAndBacktracking;

public class Fibonacci {
    int[] dp;
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        //Bottom up
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static void main(String[] args) {

    }
}
