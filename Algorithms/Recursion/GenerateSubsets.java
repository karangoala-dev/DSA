package Algorithms.Recursion;

import java.util.*;

public class GenerateSubsets {
    public void helper(int[] nums, int i, List<List<Integer>> v, List<Integer> c){
        if(i >= nums.length){
            v.add(new ArrayList<>(c));
            return;
        }

        helper(nums, i + 1, v, c);
        c.add(nums[i]);
        helper(nums, i + 1, v, c);
        c.remove(c.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> v = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        helper(nums, 0, v, c);
        return v;
    }
    public static void main(String[] args) {
        GenerateSubsets generator = new GenerateSubsets();

        // Test case 1: Empty input
        int[] nums1 = {};
        System.out.println("Subsets for []: " + generator.subsets(nums1));

        // Test case 2: Single element
        int[] nums2 = {1};
        System.out.println("Subsets for [1]: " + generator.subsets(nums2));

        // Test case 3: Two elements
        int[] nums3 = {1, 2};
        System.out.println("Subsets for [1, 2]: " + generator.subsets(nums3));

        // Test case 4: Three elements
        int[] nums4 = {1, 2, 3};
        System.out.println("Subsets for [1, 2, 3]: " + generator.subsets(nums4));

        // Test case 5: Four elements
        int[] nums5 = {1, 2, 3, 4};
        System.out.println("Subsets for [1, 2, 3, 4]: " + generator.subsets(nums5));
    }
}
