package Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void helper(int[] nums, int t, int i, List<List<Integer>> res, List<Integer> c){
        if(i >= nums.length){
            return;
        }
        if(t == 0){
            res.add(new ArrayList<>(c));
            return;
        }
        if(t < 0){
            return;
        }
        c.add(nums[i]);
        helper(nums, t - nums[i], i, res, c);
        c.remove(c.size() - 1);
        helper(nums, t, i + 1, res, c);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        helper(candidates, target, 0, res, c);
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
