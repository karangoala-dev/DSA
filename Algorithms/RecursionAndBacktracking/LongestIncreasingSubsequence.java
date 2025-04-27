package Algorithms.RecursionAndBacktracking;

public class LongestIncreasingSubsequence {
    public int helper(int[] nums, int ind, int prev){
        if(ind >= nums.length){
            //return 0 if we reached end
            return 0;
        }

        //take -> only if current num is strictly greater than previous num
        int res1 = Integer.MIN_VALUE;
        if(nums[ind] > prev){
            res1 = 1 + helper(nums, ind + 1, nums[ind]);
        }

        //not-take
        int res2 = helper(nums, ind + 1, prev);

        return Math.max(res1, res2);
    }
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -10001);
    }
    public static void main(String[] args) {

    }
}
