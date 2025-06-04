package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    int[][] dp;
    public int helper(int[] prices, Boolean buy, int ind){
        int buyIndex = buy ? 0 : 1;
        if(ind >= prices.length){
            return 0;
        }
        if(dp[ind][buyIndex] != -1){
            return dp[ind][buyIndex];
        }

        int profit = 0;
        if(buy){
            //we can either buy or not buy on current day
            //a buy operation means we subtract prices[ind] from profit
            profit = Math.max(-prices[ind] + helper(prices, false, ind + 1), helper(prices, true, ind + 1));
        }
        else{
            //we can either sell or not sell on current day
            //a sell operation means we add prices[ind] to profit
            profit = Math.max(prices[ind] + helper(prices, true, ind + 1), helper(prices, false, ind + 1));
        }

        return dp[ind][buyIndex] = profit;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(prices, true, 0);
    }
    public static void main(String[] args) {

    }
}
