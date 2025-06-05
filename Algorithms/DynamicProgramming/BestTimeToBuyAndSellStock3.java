package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
    int[][][] dp;
    public int helper(int[] prices, Boolean buy, int ind, int txns){
        int buyIndex = buy ? 0 : 1;
        if(ind >= prices.length || txns <= 0){
            return 0;
        }
        if(dp[ind][buyIndex][txns] != -1){
            return dp[ind][buyIndex][txns];
        }

        int profit = 0;
        if(buy && txns > 0){
            //we can either buy or not buy on current day
            //a buy operation means we subtract prices[ind] from profit
            profit = Math.max(-prices[ind] + helper(prices, false, ind + 1, txns), helper(prices, true, ind + 1, txns));
        }
        else{
            //we can either sell or not sell on current day
            //a sell operation means we add prices[ind] to profit

            //mark a txn as complete when sell operation is done
            profit = Math.max(prices[ind] + helper(prices, true, ind + 1, txns - 1), helper(prices, false, ind + 1, txns));
        }

        return dp[ind][buyIndex][txns] = profit;
    }
    public int maxProfit(int[] prices) {
        //3 for 3rd dimension since txns can be 2,1,0
        dp = new int[prices.length + 1][2][3];
        for(int[][] curr1: dp){
            for(int[] curr: curr1){
                Arrays.fill(curr, -1);
            }
        }
        return helper(prices, true, 0, 2);
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock3 = new BestTimeToBuyAndSellStock3();
        System.out.println(bestTimeToBuyAndSellStock3.maxProfit(new int[] {1,2,3,4,5}));;
    }
}
