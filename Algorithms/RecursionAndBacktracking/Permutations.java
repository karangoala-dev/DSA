package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(List<Integer> nums, List<Integer> curr){
        if(nums.size() == curr.size()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(curr.contains(nums.get(i))){
                //skip this element is already considered in current list
                continue;
            }
            curr.add(nums.get(i));
            helper(nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>();
        for(int num: nums){
            input.add(num);
        }
        helper(input, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {

    }
}
