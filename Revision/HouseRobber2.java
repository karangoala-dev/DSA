package Revision;

public class HouseRobber2 {
    public int helper(int[] nums, int ind, int endIndex){
        if (ind >= endIndex){
            return 0;
        }

        return Math.max(nums[ind] + helper(nums, ind + 2, endIndex), helper(nums, ind + 1, endIndex));
    }
    public int rob(int[] nums) {
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    public static void main(String[] args) {

    }
}
