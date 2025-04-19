package Algorithms.RecursionAndBacktracking;

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

    public List<List<Integer>> subsetsUsingBitManipulation(int[] nums){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int power = (int) Math.pow(2, n) - 1;
        for(int num = 0; num < power; num++){
            List<Integer> dummy = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if((num & (1 << i)) != 0){
                    dummy.add(nums[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateSubsets generator = new GenerateSubsets();
        // Test cases
        int[][] testCases = {
                {},            // Test case 1: Empty input
                {1},           // Test case 2: Single element
                {1, 2},        // Test case 3: Two elements
                {1, 2, 3},     // Test case 4: Three elements
                {1, 2, 3, 4}   // Test case 5: Four elements
        };

        for (int[] testCase : testCases) {
            System.out.println("\nInput: " + Arrays.toString(testCase));

            // Measure time for recursive approach
            long startRecursive = System.nanoTime();
            List<List<Integer>> recursiveResult = generator.subsets(testCase);
            long endRecursive = System.nanoTime();
            System.out.println("Recursive Result: " + recursiveResult);
            System.out.println("Time taken (Recursive): " + (endRecursive - startRecursive) + " ns");

            // Measure time for bit manipulation approach
            long startBitManipulation = System.nanoTime();
            List<List<Integer>> bitManipulationResult = generator.subsetsUsingBitManipulation(testCase);
            long endBitManipulation = System.nanoTime();
            System.out.println("Bit Manipulation Result: " + bitManipulationResult);
            System.out.println("Time taken (Bit Manipulation): " + (endBitManipulation - startBitManipulation) + " ns");
        }
    }
}
