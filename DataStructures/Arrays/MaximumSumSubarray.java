package DataStructures.Arrays;

public class MaximumSumSubarray {
    // 3 approaches,
    // one on O(n3) with 3 for loops
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int currSum = 0;
                for(int k = i; k <= j; k++){
                    currSum += nums[k];
                }
                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    // two on O(n2) with 2 for loops
    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int currSum = 0;
            for(int j = i; j < nums.length; j++){
                currSum += nums[j];
                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    // three on O(n) using Kadane's algorithm
    public int maxSubArray(int[] nums){
        int maxSoFar = nums[0];
        int res = nums[0];

        for(int i = 0; i < nums.length; i++){
            maxSoFar = Math.max(maxSoFar + nums[i], nums[i]);
            res = Math.max(maxSoFar, res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSumSubarray obj = new MaximumSumSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Sample input

        // Test maxSubArray1 (O(n^3))
        int result1 = obj.maxSubArray1(nums);
        System.out.println("Result of maxSubArray1 (O(n^3)): " + result1);

        // Test maxSubArray2 (O(n^2))
        int result2 = obj.maxSubArray2(nums);
        System.out.println("Result of maxSubArray2 (O(n^2)): " + result2);

        // Test maxSubArray (O(n) - Kadane's algorithm)
        int result3 = obj.maxSubArray(nums);
        System.out.println("Result of maxSubArray (O(n)): " + result3);
    }
}
