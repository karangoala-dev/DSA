package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MinimumCostToCutStick {
    int[][] dp;
    // This function returns the minimum cost to cut the stick between cuts[i] and cuts[j]
    public int helper(int[] cuts, int i, int j){
        if(i + 1 == j){
            //means no cuts can be done further, return 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        //for k in range from i + 1 to j - 1... ignore i and j as they are already cut
        // Using this for loop, we are considering each possible cut (k) between cuts[i] and cuts[j]
        // For each k, we recursively compute the cost of cutting the left (i to k) and right (k to j) segments
        for(int k = i + 1; k < j; k++){

            // Cost = length of current stick + cost of remaining cuts on left part + cost of remaining cuts on right part
            int curr = cuts[j] - cuts[i] + helper(cuts, i, k) + helper(cuts, k, j);

            min = Math.min(min, curr);
        }

        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        //+2 is done to add 0 and n to represent the stick
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        for(int i = 0; i < cuts.length; i++){
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);

        //dp table should have a length same as cuts + 2
        dp = new int[cuts.length + 2][cuts.length + 2];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }

        return helper(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {

    }
}
