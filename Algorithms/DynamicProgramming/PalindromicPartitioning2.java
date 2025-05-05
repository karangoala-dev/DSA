package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class PalindromicPartitioning2 {
    int dp[][];
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int helper(String s, int i, int j){
        if(i >= j){
            //if one or less character, then return 0
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            if(isPalindrome(s, i, k)){
                int curr;
                if(k == j){
                    //if last element, no need to add 1 as already cut
                    curr = helper(s, k + 1, j);
                }
                else{
                    //add one to keep this (i->k) string by cutting and recurse on the remaining portion
                    curr = 1 + helper(s, k + 1, j);
                }
                min = Math.min(min, curr);
            }
        }
        return dp[i][j] = min == Integer.MAX_VALUE ? 0 : min;
    }
    public int minCut(String s) {
        dp = new int[s.length()][s.length()];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(s, 0, s.length() - 1);
    }
    public static void main(String[] args) {

    }
}
