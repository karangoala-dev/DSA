package Algorithms.RecursionAndBacktracking;

public class PalindromicSubstrings {
    int count = 0;
    public void helper(String s, int l, int r){
        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)){
            return;
        }

        //if we reach here, means selected part(between l and r) is a palindrome
        count++;

        //recursively call
        helper(s, l - 1, r + 1);
    }
    public int countSubstrings(String s) {
        //first count all odd length palindromes
        for(int i = 0; i < s.length(); i++){
            //for each index, call the recursive fn
            helper(s, i, i);
        }
        //now count all even length palindromes
        for(int i = 0; i < s.length() - 1; i++){
            //for each index, call the recursive fn
            helper(s, i, i + 1);
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
