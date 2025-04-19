package Algorithms.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public void helper(int[] nums, int t, int i, List<List<Integer>> res, List<Integer> c){
        if(t == 0){
            res.add(new ArrayList<>(c));
            return;
        }
        if(i >= nums.length || t < 0){
            return;
        }

        // Include the current element
        c.add(nums[i]);
        helper(nums, t - nums[i], i + 1, res, c);
        c.remove(c.size() - 1); // Backtrack

        // Skip duplicates
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        // Exclude the current element
        helper(nums, t, i + 1, res, c);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, c);
        return res;
    }
    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();

        // Test cases
        int[] nums1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target 7: " + solution.combinationSum2(nums1, target1));

        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target 8: " + solution.combinationSum2(nums2, target2));

        int[] nums3 = {2};
        int target3 = 1;
        System.out.println("Combinations for target 1: " + solution.combinationSum2(nums3, target3));
    }
}
