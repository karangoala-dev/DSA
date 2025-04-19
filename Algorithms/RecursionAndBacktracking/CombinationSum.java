package Algorithms.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] candidates, List<Integer> curr, int currSum, int target, int ind){
        if(currSum > target){
            return;
        }
        if(ind == candidates.length){
            if(currSum == target){
                res.add(new ArrayList<>(curr));
            }
            return;
        }


        //at each point we have choice to take this index element(no ind + 1 done here so that same index can be considered again)
        curr.add(candidates[ind]);
        helper(candidates, curr, currSum + candidates[ind], target, ind);

        //or skip it(ind + 1)
        curr.remove(curr.size() - 1);
        helper(candidates, curr, currSum, target, ind + 1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, new ArrayList<>(), 0, target, 0);
        return res;
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        // Test cases
        int[] nums1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target 7: " + solution.combinationSum(nums1, target1));

        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target 8: " + solution.combinationSum(nums2, target2));

        int[] nums3 = {2};
        int target3 = 1;
        System.out.println("Combinations for target 1: " + solution.combinationSum(nums3, target3));
    }
}
