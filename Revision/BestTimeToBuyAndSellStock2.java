package Revision;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    int[][] dp;
    public int helper(int[] prices, int ind, boolean buy){
        int buyInd = buy ? 0 : 1;
        if(ind >= prices.length){
            return 0;
        }
        if(dp[ind][buyInd] != -1){
            return dp[ind][buyInd];
        }

        if(buy){
            return dp[ind][buyInd] = Math.max(-prices[ind] + helper(prices, ind + 1, false), helper(prices, ind + 1, true));
        }
        else {
            return dp[ind][buyInd] = Math.max(prices[ind] + helper(prices, ind + 1, true), helper(prices, ind + 1, false));
        }
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(prices, 0, true);
    }
    public static void main(String[] args) {

    }
}
