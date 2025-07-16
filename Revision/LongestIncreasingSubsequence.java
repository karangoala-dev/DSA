package Revision;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int[] dp;
    public int helper(int[] nums, int ind, int curr, int prev){
        if(ind >= nums.length){
            return curr;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }

        int take = 0, notTake = 0;
        if(nums[ind] > prev){
            //take only if greater than prev
            take = helper(nums, ind + 1, curr + 1, nums[ind]);
        }
        notTake = helper(nums, ind + 1, curr, prev);

        return dp[ind] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, 0, Integer.MIN_VALUE);
    }
    public static void main(String[] args) {

    }
}
