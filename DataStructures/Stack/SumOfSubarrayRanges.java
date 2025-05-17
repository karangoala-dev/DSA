package DataStructures.Stack;

public class SumOfSubarrayRanges {

    public long subArrayRanges_BruteForce(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        long minSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                minSum = minSum + min;
            }
            min = Integer.MAX_VALUE;
        }

        int max = Integer.MIN_VALUE;
        long maxSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                max = Math.max(max, nums[j]);
                maxSum = maxSum + max;
            }
            max = Integer.MIN_VALUE;
        }

        return maxSum - minSum;
    }

    public long subArrayRanges(int[] nums) {

    }
    public static void main(String[] args) {

    }
}
