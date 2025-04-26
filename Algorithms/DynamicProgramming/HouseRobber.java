package Algorithms.DynamicProgramming;

import java.util.*;

public class HouseRobber {
    int[] dp;
    //this fn returns the ans(maxSoFar)
    public int helper(int[] nums, int ind){
        if(ind >= nums.length){
            //we reached end of array so return
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }

        //take
        int res1 = nums[ind] + helper(nums, ind + 2);

        //not-take
        int res2 = helper(nums, ind + 1);

        return dp[ind] = Math.max(res1, res2);
    }
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];

        // We initialize dp[] with -1 because 0 could be a valid answer (for example, robbing 0 money).
        // If we used 0 to mark uncomputed states, we couldn't distinguish between "not yet computed" and "computed result is 0".
        // Using -1 clearly tells us whether dp[ind] has been computed or not.
        Arrays.fill(dp, -1);
        return helper(nums, 0);
    }
    public static void main(String[] args) {

    }
}
