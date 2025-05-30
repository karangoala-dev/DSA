package Algorithms.DynamicProgramming;

import java.util.*;

public class PalindromePartitioning {
    Boolean[][] palindromeDp;
    public Boolean isPalindrome(String s, int i, int j){
        if(i >= j){
            return true;
        }
        if(s.charAt(i) != s.charAt(j)){
            return false;
        }

        if(palindromeDp[i][j] != null){
            return palindromeDp[i][j];
        }

        return palindromeDp[i][j] = isPalindrome(s, i+1, j-1);
    }
    public void helper(String s, int ind, List<List<String>> res, List<String> partition){
        if(ind >= s.length()){
            //means we added all substrings for current partition to list, append it to result
            res.add(new ArrayList<>(partition));
            return;
        }

        for(int j = ind; j < s.length(); j++){
            if(isPalindrome(s, ind, j)){
                //if we found a palindromic substring at start, find rest,(in java, s.substring(i,j) will give from i to j - 1, so do a "j + 1")
                partition.add(s.substring(ind, j + 1));
                //recurse on the string, for other substrings which are palindromes, for "aab", first leg will gather result as [a,a,b], now at each level,backtracking step
                helper(s, j + 1, res, partition);
                //will remove the string from "partition" list's end.
                partition.remove(partition.size() - 1);

                //after this, for first iteration, our res will have [[a,a,b]]. Next iteration me, we will have "aa" as the first string, and it is a palindrome so...
                //will continue
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        palindromeDp = new Boolean[s.length()][s.length()];

        helper(s, 0, res, part);
        return res;
    }
    public static void main(String[] args) {

    }
}
