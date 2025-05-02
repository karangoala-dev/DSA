package Algorithms.RecursionAndBacktracking;

public class LongestPalindromicSubstringExpandApproach {
    int startPointer = -1;
    int maxLen = 0;
    public void expandRecursively(String s, int l, int r){
        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)){
            return;
        }

        if(r - l + 1 > maxLen){
            maxLen = r - l + 1;
            startPointer = l;
        }

        expandRecursively(s, l - 1, r + 1);
    }
    public String longestPalindrome(String s) {
        //first check for odd length palindromes
        for(int i = 0; i < s.length(); i++){
            expandRecursively(s, i, i);
        }

        //now for even length palindromes
        for(int i = 0; i < s.length() - 1; i++){
            expandRecursively(s, i, i + 1);
        }

        return s.substring(startPointer, startPointer + maxLen);
    }
    public static void main(String[] args) {

    }
}
