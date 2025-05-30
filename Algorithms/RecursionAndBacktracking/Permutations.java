package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class Permutations {
    List<List<Integer>> res;
    HashSet<Integer> set;
    //TC: O(n * n!)
    public void helper(int[] nums, List<Integer> curr){
        if(curr.size() == nums.length){
            //this step takes O(n) time :)
            //so due to doing this n! times for each permutation, we get a TC of O(n * n!)
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            //consider ith element only if not present in curr
            if(set.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            set.add(nums[i]);
            helper(nums, curr);

            curr.remove(curr.size() - 1);
            set.remove(nums[i]);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();
        helper(nums, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {

    }
}
