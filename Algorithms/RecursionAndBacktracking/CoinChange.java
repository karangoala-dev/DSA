package Algorithms.RecursionAndBacktracking;

public class CoinChange {
    public int helper(int[] nums, int ind, int target, int currSum){
        if(ind >= nums.length){
            return Integer.MAX_VALUE;
        }
        if(currSum > target){
            return Integer.MAX_VALUE;
        }
        if(currSum == target){
            //no more coins needed so return 0;
            return 0;
        }

        //take and stay
        int res1 = helper(nums, ind, target, currSum + nums[ind]);
        //if res1 is valid, then add 1(Integer.MAX_VALUE + 1 will give Integer.MIN_VALUE and affect result)
        if(res1 != Integer.MAX_VALUE){
            res1 += 1;
        }

        //not take and move ahead
        int res2 = helper(nums, ind + 1, target, currSum);

        return Math.min(res1, res2);
    }
    public int coinChange(int[] coins, int amount) {
        int res = helper(coins, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {

    }
}
