package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class SubsetsWithDuplicates {
    public void helper(List<List<Integer>> res, int[] nums, List<Integer> c, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(c));
            return;
        }
        // Include nums[i]
        c.add(nums[i]);
        helper(res, nums, c, i + 1);
        c.remove(c.size() - 1);

        // Skip duplicates
        //so basically, if i = 1 or i = 2, input is same to the recursion stack, so we exclude the i = 2 since it is duplicate
        //eg, for nums [] = {1,2,2}, we would have [1,2] subset coming twice in result, once due to i = 1, once due to i = 2 if we do not ignore the duplicate.
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        // Exclude nums[i]
        helper(res, nums, c, i + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, c, 0);
        return res;
    }

    public static void main(String[] args) {
        SubsetsWithDuplicates solver = new SubsetsWithDuplicates();

        // Test case 1
        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets with duplicates for [1, 2, 2]: " + solver.subsetsWithDup(nums1));

        // Test case 2
        int[] nums2 = {1, 1, 2, 2};
        System.out.println("Subsets with duplicates for [1, 1, 2, 2]: " + solver.subsetsWithDup(nums2));

        // Test case 3
        int[] nums3 = {4, 4, 4, 1, 4};
        System.out.println("Subsets with duplicates for [4, 4, 4, 1, 4]: " + solver.subsetsWithDup(nums3));
    }

}
