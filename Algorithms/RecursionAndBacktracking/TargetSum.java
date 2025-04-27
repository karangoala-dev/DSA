package Algorithms.RecursionAndBacktracking;

public class TargetSum {
    public int helper(int[] nums, int ind, int target, int currSum){
        if(ind >= nums.length){
            //if all indices traversed then return 1 or 0 based on count
            if(currSum == target){
                return 1;
            }
            return 0;
        }

        int addCount = helper(nums, ind + 1, target, currSum + nums[ind]);
        int subCount = helper(nums, ind + 1, target, currSum - nums[ind]);

        return addCount + subCount;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target, 0);
    }
    public static void main(String[] args) {

    }
}
