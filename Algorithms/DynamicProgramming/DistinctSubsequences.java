package Algorithms.DynamicProgramming;

import java.util.*;

public class DistinctSubsequences {
    //IMPORTANT ******
    //in this qn, no need to actually pass stringbuilder and keep track of current string
    int[][] dp;
    public int helper(String s, String t, int p1, int p2){
        if (p2 == t.length()){
            return 1;
        }
        if (p1 == s.length()){
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        if(s.charAt(p1) == t.charAt(p2)){
            //if equal, then add to curr and move ahead
            //or, skip this character and search for other matches

            //curr was a stringbuilder, it is not required actually
            // curr.append(s.charAt(p1));
            int res1 = helper(s, t, p1 + 1, p2 + 1);

            //backtrack and call
            // curr.deleteCharAt(curr.length() - 1);
            int res2 = helper(s, t, p1 + 1, p2);

            return dp[p1][p2] = res1 + res2;
        }
        else{
            //if not equal, we need to move p1
            return dp[p1][p2] = helper(s, t, p1 + 1, p2);
        }
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(s, t, 0, 0);
    }
    public static void main(String[] args) {

    }
}
