package Algorithms.RecursionAndBacktracking;

public class HouseRobber {
    int maxValue = Integer.MIN_VALUE;
    public void helper(int[] nums, int ind, int sumSoFar){
        if(ind >= nums.length){
            //we reached end of array so consider for max
            maxValue = Math.max(maxValue, sumSoFar);
            return;
        }

        //take
        helper(nums, ind + 2, sumSoFar + nums[ind]);

        //not-take
        helper(nums, ind + 1, sumSoFar);
    }
    public int rob(int[] nums) {
        helper(nums, 0, 0);
        return maxValue;
    }
    public static void main(String[] args) {

    }
}
