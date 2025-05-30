package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaxAlternatingSubsequenceSum {
    long[][] dp;
    public long helper(int[] nums, int ind, boolean add){
        if(ind >= nums.length){
            //when we reached end of list, return 0
            return 0;
        }

        //memoization
        if(add){
            if(dp[ind][0] != -1){
                //get result for add col in dp array
                return dp[ind][0];
            }
        }
        else{
            if(dp[ind][1] != -1){
                //get result for sub col in dp array
                return dp[ind][1];
            }
        }


        //choice1: take current element
        long res1;
        if(add){
            res1 = helper(nums, ind + 1, !add) + nums[ind];
        }
        else {
            res1 = helper(nums, ind + 1, !add) - nums[ind];
        }

        //choice2: not-take current element
        long res2 = helper(nums, ind + 1, add);

        long res = Math.max(res1, res2);
        if(add){
            dp[ind][0] = res;
        }
        else{
            dp[ind][1] = res;
        }
        return res;
    }
    public long maxAlternatingSum(int[] nums) {
        // dp[index][phase] --> {dp[i][0] for add phase, dp[i][1] for subtract phase}
        // i.e. for current index, at add phase or sub phase, what is the ans
        // here column stores the result for any add or sub phase, not necessarily current one.
        // we are just updating the add and sub
        // result on top of previous subsequences(maybe this, may not be this subsequence)
        dp = new long[nums.length + 1][2];
        for(long[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(nums, 0, true);
    }
    public static void main(String[] args) {

    }
}
