package Revision;

import java.util.*;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int n, int k, int ind, List<Integer> curr){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int i = ind; i <= n; i++){
            curr.add(i);
            helper(n, k, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
