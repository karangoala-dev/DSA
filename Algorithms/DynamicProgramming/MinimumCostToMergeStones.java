package Algorithms.DynamicProgramming;

public class MinimumCostToMergeStones {
    int[] prefixSum;
    int[][] dp;
    public int helper(int[] stones, int i, int j, int piles){
        if(i >= j){
            //for invalid index or single index, cost of merging will be 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;
        for(int k = i; k < j; k += piles - 1){
            //first merge the partitions, (this means one less merge than total required, we need k piles at the end)
            int curr = helper(stones, i, k, piles) + helper(stones, k + 1, j, piles);
            res = Math.min(curr, res);
        }

        //the last merge
        if((j - i) % (piles - 1) == 0){
            res = res + prefixSum[j + 1] - prefixSum[i];
        }

        return dp[i][j] = res;
    }
    public int mergeStones(int[] stones, int piles) {
        int n = stones.length;
        prefixSum = new int[n + 1];
        dp = new int[n][n];
        prefixSum[0] = 0;

        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        //check if feasible -> see derivation in notes
        if((n-1)%(piles-1) != 0){
            return -1;
        }

        //generate prefixSum
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        return helper(stones, 0, n - 1, piles);
    }
    public static void main(String[] args) {

    }
}
