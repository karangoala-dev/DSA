package Algorithms.DynamicProgramming;

public class ValidParenthesesString {
    Boolean dp[][];
    public boolean helper(String s, int ind, int count){
        if(count < 0){
            return false;
        }

        if(dp[ind][count] != null){
            return dp[ind][count];
        }

        if(ind == s.length()){

            return dp[ind][count] = count == 0;
        }

        if(s.charAt(ind) == '('){
            return dp[ind][count] = helper(s, ind + 1, count + 1);
        }
        else if(s.charAt(ind) == ')'){
            return dp[ind][count] = helper(s, ind + 1, count - 1);
        }
        else{
            return dp[ind][count] = helper(s, ind + 1, count + 1) || helper(s, ind + 1, count - 1) || helper(s, ind + 1, count);
        }
    }
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        return helper(s, 0, 0);
    }
    public static void main(String[] args) {

    }
}
