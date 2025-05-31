package Revision;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] candidates, int target, int ind, int currSum, List<Integer> curr){
        if(ind >= candidates.length || currSum >= target){
            if(currSum == target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        //take and repeat
        curr.add(candidates[ind]);
        currSum += candidates[ind];
        helper(candidates, target, ind, currSum, curr);

        //backtrack and move to next
        curr.remove(curr.size() - 1);
        currSum -= candidates[ind];
        helper(candidates, target, ind + 1, currSum, curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {

    }
}
