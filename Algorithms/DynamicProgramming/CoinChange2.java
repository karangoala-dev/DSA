package Algorithms.DynamicProgramming;

import java.util.*;

public class CoinChange2 {
    int[][] dp;
    public int helper(int[] coins, int target, int currSum, int ind){
        if(ind >= coins.length || currSum > target){
            return 0;
        }
        if(currSum == target){
            //found 1 way
            return 1;
        }

        if(dp[ind][currSum] != -1){
            return dp[ind][currSum];
        }

        //take and stay here
        int res1 = helper(coins, target, currSum + coins[ind], ind);

        //not take and move ahead
        int res2 = helper(coins, target, currSum, ind + 1);

        return dp[ind][currSum] = res1 + res2;
    }
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(coins, amount, 0, 0);
    }
    public static void main(String[] args){

    }
}
