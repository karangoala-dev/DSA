package Algorithms.PrefixSum;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            res[i] = currSum;
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
