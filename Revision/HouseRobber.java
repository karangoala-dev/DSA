package Revision;

import java.util.Arrays;

public class HouseRobber {
    int[] dp;
    public int helper(int[] nums, int ind){
        if(ind >= nums.length){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        return dp[ind] = Math.max(nums[ind] + helper(nums, ind + 2), helper(nums, ind + 1));
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }
    public static void main(String[] args) {

    }
}
