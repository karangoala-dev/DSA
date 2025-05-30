package Algorithms.DynamicProgramming;

public class MaximumProductSubarray {
    public int helper(int[] nums, int ind){
        if(ind == 0){
            return nums[0];
        }

        return Math.max(helper(nums[i], ind - 1) * nums[ind], nums[ind]);
    }
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, helper(nums, i));
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
