package Algorithms.Greedy;

import java.util.Arrays;

public class JumpGame2 {
    static int[][] dp;
    public static int helper(int[] nums, int i, int jumps){
        if(i >= nums.length - 1){
            return jumps;
        }
        if(dp[i][jumps] != -1){
            return dp[i][jumps];
        }

        int possibleJumps = nums[i];
        int res = Integer.MAX_VALUE;
        for(int j = 1; j <= possibleJumps; j++){
            res = Math.min(helper(nums, i + j, jumps + 1), res);
        }
        dp[i][jumps] = res;
        return res;
    }

    //This recursive approach has exponential time complexity, so cant use this fren.
    //So I implemented caching, this improves the TC to O(n^2)
    public static int jump_recursive_cached(int[] nums) {
        dp = new int[1001][1001];
        for (int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 0, 0);
    }


    public static void main(String[] args) {
        System.out.println(jump_recursive_cached(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
