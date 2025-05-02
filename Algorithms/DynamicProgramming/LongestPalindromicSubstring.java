package Algorithms.DynamicProgramming;

import java.util.HashMap;

public class LongestPalindromicSubstring {
    //Fails with TLE
    HashMap<String, String> dp;
    Boolean[][] isPalMemo;
    public boolean isPalindrome(String s, int p1, int p2){
        if (isPalMemo[p1][p2] != null){
            return isPalMemo[p1][p2];
        }

        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
                return isPalMemo[p1][p2] = false;
            }
            p1++;
            p2--;
        }
        return isPalMemo[p1][p2] = true;
    }
    public String helper(String s, int p1, int p2){
        if(p1 > p2){
            //p1 cant be greater than p2
            return "";
        }
        if(p1 == p2){
            //then return the character, single character is a palindrome
            return s.substring(p1, p2 + 1);
        }

        //check if key exists in dp map
        String key = p1 + "," + p2;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        //if palindrome then return it
        if(isPalindrome(s, p1, p2)){
            dp.put(key, s.substring(p1, p2 + 1));
            return s.substring(p1, p2 + 1);
        }

        //if not palindrome, check 2 cases, once with moving p1 inward and once with moving p2 inward
        String res1 = helper(s, p1 + 1, p2);
        String res2 = helper(s, p1, p2 - 1);

        String res;
        if(res1.length() > res2.length()){
            res = res1;
        }
        else{
            res = res2;
        }
        dp.put(key, res);
        return res;
    }
    public String longestPalindrome(String s) {
        dp = new HashMap<>();
        isPalMemo = new Boolean[s.length()][s.length()];
        return helper(s, 0, s.length() - 1);
    }
    public static void main(String[] args) {

    }
}
