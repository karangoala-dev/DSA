package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {
    int[][][] dp;
    public int helper(int[] prices, int ind, int k, Boolean buy, int txns){
        int buyInd = buy ? 0 : 1;
        if(ind >= prices.length || txns == k){
            //return 0 if end index or exhausted no of txns
            return 0;
        }
        if(dp[ind][buyInd][txns] != -1){
            return dp[ind][buyInd][txns];
        }

        int profit;
        if(buy){
            profit = Math.max(-prices[ind] + helper(prices, ind + 1, k, false, txns), helper(prices, ind + 1, k, true, txns));
        }
        else{
            //mark one txn complete and proceed if we choose to sell
            profit = Math.max(prices[ind] + helper(prices, ind + 1, k, true, txns + 1), helper(prices, ind + 1, k, false, txns));
        }
        return dp[ind][buyInd][txns] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        dp  = new int[prices.length + 1][2][k + 1];
        for(int[][] curr1: dp){
            for(int[] curr: curr1){
                Arrays.fill(curr, -1);
            }
        }
        return helper(prices, 0, k, true, 0);
    }
    public static void main(String[] args) {

    }
}
