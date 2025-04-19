package Algorithms.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(List<Integer> currList, int num, int n, int k){
        if(currList.size() == k){
            //This is done so that we add a copy of the list to the res
            //if we didn't push a copy then if we make any changes to currList, it would change the currList present in res also.
            res.add(new ArrayList<>(currList));
            return;
        }

        //For all numbers from currentNum to n, we do a recursive call for i + 1
        for(int i = num; i <= n; i++){
            currList.add(i);
            //recursive call
            helper(currList, i + 1, n, k);
            //backtracking so that next iteration me this position is cleared
            currList.remove(currList.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<>(), 1, n, k);
        return res;
    }
    public static void main(String[] args) {

    }
}
