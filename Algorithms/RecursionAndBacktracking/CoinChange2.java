package Algorithms.RecursionAndBacktracking;

public class CoinChange2 {
    public int helper(int[] coins, int target, int currSum, int ind){
        if(ind >= coins.length || currSum > target){
            return 0;
        }
        if(currSum == target){
            //found 1 way
            return 1;
        }

        //take and stay here
        int res1 = helper(coins, target, currSum + coins[ind], ind);

        //not take and move ahead
        int res2 = helper(coins, target, currSum, ind + 1);

        return res1 + res2;
    }
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0, 0);
    }
    public static void main(String[] args) {

    }
}
