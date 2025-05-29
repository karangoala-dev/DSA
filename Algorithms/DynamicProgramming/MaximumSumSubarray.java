package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumSubarray {
    int[] dp;
    public int helper(int[] nums, int ind){
        if(ind == 0){
            //reached first, now, only one subarray possible, so return nums[0]
            return nums[0];
        }
        if(dp[ind] != -1){
            return dp[ind];
        }

        return dp[ind] = Math.max(helper(nums, ind - 1) + nums[ind], nums[ind]);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.max(res, helper(nums, i));
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
