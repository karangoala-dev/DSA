package Algorithms.RecursionAndBacktracking;

public class MaximumSumSubarray {
    public int helper(int[] nums, int ind){
        if(ind == 0){
            //reached first, now, only one subarray possible, so return nums[0]
            return nums[0];
        }

        return Math.max(helper(nums, ind - 1) + nums[ind], nums[ind]);
    }
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, helper(nums, i));
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
