package Algorithms.DynamicProgramming;

import java.util.*;

public class CoinChange {
    int[][] dp;
    public int helper(int[] nums, int ind, int target, int currSum){
        if(ind >= nums.length){
            return Integer.MAX_VALUE;
        }
        if(currSum > target){
            return Integer.MAX_VALUE;
        }
        if(currSum == target){
            //no more coins needed so return 0;
            return 0;
        }

        if(currSum <= target && dp[ind][currSum] != -1){
            return dp[ind][currSum];
        }

        int res1 = Integer.MAX_VALUE;
        //take and stay only if nums[ind] is acceptable (required due to testcase where nums[ind] is INT_MAX)
        if(nums[ind] <= target - currSum){
            res1 = helper(nums, ind, target, currSum + nums[ind]);
            //if res1 is valid, then add 1(Integer.MAX_VALUE + 1 will give Integer.MIN_VALUE and affect result)
            if(res1 != Integer.MAX_VALUE){
                res1 += 1;
            }
        }

        //not take and move ahead
        int res2 = helper(nums, ind + 1, target, currSum);

        return dp[ind][currSum] = Math.min(res1, res2);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        int res = helper(coins, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {

    }
}
