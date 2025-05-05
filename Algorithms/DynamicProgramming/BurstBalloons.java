package Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons {
    int[][] dp;
    //this fn returns maximum cost we can achieve when bursting balloons from i to j, i and j are inclusive
    public int helper(int[] arr, int i, int j){
        if(i > j){
            //if i > j, means out no more balloons left to pop, so return 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        //Here in the below loop, we iterate k from i to j, and instead of checking what happens if we burst k first, we check WHAT HAPPENS IF WE BURST K LAST
        //Since, if we burst k first, it will be difficult to pass arr to left and right sub-problems, since left would be dependent on right
        //and right dependent on left (k + 1 and k - 1 respectively).
        //instead, if we burst k last, we know that then for bursting k, cost would be arr[i - 1] * arr[k] * arr[j + 1]
        //this way, we can safely pass left fn(i, k-1) and right fn(k+1, j). Now, since we didn't burst k yet, we can take arr[k] for prev, next in the fn calls
        for(int k = i; k <= j; k++){
            int curr = arr[i - 1] * arr[k] * arr[j + 1] + helper(arr, i, k - 1) + helper(arr, k + 1, j);
            max = Math.max(max, curr);
        }

        return dp[i][j] = max;
    }
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        //add 1 in the boundaries
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for(int i = 0; i < nums.length; i++){
            arr[i + 1] = nums[i];
        }

        dp = new int[arr.length][arr.length];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }

        return helper(arr, 1, arr.length - 2);
    }
    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        System.out.println(burstBalloons.maxCoins(new int[]{3,1,5,8}));
    }
}
