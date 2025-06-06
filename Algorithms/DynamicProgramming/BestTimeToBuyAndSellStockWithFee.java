package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithFee {
    int[][] dp;
    public int helper(int[] prices, int ind, boolean buy, int fee){
        int boolInd = buy ? 0 : 1;
        if(ind >= prices.length){
            return 0;
        }

        if(dp[ind][boolInd] != -1){
            return dp[ind][boolInd];
        }

        int profit = 0;
        if(buy){
            profit = Math.max(-prices[ind] + helper(prices, ind + 1, false, fee), helper(prices, ind + 1, true, fee));
        }
        else{
            //deduct fee when selling only
            profit = Math.max(prices[ind] - fee + helper(prices, ind + 1, true, fee), helper(prices, ind + 1, false, fee));
        }

        return dp[ind][boolInd] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(prices, 0, true, fee);
    }
    public static void main(String[] args) {

    }
}
