package Algorithms.DynamicProgramming;

import java.util.*;

public class MinimumCostForTickets {
    int[] dp;
    public int helper(int[] days, int[] costs, int ind){
        if(ind >= days.length){
            //means we reached end of days of travel
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        //1 day pass
        int res1 = costs[0] + helper(days, costs, ind + 1);

        //7 day pass
        int validTill = days[ind] + 7 - 1;
        int i = ind;
        //find day > validTill
        while(i < days.length && days[i] <= validTill){
            i++;
        }
        int res2 = costs[1] + helper(days, costs, i);

        //30 day pass
        int validTill1 = days[ind] + 30 - 1;
        int j = ind;
        //find day > validTill1
        while(j < days.length && days[j] <= validTill1){
            j++;
        }
        int res3 = costs[2] + helper(days, costs, j);

        return dp[ind] = Math.min(res1, Math.min(res2, res3));
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return helper(days, costs, 0);
    }
    public static void main(String[] args) {

    }
}
