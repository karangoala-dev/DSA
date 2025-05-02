package Algorithms.RecursionAndBacktracking;

public class LongestPalindromicSubstring {
    public boolean isPalindrome(String s, int p1, int p2){
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
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

        //if palindrome then return it
        if(isPalindrome(s, p1, p2)){
            return s.substring(p1, p2 + 1);
        }

        //if not palindrome, check 2 cases, once with moving p1 inward and once with moving p2 inward
        String res1 = helper(s, p1 + 1, p2);
        String res2 = helper(s, p1, p2 - 1);

        return res1.length() > res2.length() ? res1 : res2;
    }
    public String longestPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }
    public static void main(String[] args) {

    }
}
