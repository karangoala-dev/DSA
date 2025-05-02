package Algorithms.DynamicProgramming;

import java.util.HashMap;

public class LongestPalindromicSubstringDPEnhanced {
    //Even this fails for TLE
    HashMap<String, Integer> dp;
    Boolean[][] isPalMemo;
    int startPointer = -1;
    int maxLen = 0;
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
    public int helper(String s, int p1, int p2){
        if(p1 > p2){
            //p1 cant be greater than p2
            return 0;
        }
        if(p1 == p2){
            //then return the character, single character is a palindrome
            if(maxLen < 1){
                maxLen = 1;
                startPointer = p1;
            }

            return 1;
        }

        //check if key exists in dp map
        String key = p1 + "," + p2;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        //if palindrome then return it
        if(isPalindrome(s, p1, p2)){
            int currentLen = p2 - p1 + 1;
            dp.put(key, currentLen);

            if(currentLen > maxLen){
                maxLen = currentLen;
                startPointer = p1;
            }
            return p2 - p1 + 1;
        }

        //if not palindrome, check 2 cases, once with moving p1 inward and once with moving p2 inward
        Integer res1 = helper(s, p1 + 1, p2);
        Integer res2 = helper(s, p1, p2 - 1);

        Integer res;
        if(res1 > res2){
            res = res1;
        }
        else{
            res = res2;
        }
        dp.put(key, res);
        return res;
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        dp = new HashMap<>();
        isPalMemo = new Boolean[s.length()][s.length()];
        int length = helper(s, 0, s.length() - 1);

        return s.substring(startPointer, startPointer + maxLen);
    }
    public static void main(String[] args) {

    }
}
