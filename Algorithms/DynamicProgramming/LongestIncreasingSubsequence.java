package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int[][] dp;
    public int helper(int[] nums, int ind, int prevInd){
        if(ind >= nums.length){
            //return 0 if we reached end
            return 0;
        }

        //memoization
        if(dp[ind][prevInd + 1] != -1){
            return dp[ind][prevInd + 1];
        }

        //get the previous value
        int prev;
        int memoizedInd;
        if(prevInd == -1){
            prev = -10001;
        }
        else{
            prev = nums[prevInd];
        }

        //take
        int res1 = Integer.MIN_VALUE;
        if(nums[ind] > prev){
            res1 = 1 + helper(nums, ind + 1, ind);
        }

        //not-take
        int res2 = helper(nums, ind + 1, prevInd);

        return dp[ind][prevInd + 1] = Math.max(res1, res2);
    }
    public int lengthOfLIS(int[] nums) {
        //dp is 2D
        //1. row means index
        //2. col means index of previous value in nums array(it could've been prev value, but that would have large no of unused space), + 1 is done to store initial -1 col
        //dp[ind][prevInd + 1] = The maximum subsequence length you can achieve starting at index ind, given that your last taken number was at prevInd.The maximum subsequence length
        // you can achieve starting at index ind, given that your last taken number was at prevInd.

        //at current position(ind), res = dp[ind][previous value]
        //Therefore, res(ind) = dp[ind][prevInd + 1];
        dp = new int[nums.length][nums.length + 1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }

        //initially we pass -1 as the index for previous
        return helper(nums, 0, -1);
    }
    public static void main(String[] args) {

    }
}
