package Algorithms.RecursionAndBacktracking;

public class EditDistance {
    public int helper(String word1, String word2, int p1, int p2){
        if(p1 == word1.length() || p2 == word2.length()){
            if(p1 != word1.length()){
                //if p1 is not at end, return remaining length
                return word1.length() - p1;
            }
            else if(p2 != word2.length()){
                return word2.length() - p2;
            }
            else{
                //means both are at end so return 0
                return 0;
            }
        }

        if(word1.charAt(p1) == word2.charAt(p2)){
            return helper(word1, word2, p1 + 1, p2 + 1);
        }
        else {
            //here we are conceptually doing the 3 operations, not modifying the strings for real.
            //insert a char in word1, which will be same as p2, so advance only p2(because, after inserting character in s1 before the p1 conceptually, p1 is now pointing
            // to next position automatically, so compare next p2 and current p1)
            int res1 = 1 + helper(word1, word2, p1, p2 + 1);

            //delete char at p1, so do p1+1 so that we can compare next p1 with current p2
            int res2 = 1 + helper(word1, word2, p1 + 1, p2);

            //replace char so advance both p1 and p2
            int res3 = 1 + helper(word1, word2, p1 + 1, p2 + 1);

            return Math.min(res1, Math.min(res2, res3));
        }
    }
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }

    public static void main(String[] args) {

    }
}
