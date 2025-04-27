package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    //index vs currentSum
    int[][] dp;
    //offset is needed to be added to currSum to make it positive so that column can be non -ve(curr sum can be -ve)
    int offset;
    public int helper(int[] nums, int ind, int target, int currSum){
        if(ind >= nums.length){
            //if all indices traversed then return 1 or 0 based on count
            if(currSum == target){
                return 1;
            }
            return 0;
        }

        if(dp[ind][currSum + offset] != Integer.MIN_VALUE){
            return dp[ind][currSum + offset];
        }

        int addCount = helper(nums, ind + 1, target, currSum + nums[ind]);
        int subCount = helper(nums, ind + 1, target, currSum - nums[ind]);

        return dp[ind][currSum + offset] = addCount + subCount;
    }
    public int findTargetSumWays(int[] nums, int target) {
        //find max and min possible values for currSum
        int sum = Arrays.stream(nums).sum();
        int colLength = 2 * sum + 1;
        //offset is needed to be added to currSum to make it positive so that column can be non -ve(curr sum can be -ve)
        offset = sum;
        //here dp stores according to index (row) and currentSum(col)
        dp = new int[nums.length][colLength];

        for(int[] curr: dp){
            Arrays.fill(curr, Integer.MIN_VALUE);
        }

        return helper(nums, 0, target, 0);
    }
    public static void main(String[] args) {

    }
}
