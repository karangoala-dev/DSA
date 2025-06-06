package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    int[][] dp;
    public int helper(int[] prices, int ind, Boolean buy){
        int boolInd = buy ? 0 : 1;
        if(ind >= prices.length){
            return 0;
        }

        if(dp[ind][boolInd] != -1){
            return dp[ind][boolInd];
        }

        int profit = 0;
        if(buy){
            profit = Math.max(-prices[ind] + helper(prices, ind + 1, false), helper(prices, ind + 1, true));
        }
        else{
            //only diff is, if we are selling, we cant buy on next day, so skip one extra day
            profit = Math.max(prices[ind] + helper(prices, ind + 2, true), helper(prices, ind + 1, false));
        }
        return dp[ind][boolInd] = profit;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(prices, 0, true);
    }
    public static void main(String[] args) {

    }
}
