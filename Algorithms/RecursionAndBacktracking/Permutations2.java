package Algorithms.RecursionAndBacktracking;

import java.util.*;

public class Permutations2 {
    //Approach#1 : my approach. Not very efficient : TC : O(n^2 * n!)
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
    public List<List<Integer>> permuteUnique_1(int[] nums) {
        helper(nums, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    //Approach#2 TC: O(n * n!)
    List<List<Integer>> res2 = new ArrayList<>();
    HashSet<List<Integer>> unique2 = new HashSet<>();
    public void helper1(int[] nums, List<Integer> currList, int[] used){
        if(currList.size() == nums.length){
            if(!unique2.contains(new ArrayList<>(currList))){
                unique2.add(new ArrayList<>(currList));
                res2.add(new ArrayList<>(currList));
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            currList.add(nums[i]);
            used[i] = 1;
            helper1(nums, currList, used);
            currList.remove(currList.size() - 1);
            used[i] = 0;
        }
    }
    public List<List<Integer>> permuteUnique_2(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        helper1(nums, new ArrayList<>(), used);
        return res2;
    }

    //Approach#3 optimised. TC: O(n!)
    List<List<Integer>> res3 = new ArrayList<>();
    public void helper2(int[] nums, List<Integer> currList, int[] used){
        if(currList.size() == nums.length){
            res3.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            currList.add(nums[i]);
            used[i] = 1;
            helper2(nums, currList, used);
            currList.remove(currList.size() - 1);
            used[i] = 0;
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
    public List<List<Integer>> permuteUnique_3(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        helper2(nums, new ArrayList<>(), used);
        return res3;
    }

    public static void main(String[] args) {
        Permutations2 solution = new Permutations2();
        solution.permuteUnique_3(new int[] {1,1,2});
        System.out.println(solution.res3);
    }
}
