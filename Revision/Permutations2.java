package Revision;

import Algorithms.RecursionAndBacktracking.Permutations;

import java.util.*;

public class Permutations2 {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    HashSet<Integer> currentSet = new HashSet<>();

    public void helper(int[] nums, List<Integer> curr){
        if(curr.size() == nums.length){
            String s = curr.toString();
            if(!set.contains(s)){
                res.add(new ArrayList<>(curr));
                set.add(s);
                return;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(currentSet.contains(i)){
                continue;
            }
            curr.add(nums[i]);
            currentSet.add(i);
            helper(nums, curr);

            curr.remove(curr.size() - 1);
            currentSet.remove(i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(nums, new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        System.out.println(permutations2.permuteUnique(new int[]{1,1,2}));;
    }
}
