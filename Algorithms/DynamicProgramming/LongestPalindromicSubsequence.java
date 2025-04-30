package Algorithms.DynamicProgramming;

import java.util.*;

public class LongestPalindromicSubsequence {
    int[][] dp;
    public int helper(String s, int p1, int p2){
        if(p1 == p2){
            return 1;
        }
        if(p1 > p2){
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        //if same, move both p1 and p2
        if(s.charAt(p1) == s.charAt(p2)){
            return dp[p1][p2] = 2 + helper(s, p1 + 1, p2 - 1);
        }
        else{
            //if not same, move p1 once and move p2 once, and choose the max
            int res1 = helper(s, p1 + 1, p2);
            int res2 = helper(s, p1, p2 - 1);
            return dp[p1][p2] = Math.max(res1, res2);
        }
    }
    public int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(s, 0, s.length() - 1);
    }
    public static void main(String[] args) {

    }
}
