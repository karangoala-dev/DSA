package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaximumProductSubarray {
    int[][] dp;
    //here, unlike maximum sum subarray, we store 2 results,
    //max product at 0 and min product at 1, so that min may later become the max due to multiplication
    public int[] helper(int[] nums, int ind){
        if(ind == 0){
            return new int[]{nums[0], nums[0]};
        }

        if(dp[ind][0] != -1 && dp[ind][1] != -1){
            return dp[ind];
        }

        int[] prevRes = helper(nums, ind - 1);
        //we need to check max and min for when we multiple arr[ind] with both prev max and prev min
        int currMax = Math.max(nums[ind], Math.max(prevRes[0] * nums[ind], prevRes[1] * nums[ind]));
        int currMin = Math.min(nums[ind], Math.min(prevRes[0] * nums[ind], prevRes[1] * nums[ind]));

        return dp[ind] = new int[]{currMax, currMin};
    }
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        //dp stores index res rowwise and max/min column wise
        dp = new int[nums.length + 1][2];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }

        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, Math.max(helper(nums, i)[0], helper(nums, i)[1]));
        }
        return res;
    }
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,3,-4}));
    }
}
