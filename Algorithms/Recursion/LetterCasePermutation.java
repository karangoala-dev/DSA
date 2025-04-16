package Algorithms.Recursion;

import java.util.*;

public class LetterCasePermutation {
    private List<String> res = new ArrayList<>();
    public void helper(String s, int ind, StringBuilder sb){
        if(ind == s.length()){
            res.add(sb.toString());
            return;
        }

        if(Character.isLetter(s.charAt(ind))){
            //do upper case lower only if it is a letter

            //Here we must take each element
            //lowerCase
            sb.append(Character.toLowerCase(s.charAt(ind)));
            helper(s, ind + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

            //upperCase
            sb.append(Character.toUpperCase(s.charAt(ind)));
            helper(s, ind + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else{
            //no upper case lower case, plain recursion with backtracking
            sb.append(s.charAt(ind));
            helper(s, ind + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        helper(s, 0, new StringBuilder());
        return res;
    }
    public static void main(String[] args) {

    }
}
