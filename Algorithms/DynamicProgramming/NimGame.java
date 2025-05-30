package Algorithms.DynamicProgramming;

public class NimGame {
    //DP based approach gives memory exceeded for large nos like '1348820612'
    //since this length array is not created by java, solution for this qn is to just return false if n % 4 == 0, else true
    Boolean[] dp;
    public boolean helper(int i){
        if(i <= 0){
            //current player loses if no stone left
            return false;
        }
        if(dp[i] != null){
            return dp[i];
        }

        //current player wins if any of the 3 moves makes the opponent lose
        return dp[i] = !helper(i - 1) || !helper(i - 2) || !helper(i - 3);
    }
    public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        dp = new Boolean[n + 1];
        //since I go first, I have 3 choices to win
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        return helper(n);
    }
    public static void main(String[] args) {
        
    }
}
