package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {
    int[][] dp;
    int res = 0;
    public int helper(int[] nums1, int[] nums2, int p1, int p2){
        if(p1 >= nums1.length || p2 >= nums2.length){
            //no more indices, so return 0
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        //let ans store current result from p1, p2. if n1[p1] == n2[p2] then ans will be non-zero
        int ans = 0;
        if(nums1[p1] == nums2[p2]){
            //add one and check next
            ans = 1 + helper(nums1, nums2, p1 + 1, p2 + 1);
        }
        //if ans was > 0 then check if it more than res and set value of res
        res = Math.max(res, ans);

        //these 2 recursive calls are needed for all case whether n1[p1] == n2[p2] or not
        //or we will miss out larger subarrays later.
        helper(nums1, nums2, p1, p2 + 1);
        helper(nums1, nums2, p1 + 1, p2);


        return dp[p1][p2] = ans;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        dp = new int[n1 + 1][n2 + 1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        helper(nums1, nums2, 0, 0);
        return res;
    }
    public static void main(String[] args) {

    }
}
