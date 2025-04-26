package Algorithms.RecursionAndBacktracking;

import java.util.Arrays;

public class MaxAlternatingSubsequenceSum {
    long[] dp;
    public long helper(int[] nums, int ind, boolean add, long initialSum){
        if(ind >= nums.length){
            //when we reached end of list, return the initialSum
            return initialSum;
        }

        //memoization
        if(dp[ind] != -1){
            return dp[ind];
        }

        //choice1: take current element
        long res1;
        if(add){
            res1 = helper(nums, ind + 1, !add, initialSum + nums[ind]);
        }
        else {
            res1 = helper(nums, ind + 1, !add, initialSum - nums[ind]);
        }

        //choice2: not-take current element
        long res2 = helper(nums, ind + 1, add, initialSum);

        return dp[ind] = Math.max(res1, res2);
    }
    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, true, 0);
    }
    public static void main(String[] args) {

    }
}
