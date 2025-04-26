package Algorithms.DynamicProgramming;

public class ClimbingStairs {
    int[] dp;
    public int helper(int n){
        if(dp[n] != 0){
            return dp[n];
        }

        //we need summation of no of ways
        //so, at each level choice is to take either one or two steps
        //so, summation of those choices
        return dp[n] = helper(n - 1) + helper(n - 2);
    }
    public int climbStairs(int n) {
        if(n <= 2){
            //if n == 2 then no of ways = 2
            //if n == 1 then no of ways = 1
            return n;
        }
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        return helper(n);
    }

    public static void main(String[] args) {

    }
}
