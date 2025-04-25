package Algorithms.RecursionAndBacktracking;

public class PartitionEqualSubsetSum {
    //memoize for currSum and ind;
    Boolean[][] dp;
    public boolean helper(int[] nums, int ind, int currSum, int target){
        if(ind >= nums.length){
            return false;
        }
        if(currSum >= target){
            if(currSum == target){
                return dp[ind][currSum] = true;
            }
            return false;
        }

        if(dp[ind][currSum] != null){
            return dp[ind][currSum];
        }
        //take
        boolean res1 = helper(nums, ind + 1, currSum + nums[ind], target);

        //not-take
        boolean res2 = helper(nums, ind + 1, currSum, target);

        return dp[ind][currSum] = res1 || res2;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        if(sum % 2 != 0){
            //if total sum is odd then no ways it can be divided into 2 equally
            return false;
        }
        int target = sum / 2;
        //initialise the cache
        dp = new Boolean[nums.length][target + 1];
        return helper(nums, 0, 0, target);
    }
    public static void main(String[] args) {

    }
}
