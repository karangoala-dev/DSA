package Algorithms.SlidingWindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, res = Integer.MAX_VALUE, currSum = 0;
        while(j < n){
            currSum += nums[j];
            while(i <= j && currSum >= target){
                //means currSum is >= target, we need to minimise the window to find smallest possible subarray
                res = Math.min(res, j - i + 1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {

    }
}
