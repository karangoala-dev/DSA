package Revision;

public class PalindromicSubstrings {
    //general approach ->
    //1. count all odd length palindrome
    //2. count all even length palindrome
    int count = 0;
    public void helper(String s, int i, int j){
        if(i < 0 || j >= s.length()){
            return;
        }

        Character a = s.charAt(i);
        Character b = s.charAt(j);

        if(a == b){
            count++;
            helper(s, i - 1, j + 1);
        }
    }

    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            //Odd length
            helper(s, i, i);
        }
        for(int i = 0; i < s.length() - 1; i++){
            //Even length
            helper(s, i, i + 1);
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
