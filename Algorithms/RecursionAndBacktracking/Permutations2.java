package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class Permutations2 {
    //Approach#1 : my approach. Not very efficient
    List<List<Integer>> res = new ArrayList<>();
    HashSet<List<Integer>> unique = new HashSet<>();
    public void helper(int[] nums, List<Integer> currList, List<Integer> currentIndices){
        if(currList.size() == nums.length){
            if(!unique.contains(new ArrayList<>(currList))){
                unique.add(new ArrayList<>(currList));
                res.add(new ArrayList<>(currList));
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(currentIndices.contains(i)){
                continue;
            }
            currList.add(nums[i]);
            currentIndices.add(i);
            helper(nums, currList, currentIndices);
            currList.remove(currList.size() - 1);
            currentIndices.remove(currentIndices.size() - 1);
        }
    }
    //Approach#2

    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(nums, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        Permutations2 solution = new Permutations2();
        solution.permuteUnique(new int[] {1,1,2});
        System.out.println(solution.res);
    }
}
