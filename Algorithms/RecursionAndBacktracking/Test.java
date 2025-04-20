package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class Test {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] candidates, int target, List<Integer> currList, int ind, int currSum){
        //Base cases
        if(ind >= candidates.length){
            return ;
        }
        if(currSum >= target){
            if(currSum == target){
                res.add(new ArrayList<>(currList));
            }
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
        Test test = new Test();

        // Test cases
        int[] nums1 = {2, 5, 2, 1, 2};
        int target1 = 5;
        System.out.println("Combinations for target 5: " + test.combinationSum2(nums1, target1));

        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target 8: " + test.combinationSum2(nums2, target2));

        int[] nums3 = {2};
        int target3 = 1;
        System.out.println("Combinations for target 1: " + test.combinationSum2(nums3, target3));
    }
}
