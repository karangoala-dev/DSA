package Striver150;

import java.util.Arrays;

public class MaximumProductSubarray {
    int[][] dp;
    public int[] helper(int[] nums, int ind){
        //if beyond range, then return 1(neutral)
        if(ind >= nums.length){
            return new int[]{1, 1};
        }
        if(dp[ind][0] != Integer.MIN_VALUE && dp[ind][1] != Integer.MIN_VALUE){
            return dp[ind];
        }

        //find result from ind+1 onwards
        int[] nextRes = helper(nums, ind + 1);
        //see if we should consider current element only or max of curr and max/min
        int currMax = Math.max(nums[ind], Math.max(nums[ind] * nextRes[0], nums[ind] * nextRes[1]));
        int currMin = Math.min(nums[ind], Math.min(nums[ind] * nextRes[0], nums[ind] * nextRes[1]));

        return dp[ind] = new int[]{currMax, currMin};
    }
    public int maxProduct(int[] nums) {
        dp = new int[nums.length][2];
        for(int[] curr: dp){
            Arrays.fill(curr, Integer.MIN_VALUE);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int[] curr = helper(nums, i);
            res = Math.max(res, Math.max(curr[0], curr[1]));
        }
        return res;
    }

    //Using Kadane's algo
    public int maxProduct_Kadanes(int[] nums) {
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 0; i < nums.length; i++){
            int tempMax = max;

            max = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));

            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}));
    }
}
