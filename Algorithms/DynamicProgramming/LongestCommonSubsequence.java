package Algorithms.DynamicProgramming;

import java.util.*;

public class LongestCommonSubsequence {
    int[][] dp;
    public int helper(String s1, String s2, int p1, int p2){
        if(p1 >= s1.length() || p2 >= s2.length()){
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        if(s1.charAt(p1) == s2.charAt(p2)){
            // p1++;
            // p2++;
            return dp[p1][p2] = 1 + helper(s1, s2, p1 + 1, p2 + 1);
        }
        else{
            int res1 = helper(s1, s2, p1 + 1, p2);
            int res2 = helper(s1, s2, p1, p2 + 1);

            return dp[p1][p2] = Math.max(res1, res2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(text1, text2, 0, 0);
    }
    public static void main(String[] args) {

    }
}
