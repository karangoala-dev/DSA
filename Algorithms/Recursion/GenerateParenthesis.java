package Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public void helper(int open, int close, List<String> v, String current){
        if(open == 0 && close == 0){
            v.add(current);
            return;
        }

        if(open != 0){
            helper(open - 1, close, v, current + "(");
        }
        if(close > open){
            helper(open, close - 1, v, current + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> v = new ArrayList<>();
        int open = n;
        int close = n;
        helper(open, close, v, "");
        return v;
    }
    public static void main(String[] args) {

    }
}
