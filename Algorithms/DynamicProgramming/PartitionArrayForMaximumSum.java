package Algorithms.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    int[][] dp;
    public int helper(int[] arr, int k, int i, int j){
        if(i > j){
            //is i exceeds j, return 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = Integer.MIN_VALUE;
        //max element in current subarray
        int maxElement = Integer.MIN_VALUE;

        //for size 1 to k and also check the index does not exceed j
        //index for size would be : i + size - 1;
        for(int size = 1; size <= k && i + size - 1 <= j; size++){
            if(arr[i + size - 1] > maxElement){
                maxElement = arr[i + size - 1];
            }

            //current sum would be size times the maxElement and recursive call for remainder for array from index + 1 to j
            int curr = size * maxElement + helper(arr, k, i + size, j);
            res = Math.max(res, curr);
        }

        return dp[i][j] = res;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length][arr.length];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(arr, k, 0, arr.length - 1);
    }
    public static void main(String[] args) {

    }
}
