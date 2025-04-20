package Algorithms.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] candidates, int target, List<Integer> currList, int ind, int currSum){
        //Base cases
        //it is important to notice the order of base cases in this qn.
        //for case when last value in candidates is equal to target, then if the ind >= candidates.length is checked first then we wont be considering the ans and directly
        //return without adding it to res.
        //so check the current sum first and then index check
        if(currSum >= target){
            if(currSum == target){
                res.add(new ArrayList<>(currList));
            }
            return ;
        }
        if(ind >= candidates.length){
            return ;
        }

        //Take current element and move ahead
        currList.add(candidates[ind]);
        helper(candidates, target, currList, ind + 1, currSum + candidates[ind]);
        //Don't take current element and move ahead
        currList.remove(currList.size() - 1);

        //before moving to next element we must skip duplicate elements as we have considered that value(candidates[ind])
        //in prev call
        while(ind < candidates.length - 1 && candidates[ind] == candidates[ind + 1]){
            ind++;
        }
        helper(candidates, target, currList, ind + 1, currSum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, 0);
        return res;
    }
    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();

        // Test cases
        int[] nums1 = {2, 5, 2, 1, 2};
        int target1 = 5;
        System.out.println("Combinations for target 5: " + solution.combinationSum2(nums1, target1));
    }
}
