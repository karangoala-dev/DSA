package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class EvaluateBooleanExpression {
    static int[][][] dp;
    static HashMap<Character, Boolean> map = new HashMap<>();
    static int helper(String s, int i, int j, boolean isTrue){
        int thirdInd = 0;
        if(!isTrue){
            thirdInd = 1;
        }


        if(i == j){
            //means single expression, return 0
            return map.get(s.charAt(i)) == isTrue ? 1 : 0;
        }

        if(dp[i][j][thirdInd] != -1){
            return dp[i][j][thirdInd];
        }

        //iterate from first operator(i + 1 -> j - 1)
        int ways = 0;
        for(int k = i + 1; k < j; k+=2){
            //get no of ways left/right can be true/false
            int leftTrue = helper(s, i, k - 1, true);
            int leftFalse = helper(s, i, k - 1, false);
            int rightTrue = helper(s, k + 1, j, true);
            int rightFalse = helper(s, k + 1, j, false);

            //for and operation, add to ways like left and right are true
            if(s.charAt(k) == '&'){
                if(isTrue){
                    ways += leftTrue * rightTrue;
                }
                else{
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }

            //for or operation, add to ways like left or right is true
            else if(s.charAt(k) == '|'){
                if(isTrue){
                    ways += leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
                }
                else{
                    ways += leftFalse * rightFalse;
                }
            }

            //for xor, add to ways like left and right do not match
            else if(s.charAt(k) == '^'){
                if(isTrue){
                    ways += leftFalse * rightTrue + leftTrue * rightFalse;
                }
                else{
                    ways += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }

        return dp[i][j][thirdInd] = ways;
    }
    static int countWays(String s) {
        // code here
        map.put('T', true);
        map.put('F', false);
        dp = new int [s.length()][s.length()][2];
        for(int[][] curr2D: dp){
            for(int[] curr: curr2D){
                Arrays.fill(curr, -1);
            }
        }
        return helper(s, 0, s.length() - 1, true);
    }
    public static void main(String[] args) {

    }
}
