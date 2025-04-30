package Algorithms.DynamicProgramming;

import java.util.*;

public class DistinctSubsequences {
    int[][] dp;
    public int helper(String s, String t, int p1, int p2, StringBuilder curr){
        if (p2 == t.length()){
            //if we reach end of p2, means all correct so far, so return 1 as we found a match
            return 1;
        }
        if (p1 == s.length()){
            //if we reach end of p1, means we cant go ahead, so return 0;
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        if(s.charAt(p1) == t.charAt(p2)){
            //if equal, then add to curr and move ahead
            curr.append(s.charAt(p1));
            int res1 = helper(s, t, p1 + 1, p2 + 1, curr);

            //or, skip this character and search for other matches
            //backtrack and call
            curr.deleteCharAt(curr.length() - 1);
            int res2 = helper(s, t, p1 + 1, p2, curr);

            return dp[p1][p2] = res1 + res2;
        }
        else{
            //if not equal, we need to move p1 only
            return dp[p1][p2] = helper(s, t, p1 + 1, p2, curr);
        }
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(s, t, 0, 0, new StringBuilder());
    }
    public static void main(String[] args) {

    }
}
